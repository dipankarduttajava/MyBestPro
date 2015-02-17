package com.gtfs.bean;

// Generated 30 Aug, 2014 4:24:58 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JoinProdMst generated by hbm2java
 */
@Entity
@Table(name = "JOIN_PROD_MST")
public class JoinProdMst implements java.io.Serializable {

	private String joinProdId;
	private TieupCompyMst tieupCompyMst;
	private SchemeMst schemeMst;
	private String joinProdDesc;
	private String spotApplicable;
	private Long spotAmount;
	private Long prodValue;
	private Long salesTax;
	private Long svcChrgs;
	private Long svcTax;
	private Long collBenPct;
	private String activeFlag;
	private Long userId;
	private Date dateTime;
	private Set<AgentMst> agentMsts = new HashSet<AgentMst>(0);

	public JoinProdMst() {
	}

	public JoinProdMst(String joinProdId, TieupCompyMst tieupCompyMst,
			SchemeMst schemeMst, String joinProdDesc, String spotApplicable,
			Long prodValue, Long collBenPct, String activeFlag) {
		this.joinProdId = joinProdId;
		this.tieupCompyMst = tieupCompyMst;
		this.schemeMst = schemeMst;
		this.joinProdDesc = joinProdDesc;
		this.spotApplicable = spotApplicable;
		this.prodValue = prodValue;
		this.collBenPct = collBenPct;
		this.activeFlag = activeFlag;
	}

	public JoinProdMst(String joinProdId, TieupCompyMst tieupCompyMst,
			SchemeMst schemeMst, String joinProdDesc, String spotApplicable,
			Long spotAmount, Long prodValue, Long salesTax,
			Long svcChrgs, Long svcTax, Long collBenPct,
			String activeFlag, Long userId, Date dateTime,
			Set<AgentMst> agentMsts) {
		this.joinProdId = joinProdId;
		this.tieupCompyMst = tieupCompyMst;
		this.schemeMst = schemeMst;
		this.joinProdDesc = joinProdDesc;
		this.spotApplicable = spotApplicable;
		this.spotAmount = spotAmount;
		this.prodValue = prodValue;
		this.salesTax = salesTax;
		this.svcChrgs = svcChrgs;
		this.svcTax = svcTax;
		this.collBenPct = collBenPct;
		this.activeFlag = activeFlag;
		this.userId = userId;
		this.dateTime = dateTime;
		this.agentMsts = agentMsts;
	}

	@Id
	@Column(name = "JOIN_PROD_ID", unique = true, nullable = false, length = 20)
	public String getJoinProdId() {
		return this.joinProdId;
	}

	public void setJoinProdId(String joinProdId) {
		this.joinProdId = joinProdId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIE_COMPY_ID", nullable = false)
	public TieupCompyMst getTieupCompyMst() {
		return this.tieupCompyMst;
	}

	public void setTieupCompyMst(TieupCompyMst tieupCompyMst) {
		this.tieupCompyMst = tieupCompyMst;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCH_ID", nullable = false)
	public SchemeMst getSchemeMst() {
		return this.schemeMst;
	}

	public void setSchemeMst(SchemeMst schemeMst) {
		this.schemeMst = schemeMst;
	}

	@Column(name = "JOIN_PROD_DESC", nullable = false, length = 30)
	public String getJoinProdDesc() {
		return this.joinProdDesc;
	}

	public void setJoinProdDesc(String joinProdDesc) {
		this.joinProdDesc = joinProdDesc;
	}

	@Column(name = "SPOT_APPLICABLE", nullable = false, length = 1)
	public String getSpotApplicable() {
		return this.spotApplicable;
	}

	public void setSpotApplicable(String spotApplicable) {
		this.spotApplicable = spotApplicable;
	}

	@Column(name = "SPOT_AMOUNT", precision = 22, scale = 0)
	public Long getSpotAmount() {
		return this.spotAmount;
	}

	public void setSpotAmount(Long spotAmount) {
		this.spotAmount = spotAmount;
	}

	@Column(name = "PROD_VALUE", nullable = false, precision = 22, scale = 0)
	public Long getProdValue() {
		return this.prodValue;
	}

	public void setProdValue(Long prodValue) {
		this.prodValue = prodValue;
	}

	@Column(name = "SALES_TAX", precision = 22, scale = 0)
	public Long getSalesTax() {
		return this.salesTax;
	}

	public void setSalesTax(Long salesTax) {
		this.salesTax = salesTax;
	}

	@Column(name = "SVC_CHRGS", precision = 22, scale = 0)
	public Long getSvcChrgs() {
		return this.svcChrgs;
	}

	public void setSvcChrgs(Long svcChrgs) {
		this.svcChrgs = svcChrgs;
	}

	@Column(name = "SVC_TAX", precision = 22, scale = 0)
	public Long getSvcTax() {
		return this.svcTax;
	}

	public void setSvcTax(Long svcTax) {
		this.svcTax = svcTax;
	}

	@Column(name = "COLL_BEN_PCT", nullable = false, precision = 22, scale = 0)
	public Long getCollBenPct() {
		return this.collBenPct;
	}

	public void setCollBenPct(Long collBenPct) {
		this.collBenPct = collBenPct;
	}

	@Column(name = "ACTIVE_FLAG", nullable = false, length = 1)
	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "USER_ID", precision = 22, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "DATE_TIME")
	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "joinProdMst")
	public Set<AgentMst> getAgentMsts() {
		return this.agentMsts;
	}

	public void setAgentMsts(Set<AgentMst> agentMsts) {
		this.agentMsts = agentMsts;
	}

}