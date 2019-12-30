<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	span{
		color:red;
		padding-left: 5px;
		font-size: 30px;
		
	}
</style>
<script type="text/javascript">
	function validate(frm) {
		
		document.getElementById("name").value="";
		document.getElementById("name").value="";
		document.getElementById("price").value="";
		document.getElementById("vitmns").value="";
		
		var name = frm.vname.value;
		var price = frm.vprice.value;
		var vitmns = frm.vitamins.value;
		if(name=="")
			document.getElementById("name").value="Name required";
		if(name.length<3)
			document.getElementById("name").value="Name must be more than 3 chars";
		if(isNan(price))
			document.getElementById("price").value="Price number is required";
		if(vitmns=="")
			document.getElementById("vitmns").value="vitamins required";
		frm.formValFlag.value="true";
	}
</script>
</head>
<body>
	<h1 style="color:Gold;text-align:center">Vegetable Registration Form</h1>
	<table>
	<form:form  action="home.htm" method="POST" commandName="cmd" onsubmit="return validate(this)">
		<form:hidden path="formValFlag"/>
		<form:hidden path="vid"/>
		<tr><th>Vegetable Name    ::  <form:input path="vname"/></th> <th><form:errors path="vname"/><span id="name"></span></th></tr>
		<tr><th>Vegetable Price   ::  <form:input path="vprice"/></th><th><form:errors path="vprice"/><span id="price"></span></th></tr>
		<tr><th align="left" colspan=".5">Vegetable Status  ::  &nbsp;&nbsp; &nbsp;<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; 
					  Available     <form:radiobutton path="status" value="true"/>
					  Not Available <form:radiobutton path="status" value="false"/>
			</th>
		</tr>			  
		<tr><th>Vegetable Vitamins :: <form:input path="vitamins"/></th><th><form:errors path="vitamins"/><span id="vitmns"></span></th></tr>
		<tr><th><input type="submit" value="Add Vegetable"></th></tr>
	</form:form>
	</table>
	<br/>
	<h2 style="color:pink"><a href="viewAllVeg.htm">View All Vegetables</a></h2>
	
</body>
</html>