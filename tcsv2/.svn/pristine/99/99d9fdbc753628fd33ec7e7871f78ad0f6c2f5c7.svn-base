package com.meession.system.aop;

import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.meession.orga.context.UserContextHolder;
import com.meession.system.entity.SystemLog;
import com.meession.system.service.ISystemLogService;

/**
 * @author sam
 */
@Aspect
@Component
public class LogAspect {

	@Resource
	private ISystemLogService systemLogService;

	/*@Before("@annotation(Logable)")
	public void log(Logable logable) throws Throwable {
		SystemLog systemLog = new SystemLog();
		systemLog.setStaffCode(UserContextHolder.getCurrentStaffCode());
		systemLog.setActionDate(new Date());
		systemLog.setActionType(logable.value());
		systemLog.setMessage(logable.message());
		systemLogService.add(systemLog);
	}*/
}
