package com.ncshop.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ncshop.domain.TOrderdetail;

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
			getSession2().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TOrderdetail persistentInstance) {
		log.debug("deleting TOrderdetail instance");
		try {
			getSession2().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TOrderdetail findById(java.lang.Integer id) {
		log.debug("getting TOrderdetail instance with id: " + id);
		try {
			TOrderdetail instance = (TOrderdetail) getSession2().get(
					"com.ncshop.domain.TOrderdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TOrderdetail> findByExample(TOrderdetail instance) {
		log.debug("finding TOrderdetail instance by example");
		try {
			List<TOrderdetail> results = (List<TOrderdetail>) getSession2()
					.createCriteria("com.ncshop.domain.TOrderdetail")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TOrderdetail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TOrderdetail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession2().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TOrderdetail> findByBuyMount(Object buyMount) {
		return findByProperty(BUY_MOUNT, buyMount);
	}

	public List<TOrderdetail> findByBuyCost(Object buyCost) {
		return findByProperty(BUY_COST, buyCost);
	}

	public List findAll() {
		log.debug("finding all TOrderdetail instances");
		try {
			String queryString = "from TOrderdetail";
			Query queryObject = getSession2().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TOrderdetail merge(TOrderdetail detachedInstance) {
		log.debug("merging TOrderdetail instance");
		try {
			TOrderdetail result = (TOrderdetail) getSession2().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TOrderdetail instance) {
		log.debug("attaching dirty TOrderdetail instance");
		try {
			getSession2().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TOrderdetail instance) {
		log.debug("attaching clean TOrderdetail instance");
		try {
			getSession2().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}