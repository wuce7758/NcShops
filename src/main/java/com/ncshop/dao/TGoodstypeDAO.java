package com.ncshop.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ncshop.domain.TGoodstype;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * TGoodstype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ncshop.domain.TGoodstype
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TGoodstypeDAO extends BaseDao {
	private static final Log log = LogFactory.getLog(TGoodstypeDAO.class);
	// property constants
	public static final String GOODS_TYPE_NAME = "goodsTypeName";

	public void save(TGoodstype transientInstance) {
		log.debug("saving TGoodstype instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TGoodstype persistentInstance) {
		log.debug("deleting TGoodstype instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TGoodstype findById(java.lang.Integer id) {
		log.debug("getting TGoodstype instance with id: " + id);
		try {
			TGoodstype type=new TGoodstype();
			type.setGoodsTypeId(id);
			List findByExample = getHibernateTemplate().findByExample(type);
			return (TGoodstype) findByExample.get(0);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public TGoodstype merge(TGoodstype detachedInstance) {
		log.debug("merging TGoodstype instance");
		try {
			TGoodstype result = (TGoodstype) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TGoodstype instance) {
		log.debug("attaching dirty TGoodstype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TGoodstype instance) {
		log.debug("attaching clean TGoodstype instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}