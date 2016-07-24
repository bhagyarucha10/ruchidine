
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
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
    
      <li  ><a href="registrationform"/>Register</a></li>
        <li ><a href="addproduct">Add Product </a></li>
    </ul>
  </div>
</nav> 

   <div class="table-responsive">
   <table id="myTable" bgcolor="yellow">
   <thead>
   <tr>    
          
        
           <th>ID</th>  
            <th>PRODUCTNAME</th>  
            <th>CATEGORY</th>  
            <th>PRICE</th> 
            <th>EDIT</th>
            <th>DELETE</th> 
            <th>Details</th>
          </tr>  
        </thead>  
</tr>
	<c:forEach items="${listed}" var="p">
		<tr>
			<!--  <td>${p.id}</td>-->
			<td>${p.id}</td>
			<td>${p.name}</td>
			<td>${p.category}</td>
			<td>${p.price}</td>
			<td><a href="edit/${p.id}" class="btn btn-primary">Edit</a></td>
		<td><a href="delete/${p.id}" class="btn btn-primary">Delete</a></td>
		<td><a href="details/${p.id}" class="btn btn-primary">Details</a></td>
		</tr>
	</c:forEach>
	
	
	</table>
</div>

<nav class="navbar navbar-inverse ">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">FARM FRESH</a>
    </div>
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

          