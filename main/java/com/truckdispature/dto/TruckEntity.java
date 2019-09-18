package com.truckdispature.dto;

import java.sql.Date;

public class TruckEntity {

	private String trucknumber;
	private Integer mileage;
	private Date expiredate;
	private Integer maxload;
	private String name;
	private String ownerssn;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerssn() {
		return ownerssn;
	}

	public void setOwnerssn(String ownerssn) {
		this.ownerssn = ownerssn;
	}

}
