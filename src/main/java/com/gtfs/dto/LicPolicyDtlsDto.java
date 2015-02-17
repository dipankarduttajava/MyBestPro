package com.gtfs.dto;

import java.io.Serializable;
import java.util.Date;

public class LicPolicyDtlsDto implements Serializable{

	private String policyNo;
	private Date payDate;
	private String insuredName;
	private String proposerName;
	private String product;
	private String healthFlag;
	private String payMode;
	private Long dueYears;
	private Date fromDueDate;
	private Date toDueDate;
	private String payNature;
	private String branchName;
	private String sendingHub;
	private String healthValidated;
	private String paymentPayMode;
	private Double cashAmt;
	private Double chqDDAmt;
	private Double totalAmt;
	private Long licRnlPayId;
	private String hubName;
	
	
	/* GETTER SETTER */
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getProposerName() {
		return proposerName;
	}
	public void setProposerName(String proposerName) {
		this.proposerName = proposerName;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getHealthFlag() {
		return healthFlag;
	}
	public void setHealthFlag(String healthFlag) {
		this.healthFlag = healthFlag;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public Long getDueYears() {
		return dueYears;
	}
	public void setDueYears(Long dueYears) {
		this.dueYears = dueYears;
	}
	public Date getFromDueDate() {
		return fromDueDate;
	}
	public void setFromDueDate(Date fromDueDate) {
		this.fromDueDate = fromDueDate;
	}
	public Date getToDueDate() {
		return toDueDate;
	}
	public void setToDueDate(Date toDueDate) {
		this.toDueDate = toDueDate;
	}
	public String getPayNature() {
		return payNature;
	}
	public void setPayNature(String payNature) {
		this.payNature = payNature;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getSendingHub() {
		return sendingHub;
	}
	public void setSendingHub(String sendingHub) {
		this.sendingHub = sendingHub;
	}
	public String getHealthValidated() {
		return healthValidated;
	}
	public void setHealthValidated(String healthValidated) {
		this.healthValidated = healthValidated;
	}
	public Double getCashAmt() {
		return cashAmt;
	}
	public void setCashAmt(Double cashAmt) {
		this.cashAmt = cashAmt;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getPaymentPayMode() {
		return paymentPayMode;
	}
	public void setPaymentPayMode(String paymentPayMode) {
		this.paymentPayMode = paymentPayMode;
	}
	public Double getChqDDAmt() {
		return chqDDAmt;
	}
	public void setChqDDAmt(Double chqDDAmt) {
		this.chqDDAmt = chqDDAmt;
	}
	public Long getLicRnlPayId() {
		return licRnlPayId;
	}
	public void setLicRnlPayId(Long licRnlPayId) {
		this.licRnlPayId = licRnlPayId;
	}
	public String getHubName() {
		return hubName;
	}
	public void setHubName(String hubName) {
		this.hubName = hubName;
	}
}