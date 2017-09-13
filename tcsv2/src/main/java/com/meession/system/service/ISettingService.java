package com.meession.system.service;

import java.util.List;

import com.meession.system.entity.Setting;

/**
 * @author  sam
 */
public interface ISettingService {

	public Setting findSettingByName(String name);

	public Setting addSetting(Setting setting);

	public Setting updateSetting(Setting setting);

	public void saveSettings(List<Setting> settings);

	public List<Setting> list();

	public boolean isEnableEmailNotification();

}
