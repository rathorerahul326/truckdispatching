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

		<i><b>Search by Truck Number</b></i> <select name="owner" id="myInput"
			onChange="myFunction()">

			<c:forEach var="user" items="${list}">
				<option value="${user.getLoadNumber()}">${user.getTruckNumber()}</option>

			</c:forEach>
		</select>
	</div>
	<form action="#">

		<br> <br>
		<br> <br>
		<br> <br>
${msg}
		<center>
			<h2>Active Load Profile</h2>
			<table id="myTable">
				<tr class="header">
					<th style="width: 30%;"><b>Load_Number</b></th>
					<th style="width: 30%;"><b>Truck_Number</b></th>
					<th style="width: 30%;"><b>Gross</b></th>
					<th style="width: 30%;"><b>Dispatcher Commission </b></th>
					<th style="width: 30%;"><b>Gross after commission </b></th>
					<th style="width: 30%;"><b>PickUp Date</b></th>
					<th style="width: 30%;"><b>PickUp City</b></th>
					<th style="width: 30%;"><b>PickUp State</b></th>
					<th style="width: 30%;"><b>Drop OFF Date</b></th>
					<th style="width: 30%;"><b>Drop OFF City</b></th>
					<th style="width: 30%;"><b>Drop OFF State</b></th>
					<th style="width: 30%;"><b> Total Advance Paid</b></th>
					<th style="width: 30%;"><b>Add Advance</b></th>
					<th style="width: 30%;"><b>Edit</b></th>
					<th style="width: 30%;"><b>View Transaction</b></th>
					<th style="width: 30%;"><b>Close Load</b></th>
						
					
					<c:forEach var="user" items="${list}">
						<tr>
							<td>${user.getLoadNumber()}</td>
							<td>${user.getTruckNumber()}</td>
							<td>${user.getGross()}</td>
							<td>${user.getDispatureCommission()}</td>
							<td>${user.getGrossafterCommision()}</td>
							<td>${user.getPickupDate() }</td>
							<td>${user.getPickupCity()}</td>
							<td>${user.getPickupState()}</td>
							<td>${user.getDropoffDate() }</td>
							<td>${user.getDropCity()}</td>
							<td>${user.getDropState() }</td>
							<td>${user.getTotalamountpaid() }</td>
							
							<td>   <a href="addEmi?lid=${user.getLoadNumber()}"
								style="text-decoration: none;"><img border="0" alt="Add"
									src="https://png.icons8.com/metro/1600/add-row.png"
									width="25" height="25">   </td>
							
							

<td><a href="editload?loadnumber=${user.getLoadNumber()}"
								style="text-decoration: none;"><img border="0" alt="Update"
									src="https://image.freepik.com/free-icon/pencil-in-a-square-edit-interface-symbol_318-53384.jpg"
									width="25" height="25"> 
									</td>

	
							<td>   <a href="report?loadnumber=${user.getLoadNumber()}&truckNumber=${user.getTruckNumber()}"
								style="text-decoration: none;"><img border="0" alt="Add"
									src="https://d30y9cdsu7xlg0.cloudfront.net/png/1095121-200.png"
									width="25" height="25">   </td>

	<td>  <a href="closeload?lid=${user.getLoadNumber()}"style="text-decoration: none;"><img border="0" alt="Add" onclick="return confirm('Are you sure you want to close this Load Profile');"
									src="http://www.samburugirls.foundation/wp-content/plugins/itro-popup/images/close-icon.png"
									width="25" height="25">   </td> </td>


						</tr>
					</c:forEach>


					</td>
				</tr>


			</table>
		</center>
<br/>
<br/>
<br/>
<br/>

	<center>
			<h2>Closed Load Profile</h2>
			<table id="myTable">
				<tr class="header">
				
				
					<th style="width: 30%;"><b>Load_Number</b></th>
					<th style="width: 30%;"><b>Truck_Number</b></th>
					<th style="width: 30%;"><b>Gross</b></th>
					<th style="width: 30%;"><b>Dispatcher Commission </b></th>
					<th style="width: 30%;"><b>Gross after commission </b></th>
					<th style="width: 30%;"><b>PickUp Date</b></th>
					<th style="width: 30%;"><b>PickUp City</b></th>
					<th style="width: 30%;"><b>PickUp State</b></th>
					<th style="width: 30%;"><b>Drop OFF Date</b></th>
					<th style="width: 30%;"><b>Drop OFF City</b></th>
					<th style="width: 30%;"><b>Drop OFF State</b></th>
					<th style="width: 30%;"><b>Total Advance Paid</b></th>
					<th style="width: 30%;"><b>Edit</b></th>
					<th style="width: 30%;"><b>View Transaction</b></th>
					
					<c:forEach var="user2" items="${list2}">
						<tr>
							<td>${user2.getLoadNumber()}</td>
							<td>${user2.getTruckNumber()}</td>
							<td>${user2.getGross()}</td>
							<td>${user2.getDispatureCommission()}</td>
							<td>${user2.getGrossafterCommision()}</td>
							<td>${user2.getPickupDate() }</td>
							<td>${user2.getPickupCity()}</td>
							<td>${user2.getPickupState()}</td>
							<td>${user2.getDropoffDate() }</td>
							<td>${user2.getDropCity()}</td>
							<td>${user2.getDropState() }</td>
							<td>${user2.getTotalamountpaid() }</td>
							

<td><a href="editload?loadnumber=${user2.getLoadNumber()}"
								style="text-decoration: none;"><img border="0" alt="Update"
									src="https://image.freepik.com/free-icon/pencil-in-a-square-edit-interface-symbol_318-53384.jpg"
									width="25" height="25"> 
									</td>



							<td>   <a href="report?loadnumber=${user2.getLoadNumber()}&truckNumber=${user2.getTruckNumber()}"
								style="text-decoration: none;"><img border="0" alt="Add"
									src="https://d30y9cdsu7xlg0.cloudfront.net/png/1095121-200.png"
									width="25" height="25">   </td>

						</tr>
					</c:forEach>


					</td>
				</tr>


			</table>
		</center>



	</form>
</body>
</html>