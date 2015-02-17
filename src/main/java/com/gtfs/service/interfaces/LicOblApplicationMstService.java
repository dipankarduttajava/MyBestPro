package com.gtfs.service.interfaces;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.gtfs.bean.BranchMst;
import com.gtfs.bean.LicHubMst;
import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicPolicyMst;


public interface LicOblApplicationMstService extends Serializable{
	LicOblApplicationMst findById(Long id);
	Long insertDataForPreliminaryDataEntry(LicOblApplicationMst licOblApplicationMst);
	List<LicOblApplicationMst> findApplicationForSecondaryDataEntryByDate(Date date, Long branchId);
	List<LicOblApplicationMst> findApplicationForSecondaryDataEntryByApplicationNo(String applicationNo, Long branchId);
	List<LicPolicyMst> findApplicationByApplicationNoForReqirement(String applicationNo);
	Boolean insertDataForSecondaryDataEntry(LicOblApplicationMst licOblApplicationMst);
	List<LicOblApplicationMst> findDispatchApplicationsByBusinessDate(Date fromDate,Date toDate, Long brancId);
	List<Long> findPodApplications(Long id);
	List<LicOblApplicationMst> findApplicationByDispatchListAndBusinessDate(Date fromDate,Date toDate, Long id, BranchMst branchMst);
	List<Long> findPodApplicationsForPicDispatch(List<LicHubMst> licHubMsts);
	List<LicOblApplicationMst> findApplicationByDispatchListForPicDispatch(Long id, BranchMst branchMst);
	List<LicPolicyMst> findApplicationForStatusEntry(Date fromDate,Date toDate,String applicantName,Double premium,Double sumAssured,Long term,String applicationNo,String policyNo, List<LicHubMst> licHubMsts);
	List<Long> findPodApplicationsForReqirement(Long id);	
	List<LicOblApplicationMst> findAll();
	Boolean updatePrintReceiptFlagInLicOblApplMst(LicOblApplicationMst licOblApplicationMst);
}
