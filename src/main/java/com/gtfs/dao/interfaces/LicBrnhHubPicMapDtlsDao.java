package com.gtfs.dao.interfaces;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gtfs.bean.BranchMst;
import com.gtfs.bean.LicBrnhHubPicMapDtls;
import com.gtfs.bean.LicHubMst;
import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicRequirementDtls;
import com.gtfs.dao.impl.HibernateUtil;

public interface LicBrnhHubPicMapDtlsDao {
	Long saveForBranchHubDispatchList(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls);
	Long saveForHubPicDispatchList(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls);
	Boolean saveForBranchHubReqDispatchList(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls);
	List<LicRequirementDtls> findRequirementsForHubPicDispatch(Date busineeFromDate, Date busineeToDate, List<LicHubMst> licHubMsts);
	Long saveForHubPicDispatchListForReq(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls);
	Boolean savePosViewDispatchList(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls);
	List<LicOblApplicationMst> findBranchHubDispatchReport(Date businessFromDate, Date businessToDate, BranchMst branchMst);
	List<LicOblApplicationMst> findPicDispatchReport(Date businessFromDate, Date businessToDate, BranchMst branchMst);
}
