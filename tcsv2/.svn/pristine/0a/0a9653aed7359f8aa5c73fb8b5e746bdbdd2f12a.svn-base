package com.meession.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meession.system.aop.Logable;
import com.meession.system.dao.ISettingDao;
import com.meession.system.entity.Setting;
import com.meession.system.service.ISettingService;

/**
 * @author sam
 */
@Service
public class SettingService implements ISettingService {

	@Resource
	private ISettingDao settingDao;

	@Override
	public Setting findSettingByName(String name) {
		return this.settingDao.findSettingByName(name);
	}

	@Override
	public Setting addSetting(Setting setting) {
		this.settingDao.save(setting);
		return setting;
	}

	@Override
	public Setting updateSetting(Setting setting) {
		this.settingDao.update(setting);
		return setting;
	}

	@Override
	@Logable(value = "save", message = "general setting saved")
	public void saveSettings(List<Setting> settings) {
		for (Setting setting : settings) {
			this.settingDao.update(setting);
		}
	}

	@Override
	public List<Setting> list() {
		return this.settingDao.list(Setting.class);
	}

	@Override
	public boolean isEnableEmailNotification() {
		boolean enableEmailNotification = false;
		Setting setting = this.findSettingByName("enableEmailNotification");
		if (setting != null) {
			enableEmailNotification = Boolean.parseBoolean(setting.getValue());
		}
		return enableEmailNotification;
	}

}
