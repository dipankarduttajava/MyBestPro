package com.gtfs.service.interfaces;

import java.io.Serializable;
import java.util.List;

import com.gtfs.bean.BranchMst;
import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicRequirementDtls;


public interface LicBocDetailEntryService extends Serializable{
	List<LicOblApplicationMst> findApplicationForBocEntry(Long premListNo, BranchMst branchMst);
	Boolean saveBoc(List<LicOblApplicationMst>  applicationMsts);
	Boolean saveBocForReq(List<LicRequirementDtls>  licRequirementDtls);
	List<LicRequirementDtls> findRequirmentDtlsForBocEntry(Long premListNo, BranchMst branchMst);
}
