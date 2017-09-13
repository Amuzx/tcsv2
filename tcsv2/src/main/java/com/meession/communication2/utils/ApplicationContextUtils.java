package com.meession.communication2.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

/**
 * the class is used to load beans instead of get application context every time<br/>
 * 
 * 
 * @author ranbow
 *
 */
public abstract class ApplicationContextUtils {
	/**
	 * the function for loading the bean instances
	 * @param beanName   the name of the bean
	 * @param clazz  the class instance of the bean to be loaded
	 * @return
	 */
	public static <T> T getBean(String beanName, Class<T> clazz) {
		ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		return context.getBean(beanName, clazz);
	}
}