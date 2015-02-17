package com.gtfs.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.gtfs.bean.BranchMst;
import com.gtfs.bean.LicHubMst;
import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicPolicyMst;

public interface LicOblApplicationMstDao {
	Boolean insertDataForSecondaryDataEntry(LicOblApplicationMst licOblApplicationMst);
	Long insertDataForPreliminaryDataEntry(LicOblApplicationMst licOblApplicationMst);
	List<LicOblApplicationMst> findApplicationForSecondaryDataEntryByDate(Date date, Long branchId);
	List<LicPolicyMst> findApplicationByApplicationNoForReqirement(String applicationNo);
	List<LicOblApplicationMst> findApplicationForSecondaryDataEntryByApplicationNo(String applicationNo, Long branchId);
	List<LicOblApplicationMst> findDispatchApplicationsByBusinessDate(Date fromDate, Date toDate, Long branchId);
	List<LicOblApplicationMst> findApplicationByDispatchListAndBusinessDate(Date fromDate,Date toDate, Long id, BranchMst branchMst);
	List<LicOblApplicationMst> findApplicationByDispatchListForPicDispatch(Long id, BranchMst branchMst);
	List<Long> findPodApplications(Long id);
	List<Long> findPodApplicationsForPicDispatch(List<LicHubMst> licHubMsts);
	List<LicPolicyMst> findApplicationForStatusEntry(Date fromDate,Date toDate,String applicantName,Double premium,Double sumAssured,Long term,String applicationNo,String policyNo, List<LicHubMst> licHubMsts);
	LicOblApplicationMst findById(Long id);
	List<Long> findPodApplicationsForReqirement(Long id);
	List<LicOblApplicationMst> findAll();
	Boolean updatePrintReceiptFlagInLicOblApplMst(LicOblApplicationMst licOblApplicationMst);
}
