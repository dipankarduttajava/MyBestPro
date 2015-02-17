package com.gtfs.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.gtfs.bean.BranchMst;
import com.gtfs.bean.LicHubMst;
import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicPolicyMst;
import com.gtfs.dao.interfaces.LicOblApplicationMstDao;
import com.gtfs.service.interfaces.LicOblApplicationMstService;

@Repository

public class LicOblApplicationMstServiceImpl implements LicOblApplicationMstService, Serializable{
	@Autowired
	private LicOblApplicationMstDao licOblApplicationMstDao;
	
	public LicOblApplicationMst findById(Long id){
		return licOblApplicationMstDao.findById(id);
	}
	
	public Long insertDataForPreliminaryDataEntry(LicOblApplicationMst licOblApplicationMst){
		return licOblApplicationMstDao.insertDataForPreliminaryDataEntry(licOblApplicationMst);
	}
	
	public List<LicOblApplicationMst> findApplicationForSecondaryDataEntryByDate(Date date, Long branchId){
		return licOblApplicationMstDao.findApplicationForSecondaryDataEntryByDate(date, branchId);
	}
	
	public List<LicOblApplicationMst> findApplicationForSecondaryDataEntryByApplicationNo(String applicationNo, Long branchId){
		return licOblApplicationMstDao.findApplicationForSecondaryDataEntryByApplicationNo(applicationNo, branchId);
	}
	
	
	public List<LicPolicyMst> findApplicationByApplicationNoForReqirement(String applicationNo){
		return licOblApplicationMstDao.findApplicationByApplicationNoForReqirement(applicationNo);
	}	
	
	public Boolean insertDataForSecondaryDataEntry(LicOblApplicationMst licOblApplicationMst){
		return licOblApplicationMstDao.insertDataForSecondaryDataEntry(licOblApplicationMst);
	}
	
	public List<LicOblApplicationMst> findDispatchApplicationsByBusinessDate(Date fromDate,Date toDate, Long branchId){
		return licOblApplicationMstDao.findDispatchApplicationsByBusinessDate(fromDate, toDate, branchId);
	}
	
	public List<Long> findPodApplications(Long id){
		return licOblApplicationMstDao.findPodApplications(id);
	}
	
	public  List<LicOblApplicationMst> findApplicationByDispatchListAndBusinessDate(Date fromDate,Date toDate, Long id, BranchMst branchMst){
		return licOblApplicationMstDao.findApplicationByDispatchListAndBusinessDate(fromDate, toDate, id, branchMst);
	}
	
	public List<Long> findPodApplicationsForPicDispatch(List<LicHubMst> licHubMsts){
		return licOblApplicationMstDao.findPodApplicationsForPicDispatch(licHubMsts);
	}
	
	public  List<LicOblApplicationMst> findApplicationByDispatchListForPicDispatch(Long id, BranchMst branchMst){
		return licOblApplicationMstDao.findApplicationByDispatchListForPicDispatch(id, branchMst);
	}
	
	
	public List<LicPolicyMst> findApplicationForStatusEntry(Date fromDate,Date toDate,String applicantName,Double premium,Double sumAssured,Long term,String applicationNo,String policyNo ,List<LicHubMst> licHubMsts){
		return licOblApplicationMstDao.findApplicationForStatusEntry(fromDate, toDate, applicantName, premium, sumAssured, term, applicationNo,policyNo, licHubMsts);
	}

	@Override
	public List<Long> findPodApplicationsForReqirement(Long id) {
		return licOblApplicationMstDao.findPodApplicationsForReqirement(id);
	}

	@Override
	public List<LicOblApplicationMst> findAll() {
		return licOblApplicationMstDao.findAll();
	}

	@Override
	public Boolean updatePrintReceiptFlagInLicOblApplMst(LicOblApplicationMst licOblApplicationMst) {
		return licOblApplicationMstDao.updatePrintReceiptFlagInLicOblApplMst(licOblApplicationMst);
	}	
}
