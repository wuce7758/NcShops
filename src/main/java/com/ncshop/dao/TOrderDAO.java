package com.ncshop.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ncshop.domain.TAddress;
import com.ncshop.domain.TOrder;

/**
 * A data access object (DAO) providing persistence and search support for
 * TOrder entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ncshop.domain.TOrder
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TOrderDAO extends BaseDao {
	private static final Log log = LogFactory.getLog(TOrderDAO.class);
	// property constants
	public static final String ORDER_NO = "orderNo";
	public static final String ORDER_TOTAL_COST = "orderTotalCost";
	public static final String ORDER_MSG = "orderMsg";
	public static final String ORDER_STATE = "orderState";

	public void save(TOrder transientInstance) {
		log.debug("saving TOrder instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TOrder persistentInstance) {
		log.debug("deleting TOrder instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public TOrder findById(java.lang.Integer id) {
		log.debug("getting TOrder instance with id: " + id);
		try {
			TOrder instance = (TOrder) getHibernateTemplate().get(
					"com.ncshop.domain.TOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List findAll() {
		log.debug("finding all TOrder instances");
		try {
			return getHibernateTemplate().find("from TOrder");
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public TOrder merge(TOrder detachedInstance) {
		log.debug("merging TOrder instance");
		try {
			TOrder result = (TOrder) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TOrder instance) {
		log.debug("attaching dirty TOrder instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TOrder instance) {
		log.debug("attaching clean TOrder instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public boolean update(String orderId) {
		try {
			TOrder order=new TOrder();
			order.setOrderState(1);
			getHibernateTemplate().update(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}