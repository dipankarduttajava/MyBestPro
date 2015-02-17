package com.gtfs.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicPolicyMst;
import com.gtfs.dao.interfaces.LicPolicyMstDao;
@Repository
@Scope("application")
public class LicPolicyMstDaoImpl implements LicPolicyMstDao,Serializable{
	private Logger log = Logger.getLogger(LicPolicyMstDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Boolean update(LicPolicyMst licPolicyMst){
		Boolean status = false;
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(licPolicyMst);
			tx.commit();
			status = true;
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			status = false;
			log.info("LicPolicyMstDaoImpl update Error", e);
		}finally{
			session.close();
		}
		return status;
	}

	@Override
	public LicOblApplicationMst findPolicyDtls(Long id) {
		LicOblApplicationMst loam = null;
	 	Session session = null;
        try {
            session = sessionFactory.openSession();
            loam = (LicOblApplicationMst) session.get(LicOblApplicationMst.class, id);
        } catch (Exception e) {
        	log.info("LicPolicyMstDaoImpl findPolicyDtls Error", e);
        } finally {
            session.close();
        }
        return loam;
	}

	@Override
	public List<LicPolicyMst> checkPolicyNo(String policyNo) {
		List<LicPolicyMst> list = null;
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery("FROM LicPolicyMst WHERE policyNo = :policyNo AND deleteFlag = :deleteFlag ");
			query.setParameter("policyNo", policyNo);
			query.setParameter("deleteFlag", "N");
			
			list = query.list();
		}catch(Exception e){
			log.info("LicPolicyMstDaoImpl checkPolicyNo Error", e);
		}finally{
			session.close();
		}
		return list;
	}
}
