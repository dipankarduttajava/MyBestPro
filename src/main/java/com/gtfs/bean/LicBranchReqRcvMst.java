package com.gtfs.bean;

import java.io.Serializable;
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
@Entity
@Table(name = "LIC_BRANCH_REQ_RCV_MST")
public class LicBranchReqRcvMst implements Serializable{
	private Long id;
	private LicRequirementDtls licRequirementDtls;
	private LicBrnhHubPicMapDtls licBrnhHubPicMapDtls;
	private LicBrnhHubPicPodDtls licBrnhHubPicPodDtls;	
	private Long createdBy;
	private Long modifiedBy;
	private Long deletedBy;
	private Date createdDate;
	private Date modifiedDate;
	private Date deletedDate;
	private String deleteFlag;
	
	
	@Id
	@SequenceGenerator(name="LIC_BRANCH_REQ_RCV_MST_SEQ",sequenceName="LIC_BRANCH_REQ_RCV_MST_SEQ")
	@GeneratedValue(generator="LIC_BRANCH_REQ_RCV_MST_SEQ",strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIC_REQ_DTLS_ID")
	@Cascade({CascadeType.SAVE_UPDATE})
	public LicRequirementDtls getLicRequirementDtls() {
		return licRequirementDtls;
	}
	public void setLicRequirementDtls(LicRequirementDtls licRequirementDtls) {
		this.licRequirementDtls = licRequirementDtls;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRNH_HUB_MAP_DTLS_ID")
	public LicBrnhHubPicMapDtls getLicBrnhHubPicMapDtls() {
		return licBrnhHubPicMapDtls;
	}
	public void setLicBrnhHubPicMapDtls(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls) {
		this.licBrnhHubPicMapDtls = licBrnhHubPicMapDtls;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRNH_HUB_POD_DTLS_ID")
	public LicBrnhHubPicPodDtls getLicBrnhHubPicPodDtls() {
		return licBrnhHubPicPodDtls;
	}
	public void setLicBrnhHubPicPodDtls(LicBrnhHubPicPodDtls licBrnhHubPicPodDtls) {
		this.licBrnhHubPicPodDtls = licBrnhHubPicPodDtls;
	}
}
