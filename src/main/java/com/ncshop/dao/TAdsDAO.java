package com.ncshop.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.stereotype.Repository;

import com.ncshop.domain.TAds;
import com.ncshop.util.LogBuilder;


@Repository
public class TAdsDAO extends BaseDao {
	private static final Log log = LogFactory.getLog(TAdsDAO.class);

	public void save(TAds transientInstance) {
		log.debug("saving TAds instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public void delete(TAds persistentInstance) {
		log.debug("deleting TAds instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public TAds findById(java.lang.Integer id) {
		log.debug("getting TAds instance with id: " + id);
		try {
			TAds instance = (TAds) getHibernateTemplate().get(
					"com.ncshop.domain.TAds", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	
	

	public List findAll() {
		log.debug("finding all TAds instances");
		try {
			String queryString = "from TAds";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public TAds merge(TAds detachedInstance) {
		log.debug("merging TAds instance");
		try {
			TAds result = (TAds) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public void attachDirty(TAds instance) {
		log.debug("attaching dirty TAds instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public void attachClean(TAds instance) {
		log.debug("attaching clean TAds instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}
}