<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:choose>
	<c:when test="${insFlag}">
		<h1 style="color:green;text-align:center">Vegetable Added successfully</h1>
	</c:when>
	<c:when test="${updFlag}">
		<h1 style="color:green;text-align:center">Vegetable Updated successfully</h1>
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align:center">Vegetable Failed to Save/Updated</h1>
	</c:otherwise>
</c:choose>

<h1><a href="/MVCProj11_SimpleFormCntrl_VegetablesReg/home.htm">add another item</a></h1>