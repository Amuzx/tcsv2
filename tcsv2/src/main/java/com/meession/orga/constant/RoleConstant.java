package com.meession.orga.constant;

import java.util.ArrayList;
import java.util.List;

import com.meession.orga.entity.User;

/**	
 * @author sam
 */
public abstract class RoleConstant {
     /**
      * 普通用户
      */
	public static final int NORMAL_USER = 0;
    /**
     * 普通学生
     */
	public static final int NORMAL_STUDENT = 1;
   /**
    * 普通老师 
    */
	public static final int NORMAL_TEACHER = 2;
    /**
     * 超级管理员
     */
	public static final int SUPER_ADMIN = 3;
    /**
     * 行政管理人员
     */
	public static final int ADMINISTRATIVE = 4;

	public static List<Integer> getRoles(User user) {
		List<Integer> roles = new ArrayList<Integer>();
//		List<Role> roleList = user.getRoles();
//		for (Role role : roleList) {
//			roles.add(role.getRoleId());
//		}
//		if (user instanceof Student) {
//			roles.add(RoleConstant.NORMAL_STUDENT);
//		}
//		if (user instanceof Teacher) {
//			roles.add(RoleConstant.NORMAL_TEACHER);
//		}
		
		roles.add(NORMAL_USER);
		roles.add(NORMAL_STUDENT);
		roles.add(NORMAL_TEACHER);
		roles.add(SUPER_ADMIN);
		roles.add(ADMINISTRATIVE);
		return roles;
	}

	
	
}
