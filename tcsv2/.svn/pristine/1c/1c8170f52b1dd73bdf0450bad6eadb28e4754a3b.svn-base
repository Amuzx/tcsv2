package com.meession.system.view;

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
 * @author sam
 */
@ManagedBean
public class MenuView {

	private List<Menu> menuList;

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	@PostConstruct
	public void init() {
		@SuppressWarnings("unchecked")
		List<Menu> allMenuList = ApplicationContextUtils.getBean("menuList",List.class);

		this.menuList = new ArrayList<Menu>();

		User user = UserContextHolder.getCurrentUser();
		List<Integer> roles = RoleConstant.getRoles(user);
		for (Menu menu : allMenuList) {
			if (menu.getRoles() != null) {
				for (Integer role : menu.getRoles()) {
					if (roles.contains(role)) {
						this.menuList.add(menu);
						break;
					}
				}
			} else {
				this.menuList.add(menu);
			}
		}
	}

}
