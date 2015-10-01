package com.ncshop.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

import com.ncshop.domain.TSellergoods;

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
public class TSellergoodsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TSellergoodsDAO.class);
	// property constants
	public static final String GOODS_INVENTORY = "goodsInventory";
	public static final String GOODS_SALES = "goodsSales";
	public static final String IS_SALE = "isSale";

	public void save(TSellergoods transientInstance) {
		log.debug("saving TSellergoods instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TSellergoods persistentInstance) {
		log.debug("deleting TSellergoods instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TSellergoods findById(java.lang.Integer id) {
		log.debug("getting TSellergoods instance with id: " + id);
		try {
			TSellergoods instance = (TSellergoods) getSession().get(
					"com.ncshop.domain.TSellergoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TSellergoods> findByExample(TSellergoods instance) {
		log.debug("finding TSellergoods instance by example");
		try {
			List<TSellergoods> results = (List<TSellergoods>) getSession()
					.createCriteria("com.ncshop.domain.TSellergoods")
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
		log.debug("finding TSellergoods instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TSellergoods as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TSellergoods> findByGoodsInventory(Object goodsInventory) {
		return findByProperty(GOODS_INVENTORY, goodsInventory);
	}

	public List<TSellergoods> findByGoodsSales(Object goodsSales) {
		return findByProperty(GOODS_SALES, goodsSales);
	}

	public List<TSellergoods> findByIsSale(Object isSale) {
		return findByProperty(IS_SALE, isSale);
	}

	public List findAll() {
		log.debug("finding all TSellergoods instances");
		try {
			String queryString = "from TSellergoods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TSellergoods merge(TSellergoods detachedInstance) {
		log.debug("merging TSellergoods instance");
		try {
			TSellergoods result = (TSellergoods) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TSellergoods instance) {
		log.debug("attaching dirty TSellergoods instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TSellergoods instance) {
		log.debug("attaching clean TSellergoods instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}