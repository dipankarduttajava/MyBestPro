package com.gtfs.service.interfaces;

import java.io.Serializable;
import java.util.List;

import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicPolicyMst;

public interface LicPolicyMstService extends Serializable{
	Boolean update(LicPolicyMst licPolicyMst);
	LicOblApplicationMst findPolicyDtls(Long id);
	List<LicPolicyMst> checkPolicyNo(String policyNo);
}
