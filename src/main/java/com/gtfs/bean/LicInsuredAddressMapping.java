package com.gtfs.bean;

// Generated 30 Aug, 2014 4:24:58 PM by Hibernate Tools 3.4.0.CR1


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * LicInsuredAddressMapping generated by hbm2java
 */
@Entity
@Table(name = "LIC_INSURED_ADDRESS_MAPPING")
public class LicInsuredAddressMapping implements java.io.Serializable {

	private Long id;
	private LicAddressDtls licAddressDtls;
	private LicInsuredDtls licInsuredDtls;
	private String addressType;
	private Long createdBy;
	private Long modifiedBy;
	private Long deletedBy;
	private Date createdDate;
	private Date modifiedDate;
	private Date deletedDate;
	private String deleteFlag;

	public LicInsuredAddressMapping() {
	}

	public LicInsuredAddressMapping(Long id) {
		this.id = id;
	}

	public LicInsuredAddressMapping(Long id,
			LicAddressDtls licAddressDtls, LicInsuredDtls licInsuredDtls,
			String addressType, Long createdBy, Long modifiedBy,
			Long deletedBy, Date createdDate, Date modifiedDate,
			Date deletedDate, String deleteFlag) {
		this.id = id;
		this.licAddressDtls = licAddressDtls;
		this.licInsuredDtls = licInsuredDtls;
		this.addressType = addressType;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.deletedBy = deletedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.deletedDate = deletedDate;
		this.deleteFlag = deleteFlag;
	}

	@Id
	@SequenceGenerator(name="LIC_INSURED_ADD_MAPPING_SEQ",sequenceName="LIC_INSURED_ADD_MAPPING_SEQ")
	@GeneratedValue(generator="LIC_INSURED_ADD_MAPPING_SEQ",strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIC_ADDRESS_DTLS_ID")
	@Cascade({CascadeType.SAVE_UPDATE})
	public LicAddressDtls getLicAddressDtls() {
		return this.licAddressDtls;
	}

	public void setLicAddressDtls(LicAddressDtls licAddressDtls) {
		this.licAddressDtls = licAddressDtls;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIC_INSURED_DTLS_ID")
	@Cascade({CascadeType.SAVE_UPDATE})
	public LicInsuredDtls getLicInsuredDtls() {
		return this.licInsuredDtls;
	}

	public void setLicInsuredDtls(LicInsuredDtls licInsuredDtls) {
		this.licInsuredDtls = licInsuredDtls;
	}

	
	@Column(name = "ADDRESS_TYPE", length = 1)
	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
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

}
