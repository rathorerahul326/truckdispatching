package com.truckdispature.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
// @Proxy(lazy=false)
public class Driver {

	@Column
	private String name;
	@Column
	private Date dob;
	@Id
	private String ssn;
	@Column
	private Date licence_expiration;
	@Column
	private Date medical_expiration;
	@Column
	private Date testexpiry;
	@Column
	private String assignedtruck;
	@Column
	private String truckowner;
	

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


	public String getTruckowner() {
		return truckowner;
	}

	public void setTruckowner(String truckowner) {
		this.truckowner = truckowner;
	}


}
