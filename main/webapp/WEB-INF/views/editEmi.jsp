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
<title>Installment Page</title>

</head>

<body bgcolor="#999999">
	<div class="header">
		<center>
			<h1>Truck Dispatching
	</div>
	<div class="w3-container">
		<div class="dropdown">
			<button class="dropbtn">
				<a href="login"><img border="0" alt="Home"
					src="http://laoblogger.com/images/clip-art-home-10.jpg" width="50"
					height="50"></a>
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
				<a href="logout">Logout</a>
			</button>
		</div>



		<div class="w3-container w3-blue"></div>
		<form action="updateEmi" method="post" commandName="emiEdit">
			<table align="center" width="40%" width="100%" cellspacing="0"
				cellpadding="0">




				<tr>
					<td align="center" colspan="2"><h2 style="color: blue">
							<b>Advance Form</b>
						</h2></td>
				</tr>


				<tr>
					<td align="left" valign="top" width="30%"><h4
							style="color: white;">Load Number*</h4></td>

					<td><b> ${load.getLoadNumber()} </b> <input type="hidden"
						name="loadnumber" value="${load.getLoadNumber()}" /></td>
				</tr>


				<tr>
					<td align="left" valign="top" width="30%"><h4
							style="color: white;">Gross After Commission Amount*</h4></td>


					<td width="30%"><b>${emiobj.getGrossaftercommission()}</b>  <input type="hidden"
						name="grossaftercommission" value="${emiobj.getGrossaftercommission()}" />   </td>

				</tr>

				<tr>
					<td align="left" valign="top" width="30%"><h4
							style="color: white;">Total Advance Paid*</h4></td>


					<td width="30%"><b>${load.getTotalamountpaid()}</b>
					<input type="hidden" name="totalamountpaid" value="${load.getTotalamountpaid()}">
					 <input type="hidden"
						name="transno" value="${emiobj.getTransno()}" />
						<input type="hidden"
						name="datetime" value="${emiobj.getDatetime()}" />
					</td>

				</tr>




				<tr>
					<td align="left" valign="top" width="30%"><h4
							style="color: white;">Advance Amount*</h4></td>
					<td width="30%"><input type="text" name="advance" value="${emiobj.getAdvance()}"></td>
				</tr>

				
				<tr>
					<td align="left" valign="top" width="30%"><h4
							style="color: white;">Advance Type*</h4></td>
					<td width="30%"> <select name="advancetype" required>
					<option>Select</option>
					<option value="ADVANCE">Advance</option>
  <option value="FUEL">Fuel</option>
  <option value="MAINTENACE">Maintenance</option> 
</select>  </td>
				</tr>
				



				<tr>
					<td align="center" colspan="2"><input type="submit"
						value="Update Advance"onclick="return confirm('Are you sure you want to make this Payment');"></td>
				</tr>
			</table>
		</form>
</body>
</html>