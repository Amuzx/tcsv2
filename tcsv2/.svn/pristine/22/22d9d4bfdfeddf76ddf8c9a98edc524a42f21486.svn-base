package com.meession.orga.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.meession.orga.entity.User;
import com.meession.orga.service.IUserService;

/**
 * @author sam
 */
@ManagedBean
@ViewScoped
public class SuperAdminUserListView {

	@ManagedProperty("#{userService}")
	private IUserService userService;

	private List<User> userList;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@PostConstruct
	public void init() {
		userList = this.userService.listSuperAdminUsers();
	}

	public void delete(ActionEvent event) {
		Long id = (Long) event.getComponent().getAttributes().get("userId");
		this.userService.deleteSuperAdminUser(id);
		this.init();
	}

}
