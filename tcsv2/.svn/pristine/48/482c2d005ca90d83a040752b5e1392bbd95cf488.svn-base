package com.meession.orga.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.meession.orga.entity.Role;
import com.meession.orga.service.IUserService;

@ManagedBean
@ViewScoped
public class RoleView {
	@ManagedProperty("#{userService}")
	private IUserService userService;

	private List<Role> roleList;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
