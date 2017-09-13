package com.meession.system.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.LazyDataModel;

import com.meession.common.model.TableDataModel;
import com.meession.system.entity.SystemLog;
import com.meession.system.service.ISystemLogService;

/**
 * @author sam
 */
@ManagedBean
public class SystemLogListView {

	@ManagedProperty("#{systemLogService}")
	private ISystemLogService systemLogService;

	private LazyDataModel<SystemLog> lazyModel;

	public ISystemLogService getSystemLogService() {
		return systemLogService;
	}

	public void setSystemLogService(ISystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}

	public LazyDataModel<SystemLog> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<SystemLog> lazyModel) {
		this.lazyModel = lazyModel;
	}

	@PostConstruct
	public void init() {
		lazyModel = new TableDataModel<SystemLog>(systemLogService);
	}

}
