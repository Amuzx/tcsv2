package com.meession.orga.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.meession.orga.entity.Teacher;
import com.meession.orga.service.IUserService;

@ManagedBean
@ViewScoped
public class TeacherView{
	
	@ManagedProperty("#{userService}")
	private IUserService userService;

	private List<Teacher> teacherList;
	private Teacher teacherAdd;
	private Teacher teacherQuery;
	private Teacher teacherMod;
	private List<Teacher> selectedTeacherList;
	
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	public Teacher getTeacherAdd() {
		return teacherAdd;
	}

	public void setTeacherAdd(Teacher teacherAdd) {
		this.teacherAdd = teacherAdd;
	}

	public Teacher getTeacherQuery() {
		return teacherQuery;
	}

	public void setTeacherQuery(Teacher teacherQuery) {
		this.teacherQuery = teacherQuery;
	}

	public Teacher getTeacherMod() {
		return teacherMod;
	}

	public void setTeacherMod(Teacher teacherMod) {
		this.teacherMod = teacherMod;
	}

	public List<Teacher> getSelectedTeacherList() {
		return selectedTeacherList;
	}

	public void setSelectedTeacherList(List<Teacher> selectedTeacherList) {
		this.selectedTeacherList = selectedTeacherList;
	}

	@PostConstruct
	public void init(){
		teacherList=new ArrayList<Teacher>();
		selectedTeacherList=new ArrayList<Teacher>();
		teacherAdd=new Teacher();
		teacherQuery=new Teacher();
		teacherMod=new Teacher();
	}

	public void query(){
		System.out.println("query");
	}
	
	
}
