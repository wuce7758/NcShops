package com.ncshop.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

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
			getSession2().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TOrder persistentInstance) {
		log.debug("deleting TOrder instance");
		try {
			getSession2().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TOrder findById(java.lang.Integer id) {
		log.debug("getting TOrder instance with id: " + id);
		try {
			TOrder instance = (TOrder) getSession2().get(
					"com.ncshop.domain.TOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TOrder> findByExample(TOrder instance) {
		log.debug("finding TOrder instance by example");
		try {
			List<TOrder> results = (List<TOrder>) getSession2()
					.createCriteria("com.ncshop.domain.TOrder")
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
		log.debug("finding TOrder instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TOrder as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession2().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TOrder> findByOrderNo(Object orderNo) {
		return findByProperty(ORDER_NO, orderNo);
	}

	public List<TOrder> findByOrderTotalCost(Object orderTotalCost) {
		return findByProperty(ORDER_TOTAL_COST, orderTotalCost);
	}

	public List<TOrder> findByOrderMsg(Object orderMsg) {
		return findByProperty(ORDER_MSG, orderMsg);
	}

	public List<TOrder> findByOrderState(Object orderState) {
		return findByProperty(ORDER_STATE, orderState);
	}

	public List findAll() {
		log.debug("finding all TOrder instances");
		try {
			String queryString = "from TOrder";
			Query queryObject = getSession2().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TOrder merge(TOrder detachedInstance) {
		log.debug("merging TOrder instance");
		try {
			TOrder result = (TOrder) getSession2().merge(detachedInstance);
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
			getSession2().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TOrder instance) {
		log.debug("attaching clean TOrder instance");
		try {
			getSession2().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public boolean update(String orderId) {
		Session session = getSessionFactory().openSession();
		try { 
			 
			session.beginTransaction();
			 
			TOrder load = (TOrder) session.load(TOrder.class, Integer.parseInt(orderId));
			 
			load.setOrderState(1);
			
			 
			session.update(load);
			 
			session.getTransaction().commit();
			return true; 
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false; 
		}finally{ 
			session.close();
		} 
	}
}