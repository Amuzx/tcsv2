package com.meession.system.dao;

import com.meession.common.support.dao.IDaoSupport;
import com.meession.system.entity.HomePage;

/**
 * @author sam
 */
public interface IHomePageDao extends IDaoSupport {

	public HomePage findLatestHomePage();

}
