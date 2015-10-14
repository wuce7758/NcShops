package com.ncshop.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
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
			getSession2().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TGoods persistentInstance) {
		log.debug("deleting TGoods instance");
		try {
			getSession2().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TGoods findById(java.lang.Integer id) {
		log.debug("getting TGoods instance with id: " + id);
		try {
			TGoods instance = (TGoods) getSession2().get(
					"com.ncshop.domain.TGoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TGoods> findByExample(TGoods instance) {
		log.debug("finding TGoods instance by example");
		try {
			List<TGoods> results = (List<TGoods>) getSession2()
					.createCriteria("com.ncshop.domain.TGoods")
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
		log.debug("finding TGoods instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TGoods as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession2().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TGoods> findByGoodsName(Object goodsName) {
		return findByProperty(GOODS_NAME, goodsName);
	}

	public List<TGoods> findByGoodsPrice(Object goodsPrice) {
		return findByProperty(GOODS_PRICE, goodsPrice);
	}

	public List<TGoods> findByGoodsMsg(Object goodsMsg) {
		return findByProperty(GOODS_MSG, goodsMsg);
	}

	public List<TGoods> findByGoodsPic(Object goodsPic) {
		return findByProperty(GOODS_PIC, goodsPic);
	}

	public List findAll() {
		log.debug("finding all TGoods instances");
		try {
			String queryString = "from TGoods";
			Query queryObject = getSession2().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TGoods merge(TGoods detachedInstance) {
		log.debug("merging TGoods instance");
		try {
			TGoods result = (TGoods) getSession2().merge(detachedInstance);
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
			getSession2().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TGoods instance) {
		log.debug("attaching clean TGoods instance");
		try {
			getSession2().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}