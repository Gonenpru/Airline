<%-- <% response.sendRedirect("airlineManagement.jsp"); %> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-dojo-tags" prefix="sd" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <sd:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Airline</title>
<link rel="icon" href="images/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Sales Manager Dashboard Panel" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="https://use.fontawesome.com/36a53496c3.js"></script>
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<script src="js/Chart.js"></script>
<link href="css/animate.css" rel="stylesheet" type="text/css"
	media="all">

<script src="js/wow.min.js"></script>
<script>
	new WOW().init();
</script>
<script src="js/jquery-1.10.2.min.js"></script>

<link href="css/editor-style.css" rel="stylesheet" type="text/css">
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
				<li><s:a name="action" value="execute_flight"><i class="fa fa-globe" ></i><span>Create</span></s:a></li>
				<li><s:a name="action" value="execute_flight_table"><i class="fa fa-table"></i><span>History</span></s:a></li>
			</ul>
		</div>
	</div>

	<div class="main-content"> 
 	<jsp:include page="includes/header_section.jsp" /> 
	<s:form action="update_flight" method="post" theme="simple">
		<h1> UPDATE FLIGHT </h1>
		<div class="contentform">
			<div id="sendmessage">Your message has been sent successfully. Thank you.</div>

			<div class="leftcontact">
								
				<div class="form-group">
					<p>
						Plane <span>*</span>
					</p>
					<span class="icon-case"><i class="fa fa-plane"></i></span> 
					<s:textfield type="number" name="flights.plane_id"/>
				</div>

				<div class="form-group">
					<p>
						Gate <span>*</span>
					</p>
					<span class="icon-case"><i class="fa fa-building-o"></i></span> 
					<s:textfield type="number" name="flights.gate_id" /> 
				</div>
				
				<div class="form-group">
					<p>
						Departure date <span>*</span>
					</p>

					<span class="icon-case"><i class="fa fa-calendar-o"></i></span>						
					<s:textfield type="date" name="flights.d_Departure" />
				</div>	
				
				<div class="form-group">
					<p>
						Departure time <span>*</span>
					</p>

					<span class="icon-case"><i class="fa fa-clock-o"></i></span>						
					<s:textfield name="flights.d_Time" />
				</div>	
	
			</div>

			<div class="rightcontact">

				<div class="form-group">
					<p>
						Baggage door <span>*</span>
					</p>
					<span class="icon-case"><i class="fa fa-suitcase"></i></span> 
					<s:textfield type="number" name="flights.baggage_id" />
				</div>

				<div class="form-group">
					<p>
						Route <span>*</span>
					</p>
					<span class="icon-case"><i class="fa fa-globe"></i></span>						
					<s:textfield type="number" name="flights.route_id" />
				</div>

				<div class="form-group">
					<p>
						 Duration <span>*</span>
					</p>
					<span class="icon-case"><i class="fa fa-clock-o"></i></span>
					<s:textfield name="flights.duration"/>
				</div>
		
			</div>
		</div>
		<s:submit value="Update" class="bouton-contact"/>
	</s:form>
	</div> 



	<footer>
	<p> &copy 2017 Gonenpru Corporation </p>
	</footer>
	
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>