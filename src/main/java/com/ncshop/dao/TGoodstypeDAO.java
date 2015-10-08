package com.ncshop.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
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
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TGoodstype persistentInstance) {
		log.debug("deleting TGoodstype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TGoodstype findById(java.lang.Integer id) {
		log.debug("getting TGoodstype instance with id: " + id);
		try {
			TGoodstype instance = (TGoodstype) getSession().get(
					"com.ncshop.domain.TGoodstype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TGoodstype> findByExample(TGoodstype instance) {
		log.debug("finding TGoodstype instance by example");
		try {
			List<TGoodstype> results = (List<TGoodstype>) getSession()
					.createCriteria("com.ncshop.domain.TGoodstype")
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
		log.debug("finding TGoodstype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TGoodstype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TGoodstype> findByGoodsTypeName(Object goodsTypeName) {
		return findByProperty(GOODS_TYPE_NAME, goodsTypeName);
	}

	public List findAll() {
		log.debug("finding all TGoodstype instances");
		try {
			String queryString = "from TGoodstype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TGoodstype merge(TGoodstype detachedInstance) {
		log.debug("merging TGoodstype instance");
		try {
			TGoodstype result = (TGoodstype) getSession().merge(
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
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TGoodstype instance) {
		log.debug("attaching clean TGoodstype instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}