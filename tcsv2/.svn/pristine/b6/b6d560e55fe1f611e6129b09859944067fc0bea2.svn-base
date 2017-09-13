package com.meession.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meession.common.support.Pager;
import com.meession.system.dao.ISystemLogDao;
import com.meession.system.entity.SystemLog;
import com.meession.system.service.ISystemLogService;

/**
 * System log service
 * 
 * @author sam
 */
@Service
public class SystemLogService implements ISystemLogService {

	@Resource
	private ISystemLogDao systemLogDao;

	@Override
	public Pager<SystemLog> search(Pager<SystemLog> pager, String filterValue) {
		return this.systemLogDao.search(pager, filterValue);
	}

	@Override
	public SystemLog add(SystemLog systemLog) {
		this.systemLogDao.save(systemLog);
		return systemLog;
	}

}
