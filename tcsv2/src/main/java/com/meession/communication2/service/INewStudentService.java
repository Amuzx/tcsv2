package com.meession.communication2.service;

import java.util.List;

import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;

public interface INewStudentService {

	public NewUser findStudent(int id);
	
	public List<NewPlan> findPlanForStudent();
	
	public NewPlan findPlanById(int planId);
	
	public void updateFinishPlan(int chooseStars,int pId);
	
	public int findStarsAccount(int starAccount);
	
	public int[] findAffirmedUser();
}
