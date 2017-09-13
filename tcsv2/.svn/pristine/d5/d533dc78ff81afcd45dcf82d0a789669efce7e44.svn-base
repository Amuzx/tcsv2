package com.meession.communication2.service;

import java.io.InputStream;
import java.util.List;

import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewModel;
import com.meession.communication2.entity.NewUser;

public interface INewUserService {

	public NewUser addStudentUser(NewUser newuser);
	
	public List<NewUser> listStudentUser();
	
	public String deleteStudentUserById(int id,String stuNo);
	
	public String addStudent(InputStream inputStream);
	
	public NewUser findByUsername(String username);
	
	public void addStudent(NewUser student);
	
	public List<NewPlan> listuserplan(String username);
	
	public String insertPlanToStudent(List<NewUser> selectedStudentList,NewPlan newPlan);
	
	public List<NewModel> listModel();
}
