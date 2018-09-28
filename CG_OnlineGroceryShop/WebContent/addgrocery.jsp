<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OnlineGroceryShop</title>
</head>
<body style="background-color: pink"align="center">
	<h2>Online Grocery Shop</h2>
	<h3>Add an Item</h3>

	<form:form action="submitGrocery.obj" modelAttribute="grocery">
		<table align="center"  >
			<tr>
				<th>Item Name</th>
				<td><form:input path="name" />
				<form:errors path="name"/></td>
			</tr>
			<tr>
				<th>Price(Rs)</th>
				<td><form:input path="price" />
				<form:errors path="price"/></td>
			</tr>
			<tr>
				<th>Category</th>
				<td><form:select path="category" >
				<form:option value="Select"></form:option>
				<form:options items="${clist}"/>
				</form:select><form:errors path="category"/></td>
			</tr>
			<tr>
				<th>Quantity</th>
				<td><form:input path="quantity" />
				<form:errors path="quantity"/></td>
			</tr>
			<tr>
				<th>Unit</th>
				<td><form:input path="unit" />
				<form:errors path="unit"/></td>
			</tr>
			<tr>
				<th>Description</th>
				<td><form:textarea path="description" />
				<form:errors path="description"/></td>
			</tr>
		</table>

		<input type="submit" value="Add the item">



	</form:form>
</body>
</html>