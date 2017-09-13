package com.meession.communication2.util;

import com.meession.communication2.entity.NewUser;

public class ThreadCache {

	private static ThreadLocal<NewUser> threadLocal = new ThreadLocal<NewUser>();
	
	public static void setNewUser(NewUser user){
		threadLocal.set(user);
	}
	
	public static NewUser getNewUser(){
		return threadLocal.get();
	}
}
