package com.truckdispature.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Truck")
public class Truck {

	@Id
	private String trucknumber;
	@Column
	private Integer mileage;
	@Column
	private Date expiredate;
	@Column
	private Integer maxload;
	@Column
	private String ssn;
	@Column
	private String registrationNumber;


	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getTrucknumber() {
		return trucknumber;
	}

	public void setTrucknumber(String trucknumber) {
		this.trucknumber = trucknumber;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}


	public Date getExpiredate() {
		return expiredate;
	}

	public void setExpiredate(Date expiredate) {
		this.expiredate = expiredate;
	}

	public Integer getMaxload() {
		return maxload;
	}

	public void setMaxload(Integer maxload) {
		this.maxload = maxload;
	}

}
