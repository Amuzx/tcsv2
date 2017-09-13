package com.meession.system.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.meession.system.entity.Setting;
import com.meession.system.service.ISettingService;

/**
 * @author sam
 */
@ManagedBean
public class SettingView {

	@ManagedProperty("#{settingService}")
	private ISettingService settingService;

	private Map<String, Setting> settingMap;

	public ISettingService getSettingService() {
		return settingService;
	}

	public void setSettingService(ISettingService settingService) {
		this.settingService = settingService;
	}

	public Map<String, Setting> getSettingMap() {
		return settingMap;
	}

	public void setSettingMap(Map<String, Setting> settingMap) {
		this.settingMap = settingMap;
	}

	@PostConstruct
	public void init() {
		settingMap = new HashMap<String, Setting>();

		String[] settingNames = { "enableSubmissionForTariffEmployeeVCIC",
				"enableSubmissionForManagementEmployeeVCIC",
				"enableSubmissionForTariffEmployeeVGIC",
				"enableSubmissionForManagementEmployeeVGIC",
				"enableSubmissionForTariffEmployeeAUDI",
				"enableSubmissionForManagementEmployeeAUDI",
				"enableSubmissionForTariffEmployeeVCRA",
				"enableSubmissionForManagementEmployeeVCRA",
				"enableEmailNotification" };
		for (String name : settingNames) {
			Setting setting = this.settingService.findSettingByName(name);
			if (setting == null) {
				setting = new Setting();
				setting.setName(name);
			}
			settingMap.put(name, setting);
		}
	}

	public void save() {
		List<Setting> settings = Arrays.asList(settingMap.values().toArray(
				new Setting[0]));
		this.settingService.saveSettings(settings);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Your changes have been saved.", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
