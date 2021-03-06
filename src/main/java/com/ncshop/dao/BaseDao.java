package com.ncshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.classic.Session;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class BaseDao extends BaseHibernateDAO {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	/**
	 * 
	 * @param t
	 *            要查找表的的bean实例
	 * @param fields
	 *            是表实例类型的 成员变量名
	 * @return
	 */
	public <T> List<T> getEntitiestNotLazy(T t, String[] fields,
			SimpleExpression[] eq, int start, int max, boolean flag) {
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		try {
			Criteria criteria = session.createCriteria(t.getClass());
			criteria.setTimeout(1000);
			if (fields != null) {
				for (String string : fields) {
					criteria = criteria.setFetchMode(string, FetchMode.JOIN);
				}
			}
			// 判断是否分页
			if (flag) {
				criteria.setFirstResult(start);
				criteria.setMaxResults(max);
			}

			if (eq != null) {

				for (SimpleExpression simpleExpression : eq) {
					criteria.add(simpleExpression);
				}
			}
			List<T> list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("close");
			session.close();
		}
		return null;
	}
}
