package com.meession.orga.view;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import com.meession.common.model.TableDataModel;
import com.meession.orga.entity.User;
import com.meession.orga.service.IUserService;

/**
 * @author sam
 */
@ManagedBean
@ViewScoped
public class OrgaListView {

	@ManagedProperty("#{userService}")
	private IUserService userService;

	private LazyDataModel<User> lazyModel;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public LazyDataModel<User> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<User> lazyModel) {
		this.lazyModel = lazyModel;
	}

	@PostConstruct
	public void init() {
		lazyModel = new TableDataModel<User>(userService);
	}

	public void openImportView() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("draggable", true);
		options.put("resizable", true);
		options.put("contentHeight", 300);

		RequestContext.getCurrentInstance().openDialog("orgaImport", options,
				null);
	}

	public void importViewReturn(SelectEvent event) {
		RequestContext.getCurrentInstance().update(
				":adminTab:orgaListForm:orgaListTable");
	}
}
