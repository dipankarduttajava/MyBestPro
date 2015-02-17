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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.gtfs.bean.BranchMst;
import com.gtfs.bean.LicBrnhHubPicMapDtls;
import com.gtfs.bean.LicHubMst;
import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicPolicyMst;
import com.gtfs.dao.interfaces.LicOblApplicationMstDao;

@Repository
@Scope("application")
public class LicOblApplicationMstDaoImpl implements LicOblApplicationMstDao,Serializable{
	private Logger log = Logger.getLogger(LicOblApplicationMstDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Boolean insertDataForSecondaryDataEntry(LicOblApplicationMst licOblApplicationMst){
		Session session=null;
		Transaction tx=null;
		Boolean status=false;
		try{
			session = sessionFactory.openSession();
			tx=session.beginTransaction();
			session.update(licOblApplicationMst);
			tx.commit();
			status=true;
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			status=false;
			log.info("LicOblApplicationMstDaoImpl insertDataForSecondaryDataEntry Error", e);
		}finally{
			session.close();
		}
		return status;
	}
	
	
	public Long insertDataForPreliminaryDataEntry(LicOblApplicationMst licOblApplicationMst){
		Session session=null;
		Transaction tx=null;
		Long row=0l;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			row = (Long) session.save(licOblApplicationMst);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			row=0l;
			log.info("LicOblApplicationMstDaoImpl insertDataForPreliminaryDataEntry Error", e);
		}finally{
			session.close();
		}
		return row;
	}
	
	public List<LicOblApplicationMst> findApplicationForSecondaryDataEntryByDate(Date date, Long branchId){
		Session session=null;
		List<LicOblApplicationMst> licOblApplicationMstList=null;
		try{
			session=sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicOblApplicationMst.class,"loam");
			criteria.createAlias("loam.licProductValueMst", "lpvm");
			criteria.createAlias("loam.licProposerDtls", "lpd");
			criteria.createAlias("loam.licInsuredDtls", "lid");
			criteria.createAlias("lpvm.licProductMst", "lpm");
			criteria.createAlias("loam.branchMst", "bm");
			criteria.createAlias("lid.ageProofNature", "apn",JoinType.LEFT_OUTER_JOIN);
			criteria.createAlias("lid.identityProof", "ip",JoinType.LEFT_OUTER_JOIN);
			criteria.createAlias("lid.addrProof", "ap",JoinType.LEFT_OUTER_JOIN);
			criteria.createAlias("lid.incomeProof", "icp",JoinType.LEFT_OUTER_JOIN);
			criteria.createAlias("loam.licInsuredBankDtls", "libd",JoinType.LEFT_OUTER_JOIN);
			
			criteria.add(Restrictions.eq("loam.businessDate", date));
//			criteria.add(Restrictions.eq("loam.secondaryEntryFlag", "N"));
			criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
			criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
			criteria.add(Restrictions.eq("lpvm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpd.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lid.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("bm.branchId", branchId));
			licOblApplicationMstList=criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findApplicationForSecondaryDataEntryByDate Error", e);
		}finally{
			session.close();
		}
		return licOblApplicationMstList;
	}
	

	public List<LicPolicyMst> findApplicationByApplicationNoForReqirement(String applicationNo){
		Session session = null;
		List<LicPolicyMst> list = null;
		try{
			session=sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicPolicyMst.class,"lipm");
			criteria.createAlias("lipm.licOblApplicationMst", "loam");
			criteria.createAlias("loam.licProductValueMst", "lpvm");
			criteria.createAlias("loam.licProposerDtls", "lpd");
			criteria.createAlias("loam.licInsuredDtls", "lid");
			criteria.createAlias("lpvm.licProductMst", "lpm");
			criteria.createAlias("loam.branchMst", "bm");
			criteria.createAlias("loam.picBranchMstId", "pbmi");
			//criteria.add(Restrictions.eq("lipm.policyStatus", "Q"));
			criteria.add(Restrictions.eq("loam.oblApplNo", applicationNo));
			criteria.add(Restrictions.eq("lpvm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpd.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lid.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpm.deleteFlag", "N"));
			criteria.add(Restrictions.isNotNull("loam.hubPicPodDtls"));			
			criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
            criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
            
			list=criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findApplicationByApplicationNoForReqirement Error", e);
		}finally{
			session.close();
		}
		return list;
	}
	
	
	
	
	public List<LicOblApplicationMst> findApplicationForSecondaryDataEntryByApplicationNo(String applicationNo, Long branchId){
		Session session = null;
		List<LicOblApplicationMst> licOblApplicationMstList = null;
		try{
			session=sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicOblApplicationMst.class,"loam");
			criteria.createAlias("loam.licProductValueMst", "lpvm");
			criteria.createAlias("loam.licProposerDtls", "lpd");
			criteria.createAlias("loam.licInsuredDtls", "lid");
			criteria.createAlias("lpvm.licProductMst", "lpm");
			criteria.add(Restrictions.eq("loam.oblApplNo", applicationNo));
//			criteria.add(Restrictions.eq("loam.secondaryEntryFlag", "N"));
			criteria.add(Restrictions.eq("lpvm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpd.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lid.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("bm.branchId", branchId));
			criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
            criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
            
			licOblApplicationMstList=criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findApplicationForSecondaryDataEntryByApplicationNo Error", e);
		}finally{
			session.close();
		}
		return licOblApplicationMstList;
	}
	
	
	public List<LicOblApplicationMst> findDispatchApplicationsByBusinessDate(Date fromDate, Date toDate, Long branchId){
		Session session=null;
		List<LicOblApplicationMst> licOblApplicationMstList=null;
		try{
			session=sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicOblApplicationMst.class,"loam");
			criteria.createAlias("loam.licProductValueMst", "lpvm");
			criteria.createAlias("loam.licProposerDtls", "lpd");
			criteria.createAlias("loam.licInsuredDtls", "lid");
			criteria.createAlias("lpvm.licProductMst", "lpm");
			criteria.createAlias("loam.branchMst", "bm");
			criteria.createAlias("loam.licBusinessTxn", "lbt");
			criteria.createAlias("lbt.licPaymentMst", "lpaym");
			
			criteria.add(Restrictions.isNull("brnhHubMapDtls"));
			criteria.add(Restrictions.isNotNull("loam.licPisMst"));
			criteria.add(Restrictions.ge("loam.businessDate", fromDate));
			criteria.add(Restrictions.le("loam.businessDate", toDate));
			criteria.add(Restrictions.eq("loam.secondaryEntryFlag", "Y"));
			criteria.add(Restrictions.eq("loam.branchMst.branchId", branchId));
			criteria.add(Restrictions.eq("lpvm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpd.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lid.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
            criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
            
			licOblApplicationMstList = criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findDispatchApplicationsByBusinessDate Error", e);
		}finally{
			session.close();
		}
		return licOblApplicationMstList;
	}
	
	public List<LicOblApplicationMst> findApplicationByDispatchListAndBusinessDate(Date fromDate,Date toDate, Long id, BranchMst branchMst){
		Session session=null;
		List<LicOblApplicationMst> licOblApplicationMstList = null;
		try{
			session=sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicOblApplicationMst.class,"loam");
			criteria.createAlias("loam.licProductValueMst", "lpvm");
			criteria.createAlias("loam.licProposerDtls", "lpd");
			criteria.createAlias("loam.licInsuredDtls", "lid");
			criteria.createAlias("lpvm.licProductMst", "lpm");
			criteria.createAlias("loam.branchMst", "bm");
			criteria.createAlias("loam.licBusinessTxn", "lbt");
			criteria.createAlias("lbt.licPaymentMst", "lpaym");
			criteria.createAlias("loam.brnhHubMapDtls", "bhmd");
			
			if(fromDate != null){
				criteria.add(Restrictions.ge("loam.businessDate", fromDate));
			}
			
			if(toDate != null){
				criteria.add(Restrictions.le("loam.businessDate", toDate));

			}
			
			if(fromDate == null && toDate == null){
				criteria.add(Restrictions.eq("loam.brnhHubMapDtls.id", id));
			}
			
			criteria.add(Restrictions.isNotNull("loam.brnhHubMapDtls"));
			criteria.add(Restrictions.isNull("loam.brnhHubPodDtls"));
			criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
            criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
            criteria.add(Restrictions.eq("loam.branchMst", branchMst));
			criteria.add(Restrictions.eq("lpvm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpd.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lid.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpm.deleteFlag", "N"));
			criteria.add(Restrictions.eq("bm.activeFlag", "Y"));
			criteria.add(Restrictions.eq("lbt.deleteFlag", "N"));
			criteria.add(Restrictions.eq("lpaym.deleteFlag", "N"));
			
			licOblApplicationMstList=criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findApplicationByDispatchList Error", e);
		}finally{
			session.close();
		}
		return licOblApplicationMstList;
	}
	
	
	public  List<LicOblApplicationMst> findApplicationByDispatchListForPicDispatch(Long id, BranchMst branchMst){
		Session session=null;
		List<LicOblApplicationMst> licOblApplicationMstList=null;
		try{
			session=sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicOblApplicationMst.class,"loam");
			criteria.createAlias("loam.licProductValueMst", "lpvm");
			criteria.createAlias("loam.licProposerDtls", "lpd");
			criteria.createAlias("loam.licInsuredDtls", "lid");
			criteria.createAlias("lpvm.licProductMst", "lpm");
			criteria.createAlias("loam.branchMst", "bm");
			criteria.createAlias("loam.licBusinessTxn", "lbt");
			criteria.createAlias("lbt.licPaymentMst", "lpaym");
			criteria.createAlias("loam.picBranchMstId", "pbm");
            criteria.createAlias("loam.oblHubMst", "ohm");
            
			criteria.add(Restrictions.isNotNull("loam.hubPicMapDtls"));
			criteria.add(Restrictions.isNull("loam.hubPicPodDtls"));
			criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
            criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
			criteria.add(Restrictions.eq("loam.hubPicMapDtls.id", id));
			
			licOblApplicationMstList=criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findApplicationByDispatchListForPicDispatch Error", e);
		}finally{
			session.close();
		}
		return licOblApplicationMstList;
	}
	
	public List<Long> findPodApplicationsForReqirement(Long id){
		Session session = null;
		List<Long> podId = null;
		try{
			session=sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicBrnhHubPicMapDtls.class,"lbhpmd");
			criteria.createAlias("lbhpmd.licBranchReqRcvMsts", "lbrrm");
			criteria.createAlias("lbrrm.licRequirementDtls", "lrd");
			criteria.createAlias("lrd.licOblApplicationMst", "loam");
			criteria.createAlias("loam.branchMst", "bm");
			
			criteria.add(Restrictions.eq("bm.branchId", id));
			criteria.add(Restrictions.isNotNull("lbrrm.licBrnhHubPicMapDtls"));
			criteria.add(Restrictions.isNull("lbrrm.licBrnhHubPicPodDtls"));
			criteria.add(Restrictions.eq("lbrrm.deleteFlag", "N"));
			criteria.setProjection(Projections.distinct(Projections.property("lbhpmd.id")));
			podId = criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findPodApplicationsForReqirement Error", e);
		}finally{
			session.close();
		}
		return podId;
	}
	
	
	public List<Long> findPodApplications(Long id){
		Session session = null;
		List<Long> podId = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicBrnhHubPicMapDtls.class,"lbhpmd");
			criteria.createAlias("lbhpmd.licOblApplicationMsts", "loam");
			criteria.createAlias("loam.branchMst", "bm");
			
			criteria.add(Restrictions.eq("bm.id", id));
			criteria.add(Restrictions.isNotNull("loam.brnhHubMapDtls"));
			criteria.add(Restrictions.isNull("loam.brnhHubPodDtls"));
			criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
            criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
			criteria.setProjection(Projections.distinct(Projections.property("lbhpmd.id")));			
			podId = criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findPodApplications Error", e);
		}finally{
			session.close();
		}
		return podId;
	}
	
	public List<Long> findPodApplicationsForPicDispatch(List<LicHubMst> licHubMsts){
		Session session = null;
		List<Long> id = null;
		try{
			session=sessionFactory.openSession();
			session=sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicOblApplicationMst.class,"loam");
			criteria.createAlias("loam.hubPicMapDtls", "hpmd");
			criteria.add(Restrictions.isNull("loam.hubPicPodDtls"));
			criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
            criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
			criteria.add(Restrictions.in("loam.oblHubMst", licHubMsts));
			
			criteria.setProjection(Projections.distinct(Projections.property("hpmd.id")));
			
			id = criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findPodApplicationsForPicDispatch Error", e);
		}finally{
			session.close();
		}
		return id;
	}
	
	public List<LicPolicyMst> findApplicationForStatusEntry(Date fromDate, Date toDate, String applicantName, Double premium, Double sumAssured, Long term, String applicationNo,String policyNo, List<LicHubMst> licHubMsts){
		Session session=null;
		List<LicPolicyMst> list = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria= session.createCriteria(LicPolicyMst.class,"lpm");
			criteria.createAlias("lpm.licOblApplicationMst", "loam", JoinType.RIGHT_OUTER_JOIN);
			criteria.createAlias("loam.licInsuredDtls", "lids");
			criteria.createAlias("loam.licProposerDtls", "lpds");
			criteria.createAlias("loam.branchMst", "bm");
			criteria.createAlias("loam.picBranchMstId", "pbmi");
			criteria.createAlias("loam.licProductValueMst", "lpvm");
			criteria.createAlias("loam.oblHubMst", "ohm");
			
			//criteria.add(Restrictions.eq("bm.branchId", id));
			criteria.add(Restrictions.in("loam.oblHubMst",licHubMsts));
			criteria.add(Restrictions.eq("loam.deleteFlag", "N"));
            criteria.add(Restrictions.eq("loam.migrationFlag", "N"));
			criteria.add(Restrictions.isNotNull("loam.hubPicPodDtls"));
			
			if(fromDate != null){
				criteria.add(Restrictions.ge("loam.businessDate", fromDate));
			}
			
			if(policyNo!=null){
				criteria.add(Restrictions.eq("lpm.policyNo", policyNo));
			}
			
			if(toDate != null){
				criteria.add(Restrictions.le("loam.businessDate", toDate));
			}
			if(applicantName != null){
				criteria.add(Restrictions.eq("lids.name", applicantName));
			}
			if(premium != null){
				criteria.add(Restrictions.eq("lpvm.premAmt", premium));
			}
			if(sumAssured != null){
				criteria.add(Restrictions.eq("lpvm.sumAssured", sumAssured));
			}
			if(term != null){
				criteria.add(Restrictions.eq("lpvm.term", term));
			}
			if(applicationNo != null){
				criteria.add(Restrictions.eq("loam.oblApplNo", applicationNo));
			}
				
			list = criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findApplicationForStatusEntry Error", e);
		}finally{
			session.close();
		}
		return list;
	}
	
	public LicOblApplicationMst findById(Long id){
		Session session=null;
		LicOblApplicationMst licOblApplicationMst=null;
		try{
			session = sessionFactory.openSession();
			licOblApplicationMst = (LicOblApplicationMst) session.get(LicOblApplicationMst.class, id);
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findById Error", e);
		}finally{
			session.close();
		}
		return licOblApplicationMst;
	}


	@Override
	public List<LicOblApplicationMst> findAll() {
		Session session=null;
		List<LicOblApplicationMst> list=null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(LicOblApplicationMst.class);
			criteria.add(Restrictions.eq("deleteFlag","N"));
			
			list = criteria.list();
		}catch(Exception e){
			log.info("LicOblApplicationMstDaoImpl findAll Error", e);
		}finally{
			session.close();
		}
		return list;
	}


	@Override
	public Boolean updatePrintReceiptFlagInLicOblApplMst(LicOblApplicationMst licOblApplicationMst) {
		Session session = null;
		Transaction tx = null;
		Boolean status = false;		
		try{
			session = sessionFactory.openSession();
			tx=session.beginTransaction();
			Query query = session.createQuery("UPDATE LicOblApplicationMst SET printFlag = 'Y' WHERE id=:id");
			query.setParameter("id", licOblApplicationMst.getId());
			int rows = query.executeUpdate();
			tx.commit();
			if(rows > 0){
				status = true;
			}
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			status=false;
			log.info("LicOblApplicationMstDaoImpl updatePrintReceiptFlagInLicOblApplMst Error", e);
		}finally{
			session.close();
		}
		return status;
	}
	
}
