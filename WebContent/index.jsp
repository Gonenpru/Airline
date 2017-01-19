<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Airline</title>
<link rel="icon" href="images/favicon.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="Sales Manager Dashboard Panel" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="https://use.fontawesome.com/36a53496c3.js"></script>
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/d3.js"></script>
<script type="text/javascript" src="js/d3-tip.js"></script>
<link href="css/input-icons.css" rel="stylesheet" type="text/css" >
<script type="text/javascript" src="js/wow.min.js"></script>
<script type="text/javascript">
		new WOW().init();
	</script>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>

</head>

<body class="sticky-header left-side-collapsed">
	<div class="left-side sticky-left-side">
		<div class="logo">
			<h1>
				<a href="index.jsp">Index</a>
			</h1>
		</div>
		<div class="logo-icon text-center">
			<a href="index.jsp"><i class="lnr lnr-home"></i> </a>
		</div>
		<div class="left-side-inner">
			<ul class="nav nav-pills nav-stacked custom-nav">
				<li><s:a name="action" value="execute_plane"><i class="fa fa-plane" ></i><span>Planes</span></s:a></li>
				<li><s:a name="action" value="execute_flight"><i class="fa fa-ticket" ></i><span>Flights</span></s:a></li>
				<li><s:a name="action" value="list_routes"><i class="fa fa-globe"></i><span>Routes</span></s:a></li>
			</ul>
		</div>
	</div>
	<div class="main-content">
		<jsp:include page="includes/header_section.jsp" />
		<div id="page-wrapper">
			<div class="graphs">
				<div class="col_3">
					<div class="col-md-3 widget widget1">
						<div class="r3_counter_box">
							<i class="fa fa-mail-forward"></i>
							<div class="stats">
								<h5>
									+5 <span>%</span>
								</h5>
								<div class="grow">
									<p>Ticket Value</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 widget widget1">
						<div class="r3_counter_box">
							<i class="fa fa-users"></i>
							<div class="stats">
								<h5>
									130,000
								</h5>
								<div class="grow grow1">
									<p>Clients</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 widget widget1">
						<div class="r3_counter_box">
							<i class="fa fa-eye"></i>
							<div class="stats">
								<h5>
									12
								</h5>
								<div class="grow grow3">
									<p>Flights</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 widget">
						<div class="r3_counter_box">
							<i class="fa fa-usd"></i>
							<div class="stats">
								<h5>
									120 <span>$</span>
								</h5>
								<div class="grow grow2">
									<p>Ticket Price</p>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
<div class="switches">
					<div class="col-4">
						<div class="col-md-4 switch-right">
							<div class="switch-right-grid" style="height: 425px;">
								<div class="switch-right-grid1">
									<h4>TODAY'S STATS</h4>
									<ul>
										<li>Earnings: $5,000 USD</li>
										<li>Tickets Sold: 50 Tickets</li>
										<li>Ticket Actual Prize: $120 USD</li>
									</ul>
								</div>
								<object type="text/html" data="charts/chart_airline_today.html" width="100%" height="100%"></object>
							</div>
						</div>
						<div class="col-md-4 switch-right">
							<div class="switch-right-grid" style="height: 425px;">
								<div class="switch-right-grid1">
									<h4>WEEKLY STATS</h4>
									<ul>
										<li>Earnings: $30,000 USD</li>
										<li>Tickets Sold: 400 Tickets</li>
										<li>Last Hour Sales: $2,434 USD</li>
									</ul>
								</div>

								<object type="text/html" data="charts/chart_airline_weekly.html" width="100%" height="100%"></object>

							</div>
						</div>
						<div class="col-md-4 switch-right">
							<div class="switch-right-grid" style="height: 425px;">
								<div class="switch-right-grid1">
									<h4>MONTHLY STATS</h4>
									<ul>
										<li>Earnings: $250,000 USD</li>
										<li>Tickets Sold: 8,000 Items</li>
										<li>Last Hour Sales: $75,434 USD</li>
									</ul>
								</div>
								<object type="text/html" data="charts/chart_airline_monthly.html" width="100%" height="100%"></object>
							</div>			
						</div>
					</div>
				</div>
		</div>
	</div>
	<p>
		&copy; 2016 Gonenpru Corporation
	</p>
	<script type="text/javascript" src="js/jquery.nicescroll.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>