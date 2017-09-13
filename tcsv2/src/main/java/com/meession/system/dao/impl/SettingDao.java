package com.meession.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.meession.common.support.dao.DaoSupport;
import com.meession.system.dao.ISettingDao;
import com.meession.system.entity.Setting;

/**
 * @author sam
 */
@Repository
public class SettingDao extends DaoSupport implements ISettingDao {

	@Override
	public Setting findSettingByName(String name) {
		String queryString = "SELECT entity FROM Setting entity WHERE LOWER(entity.name) = ?";

		return getDaoTemplate().find(Setting.class, queryString,
				name.toLowerCase());
	}

}
