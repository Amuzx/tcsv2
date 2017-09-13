package com.meession.communication2.dao;

import java.util.List;

import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;

public interface INewStudentDao {

	public NewUser findStudent(int id);
	
	public List<NewPlan> findPlanForStudent();
	
	public NewPlan findPlanById(int planId);
	
	public List<NewPlan> findPlanByStudentNo(String stuNo);
	
	public void updateFinishPlan(NewPlan newPlan);
	
	public int findStarsAccount(int starAccount);
	
	public List findAffirmedUser(int teastatus,int stustatus,String...params);
	
	public List findHaveContentPlan(String content,String result);
}
