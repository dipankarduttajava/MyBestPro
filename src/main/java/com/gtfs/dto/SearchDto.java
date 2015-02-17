package com.gtfs.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchDto implements Serializable {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date businessFromDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date businessToDate;
	private Long hubId;
	public Date getBusinessFromDate() {
		return businessFromDate;
	}
	public void setBusinessFromDate(Date businessFromDate) {
		this.businessFromDate = businessFromDate;
	}
	public Date getBusinessToDate() {
		return businessToDate;
	}
	public void setBusinessToDate(Date businessToDate) {
		this.businessToDate = businessToDate;
	}
	public Long getHubId() {
		return hubId;
	}
	public void setHubId(Long hubId) {
		this.hubId = hubId;
	}
	
	
}
