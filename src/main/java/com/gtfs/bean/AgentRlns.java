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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AgentRlns generated by hbm2java
 */
@Entity
@Table(name = "AGENT_RLNS")
public class AgentRlns implements java.io.Serializable {

	private Long agRelId;
	private RankMst rankMst;
	private AgentMst agentMst;
	private AgentRlns agentRlns;
	private PhaseMst phaseMst;
	private Long pseudoRank;
	private Long introCode;
	private Date wefDate;
	private String activeFlag;
	private String promAuFlag;
	private Long userId;
	private Date dateTime;
	private Set<AgentRlns> agentRlnses = new HashSet<AgentRlns>(0);
	private Set<LicBusinessTxn> licBusinessTxns = new HashSet<LicBusinessTxn>(0);

	public AgentRlns() {
	}

	public AgentRlns(Long agRelId) {
		this.agRelId = agRelId;
	}

	public AgentRlns(Long agRelId, RankMst rankMst, AgentMst agentMst,
			AgentRlns agentRlns, PhaseMst phaseMst, Long pseudoRank,
			Long introCode, Date wefDate, String activeFlag,
			String promAuFlag, Long userId, Date dateTime,
			Set<AgentRlns> agentRlnses) {
		this.agRelId = agRelId;
		this.rankMst = rankMst;
		this.agentMst = agentMst;
		this.agentRlns = agentRlns;
		this.phaseMst = phaseMst;
		this.pseudoRank = pseudoRank;
		this.introCode = introCode;
		this.wefDate = wefDate;
		this.activeFlag = activeFlag;
		this.promAuFlag = promAuFlag;
		this.userId = userId;
		this.dateTime = dateTime;
		this.agentRlnses = agentRlnses;
	}

	@Id
	@Column(name = "AG_REL_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getAgRelId() {
		return this.agRelId;
	}

	public void setAgRelId(Long agRelId) {
		this.agRelId = agRelId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AG_RANK_ID")
	public RankMst getRankMst() {
		return this.rankMst;
	}

	public void setRankMst(RankMst rankMst) {
		this.rankMst = rankMst;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AG_CODE")
	public AgentMst getAgentMst() {
		return this.agentMst;
	}

	public void setAgentMst(AgentMst agentMst) {
		this.agentMst = agentMst;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INTRO_REL_ID")
	public AgentRlns getAgentRlns() {
		return this.agentRlns;
	}

	public void setAgentRlns(AgentRlns agentRlns) {
		this.agentRlns = agentRlns;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PHASE_ID")
	public PhaseMst getPhaseMst() {
		return this.phaseMst;
	}

	public void setPhaseMst(PhaseMst phaseMst) {
		this.phaseMst = phaseMst;
	}

	@Column(name = "PSEUDO_RANK", precision = 22, scale = 0)
	public Long getPseudoRank() {
		return this.pseudoRank;
	}

	public void setPseudoRank(Long pseudoRank) {
		this.pseudoRank = pseudoRank;
	}

	@Column(name = "INTRO_CODE", precision = 22, scale = 0)
	public Long getIntroCode() {
		return this.introCode;
	}

	public void setIntroCode(Long introCode) {
		this.introCode = introCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "WEF_DATE", length = 7)
	public Date getWefDate() {
		return this.wefDate;
	}

	public void setWefDate(Date wefDate) {
		this.wefDate = wefDate;
	}

	@Column(name = "ACTIVE_FLAG", length = 1)
	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "PROM_AU_FLAG", length = 2)
	public String getPromAuFlag() {
		return this.promAuFlag;
	}

	public void setPromAuFlag(String promAuFlag) {
		this.promAuFlag = promAuFlag;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agentRlns")
	public Set<AgentRlns> getAgentRlnses() {
		return this.agentRlnses;
	}

	public void setAgentRlnses(Set<AgentRlns> agentRlnses) {
		this.agentRlnses = agentRlnses;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agentRlns")
	public Set<LicBusinessTxn> getLicBusinessTxns() {
		return licBusinessTxns;
	}

	public void setLicBusinessTxns(Set<LicBusinessTxn> licBusinessTxns) {
		this.licBusinessTxns = licBusinessTxns;
	}

}