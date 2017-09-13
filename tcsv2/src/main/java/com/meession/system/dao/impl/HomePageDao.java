package com.meession.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.meession.common.support.dao.DaoSupport;
import com.meession.system.dao.IHomePageDao;
import com.meession.system.entity.HomePage;

/**
 * @author sam
 */
@Repository
public class HomePageDao extends DaoSupport implements IHomePageDao {

	@Override
	public HomePage findLatestHomePage() {
		String queryString = "SELECT entity FROM HomePage entity ORDER BY entity.createdDate DESC";

		return getDaoTemplate().find(HomePage.class, queryString);
	}

}
