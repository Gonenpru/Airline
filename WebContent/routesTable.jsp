<%-- <% response.sendRedirect("airlineManagement.jsp"); %> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-dojo-tags" prefix="sd" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <sd:head/>
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
<link href="css/font-awesome.css" rel="stylesheet">
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

<!-- DATATABLES  -->
<script
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<link
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"
	rel="stylesheet">
	
<script>
	$(document).ready(function() {
		$('#myTable').DataTable();
	});
</script>
</head>

<body class="sticky-header left-side-collapsed">
	<section>
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
				<li><s:a name="action" value="execute_flight"><i class="fa fa-plane" ></i><span>Flights</span></s:a></li>
				<li><s:a name="action" value="list_routes"><i class="fa fa-pencil-square-o"></i><span>Routes</span></s:a></li>
			</ul>
		</div>
	</div>

	<div class="main-content">
		<jsp:include page="includes/header_section.jsp" />
		<h1>ROUTES</h1>
			<div class="contentform">
					<table id="myTable" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Origin</th>
								<th>Arrival</th>
								<th>Airline</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="routesList">
								<tr>
									<td><s:property value="departure" /></td>
									<td><s:property value="arrival" /></td>
									<td><s:property value="airline_id" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
			</div>
	</div>
	<footer>
	<p> &copy 2017 Gonenpru Corporation </p>
	</footer> </section>
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>