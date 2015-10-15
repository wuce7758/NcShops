package com.ncshop.dao;

import java.nio.channels.SeekableByteChannel;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ncshop.domain.TAddress;
import com.ncshop.domain.TOrder;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAddress entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ncshop.domain.TAddress
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TAddressDAO extends BaseDao {
	private static final Log log = LogFactory.getLog(TAddressDAO.class);
	// property constants
	public static final String ADS_CONTENT = "adsContent";
	public static final String ADS_PHONE = "adsPhone";

	public void save(TAddress transientInstance) {
		log.debug("saving TAddress instance");
		try {
			getSession2().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TAddress persistentInstance) {
		log.debug("deleting TAddress instance");
		try {
			getSession2().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TAddress findById(java.lang.Integer id) {
		log.debug("getting TAddress instance with id: " + id);
		try {
			TAddress instance = (TAddress) getSession2().get(
					"com.ncshop.domain.TAddress", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TAddress> findByExample(TAddress instance) {
		log.debug("finding TAddress instance by example");
		try {
			List<TAddress> results = (List<TAddress>) getSession2()
					.createCriteria("com.ncshop.domain.TAddress")
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
		
		Session session=getSession2();
		log.debug("finding TAddress instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TAddress as model where model."
					+ propertyName + "= ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}finally{
			session.close();
		}
	}

	public List<TAddress> findByAdsContent(Object adsContent) {
		return findByProperty(ADS_CONTENT, adsContent);
	}

	public List<TAddress> findByAdsPhone(Object adsPhone) {
		return findByProperty(ADS_PHONE, adsPhone);
	}

	public List findAll() {
		log.debug("finding all TAddress instances");
		try {
			String queryString = "from TAddress";
			Query queryObject = getSession2().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TAddress merge(TAddress detachedInstance) {
		log.debug("merging TAddress instance");
		try {
			TAddress result = (TAddress) getSession2().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAddress instance) {
		log.debug("attaching dirty TAddress instance");
		try {
			getSession2().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAddress instance) {
		log.debug("attaching clean TAddress instance");
		try {
			getSession2().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public boolean update(Integer addressId) {
		
		Session session = getSessionFactory().openSession();
		try { 
			 
			session.beginTransaction();
			TAddress load = (TAddress) session.load(TAddress.class, addressId);
			load.setIsDefault(false);
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