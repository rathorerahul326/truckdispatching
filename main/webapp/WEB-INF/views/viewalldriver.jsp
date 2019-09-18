<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/main.js" />"></script>
<title>Insert title here</title>



</head>

<body bgcolor="#999999">
	<div class="header">
		<center>
			<h1>Truck Dispatching</h1>
		</center>
	</div>
	<div class="dropdown">
		<button class="dropbtn">
			<a href="login" style="text-decoration: none"><img border="0"
				alt="Home" src="http://laoblogger.com/images/clip-art-home-10.jpg"
				width="50" height="50"></a>
		</button>
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
			<a href="load">Add Load</a> <a href="viewload">View Load</a>
		</div>
	</div>



	&nbsp&nbsp&nbsp
	<div class="dropdown">
		<button class="dropbtn"
			onclick="return confirm('Are you sure you want to logout');">
			<a href="logout" style="text-decoration: none">Logout</a>
		</button>
	</div>
	&nbsp&nbsp&nbsp
	<div class="dropdown">

		<i><b>Search by name</b></i> <select name="owner" id="myInput"
			onChange="myFunction()">

			<c:forEach var="user" items="${list}">
				<option value="${user.getName()}">${user.getName()}</option>

			</c:forEach>
		</select>
	</div>
	<form action="#">

		<br> <br>
		<br> <br>
		<br> <br>
${msg}
		<center>
			<h2>Driver Profile</h2>
			<table id="myTable">
				<tr class="header">
					<th style="width: 30%;"><b>Name</b></th>
					<th style="width: 30%;"><b>DOB</b></th>
					<th style="width: 30%;"><b>SSN</b></th>
					<th style="width: 30%;"><b>License_expiration</b></th>
					<th style="width: 30%;"><b>Medical_Card_Expiration</b></th>
					<th style="width: 30%;"><b>Drug_Test_Expiration_Date</b></th>
					<th style="width: 30%;"><b>Current_Assigned_Truck</b></th>
					<th style="width: 30%;"><b>Employer_(Truck Owner)</b></th>
					<th style="width: 30%;"><b>Action</b></th>
					<c:forEach var="user" items="${list}">
						<tr>
							<td>${user.getName()}</td>
							<td>${user.getDob()}</td>
							<td>${user.getSsn()}</td>
							<td>${user.getLicence_expiration()}</td>
							<td>${user.getMedical_expiration()}</td>
							<td>${user.getTestexpiry()}</td>
							<td>${user.getAssignedtruck()}</td>
							<td>${user.getOwnername()}</td>

							<td><a href="editdriver?ssn=${user.getSsn()}"
								style="text-decoration: none;"><img border="0" alt="Update"
									src="https://image.freepik.com/free-icon/pencil-in-a-square-edit-interface-symbol_318-53384.jpg"
									width="25" height="25"> <a
									href="deletedriver?ssn=${user.getSsn()}"
									onclick="return confirm('Are you sure you want to delete this profile');"
									style="text-decoration: none;"><img border="0" alt="Delete"
										src="https://imageog.flaticon.com/icons/png/512/54/54758.png"
										width="25" height="25"></td>

						</tr>
					</c:forEach>


					</td>
				</tr>


			</table>
		</center>




	</form>
</body>
</html>