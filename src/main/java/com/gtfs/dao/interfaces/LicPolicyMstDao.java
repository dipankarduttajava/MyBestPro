package com.gtfs.dao.interfaces;

import java.util.List;

import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicPolicyMst;

public interface LicPolicyMstDao {
	Boolean update(LicPolicyMst licPolicyMst);
	LicOblApplicationMst findPolicyDtls(Long id);
	List<LicPolicyMst> checkPolicyNo(String policyNo);
}
