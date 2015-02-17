package com.gtfs.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductChangeDto implements Serializable{
	private List<Long> termList = new ArrayList<Long>();
	private Map<String ,String> payModeList = new HashMap<String ,String>();

	public List<Long> getTermList() {
		return termList;
	}

	public void setTermList(List<Long> termList) {
		this.termList = termList;
	}

	public Map<String, String> getPayModeList() {
		return payModeList;
	}

	public void setPayModeList(Map<String, String> payModeList) {
		this.payModeList = payModeList;
	}
	
	
}
