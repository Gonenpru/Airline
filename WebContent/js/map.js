var map;
function initMap() {

  var coords = [{lat: 43.0631988, lng: -2.5068561},
  {lat: 34.0201813, lng: -118.6919193},
  {lat: 41.2825124, lng: 69.139283},
  {lat: -15.7217174, lng: -48.0783222},
  {lat: 24.0226825, lng: -104.7177651},
  {lat: 11.5793306, lng: 104.7437273}];

  var mapOptions = {
    zoom: 2,
    center: {lat: 0, lng: 0}
  };

  map = new google.maps.Map(document.getElementById('map'), mapOptions);

  for (var i = 0; i < coords.length; i++) {
   new google.maps.Marker({
    position: coords[i],
    map: map
  });
 }
}
