package com.ncshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncshop.dao.Ouath2Dao;
import com.ncshop.dao.TUserDAO;
import com.ncshop.domain.TUser;
import com.ncshop.util.LogBuilder;
@Service
public class Ouath2Service {

	@Autowired
	private Ouath2Dao dao;
	public TUser findUser(String openId) {
		
		try {
			Object []objs={openId};
			List<TUser> list = dao.getHibernateTemplate().find("from TUser where openId=?",objs);
			if (list.size() < 1) {
				return null;
			} else {
				return list.get(0);
			}
		} catch (Exception e) {
			LogBuilder.writeToLog("eror"+e.toString());
			return null;
		}
		
	}
}
