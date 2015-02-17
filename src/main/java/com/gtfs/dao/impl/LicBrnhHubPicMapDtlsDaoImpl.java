package com.gtfs.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.gtfs.bean.BranchMst;
import com.gtfs.bean.LicBrnhHubPicMapDtls;
import com.gtfs.bean.LicHubMst;
import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicRequirementDtls;
import com.gtfs.dao.interfaces.LicBrnhHubPicMapDtlsDao;

@Repository
@Scope("application")
public class LicBrnhHubPicMapDtlsDaoImpl implements LicBrnhHubPicMapDtlsDao,Serializable{
	private Logger log = Logger.getLogger(LicBrnhHubPicMapDtlsDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long saveForBranchHubDispatchList(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls){
		Session session=null;
		Transaction tx=null;
		Long id=0l;
		try{
			session = sessionFactory.openSession();
			tx=session.beginTransaction();
			id=(Long) session.save(licBrnhHubPicMapDtls);
			tx.commit();
			
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			id=0l;
			log.info("LicBrnhHubPicMapDtlsDaoImpl saveForBranchHubDispatchList Error", e);
		}finally{
			session.close();
		}
		return id;
	}
	
	public Long saveForHubPicDispatchList(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls){
		Session session=null;
		Transaction tx=null;
		Long id = 0l;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			id=(Long) session.save(licBrnhHubPicMapDtls);
			tx.commit();
			
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			id=0l;
			log.info("LicBrnhHubPicMapDtlsDaoImpl saveForHubPicDispatchList Error", e);
		}finally{
			session.close();
		}
		return id;
	}

	@Override
	public Boolean saveForBranchHubReqDispatchList(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls) {
		Boolean status = false;
		Session session = null;
		Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(licBrnhHubPicMapDtls);
            tx.commit();       
            status = true;
        } catch (Exception e) {
        	if(tx!=null) tx.rollback();
        	status = false;
        	log.info("LicBrnhHubPicMapDtlsDaoImpl saveForBranchHubReqDispatchList Error", e);
        } finally {
            session.close();
        }
        return status;
	}

	@Override
	public List<LicRequirementDtls> findRequirementsForHubPicDispatch(Date busineeFromDate, Date busineeToDate, List<LicHubMst> licHubMsts) {
		List<LicRequirementDtls> list = null;
		Session session = null;
		try {
            session = sessionFactory.openSession();   
            Criteria criteria  = session.createCriteria(LicRequirementDtls.class,"lrd");
            criteria.createAlias("lrd.licReqBocMappings", "lrbm",JoinType.LEFT_OUTER_JOIN);
            criteria.createAlias("lrd.licMarkingToQcDtls", "lmtqd",JoinType.LEFT_OUTER_JOIN);
            criteria.createAlias("lrd.licOblApplicationMst", "loam");
            criteria.createAlias("loam.branchMst", "bm");
            criteria.createAlias("loam.picBranchMstId", "pbmi");
            criteria.createAlias("loam.licProductValueMst", "lpvm");
            
            criteria.add(
            		Restrictions.or(
	            		Restrictions.and(Restrictions.isNotNull("lrbm.id"),Restrictions.eq("lrd.reqType", "S"),Restrictions.eq("lrd.dispatchReadyFlag","Y")),
	            		Restrictions.and(Restrictions.eq("lrd.reqType", "D"),Restrictions.isNotNull("lmtqd.indMrkFlag"),Restrictions.eq("lrd.dispatchReadyFlag","Y")),
	            		Restrictions.and(Restrictions.eq("lrd.actionType", "IR"),Restrictions.eq("lrd.dispatchReadyFlag", "Y"))
            		));
            criteria.add(Restrictions.in("lrd.licHubMst", licHubMsts));
            criteria.add(Restrictions.ge("loam.businessDate", busineeFromDate));
            criteria.add(Restrictions.le("loam.businessDate", busineeToDate));
            criteria.add(Restrictions.isNull("lrd.licBrnhHubPicMapDtls"));
            criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
            criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
            list = criteria.list();
            
        } catch (Exception e) {
        	log.info("LicBrnhHubPicMapDtlsDaoImpl saveForBranchHubReqDispatchList Error", e);
        } finally {
            session.close();
        }
        return list;
	}

	@Override
	public Long saveForHubPicDispatchListForReq(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls) {
		Session session=null;
		Transaction tx=null;
		Long id = 0l;
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			id=(Long) session.save(licBrnhHubPicMapDtls);
			tx.commit();
			
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			id=0l;
			log.info("LicBrnhHubPicMapDtlsDaoImpl saveForHubPicDispatchListForReq Error", e);
		}finally{
			session.close();
		}
		return id;
	}
	
	@Override
	public Boolean savePosViewDispatchList(LicBrnhHubPicMapDtls licBrnhHubPicMapDtls) {
		Boolean status = false;
		Session session = null;
		Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(licBrnhHubPicMapDtls);
            tx.commit();       
            status = true;
        } catch (Exception e) {
        	if(tx!=null) tx.rollback();
        	status = false;
        	log.info("LicBrnhHubPicMapDtlsDaoImpl savePosViewDispatchList Error", e);
        } finally {
            session.close();
        }
        return status;
	}

	@Override
	public List<LicOblApplicationMst> findBranchHubDispatchReport(Date businessFromDate, Date businessToDate, BranchMst branchMst) {
		Session session = null;
		List<LicOblApplicationMst> list = null;
		try{
			session=sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicOblApplicationMst.class,"loam");
			criteria.createAlias("loam.licProductValueMst", "lpvm");
			criteria.createAlias("loam.licProposerDtls", "lpd");
			criteria.createAlias("loam.licInsuredDtls", "lid");
			criteria.createAlias("loam.oblHubMst", "ohm");
			criteria.createAlias("lpvm.licProductMst", "lpm");
			criteria.createAlias("loam.branchMst", "bm");
			criteria.createAlias("loam.licBusinessTxn", "lbt");
			criteria.createAlias("lbt.licPaymentMst", "lpaym");
			
			//criteria.add(Restrictions.isNull("loam.brnhHubPodDtls"));
			criteria.add(Restrictions.isNotNull("loam.brnhHubMapDtls"));
			criteria.add(Restrictions.isNotNull("loam.licPisMst"));
			criteria.add(Restrictions.ge("loam.businessDate", businessFromDate));
			criteria.add(Restrictions.le("loam.businessDate", businessToDate));
			criteria.add(Restrictions.eq("loam.secondaryEntryFlag", "Y"));
			criteria.add(Restrictions.eq("loam.branchMst", branchMst));
			criteria.add(Restrictions.eq("lpvm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpd.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lid.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
            criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
            
            list = criteria.list();
		}catch(Exception e){
			log.info("LicBrnhHubPicMapDtlsDaoImpl findBranchHubDispatchReport Error", e);
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<LicOblApplicationMst> findPicDispatchReport(Date businessFromDate, Date businessToDate, BranchMst branchMst) {
		List<LicOblApplicationMst> list = null;
	 	Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("SELECT loam FROM LicOblApplicationMst as loam inner join "
                    + "loam.licBusinessTxn as lbt inner join "
                    + "lbt.licPaymentMst as lpm inner join "
                    + "loam.licProposerDtls as lpd inner join "
                    + "loam.licInsuredDtls as lid inner join fetch "
                    + "loam.licProductValueMst as lpvm inner join fetch "
                    + "loam.branchMst as bm inner join "
                    + "loam.licPremApplMappings as lpam inner join fetch "
                    + "loam.picBranchMstId as pbm inner join fetch "
                    + "loam.oblHubMst as ohm inner join fetch "
                    + "loam.hubPicMapDtls as hpmd inner join fetch "
                    + "lpvm.licProductMst as lipm "
                    
					+ "WHERE "
					+ "loam.hubPicMapDtls IS NOT NULL "
					+ "AND loam.businessDate >= :businessFromDate "
					+ "AND loam.businessDate <= :businessToDate "
					+ "AND loam.branchMst = :branchMst "
					+ "AND loam.deleteFlag = 'N' "
            		+ "AND loam.migrationFlag = 'N' "
            		+ "AND lpvm.deleteFlag = 'N' "
            		+ "AND lpd.deleteFlag = 'N' "
            		+ "AND lid.deleteFlag = 'N' "
            		+ "AND lpm.deleteFlag = 'N' ");
            
            
            query.setParameter("businessFromDate", businessFromDate);
            query.setParameter("businessToDate", businessToDate);
            query.setParameter("branchMst", branchMst);
            list = (List<LicOblApplicationMst>) query.list();
            
        } catch (Exception e) {
        	log.info("LicBrnhHubPicMapDtlsDaoImpl findPicDispatchReport Error ", e);
        } finally {
            session.close();
        }
        return list;
	}
}
