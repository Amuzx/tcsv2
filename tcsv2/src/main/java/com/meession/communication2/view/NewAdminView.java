package com.meession.communication2.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;
import com.meession.communication2.service.INewAdminService;
import com.meession.communication2.service.INewPlanService;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class NewAdminView implements Serializable {
	
	@ManagedProperty("#{newAdminServiceImpl}")
	private INewAdminService adminService;
	
	@ManagedProperty("#{newPlanServiceImpl}")
	private INewPlanService modelService;
	
	/**
	 * 要提交的用户
	 */
	private NewUser user;
	

	/**
	 * 要删除的用户
	 */
	private NewUser deleteTeacher;
	
	/**
	 * 用户列表
	 */
	private List<NewUser> userList;
	
	/**
	 * 要提交的模块
	 */
	private NewPlan model;
	
	/**
	 * 要模块列表
	 */
	private List<NewPlan> modelList;
	
	@PostConstruct
	public void userstuinit()
	{
		modelList = this.modelService.infolist();
		model = new NewPlan();
		userList = this.adminService.listTeacher();
		user = new NewUser();
//		user.setUserAccount("20160107");
//		user.setPwd("123456");
//		user.setUserType(2);
//		userList.add(user);
	}
	/**
	 * 添加用户
	 */
	public void addUsers() {
//		String isSuccess = null;
		this.adminService.addTeacher(user);
//		System.out.println(isSuccess);
//		if ("save success!".equals(isSuccess)) {
//			RequestContext.getCurrentInstance().execute("PF('addadminDialog').hide()");
//			//RequestContext.getCurrentInstance().reset("PF('userstuInfo')");
//		}else {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR!","this account is already!"));
//		}
		
	}

	/*
	 * 删除老师
	 */
	public void deleteTeacher(ActionEvent e){
		 Integer deleteTeacherId = (Integer) e.getComponent().getAttributes().get("teacherId");
		adminService.delectTeacherById(deleteTeacherId);
	}
	
	/**
	 * 添加模板
	 */
	public void addmodel(){
			this.modelService.save(model);
	}

	public INewAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(INewAdminService adminService) {
		this.adminService = adminService;
	}


	public NewUser getUser() {
		return user;
	}

	public void setUser(NewUser user) {
		this.user = user;
	}
	
	public List<NewUser> getUserList() {
		return userList;
	}
	public void setUserList(List<NewUser> userList) {
		this.userList = userList;
	}
	public INewPlanService getModelService() {
		return modelService;
	}
	public void setModelService(INewPlanService modelService) {
		this.modelService = modelService;
	}
	public NewPlan getModel() {
		return model;
	}
	public void setModel(NewPlan model) {
		this.model = model;
	}
	public List<NewPlan> getModelList() {
		return modelList;
	}
	public void setModelList(List<NewPlan> modelList) {
		this.modelList = modelList;
	}
	public NewUser getDeleteTeacher() {
		return deleteTeacher;
	}
	public void setDeleteTeacher(NewUser deleteTeacher) {
		this.deleteTeacher = deleteTeacher;
	}

}
