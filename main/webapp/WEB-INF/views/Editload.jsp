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
<title>Load Update Page</title>

</head>

<body bgcolor="#999999">
	<div class="header">
		<center>
			<h1>Truck Dispatching</div>
	<div class="w3-container">
<div class="dropdown">
  <button class="dropbtn"><a href="login"><img border="0" alt="Home" src="http://laoblogger.com/images/clip-art-home-10.jpg" width="50" height="50"></a></button>
  </div>
	&nbsp&nbsp&nbsp

	<div class="dropdown">
  <button class="dropbtn">Owner Master</button>
  <div class="dropdown-content">
    <a href="owner">Add Owner</a>
        <a href="viewowner">View Owner</a>
  </div>
</div>&nbsp&nbsp&nbsp
	<div class="dropdown">
  <button class="dropbtn">Truck Master</button>
  <div class="dropdown-content">
  <a href="truck">Add Truck</a>
    	<a href="viewtruck">View Truck</a>
    	
  </div>
</div>&nbsp&nbsp&nbsp
<div class="dropdown">
  <button class="dropbtn">Driver Master</button>
  <div class="dropdown-content">
  <a href="driver">Add Driver</a>
    	<a href="viewdriver">View Driver</a>
    	
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
  <button class="dropbtn" onclick="return confirm('Are you sure you want to logout');"><a href="logout">Logout</a></button>
  </div>
	
	
	
	<div class="w3-container w3-blue"></div>
	<form action="updateload" method="post">
		<table align="center" width="40%" width="100%" cellspacing="0"
			cellpadding="0">
			
		
			

			<tr>
				<td align="center" colspan="2"><h2 style="color: blue">
						<b>Load Update Form</b>
					</h2></td>
			</tr>


			<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Load Number*</h4></td>
				<td width="30%"><b>${loadobj.getLoadNumber()}</b>
				<input type="hidden" name="loadNumber" value="${loadobj.getLoadNumber()}" readonly />
				</td>
			</tr>

				<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Truck Number*</h4></td>
						
						
						
						
						
						
				
				<td><select name="truckNumber">

						<c:forEach var="user" items="${list}">
							<option value="${user.getTrucknumber()}">${user.getTrucknumber()} </option>


						</c:forEach>
				</select></td>
				
				
				
			</tr>
				
			
				


			<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Gross*</h4></td>
				<td width="30%"><input type="text" name="gross" value="${loadobj.getGross() }" id="gross1" onchange="myFunction1()"></td>
			</tr>





		
			<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Dispatcher Commission *</h4></td>
				<td><input type="text" name="dispatureCommission" id="dpc"value="${loadobj.getDispatureCommission() }"readonly></td>
			</tr>

			<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Gross after commission *</h4></td>
				<td><input type="text" name="grossafterCommision" id="acg" value="${loadobj.getGrossafterCommision() }" readonly></td>
			</tr>
			
			
			<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Pickup date Date*</h4></td>
				<td width="30%"><input type="date" name="pickupDate" value="${loadobj.getPickupDate() }" > <input type="hidden" name="totalamountpaid" value="${loadobj.getTotalamountpaid() }"></td>
			</tr>
				
			
			
			
				<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Pickup City*</h4></td>
				<td><input type="text" name="pickupCity" value="${loadobj.getPickupCity() }"></td>
			</tr>
			
			
				<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Pickup State*</h4></td>
				<td><input type="text" name="pickupState" value="${loadobj.getPickupState() }"></td>
			</tr>
			
			
			
			
			<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Drop OFF Date*</h4></td>
				<td width="30%"><input type="date" name="dropoffDate" value="${loadobj.getDropoffDate() }"  ></td>
			</tr>
				
			
			
			
			
				<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Drop OFF City*</h4></td>
				<td><input type="text" name="dropCity" value="${loadobj.getDropCity() }"></td>
			</tr>
			
			
				<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Drop OFF State*</h4></td>
				<td><input type="text" name="dropState" value="${loadobj.getDropState()  }"></td>
			</tr>
			
			<tr>
				<td align="left" valign="top" width="30%"><h4
						style="color: white;">Status*</h4></td>
				<td><select name="status">
  <option value="1">Open</option>
  <option value="0">Close</option>
</select></td>
			</tr>
			
					
						
			
			
			<tr>
				<td align="center" colspan="2" ><input type="submit"
					value="Update Load"onclick="return confirm('Are you sure you want to Update this profile');"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>