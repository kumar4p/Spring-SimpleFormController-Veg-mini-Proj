<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:orange;text-align:center">List of Vegetables</h1>
	
	<br>
	<a href="/MVCProj11_SimpleFormCntrl_VegetablesReg/home.htm">+Add Vegetable</a>
	<h3 style="color:red;text-align:center">${delMsg} ${unDelMsg}</h3>
	<c:choose >
		<c:when test="${!empty listCmd }">
	<table border="1"  title="Vegetables Details">	
		<thead style="color:pink;background-color:cyan">
			<tr>
				<th>SNO</th><th>Vegetable Id</th><th>Vegetable Name</th><th>Vegetable Vitamins</th><th>Vegetable Status</th><th>Vegetable Price</th><th>Action</th>
			</tr>
		</thead>
		<tbody style="color:black;background-color:cyan">
			<c:forEach var="cmd" items="${listCmd}"  varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td><c:out value="${cmd.vid}"/></td>
					<td><c:out value="${cmd.vname}"/></td>
					<td><c:out value="${cmd.vitamins}"/></td>
					<td><c:out value="${cmd.status}"/></td>
					<td><c:out value="${cmd.vprice}"/></td>
					<td><a href="/MVCProj11_SimpleFormCntrl_VegetablesReg/editVeg.htm?vId=${cmd.vid}">Edit</a>&nbsp;&nbsp;<a href="/MVCProj11_SimpleFormCntrl_VegetablesReg/deletVeg.htm?vId=${cmd.vid}">Delete</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
		<h3 style="color:red">${rMsg}</h3>
	</c:otherwise>
	</c:choose>
	<br>
</body>
</html>