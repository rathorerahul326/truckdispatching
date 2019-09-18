package com.truckdispature.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "LoadMaster")
public class LoadMaster {

	@Id
	private Integer loadNumber;
	@Column
	private String truckNumber;
	@Column
	private Double gross;
	@Column
	private Double dispatureCommission;
	@Column
	private Double grossafterCommision;
	@Column
	private Date pickupDate;
	@Column
	private String pickupCity;
	@Column
	private String pickupState;
	@Column
	private Date dropoffDate;
	@Column
	private String dropCity;
	@Column
	private String dropState;
	@Column
	private Double totalamountpaid;
	@Column
	private Integer status;
	@Column
	private Double finalGross;
	
	public Integer getLoadNumber() {
		return loadNumber;
	}
	public void setLoadNumber(Integer loadNumber) {
		this.loadNumber = loadNumber;
	}
	public String getTruckNumber() {
		return truckNumber;
	}
	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}
	public Double getGross() {
		return gross;
	}
	public void setGross(Double gross) {
		this.gross = gross;
	}
	public Double getDispatureCommission() {
		return dispatureCommission;
	}
	public void setDispatureCommission(Double dispatureCommission) {
		this.dispatureCommission = dispatureCommission;
	}
	public Double getGrossafterCommision() {
		return grossafterCommision;
	}
	public void setGrossafterCommision(Double grossafterCommision) {
		this.grossafterCommision = grossafterCommision;
	}
	public Date getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	public String getPickupCity() {
		return pickupCity;
	}
	public void setPickupCity(String pickupCity) {
		this.pickupCity = pickupCity;
	}
	public String getPickupState() {
		return pickupState;
	}
	public void setPickupState(String pickupState) {
		this.pickupState = pickupState;
	}
	public Date getDropoffDate() {
		return dropoffDate;
	}
	public void setDropoffDate(Date dropoffDate) {
		this.dropoffDate = dropoffDate;
	}
	public String getDropCity() {
		return dropCity;
	}
	public void setDropCity(String dropCity) {
		this.dropCity = dropCity;
	}
	public String getDropState() {
		return dropState;
	}
	public void setDropState(String dropState) {
		this.dropState = dropState;
	}
	public Double getTotalamountpaid() {
		return totalamountpaid;
	}
	public void setTotalamountpaid(Double totalamountpaid) {
		this.totalamountpaid = totalamountpaid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Double getFinalGross() {
		return finalGross;
	}
	public void setFinalGross(Double finalGross) {
		this.finalGross = finalGross;
	}
	

	
}
