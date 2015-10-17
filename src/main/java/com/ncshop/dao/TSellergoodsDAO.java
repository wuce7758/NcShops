package com.ncshop.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ncshop.domain.TSellergoods;
import com.ncshop.util.LogBuilder;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * TSellergoods entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ncshop.domain.TSellergoods
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TSellergoodsDAO extends BaseDao {
	private static final Log log = LogFactory.getLog(TSellergoodsDAO.class);
	// property constants
	public static final String GOODS_INVENTORY = "goodsInventory";
	public static final String GOODS_SALES = "goodsSales";
	public static final String IS_SALE = "isSale";

	public void save(TSellergoods transientInstance) {
		log.debug("saving TSellergoods instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public void delete(TSellergoods persistentInstance) {
		log.debug("deleting TSellergoods instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public TSellergoods findById(java.lang.Integer id) {
		log.debug("getting TSellergoods instance with id: " + id);
		try {
			TSellergoods instance = (TSellergoods) getHibernateTemplate().get(
					"com.ncshop.domain.TSellergoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TSellergoods instances");
		try {
			String queryString = "from TSellergoods";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public TSellergoods merge(TSellergoods detachedInstance) {
		log.debug("merging TSellergoods instance");
		try {
			TSellergoods result = (TSellergoods) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public void attachDirty(TSellergoods instance) {
		log.debug("attaching dirty TSellergoods instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			LogBuilder.writeToLog(re.getMessage());
			throw re;
		}
	}

	public void attachClean(TSellergoods instance) {
		log.debug("attaching clean TSellergoods instance");
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