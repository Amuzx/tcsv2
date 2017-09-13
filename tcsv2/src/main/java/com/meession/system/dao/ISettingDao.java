package com.meession.system.dao;

import com.meession.common.support.dao.IDaoSupport;
import com.meession.system.entity.Setting;

/**
 * @author sam
 */
public interface ISettingDao extends IDaoSupport {

	public Setting findSettingByName(String name);

}
