<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cg.bean.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Grocery Shop</title>
</head>
<body  align ="center" style="background-color: pink">

<H1>Online Grocery Shop</H1>
<c:choose>
<c:when test="${all.size()>0 }">


<h3>Available Items</h3>
<table style="background-color: aqua"align = "center" border="1 px">
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Category</th>
<th>Unit</th>
<th>Quantity</th>

<th>Description</th>
</tr>
<c:forEach items="${all}" var="detail">
<tr>
<td>${detail.getId()} </td>
<td>${detail.getName()} </td>


<td>${detail.getPrice()} </td>


<td>${detail.getCategory()} </td>

<td>${detail.getUnit()} </td>
<td>${detail.getQuantity()} </td>




<td>${detail.getDescription()} </td>
</tr>

</c:forEach>


</table><br><br>

</c:when>
<c:otherwise>
<h3><center>No data found</center></h3>

</c:otherwise>

</c:choose>
<a align ="center"href="index.jsp">Go Home</a>

</body>
</html>