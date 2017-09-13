package com.meession.communication2.dao;

import java.util.List;

import com.meession.communication2.entity.NewUser;


public interface INewAdminDao {
	
	public void addTeacher(NewUser teacher);
	public List<NewUser> listTeacher();
	public void delectTeacherById(int id);

}
