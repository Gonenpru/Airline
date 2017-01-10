<%-- <% response.sendRedirect("airlineManagement.jsp"); %> --%>

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

<!-- DATATABLES  -->
<script
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<link
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"
	rel="stylesheet">

<link href="css/textbox-style.css" rel="stylesheet" type="text/css">
<script>
	$(document).ready(function() {
// 		$('#myTable').DataTable();
		$('#myTable').dataTable( {
			  "lengthChange": false
			} );
	});

	// 	$(document).ready(function() {
	// 	    var table = $('#myTable').DataTable( {
	// 	        "columnDefs": [ {
	// 	            "targets": -1,
	// 	            "data": null,
	// 	            "defaultContent": "<a href='delete?id=<s:property value='id'/>'>Delete</a>"
	// 	        } ]
	// 	    } );

	// 	    $('#myTable tbody').on( 'click', 'button', function () {
	// 	    	document.myForm.action="delete";
	// 	        document.myForm.submit();
	// 	    } );
	// 	} );
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
				<li><a href="planeGenerator.jsp"><i class="lnr lnr-diamond"></i><span>Dashboard</span></a></li>
				<li><a href="timetable.jsp"><i class="lnr lnr-earth"></i><span>Routes</span></a></li>
			</ul>
		</div>
	</div>
	<div class="main-content">
		<jsp:include page="includes/header_section.jsp" />
		<div id="page-wrapper">
			<div class="widget_middle">
			<div class="col_3">
			
			<div class="col-md-3 widget widget1">
					<div class="form-style-5">
						<s:form action="add" method="post">
							<fieldset>
								<legend> <span class="number">1</span> Edit a Model </legend>
 								<s:select headerKey="-1" headerValue="Select the Model *" 
 								list="planeModelsList"   
								listValue="name" name="planeModels.manufacturer_id"  required="true"/> 
								<s:textfield name="planeModels.name" placeholder="New Name *"/>
								<s:textfield name="planeModels.maxPassengers" placeholder="Max Passengers *"/>
							</fieldset>
							<s:submit class="input-style" value="Edit" />
						</s:form>
					</div>
				</div>
				
				<div class="col-md-3 widget widget1">
					<div class="form-style-5">
						<s:form action="add_model" method="post">
							<fieldset>
								<s:select headerKey="-1" headerValue="Select the Manufacturer *" 
								list="manufacturersList_model" name="planeModels.manufacturer_id" 
								listValue="name" value="id" required="true"/>
								<legend> <span class="number">2</span> Create a Model </legend>
								<s:textfield name="planeModels.name" placeholder="Plane Model Name *"/>
								<s:textfield name="planeModels.maxPassengers" placeholder="Max Passengers *"/>
							</fieldset>
							<s:submit class="input-style" value="Create" />
						</s:form>
					</div>
				</div>
			
			<div class="col-md-6 widget_middle_left">
			<div class="form-style-5">
					<fieldset>
					<legend> <span class="number">3</span> Models table </legend>
					<table id="myTable" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Max Passengers</th>
								<th>Manufacturer</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="planeModelsList">
								<tr>
									<td><s:property value="id" /></td>
									<td><s:property value="name" /></td>
									<td><s:property value="maxPassengers" /></td>
									<td><s:property value="manufacturer_id" /></td>
									<td><a href="delete_model?id=<s:property value="id"/>">Delete</a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					</fieldset>
				</div>
				</div>
			</div>
			</div>
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