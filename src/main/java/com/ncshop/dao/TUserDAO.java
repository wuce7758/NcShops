package com.ncshop.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ncshop.domain.TUser;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for TUser
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ncshop.domain.TUser
 * @author MyEclipse Persistence ToolsW
 */
@Repository
public class TUserDAO extends BaseDao {
	private static final Log log = LogFactory.getLog(TUserDAO.class);
	// property constants
	public static final String OPEN_ID = "openId";
	public static final String USER_NAME = "userName";
	public static final String TEL_NUMBER = "telNumber";
	public static final String EMAIL = "email";
	public static final String SEX = "sex";
	public static final String IS_ATTENTION = "isAttention";

	public void save(TUser transientInstance) {
		Session session = getSession2();
		log.debug("saving TUser instance");
		try {
			session.save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}finally{
			session.close();
		}
	}

	public void delete(TUser persistentInstance) {
		log.debug("deleting TUser instance");
		try {
			getSession2().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUser findById(java.lang.Integer id) {
		log.debug("getting TUser instance with id: " + id);
		try {
			TUser instance = (TUser) getSession2().get(
					"com.ncshop.domain.TUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TUser> findByExample(TUser instance) {
		log.debug("finding TUser instance by example");
		try {
			List<TUser> results = (List<TUser>) getSession2()
					.createCriteria("com.ncshop.domain.TUser")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<TUser> findByProperty(String propertyName, Object value) {
		log.debug("finding TUser instance with property: " + propertyName
				+ ", value: " + value);
		Session session = getSession2();
		try {
			String queryString = "from TUser as model where model."
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

	public List<TUser> findByOpenId(Object openId) {
		return findByProperty(OPEN_ID, openId);
	}

	public List<TUser> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<TUser> findByTelNumber(Object telNumber) {
		return findByProperty(TEL_NUMBER, telNumber);
	}

	public List<TUser> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<TUser> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<TUser> findByIsAttention(Object isAttention) {
		return findByProperty(IS_ATTENTION, isAttention);
	}

	public List findAll() {
		log.debug("finding all TUser instances");
		try {
			String queryString = "from TUser";
			Query queryObject = getSession2().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TUser merge(TUser detachedInstance) {
		log.debug("merging TUser instance");
		try {
			TUser result = (TUser) getSession2().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUser instance) {
		log.debug("attaching dirty TUser instance");
		try {
			getSession2().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUser instance) {
		log.debug("attaching clean TUser instance");
		try {
			getSession2().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}