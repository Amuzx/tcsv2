package com.meession.communication2.utils;

import com.meession.communication2.entity.NewUser;
import com.meession.communication2.service.INewUserService;

/**
 * this is for loading the current user's information
 * @author sanguine
 *
 */
public abstract class UserContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	
	private static final ThreadLocal<NewUser> userHolder = new ThreadLocal<NewUser>();
	
	private static final INewUserService userService = ApplicationContextUtils
			.getBean("userService", INewUserService.class);

	public static String getCurrentUserName() {
		return contextHolder.get();
	}

	public static void setCurrentUserName(String userName) {
		contextHolder.set(userName);
	}

	
	public static NewUser getCurrentLogedUser() {
		return userHolder.get();
	}

	public static void setCurrentUser(NewUser user) {
		userHolder.set(user);
	}
	
	public static void clear() {
		contextHolder.remove();
	}

	public static NewUser getCurrentUser() {
		return userService.findByUsername(UserContextHolder.getCurrentUserName());
	}

}
