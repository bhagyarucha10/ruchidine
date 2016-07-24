<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>RuchiDine.com</title>
  <meta charset="utf-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.10.1/bootstrap-social.css" rel="stylesheet" >
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">FARM FRESH</a>

    </div>
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="index">Home</a></li>
      <li  ><a href="productpage">Product</a></li>
      <li  ><a href="signin">SignIn</a></li>
      <li  ><a href="registrationform"/>Register</a></li>
    </ul>
  </div>
</nav> 

  
<html>
<head>
	<title>RuchiDine.com</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	MODIFY A PRODUCT
</h1>
<
<c:url var="addAction" value="/productpage" ></c:url>
<form:form action="${addAction}" commandName="product">

div class="table-responsive">
   <table id="myTable" bgcolor="yellow">
   <thead>
   <tr> 

	<c:if test="${!empty product.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="category">
				<spring:message text="category"/>
			</form:label>
		</td>
		<td>
			<form:input path="category" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="price">
				<spring:message text="price"/>
			</form:label>
		</td>
		<td>
			<form:input path="price" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty product.name}">
				<input type="submit"
					value="<spring:message text="Edit Product"/>" />
			</c:if>
		
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Product List</h3>
<c:if test="${!empty product}">
	<table class="tg">
	<tr>
		<th width="80"> ID</th>
		<th width="120"> NAME</th>
		<th width="120"> CATEGORY</th>
		<th width="60">PRICE</th>
		
	</tr>
	<c:forEach items="${listpersons}" var="p">
		<tr>
			
			<td>${p.name}</td>
			<td>${p.category}</td>
			<td>${p.price}</td>
			<td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">About US</a></li>
        <li class="active"><a href="#">CONTACT</a></li>
      </ul>
            <ul class="nav navbar-nav navbar-right">
       
      <li><a onclick="" class="btn btn-social-icon btn-lg btn-facebook"><i class="fa fa-facebook"></i></a></li>
      <li><<a onclick="" class="btn btn-social-icon btn-lg btn-dropbox"><i class="fa fa-dropbox"></i></a></li>
      <li> <a onclick="" class="btn btn-social-icon btn-lg btn-flickr"><i class="fa fa-flickr"></i></a></li>
    </ul> 
  </div>
</nav>
</body>


</html>

          