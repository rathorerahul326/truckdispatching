<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/main1.js" />"></script>

<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/0.9.0rc1/jspdf.min.js"></script>


<title>Driver Page</title>



<body bgcolor="#999999">

		<div class="header">

			<h1>Truck Dispatching</h1>
		</div>


		<br> <br> 


		<center>
			<h2>Transaction Details of Load NO:- ${param.loadnumber}</h2>

			<table id="myTable">
				<tr class="header">
					<th style="width: 30%;"><b>Trasaction Id</b></th>
					<th style="width: 30%;"><b>DateTime</b></th>
					<th style="width: 30%;"><b>Advance</b></th>
					<th style="width: 30%;"><b>Gross After Commission</b></th>
					<th style="width: 30%;"><b>Advance Type</b></th>
					<th style="width: 30%;"><b>Load Number</b></th>

				</tr>

				<c:forEach var="user" items="${transList}">
					<tr>
						<td>${user.getTransno()}</td>
						<td>${user.getDatetime()}</td>
						<td>${user.getAdvance()}</td>
						<td>${user.getGrossaftercommission()}</td>
						<td>${user.getAdvancetype()}</td>
						<td>${user.getLoadnumber()}</td>
						

					</tr>
				</c:forEach>
			</table>

		</center>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<a href="viewload" style="text-decoration: none;">Back</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<a href="editEmi?transId=${transId}"> Edit Last Advance</a>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<a href="report/?type=xls&loadnumber=${param.loadnumber}&truckNumber=${param.truckNumber}"> Download Excel</a> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<a href="report/?type=pdf&loadnumber=${param.loadnumber}&truckNumber=${param.truckNumber}"> Download Pdf</a>
</body>
</html>