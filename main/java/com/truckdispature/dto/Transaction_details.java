package com.truckdispature.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Transaction_details {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transno;
	@Column
	private Integer loadnumber;
	@Column
	private Double grossaftercommission;
	@Column
	private Double advance;
	@Column
	private String advancetype;
	@Column
	private Timestamp datetime;
	
	public Integer getTransno() {
		return transno;
	}
	public void setTransno(Integer transno) {
		this.transno = transno;
	}
	public Integer getLoadnumber() {
		return loadnumber;
	}
	public void setLoadnumber(Integer loadnumber) {
		this.loadnumber = loadnumber;
	}
	public Double getGrossaftercommission() {
		return grossaftercommission;
	}
	public void setGrossaftercommission(Double grossaftercommission) {
		this.grossaftercommission = grossaftercommission;
	}
	public Double getAdvance() {
		return advance;
	}
	public void setAdvance(Double advance) {
		this.advance = advance;
	}
	public String getAdvancetype() {
		return advancetype;
	}
	public void setAdvancetype(String advancetype) {
		this.advancetype = advancetype;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	


	
}
