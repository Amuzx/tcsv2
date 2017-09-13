package com.meession.orga.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.meession.common.util.ApplicationContextUtils;
import com.meession.orga.constant.RoleConstant;
import com.meession.orga.context.UserContextHolder;
import com.meession.orga.entity.User;
import com.meession.system.entity.Menu;

/**
 * @author dingxin xin.ding@hp.com
 */
@ManagedBean
public class AdminTabView {

	private List<Menu> adminTabList;

	public List<Menu> getAdminTabList() {
		return adminTabList;
	}

	public void setAdminTabList(List<Menu> adminTabList) {
		this.adminTabList = adminTabList;
	}

	@PostConstruct
	public void init() {
		@SuppressWarnings("unchecked")
		List<Menu> allAdminTabList = ApplicationContextUtils.getBean(
				"adminTabList", List.class);

		this.adminTabList = new ArrayList<Menu>();

		User user = UserContextHolder.getCurrentUser();
		List<Integer> roles = RoleConstant.getRoles(user);
		for (Menu menu : allAdminTabList) {
			if (menu.getRoles() != null) {
				for (Integer role : menu.getRoles()) {
					if (roles.contains(role)) {
						this.adminTabList.add(menu);
						break;
					}
				}
			} else {
				this.adminTabList.add(menu);
			}
		}
	}

}
