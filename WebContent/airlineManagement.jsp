<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Airline Management</title>
</head>
<body>

	<h1>Airline</h1>
	<s:actionerror />
	<s:form action="add_airline" method="post">
		<s:textfield name="airline.name" label="Name" />
		<s:textfield name="airline.email" label="Email" />
		<s:textfield name="airline.password" label="Password" />
		<s:submit value="Add Airline" align="center" />
	</s:form>

	<s:form action="add_model" method="post">
		<s:textfield name="planeModels.name" label="Name" />
		<s:textfield name="planeModels.maxPassengers" label="Max p" />
		<s:textfield name="planeModels.manufacturer_id" label="id" />
		<s:submit value="Add Model" align="center" />
	</s:form>

	<s:form action="list" method="post">
		<s:submit value="Planes List" align="center" />
	</s:form>

	<h2>Items in Master</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<s:iterator value="airlinesList">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="email" /></td>
				<td><a href="delete?id=<s:property value="id"/>">delete</a></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>