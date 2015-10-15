package com.ncshop.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ncshop.domain.TSeller;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * TSeller entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ncshop.domain.TSeller
 * @author MyEclipse Persistence Tools
 */
@Repository("TSellerDAO")
public class TSellerDAO extends BaseDao {
	private static final Log log = LogFactory.getLog(TSellerDAO.class);
	// property constants
	public static final String SHOP_NAME = "shopName";
	public static final String SELLER_NAME = "sellerName";
	public static final String SELLER_ADDRESS = "sellerAddress";
	public static final String SELLER_PHONE = "sellerPhone";
	public static final String JOIN_DEADLINE = "joinDeadline";
	public static final String IS_VALID = "isValid";
	public static final String MIN_BUY = "minBuy";
	public static final String DELIVER_MONEY = "deliverMoney";
	public static final String SELLER_MSG = "sellerMsg";

	public void save(TSeller transientInstance) {
		log.debug("saving TSeller instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TSeller persistentInstance) {
		log.debug("deleting TSeller instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TSeller findById(java.lang.Integer id) {
		log.debug("getting TSeller instance with id: " + id);
		try {
			TSeller instance = (TSeller) getHibernateTemplate().get(
					"com.ncshop.domain.TSeller", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	

	public List findAll() {
		log.debug("finding all TSeller instances");
		try {
			String queryString = "from TSeller";
			return getHibernateTemplate().findByExample(new TSeller());
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TSeller merge(TSeller detachedInstance) {
		log.debug("merging TSeller instance");
		try {
			TSeller result = (TSeller) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TSeller instance) {
		log.debug("attaching dirty TSeller instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TSeller instance) {
		log.debug("attaching clean TSeller instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}