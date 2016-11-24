var margin = {top: 30, right: 40, bottom: 30, left: 50},
width = 450 - margin.left - margin.right,
height = 200 - margin.top - margin.bottom;

var tip = d3.tip().html(function(d) { return d; });

var parseDate = d3.time.format("%H:%M").parse;

var x = d3.time.scale().range([0, width]);
var y0 = d3.scale.linear().range([height, 0]);
var y1 = d3.scale.linear().range([height, 0]);

var xAxis = d3.svg.axis().scale(x)
.orient("bottom").ticks(5);

var yAxisLeft = d3.svg.axis().scale(y0)
.orient("left").ticks(5);

var yAxisRight = d3.svg.axis().scale(y1)
.orient("right").ticks(5); 

var valueline = d3.svg.line()
.x(function(d) { return x(d.date); })
.y(function(d) { return y0(d.close); });

var valueline2 = d3.svg.line()
.x(function(d) { return x(d.date); })
.y(function(d) { return y1(d.open); });

var svg = d3.select("body")
.append("svg")
.attr("width", width + margin.left + margin.right)
.attr("height", height + margin.top + margin.bottom)
.append("g")
.attr("transform", 
 "translate(" + margin.left + "," + margin.top + ")")
  .on('mouseover', tip.show)
  .on('mouseout', tip.hide);

svg.call(tip);

// Get the data
d3.csv("./data/data_manager_today.csv", function(error, data) {
	data.forEach(function(d) {
		d.date = parseDate(d.date);
		d.close = +d.close;
		d.open = +d.open;
	});

    // Scale the range of the data
    x.domain(d3.extent(data, function(d) { return d.date; }));
    y0.domain([0, d3.max(data, function(d) {
    	return Math.max(d.close); })]); 
    y1.domain([0, d3.max(data, function(d) { 
    	return Math.max(d.open); })]);

    svg.append("path")
    .style("stroke","steelblue")        // Add the valueline path.
    .attr("d", valueline(data));

    svg.append("path")        // Add the valueline2 path.
    .style("stroke", "green")
    .attr("d", valueline2(data));

    svg.append("g")            // Add the X Axis
    .attr("class", "x axis")
    .attr("transform", "translate(0," + height + ")")
    .call(xAxis);

    svg.append("text")
    .attr("transform", "rotate(-90)")
    .attr("x",0 - (height / 2))
    .attr("dy", "1em")
    .style("text-anchor", "middle")
    .text("Production");

    svg.append("g")
    .attr("class", "y axis")
    .style("fill", "steelblue")
    .call(yAxisLeft);	

    svg.append("text")
    .attr("transform", "rotate(-90)")
    .attr("x",0 - (height / 2))
    .attr("y", width-30)
    .attr("dy", "1em")
    .style("text-anchor", "middle")
    .text("Quality (%)");

    svg.append("g")				
    .attr("class", "y axis")	
    .attr("transform", "translate(" + width + " ,0)")	
    .style("fill", "green")		
    .call(yAxisRight);

});