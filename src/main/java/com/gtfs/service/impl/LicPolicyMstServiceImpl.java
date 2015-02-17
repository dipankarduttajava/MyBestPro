package com.gtfs.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicPolicyMst;
import com.gtfs.dao.interfaces.LicPolicyMstDao;
import com.gtfs.service.interfaces.LicPolicyMstService;

@Service
public class LicPolicyMstServiceImpl implements LicPolicyMstService, Serializable{
	@Autowired
	private LicPolicyMstDao licPolicyMstDao;
	
	public Boolean update(LicPolicyMst licPolicyMst){
		return licPolicyMstDao.update(licPolicyMst);
	}

	@Override
	public LicOblApplicationMst findPolicyDtls(Long id) {
		return licPolicyMstDao.findPolicyDtls(id);
	}

	@Override
	public List<LicPolicyMst> checkPolicyNo(String policyNo) {
		return licPolicyMstDao.checkPolicyNo(policyNo);
	}
}
