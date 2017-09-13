package com.meession.communication2.service;

import java.util.List;

import com.meession.communication2.entity.NewModel;
import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;

public interface INewPlanService {
	public NewPlan save(NewPlan newplan);
	public void update(NewPlan newplan);
	public void deleteById(Integer userid);
	public NewPlan findByStuNo(Integer id);
	public List<NewPlan> infolist();
	public NewUser findUserById(Integer id);
}
