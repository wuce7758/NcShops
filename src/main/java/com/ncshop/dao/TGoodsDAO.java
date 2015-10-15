package com.ncshop.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ncshop.domain.TGoods;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * TGoods entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ncshop.domain.TGoods
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TGoodsDAO extends BaseDao {
	private static final Log log = LogFactory.getLog(TGoodsDAO.class);
	// property constants
	public static final String GOODS_NAME = "goodsName";
	public static final String GOODS_PRICE = "goodsPrice";
	public static final String GOODS_MSG = "goodsMsg";
	public static final String GOODS_PIC = "goodsPic";

	public void save(TGoods transientInstance) {
		log.debug("saving TGoods instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TGoods persistentInstance) {
		log.debug("deleting TGoods instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TGoods findById(java.lang.Integer id) {
		log.debug("getting TGoods instance with id: " + id);
		try {
			TGoods goods = new TGoods();
			goods.setGoodsId(id);
			return (TGoods) getHibernateTemplate().findByExample(goods).get(0);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	public List findAll() {
		log.debug("finding all TGoods instances");
		try {
			String queryString = "from TGoods";
			return getHibernateTemplate().find("from TGoods");
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TGoods merge(TGoods detachedInstance) {
		log.debug("merging TGoods instance");
		try {
			TGoods result = (TGoods) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TGoods instance) {
		log.debug("attaching dirty TGoods instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TGoods instance) {
		log.debug("attaching clean TGoods instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}