package com.meession.communication2.service;

import java.io.InputStream;
import java.util.List;

import com.meession.communication2.entity.NewUser;
public interface INewAdminService{

	
	public void importUser(InputStream userStream);
	public void addTeacher(NewUser teacher);
	public List<NewUser> listTeacher();
	public void delectTeacherById(int id);
	
	//Excel批量插入
	public String addUsers(InputStream inputStream);

}
