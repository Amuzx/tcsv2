package com.meession.orga.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.meession.orga.entity.ClassRoom;
import com.meession.orga.service.IUserService;

@ManagedBean
@ViewScoped
public class ClassRoomView {
	@ManagedProperty("#{userService}")
	private IUserService userService;

	private List<ClassRoom> classRoomList;

	public IUserService getUserService() {
		return userService;
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public List<ClassRoom> getClassRoomList() {
		return classRoomList;
	}

	public void setClassRoomList(List<ClassRoom> classRoomList) {
		this.classRoomList = classRoomList;
	}

	public void query(){
		System.out.println("query");
	}
	
	
}
