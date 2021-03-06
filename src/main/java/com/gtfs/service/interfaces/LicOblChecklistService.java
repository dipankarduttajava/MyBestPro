package com.gtfs.service.interfaces;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.gtfs.bean.BranchMst;
import com.gtfs.bean.LicOblChecklist;


public interface LicOblChecklistService extends Serializable{
	Boolean insertIntoLicChecklist(LicOblChecklist licOblChecklist);
	List<LicOblChecklist> findApplicationForPremDataEntryByDate(Date date, Long branchId);
	List<LicOblChecklist> findApplicationForPremDataEntryByApplicationNo(String applicationNo, Long branchId);
	List<LicOblChecklist> findApplicationForCheckListEditByApplicationNo(String applicationNo, BranchMst branchMst);
	List<LicOblChecklist> findApplicationByApplicationNo(String applicationNo);
	Boolean updateLicChecklist(LicOblChecklist licOblChecklist);
}
