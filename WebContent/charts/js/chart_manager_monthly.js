var margin = {top: 20, right: 20, bottom: 70, left: 40},
width = 450 - margin.left - margin.right,
height = 200 - margin.top - margin.bottom;

		// Parse the date / time
		var	parseDate = d3.time.format("%b").parse;

		var x = d3.scale.ordinal().rangeRoundBands([0, width], .3);

		var y = d3.scale.linear().range([height, 0]);

		var xAxis = d3.svg.axis()
		.scale(x)
		.orient("bottom")
		.tickFormat(d3.time.format("%b"));

		var yAxis = d3.svg.axis()
		.scale(y)
		.orient("left")
		.ticks(5)
		.tickFormat(function(e){
			if(Math.floor(e) != e)
			{
				return;
			}

			return e;
		});

		var svg = d3.select("body").append("svg")
		.attr("width", width + margin.left + margin.right)
		.attr("height", height + margin.top + margin.bottom)
		.append("g")
		.attr("transform", 
			"translate(" + margin.left + "," + margin.top + ")");

		d3.json("data/data_manager_month.json", function(error, data) {

			data.forEach(function(d) {
				d.date = parseDate(d.date);
				d.value = +d.value;
			});
			
			x.domain(data.map(function(d) { return d.date; }));
			y.domain([0, d3.max(data, function(d) { return d.value; })]);

			svg.append("g")
			.attr("class", "x axis")
			.attr("transform", "translate(0," + height + ")")
			.call(xAxis)
			.selectAll("text")
			.style("text-anchor", "end")
			.attr("dx", "-.8em")
			.attr("dy", "-.55em")
			.attr("transform", "rotate(-90)" );

			svg.append("g")
			.attr("class", "y axis")
			.call(yAxis)
			.append("text")
			.attr("transform", "rotate(-90)")
			.attr("y", 6)
			.attr("dy", ".71em")
			.style("text-anchor", "end")
			.text("Production");

			svg.selectAll("bar")
			.data(data)
			.enter().append("rect")
			.style("fill",function(d){
				if(d.value < 4200){
					return "red";
				}else if(d.value < 4300){
					return "orange";
				}else{
					return "green";
				}
			})
			.attr("x", function(d) { return x(d.date); })
			.attr("width", x.rangeBand())
			.attr("y", function(d) { return y(d.value); })
			.attr("height", function(d) { return height - y(d.value); });

		});