package com.gtfs.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gtfs.bean.BranchMst;
import com.gtfs.bean.LicOblChecklist;
import com.gtfs.dao.interfaces.LicOblChecklistDao;
import com.gtfs.service.interfaces.LicOblChecklistService;

@Service

public class LicOblChecklistServiceImpl implements LicOblChecklistService, Serializable{
	@Autowired
	private LicOblChecklistDao licOblChecklistDao;
	
	public Boolean insertIntoLicChecklist(LicOblChecklist licOblChecklist){
		return licOblChecklistDao.insertIntoLicChecklist(licOblChecklist);
	}
	
	public List<LicOblChecklist> findApplicationForPremDataEntryByDate(Date date,Long branchId){
		return licOblChecklistDao.findApplicationForPremDataEntryByDate(date, branchId);
	}
	
	public List<LicOblChecklist> findApplicationForPremDataEntryByApplicationNo(String applicationNo, Long branchId){
		return licOblChecklistDao.findApplicationForPremDataEntryByApplicationNo(applicationNo, branchId);
	}

	@Override
	public List<LicOblChecklist> findApplicationForCheckListEditByApplicationNo(String applicationNo, BranchMst branchMst) {
		return licOblChecklistDao.findApplicationForCheckListEditByApplicationNo(applicationNo, branchMst);
	}

	@Override
	public Boolean updateLicChecklist(LicOblChecklist licOblChecklist) {
		return licOblChecklistDao.updateLicChecklist(licOblChecklist);
	}

	@Override
	public List<LicOblChecklist> findApplicationByApplicationNo(String applicationNo) {
		return licOblChecklistDao.findApplicationByApplicationNo(applicationNo);
	}
}
