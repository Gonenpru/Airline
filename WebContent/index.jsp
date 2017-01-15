<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Airline</title>
<link rel="icon" href="images/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Sales Manager Dashboard Panel" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
	
<link href="css/input-icons.css" rel="stylesheet" type="text/css" >
<script src="js/wow.min.js"></script>
<script>
		new WOW().init();
	</script>
<script src="js/jquery-1.10.2.min.js"></script>

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
				<li><s:a name="action" value="execute_flight"><i class="fa fa-globe" ></i><span>Flights</span></s:a></li>
				<li><s:a name="action" value="execute_plane"><i class="fa fa-plane" style="color:white"></i><span>Planes</span></s:a></li>
				<li><s:a name="action" value="execute_model"><i class="fa fa-plane" ></i><span>Models</span></s:a></li>
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
									45 <span>%</span>
								</h5>
								<div class="grow">
									<p>Growth</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 widget widget1">
						<div class="r3_counter_box">
							<i class="fa fa-users"></i>
							<div class="stats">
								<h5>
									<s:property value="totalAirlines" />
								</h5>
								<div class="grow grow1">
									<p>Airlines</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 widget widget1">
						<div class="r3_counter_box">
							<i class="fa fa-eye"></i>
							<div class="stats">
								<h5>
									95.9 <span>%</span>
								</h5>
								<div class="grow grow3">
									<p>Av. Quality</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 widget">
						<div class="r3_counter_box">
							<i class="fa fa-usd"></i>
							<div class="stats">
								<h5>
									4 <span>$</span>
								</h5>
								<div class="grow grow2">
									<p>Profit</p>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="widget_middle">
				<div class="col-md-6 widget_middle_left">
					<div class="switch-right-grid" style="height: 400px;"></div>
				</div>
				<div class="col-md-6 widget_middle_left">
					<div class="switch-right-grid" style="height: 400px;">
						<div class="switch-right-grid1"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<footer>
	<p>&copy 2016 Gonenpru Corporation</p>
</footer>
</section>
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>