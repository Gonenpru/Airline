<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add / Delete / List </h1>
<s:actionerror/>
 <s:form action="add" method="post">
 	<s:textfield name="planes.airlines" label="Plane Airline"/>
 	<s:textfield name="planes.planeModels" label="Plane Model"/>
 	<s:textfield name="planes.planeStatus" label="Plane Status"/>
 	
 	<s:submit value="Add Plane" align="center"/>
 </s:form>

<s:form action="list" method="post">
	<s:submit value="Planes List" align="center"/>
</s:form>
 
<h2>Items in Master</h2>
<table border="1">
	<tr>
		<th>Airline</th>
		<th>Model</th>
		<th>Status</th>
	</tr>
	<s:iterator value="planesList" var="planes">
	<tr>
		<td><s:property value="id"/></td>
		<td><s:property value="airlines"/></td>
		<td><s:property value="planeModels"/></td>
		<td><s:property value="planeStatus"/></td>
	<td><a href="delete?id=<s:property value="id"/>">delete</a></td>
</tr>
</s:iterator>
</table>
 
</body>
</html>