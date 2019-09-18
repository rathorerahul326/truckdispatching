<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/js/main.js" />"></script>
<title>Home Page</title>
</head>
<body bgcolor="#999999">
	<div class="header">
		<center>
			<h1>Truck Dispatching</h1>
			

			
		</center>
	</div>

<div class="dropdown">
  <button class="dropbtn"><a href="login"><img border="0" alt="Home" src="http://laoblogger.com/images/clip-art-home-10.jpg" width="50" height="50"></a></button>
  </div>
	&nbsp&nbsp&nbsp
	
	
	<div class="dropdown">
		<button class="dropbtn">Owner Master</button>
		<div class="dropdown-content">
			<a href="owner">Add Owner</a> <a href="viewowner">View Owner</a>
		</div>
	</div>
	&nbsp&nbsp&nbsp
	<div class="dropdown">
		<button class="dropbtn">Truck Master</button>
		<div class="dropdown-content">
			<a href="truck">Add Truck</a> <a href="viewtruck">View Truck</a>

		</div>
	</div>
	&nbsp&nbsp&nbsp
	<div class="dropdown">
		<button class="dropbtn">Driver Master</button>
		<div class="dropdown-content">
			<a href="driver">Add Driver</a> <a href="viewdriver">View Driver</a>

		</div>
	</div>
	
		&nbsp&nbsp&nbsp
	
	<div class="dropdown">
  <button class="dropbtn">Schedule Load</button>
  <div class="dropdown-content">
  <a href="load">Add Load</a>
    	<a href="viewload">View Load</a>
    	
  </div>
</div>
	
	
	
	&nbsp&nbsp&nbsp
	<div class="dropdown">
		<button class="dropbtn">
			<a href="logout"
				onclick="return confirm('Are you sure you want to logout');"
				style="text-decoration: none">Logout</a>
		</button>
	</div>
	
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp



<div class="dropdown">
  <!-- Trigger the modal with a button -->
<button style="font-size:20px" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Notification <i class="material-icons" style="font-size:15px;color:red">notifications_active</i><span> ${count}</span></button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title">Expire Items </h3>
        </div>
      <div class="modal-body">
          <p><c:forEach var="user" items="${list}">

				<p>${user}</p>

			</c:forEach>
   </p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>



</body>
</html>