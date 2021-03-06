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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * StateMst generated by hbm2java
 */
@Entity
@Table(name = "STATE_MST")
public class StateMst implements java.io.Serializable {

	private Long stateId;
	private String stateName;
	private String stateAbbr;
	private String activeFlag;
	private Long userId;
	private Date dateTime;
	private Set<CampMst> campMsts = new HashSet<CampMst>(0);
	private Set<RegionMst> regionMsts = new HashSet<RegionMst>(0);
	private Set<LicAddressDtls> licAddressDtlses = new HashSet<LicAddressDtls>(
			0);
	private Set<HoMst> hoMsts = new HashSet<HoMst>(0);
	private Set<DivisionMst> divisionMsts = new HashSet<DivisionMst>(0);
	private Set<AgentMst> agentMsts = new HashSet<AgentMst>(0);
	private Set<BranchMst> branchMsts = new HashSet<BranchMst>(0);

	public StateMst() {
	}

	public StateMst(Long stateId) {
		this.stateId = stateId;
	}

	public StateMst(Long stateId, String stateName, String stateAbbr,
			String activeFlag, Long userId, Date dateTime,
			Set<CampMst> campMsts, Set<RegionMst> regionMsts,
			Set<LicAddressDtls> licAddressDtlses, Set<HoMst> hoMsts,
			Set<DivisionMst> divisionMsts, Set<AgentMst> agentMsts,
			Set<BranchMst> branchMsts) {
		this.stateId = stateId;
		this.stateName = stateName;
		this.stateAbbr = stateAbbr;
		this.activeFlag = activeFlag;
		this.userId = userId;
		this.dateTime = dateTime;
		this.campMsts = campMsts;
		this.regionMsts = regionMsts;
		this.licAddressDtlses = licAddressDtlses;
		this.hoMsts = hoMsts;
		this.divisionMsts = divisionMsts;
		this.agentMsts = agentMsts;
		this.branchMsts = branchMsts;
	}

	@Id
	@Column(name = "STATE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getStateId() {
		return this.stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	@Column(name = "STATE_NAME", length = 50)
	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Column(name = "STATE_ABBR", length = 3)
	public String getStateAbbr() {
		return this.stateAbbr;
	}

	public void setStateAbbr(String stateAbbr) {
		this.stateAbbr = stateAbbr;
	}

	@Column(name = "ACTIVE_FLAG", length = 20)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stateMst")
	public Set<CampMst> getCampMsts() {
		return this.campMsts;
	}

	public void setCampMsts(Set<CampMst> campMsts) {
		this.campMsts = campMsts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stateMst")
	public Set<RegionMst> getRegionMsts() {
		return this.regionMsts;
	}

	public void setRegionMsts(Set<RegionMst> regionMsts) {
		this.regionMsts = regionMsts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stateMst")
	public Set<LicAddressDtls> getLicAddressDtlses() {
		return this.licAddressDtlses;
	}

	public void setLicAddressDtlses(Set<LicAddressDtls> licAddressDtlses) {
		this.licAddressDtlses = licAddressDtlses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stateMst")
	public Set<HoMst> getHoMsts() {
		return this.hoMsts;
	}

	public void setHoMsts(Set<HoMst> hoMsts) {
		this.hoMsts = hoMsts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stateMst")
	public Set<DivisionMst> getDivisionMsts() {
		return this.divisionMsts;
	}

	public void setDivisionMsts(Set<DivisionMst> divisionMsts) {
		this.divisionMsts = divisionMsts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stateMst")
	public Set<AgentMst> getAgentMsts() {
		return this.agentMsts;
	}

	public void setAgentMsts(Set<AgentMst> agentMsts) {
		this.agentMsts = agentMsts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stateMst")
	public Set<BranchMst> getBranchMsts() {
		return this.branchMsts;
	}

	public void setBranchMsts(Set<BranchMst> branchMsts) {
		this.branchMsts = branchMsts;
	}

	@Override
	public boolean equals(Object obj) {
		StateMst stateMst = (StateMst) obj;
		return this.stateId.equals(stateMst.getStateId());
	}
}
