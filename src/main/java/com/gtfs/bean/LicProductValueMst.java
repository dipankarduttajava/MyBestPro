package com.gtfs.bean;

// Generated 30 Aug, 2014 4:24:58 PM by Hibernate Tools 3.4.0.CR1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LicProductValueMst generated by hbm2java
 */
@Entity
@Table(name = "LIC_PRODUCT_VALUE_MST")
public class LicProductValueMst implements java.io.Serializable {

	private Long id;
	private LicProductMst licProductMst;
	private TieupCompyMst tieupCompyMst;
	private SchemeMst schemeMst;
	private Double collBenPct;
	private String oblApplNo;
	private Integer age;
	private Long policyTerm;
	private Long premiumPayingTerm;
	private Double basicPrem;
	private Double tabPrem;
	private Double sumAssured;
	private String payNature;
	private Double taxOnPrem;
	private String nsapFlag;
	private Double nsapAmt;
	private LicNsapDocMst licNsapDocMst;
	private String arFlag;
	private Double arAmt;
	private Double totalAmt;
	private String modeRebateFlag;
	private Double modeRebateAmt;
	private Double shortAmount;
	private Long createdBy;
	private Long modifiedBy;
	private Long deletedBy;
	private Date createdDate;
	private Date modifiedDate;
	private Date deletedDate;
	private String deleteFlag;
	private Set<LicOblApplicationMst> licOblApplicationMsts = new HashSet<LicOblApplicationMst>(0);
	private Set<LicOblChecklist> licOblChecklists = new HashSet<LicOblChecklist>(0);

	public LicProductValueMst() {
	}

	public LicProductValueMst(Long id, String payNature) {
		this.id = id;
		this.payNature = payNature;
	}

	
	@Id
	@Column(name = "ID", nullable = false, precision = 22, scale = 0)
	@SequenceGenerator(name="LIC_PRODUCT_VALUE_MST_SEQ",sequenceName="LIC_PRODUCT_VALUE_MST_SEQ")
	@GeneratedValue(generator="LIC_PRODUCT_VALUE_MST_SEQ",strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIC_PRODUCT_MST_ID")
	public LicProductMst getLicProductMst() {
		return this.licProductMst;
	}
	public void setLicProductMst(LicProductMst licProductMst) {
		this.licProductMst = licProductMst;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIEUP_COMPY_MST_ID")
	public TieupCompyMst getTieupCompyMst() {
		return tieupCompyMst;
	}
	public void setTieupCompyMst(TieupCompyMst tieupCompyMst) {
		this.tieupCompyMst = tieupCompyMst;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCHEME_MST_ID")
	public SchemeMst getSchemeMst() {
		return schemeMst;
	}
	public void setSchemeMst(SchemeMst schemeMst) {
		this.schemeMst = schemeMst;
	}
	
	
	@Column(name = "COLL_BEN_PCT", precision = 22, scale = 0)
	public Double getCollBenPct() {
		return collBenPct;
	}
	public void setCollBenPct(Double collBenPct) {
		this.collBenPct = collBenPct;
	}

	
	@Column(name = "POLICY_TERM", precision = 22, scale = 0)
	public Long getPolicyTerm() {
		return policyTerm;
	}
	public void setPolicyTerm(Long policyTerm) {
		this.policyTerm = policyTerm;
	}
	
	
	@Column(name = "PREMIUM_PAYING_TERM", precision = 22, scale = 0)
	public Long getPremiumPayingTerm() {
		return premiumPayingTerm;
	}
	public void setPremiumPayingTerm(Long premiumPayingTerm) {
		this.premiumPayingTerm = premiumPayingTerm;
	}

	
	@Column(name = "AGE", precision = 22, scale = 0)
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	@Column(name = "TAB_PREM", precision = 22, scale = 0)
	public Double getTabPrem() {
		return tabPrem;
	}
	public void setTabPrem(Double tabPrem) {
		this.tabPrem = tabPrem;
	}

	
	@Column(name = "BASIC_PREM", precision = 22, scale = 0)
	public Double getBasicPrem() {
		return basicPrem;
	}
	public void setBasicPrem(Double basicPrem) {
		this.basicPrem = basicPrem;
	}

	
	@Column(name = "SUM_ASSURED", precision = 22, scale = 0)
	public Double getSumAssured() {
		return this.sumAssured;
	}
	public void setSumAssured(Double sumAssured) {
		this.sumAssured = sumAssured;
	}

	
	@Column(name = "PAY_NATURE", nullable = false, length = 1)
	public String getPayNature() {
		return this.payNature;
	}
	public void setPayNature(String payNature) {
		this.payNature = payNature;
	}

	
	@Column(name = "TAX_ON_PREM", precision = 22, scale = 0)
	public Double getTaxOnPrem() {
		return this.taxOnPrem;
	}
	public void setTaxOnPrem(Double taxOnPrem) {
		this.taxOnPrem = taxOnPrem;
	}
	
	
	@Column(name="NSAP_FLAG",length=5)
	public String getNsapFlag() {
		return nsapFlag;
	}
	public void setNsapFlag(String nsapFlag) {
		this.nsapFlag = nsapFlag;
	}
	
	
	@Column(name = "NSAP_AMT", precision = 22, scale = 0)
	public Double getNsapAmt() {
		return nsapAmt;
	}
	public void setNsapAmt(Double nsapAmt) {
		this.nsapAmt = nsapAmt;
	}

	
	@Column(name="AR_FLAG",length=5)
	public String getArFlag() {
		return arFlag;
	}
	public void setArFlag(String arFlag) {
		this.arFlag = arFlag;
	}
	
	
	@Column(name="MODE_REBATE_FLAG",length=5)
	public String getModeRebateFlag() {
		return modeRebateFlag;
	}
	public void setModeRebateFlag(String modeRebateFlag) {
		this.modeRebateFlag = modeRebateFlag;
	}
	
	
	@Column(name = "MODE_REBATE_AMT", precision = 22, scale = 0)
	public Double getModeRebateAmt() {
		return modeRebateAmt;
	}
	public void setModeRebateAmt(Double modeRebateAmt) {
		this.modeRebateAmt = modeRebateAmt;
	}

	
	@Column(name = "AR_AMT", precision = 22, scale = 0)
	public Double getArAmt() {
		return arAmt;
	}
	public void setArAmt(Double arAmt) {
		this.arAmt = arAmt;
	}
	
	
	@Column(name = "TOTAL_AMT", precision = 22, scale = 0)
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	
	@Column(name = "OBL_APPL_NO", length=50)
	public String getOblApplNo() {
		return this.oblApplNo;
	}
	public void setOblApplNo(String oblApplNo) {
		this.oblApplNo = oblApplNo;
	}
	
	
	@Column(name = "SHORT_AMOUNT", precision = 22, scale = 0)
	public Double getShortAmount() {
		return shortAmount;
	}
	public void setShortAmount(Double shortAmount) {
		this.shortAmount = shortAmount;
	}

	
	@Column(name = "CREATED_BY", precision = 22, scale = 0)
	public Long getCreatedBy() {
		return this.createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	

	@Column(name = "MODIFIED_BY", precision = 22, scale = 0)
	public Long getModifiedBy() {
		return this.modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	
	@Column(name = "DELETED_BY", precision = 22, scale = 0)
	public Long getDeletedBy() {
		return this.deletedBy;
	}
	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", length = 7)
	public Date getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_DATE", length = 7)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(name = "DELETED_DATE", length = 7)
	public Date getDeletedDate() {
		return this.deletedDate;
	}
	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	
	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licProductValueMst")
	public Set<LicOblApplicationMst> getLicOblApplicationMsts() {
		return this.licOblApplicationMsts;
	}
	public void setLicOblApplicationMsts(
			Set<LicOblApplicationMst> licOblApplicationMsts) {
		this.licOblApplicationMsts = licOblApplicationMsts;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licProductValueMst")
	public Set<LicOblChecklist> getLicOblChecklists() {
		return this.licOblChecklists;
	}
	public void setLicOblChecklists(Set<LicOblChecklist> licOblChecklists) {
		this.licOblChecklists = licOblChecklists;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIC_NSAP_DOC_ID")
	public LicNsapDocMst getLicNsapDocMst() {
		return licNsapDocMst;
	}
	public void setLicNsapDocMst(LicNsapDocMst licNsapDocMst) {
		this.licNsapDocMst = licNsapDocMst;
	}

}
