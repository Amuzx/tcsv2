package com.meession.communication2.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meession.communication2.dao.INewPlanDao;
import com.meession.communication2.entity.NewModel;
import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;
import com.meession.communication2.service.INewPlanService;
@Service
public class NewPlanServiceImpl implements INewPlanService {
	@Resource(name="newPlanDaoImpl")
	private INewPlanDao newPlanDao;

	public INewPlanDao getNewPlanDao() {
		return newPlanDao;
	}

	public void setNewPlanDao(INewPlanDao newPlanDao) {
		this.newPlanDao = newPlanDao;
	}

	@Override
	public NewPlan save(NewPlan newplan) {
		return newPlanDao.save(newplan);
	}

	@Override
	public void update(NewPlan newplan) {
		newPlanDao.update(newplan);
	}

	@Override
	public void deleteById(Integer userid) {
		newPlanDao.deleteById(userid);
	}

	@Override
	public NewUser findUserById(Integer id) {
		NewUser user = newPlanDao.findUserById(id);
		return user;
	}

	@Override
	public List<NewPlan> infolist() {
		List<NewPlan> list;
		list=newPlanDao.infolist();
		return list;
	}

	@Override
	public NewPlan findByStuNo(Integer id) {
		
		return newPlanDao.findBystuNo(id);
	}

}
