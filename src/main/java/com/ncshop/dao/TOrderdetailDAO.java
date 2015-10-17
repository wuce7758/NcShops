package com.ncshop.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ncshop.domain.TOrderdetail;
import com.ncshop.util.LogBuilder;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * TOrderdetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ncshop.domain.TOrderdetail
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TOrderdetailDAO extends BaseDao {
	private static final Log log = LogFactory.getLog(TOrderdetailDAO.class);
	// property constants
	public static final String BUY_MOUNT = "buyMount";
	public static final String BUY_COST = "buyCost";

	public void save(TOrderdetail transientInstance) {
		log.debug("saving TOrderdetail instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public void delete(TOrderdetail persistentInstance) {
		log.debug("deleting TOrderdetail instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public TOrderdetail findById(java.lang.Integer id) {
		log.debug("getting TOrderdetail instance with id: " + id);
		try {
			TOrderdetail instance = (TOrderdetail) getHibernateTemplate().get(
					"com.ncshop.domain.TOrderdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TOrderdetail instances");
		try {
			String queryString = "from TOrderdetail";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public TOrderdetail merge(TOrderdetail detachedInstance) {
		log.debug("merging TOrderdetail instance");
		try {
			TOrderdetail result = (TOrderdetail) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public void attachDirty(TOrderdetail instance) {
		log.debug("attaching dirty TOrderdetail instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public void attachClean(TOrderdetail instance) {
		log.debug("attaching clean TOrderdetail instance");
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