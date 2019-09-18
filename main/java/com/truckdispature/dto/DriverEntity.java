package com.truckdispature.dto;

import java.sql.Date;

public class DriverEntity {

	private String name;
	private Date dob;
	private String ssn;
	private Date licence_expiration;
	private Date medical_expiration;
	private Date testexpiry;
	private String assignedtruck;
	private String ownername;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getLicence_expiration() {
		return licence_expiration;
	}

	public void setLicence_expiration(Date licence_expiration) {
		this.licence_expiration = licence_expiration;
	}

	public Date getMedical_expiration() {
		return medical_expiration;
	}

	public void setMedical_expiration(Date medical_expiration) {
		this.medical_expiration = medical_expiration;
	}

	public Date getTestexpiry() {
		return testexpiry;
	}

	public void setTestexpiry(Date testexpiry) {
		this.testexpiry = testexpiry;
	}

	public String getAssignedtruck() {
		return assignedtruck;
	}

	public void setAssignedtruck(String assignedtruck) {
		this.assignedtruck = assignedtruck;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

}
