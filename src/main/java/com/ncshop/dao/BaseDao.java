package com.ncshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.classic.Session;
import org.hibernate.criterion.SimpleExpression;

public class BaseDao extends BaseHibernateDAO {

	/**
	 * 
	 * @param t
	 *            要查找表的的bean实例
	 * @param fields
	 *            是表实例类型的 成员变量名
	 * @return
	 */
	public <T> List<T> getEntitiestNotLazy(T t, String[] fields,
			SimpleExpression eq, int start, int max, boolean flag) {
		Session session = getSessionFactory().openSession();
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

				criteria.add(eq);
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
