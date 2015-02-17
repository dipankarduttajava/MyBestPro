package com.gtfs.dao.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.gtfs.bean.AgentMst;
import com.gtfs.dao.interfaces.AgentMstDao;

@Repository
@Scope("application")
public class AgentMstDaoImpl implements AgentMstDao,Serializable{
	private Logger log = Logger.getLogger(AgentMstDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AgentMst findByAgCode(Long agCode){
		AgentMst agentMst = null;
	 	Session session = null;
        try {
            session = sessionFactory.openSession();
            agentMst = (AgentMst) session.get(AgentMst.class, agCode);
        } catch (Exception e) {
        	log.info("AgentMstDaoImpl findByAgCode Error", e);
        } finally {
            session.close();
        }
        return agentMst;
	}
}