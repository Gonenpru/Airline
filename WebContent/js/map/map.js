var socket = io.connect("http://localhost:9092");

var map;
var markers = [];
var move_id = [];
var positions = [];

/*

 {id: data.plane_id, pos:[0, 0] ,coord:[data.posx, data.posy], new: 0} + Movimientos pendientes

 update mira el pos
 y cuando acaba si hay Movimientos pendientes en el finish se le pasa el primero a pos
 y se ejecuta de nuevo

 Cada update si hay algo en pos introduce en pendientes las coordenadas

*/

function start() {
  initMap();
  socket.on("eventFromJava", function(jsonData) {
    var data = JSON.parse(jsonData);
    startOperations(data);
  });
}

function doSetTimeout(i, data) {
  setTimeout(function() {
    transition(positions[i], data);
  }, 1000);
}

function startOperations(data) {
  if (finder(data.plane_id) !== null){
    console.log("UPDATE");
    var posToUpdate = finder(data.plane_id);
    if (positions[posToUpdate].pos[0] === 0 && positions[posToUpdate].pos[1] === 0){
      positions[posToUpdate].pos = [data.posx, data.posy];
      if (finder_moves(data.plane_id) !== null){
        move_id[finder_moves(data.plane_id)].move = 0;
        move_id[finder_moves(data.plane_id)].i = 0;
        doSetTimeout(posToUpdate, data);
      }
    }else if (positions[posToUpdate].pos[0] === -1 && positions[posToUpdate].pos[1] === -1){
      console.log("NEXT");
      positions[posToUpdate].pos = positions[posToUpdate].next;
      doSetTimeout(posToUpdate, data);
    }else {
      console.log("Push");
      positions[posToUpdate].pending.push([data.posx, data.posy]);
    }
  }else {
    console.log("INSERT");
    positions.push({id: data.plane_id, pos:[0, 0] ,coord:[data.posx, data.posy], new: 0, pending: [], next : 0});
    move_id.push({id: data.plane_id, move: 0, i: 0});
  }
}

function initMap() {
    var latlng = new google.maps.LatLng(51.471477, -0.459911);
    var myOptions = {
        zoom: 14,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map"), myOptions);
}

var numDeltas = 100;
var delay = 100;
var deltaLat = [];
var deltaLng = [];

function transition(result, data){
    if (result.new === 0){
      var marker = new google.maps.Marker({
          position: new google.maps.LatLng(result.coord[0],result.coord[1]),
          map: map
      });
      result.new = 1;
      markers.push(marker);
    }

    var lat = (result.pos[0] - result.coord[0])/numDeltas;
    var long = (result.pos[1] - result.coord[1])/numDeltas;
    deltaLat.push({id: result.id ,pos: lat});
    deltaLng.push({id: result.id ,pos: long});
    moveMarker(result.id, data);
}

function moveMarker(id, data){

  var a = finder(id);
	positions[a].coord[0] += contains_lat(id);
	positions[a].coord[1] += contains_lng(id);

  var latlng = new google.maps.LatLng(positions[a].coord[0], positions[a].coord[1]);
  markers[a].setPosition(latlng);

  var b = finder_moves(id);
  if(move_id[b].i!=numDeltas){
    move_id[b].i++;
    setTimeout(function() {
      moveMarker(id, data);
    }, delay);

  }else {
    finder_lat_delete(id);
    finder_lng_delete(id);
    if (positions[a].pending[0] !== undefined){
      positions[a].pos[0] = -1;
      positions[a].pos[1] = -1;
      move_id[b].i = 0;
      move_id[b].move = 0;
      positions[id].next = positions[id].pending[0];
      movePendingToPos(id);
      startOperations(data);
    }else {
      positions[a].pos[0] = 0;
      positions[a].pos[1] = 0;
      console.log("Finish");
    }
  }
}

function movePendingToPos(id) {
  for (var i = 0; i < positions[id].pending.length; i++) {
    if (positions[id].pending[i + 1] !== undefined){
      positions[id].pending[i] = positions[id].pending[i + 1];
    }else{
      positions[id].pending[i] = undefined;
    }
  }
}

function finder(id) {
  for (var i = 0; i < positions.length; i++) {
    if (positions[i].id == id){
      return i;
    }
  }
  return null;
}

function finder_moves(id) {
  for (var i = 0; i < move_id.length; i++) {
    if (move_id[i].id == id){
      return i;
    }
  }
  return null;
}

function finder_lat_delete(id) {
  for (var i = 0; i < deltaLat.length; i++) {
    if (deltaLat[i].id == id){
      deltaLat.splice(i, 1);
    }
  }
}

function finder_lng_delete(id) {
  for (var i = 0; i < deltaLng.length; i++) {
    if (deltaLng[i].id == id){
      deltaLng.splice(i, 1);
    }
  }
}

function contains_lat(id) {
	for (var i in deltaLat) {
	     if (deltaLat[i].id == id) {
	    	 	return deltaLat[i].pos;
	     }
	   }
	return false;
}

function contains_lng(id) {
	for (var i in deltaLng) {
	     if (deltaLng[i].id == id) {
	    	 	return deltaLng[i].pos;
	     }
	   }
	return null;
}
