package com.meession.orga.context;

import com.meession.common.util.ApplicationContextUtils;
import com.meession.orga.entity.Student;
import com.meession.orga.entity.User;
import com.meession.orga.service.IUserService;

/**
 * @author sam
 */
public abstract class UserContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	private static final IUserService userService = ApplicationContextUtils
			.getBean("userService", IUserService.class);

	public static String getCurrentStaffCode() {
		return contextHolder.get();
	}

	public static void setCurrentStaffCode(String staffCode) {
		contextHolder.set(staffCode);
	}

	public static void clear() {
		contextHolder.remove();
	}

	public static User getCurrentUser() {
		Student user=new Student();
		user.setName("sam");
		user.setCellPhone("18073245870");
		user.setDisabled(false);
		user.setEmail("aa@qq.com");
		user.setPassword("sam");
		return user;
//		return userService.loadCurrentUser();
	}

}
