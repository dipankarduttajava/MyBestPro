package com.gtfs.bean;

// Generated 30 Aug, 2014 4:24:58 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
 * DivisionMst generated by hbm2java
 */
@Entity
@Table(name = "DIVISION_MST")
public class DivisionMst implements java.io.Serializable {

	private Long divId;
	private RegionMst regionMstByPrntRegIdBns;
	private StateMst stateMst;
	private RegionMst regionMstByPrntRegIdOps;
	private String divName;
	private String divAbbr;
	private String divCode;
	private String addr1;
	private String addr2;
	private String addr3;
	private String city;
	private Long pin;
	private String phone;
	private String mobile;
	private String email;
	private String activeFlag;
	private Long trnfLoc;
	private String remarks;
	private Long userId;
	private Date dateTime;
	private Set<UserMst> userMsts = new HashSet<UserMst>(0);
	private Set<BranchMst> branchMstsForPrntDivIdBns = new HashSet<BranchMst>(0);
	private Set<BranchMst> branchMstsForPrntDivIdOps = new HashSet<BranchMst>(0);
	

	public DivisionMst() {
	}

	public DivisionMst(Long divId) {
		this.divId = divId;
	}

	public DivisionMst(Long divId, RegionMst regionMstByPrntRegIdBns,
			StateMst stateMst, RegionMst regionMstByPrntRegIdOps,
			String divName, String divAbbr, String divCode, String addr1,
			String addr2, String addr3, String city, Long pin,
			String phone, String mobile, String email, String activeFlag,
			Long trnfLoc, String remarks, Long userId,
			Date dateTime, Set<UserMst> userMsts,
			Set<BranchMst> branchMstsForPrntDivIdBns,
			Set<BranchMst> branchMstsForPrntDivIdOps) {
		this.divId = divId;
		this.regionMstByPrntRegIdBns = regionMstByPrntRegIdBns;
		this.stateMst = stateMst;
		this.regionMstByPrntRegIdOps = regionMstByPrntRegIdOps;
		this.divName = divName;
		this.divAbbr = divAbbr;
		this.divCode = divCode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.city = city;
		this.pin = pin;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.activeFlag = activeFlag;
		this.trnfLoc = trnfLoc;
		this.remarks = remarks;
		this.userId = userId;
		this.dateTime = dateTime;
		this.userMsts = userMsts;
		this.branchMstsForPrntDivIdBns = branchMstsForPrntDivIdBns;
		this.branchMstsForPrntDivIdOps = branchMstsForPrntDivIdOps;
	}

	@Id
	@Column(name = "DIV_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getDivId() {
		return this.divId;
	}

	public void setDivId(Long divId) {
		this.divId = divId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRNT_REG_ID_BNS")
	public RegionMst getRegionMstByPrntRegIdBns() {
		return this.regionMstByPrntRegIdBns;
	}

	public void setRegionMstByPrntRegIdBns(RegionMst regionMstByPrntRegIdBns) {
		this.regionMstByPrntRegIdBns = regionMstByPrntRegIdBns;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE_ID")
	public StateMst getStateMst() {
		return this.stateMst;
	}

	public void setStateMst(StateMst stateMst) {
		this.stateMst = stateMst;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRNT_REG_ID_OPS")
	public RegionMst getRegionMstByPrntRegIdOps() {
		return this.regionMstByPrntRegIdOps;
	}

	public void setRegionMstByPrntRegIdOps(RegionMst regionMstByPrntRegIdOps) {
		this.regionMstByPrntRegIdOps = regionMstByPrntRegIdOps;
	}

	@Column(name = "DIV_NAME", length = 50)
	public String getDivName() {
		return this.divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}

	@Column(name = "DIV_ABBR", length = 3)
	public String getDivAbbr() {
		return this.divAbbr;
	}

	public void setDivAbbr(String divAbbr) {
		this.divAbbr = divAbbr;
	}

	@Column(name = "DIV_CODE", length = 15)
	public String getDivCode() {
		return this.divCode;
	}

	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	@Column(name = "ADDR_1", length = 250)
	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	@Column(name = "ADDR_2", length = 50)
	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	@Column(name = "ADDR_3", length = 50)
	public String getAddr3() {
		return this.addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	@Column(name = "CITY", length = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "PIN", precision = 22, scale = 0)
	public Long getPin() {
		return this.pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	@Column(name = "PHONE", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "MOBILE", length = 15)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ACTIVE_FLAG", length = 1)
	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "TRNF_LOC", precision = 22, scale = 0)
	public Long getTrnfLoc() {
		return this.trnfLoc;
	}

	public void setTrnfLoc(Long trnfLoc) {
		this.trnfLoc = trnfLoc;
	}

	@Column(name = "REMARKS", length = 500)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "divisionMst")
	public Set<UserMst> getUserMsts() {
		return this.userMsts;
	}

	public void setUserMsts(Set<UserMst> userMsts) {
		this.userMsts = userMsts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "divisionMstByPrntDivIdBns")
	public Set<BranchMst> getBranchMstsForPrntDivIdBns() {
		return this.branchMstsForPrntDivIdBns;
	}

	public void setBranchMstsForPrntDivIdBns(
			Set<BranchMst> branchMstsForPrntDivIdBns) {
		this.branchMstsForPrntDivIdBns = branchMstsForPrntDivIdBns;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "divisionMstByPrntDivIdOps")
	public Set<BranchMst> getBranchMstsForPrntDivIdOps() {
		return this.branchMstsForPrntDivIdOps;
	}

	public void setBranchMstsForPrntDivIdOps(
			Set<BranchMst> branchMstsForPrntDivIdOps) {
		this.branchMstsForPrntDivIdOps = branchMstsForPrntDivIdOps;
	}

}