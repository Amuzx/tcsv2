package com.meession.communication2.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.meession.communication2.entity.NewUser;
import com.meession.communication2.service.INewUserService;

@ManagedBean
@ViewScoped
public class NewStudentView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{newUserServiceImpl}")
	private INewUserService newUserService;
	
	/**
	 * 添加单个学生
	 */
	private NewUser newuser;
	
	private List<NewUser> listNewUser;
	
	@PostConstruct
	public void init(){
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//		user = (NewUser) session.getAttribute("user");
		newuser = new NewUser();
		listNewUser = this.newUserService.listStudentUser();
	}
	
	/**
	 * 添加学生
	 */
	public void addStudentUser(){
		newuser.setType(2);
		newUserService.addStudent(newuser);
	}
	
	/**
	 * 删除学生
	 */
	public void deleteStudentUser(ActionEvent e){
		int id = (int) e.getComponent().getAttributes().get("userid");
		String stuNo = (String) e.getComponent().getAttributes().get("userNo");
		String result = this.newUserService.deleteStudentUserById(id,stuNo);
		if("delete succeed".equals(result)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "delete succeed"));
		}else if("delete failure".equals(result)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN!", "You can't delete he/she,because he/she has plan!"));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "unsuccessful delete the student"));
		}
	}

	public List<NewUser> getListNewUser() {
		return listNewUser;
	}

	public void setListNewUser(List<NewUser> listNewUser) {
		this.listNewUser = listNewUser;
	}

	public INewUserService getNewUserService() {
		return newUserService;
	}

	public void setNewUserService(INewUserService newUserService) {
		this.newUserService = newUserService;
	}

	public NewUser getNewuser() {
		return newuser;
	}

	public void setNewuser(NewUser newuser) {
		this.newuser = newuser;
	}
}
