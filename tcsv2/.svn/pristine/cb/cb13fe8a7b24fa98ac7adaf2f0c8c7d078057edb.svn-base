package com.meession.orga.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.meession.orga.entity.User;
import com.meession.orga.service.IUserService;

@ManagedBean
public class SuperAdminUserAddView {

	@ManagedProperty("#{userService}")
	private IUserService userService;

	@ManagedProperty("#{superAdminUserListView}")
	private SuperAdminUserListView superAdminUserListView;

	private List<User> userListForAdd;

	private List<User> filteredUsers;

	private List<User> selectedUsers;

	public void setSuperAdminUserListView(
			SuperAdminUserListView superAdminUserListView) {
		this.superAdminUserListView = superAdminUserListView;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<User> getUserListForAdd() {
		return userListForAdd;
	}

	public void setUserListForAdd(List<User> userListForAdd) {
		this.userListForAdd = userListForAdd;
	}

	public List<User> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<User> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}

	public List<User> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	@PostConstruct
	public void init() {
		userListForAdd = this.userService.listSuperAdminUsersForAdd();
	}

	public void add(ActionEvent event) {
		List<User> users = this.getSelectedUsers();
		for (int i = 0; i < users.size(); i++) {
			this.userService.addSuperAdminUser(users.get(i).getId());
		}
		superAdminUserListView.init();
	}

	public void reset() {
		RequestContext.getCurrentInstance().reset(
				":adminTab:addSUserForm:addSUserTable");
	}
}
