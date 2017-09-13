package com.meession.communication2.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
//import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.UploadedFile;

import com.meession.communication2.service.INewAdminService;
import com.meession.communication2.service.INewUserService;

@SuppressWarnings("serial")
@ManagedBean
public class ImportUsersView implements Serializable{

	@ManagedProperty("#{newAdminServiceImpl}")
	private INewAdminService newUsersService;
	
	private UploadedFile usersExcel ;

	public void uploadUsers(){
		System.out.println(usersExcel);
		try{
			String result = this.newUsersService.addUsers(usersExcel.getInputstream());
			if("successful".equals(result)){
				RequestContext.getCurrentInstance().execute("PF('importadminDialog').hide()");
				RequestContext.getCurrentInstance().update(":adminListForm:adminListTable");
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succesful", "save Excel successful");				
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}catch(Exception e){
			System.out.println("读取表格失败！");
		}
	}


	public INewAdminService getNewUsersService() {
		return newUsersService;
	}


	public void setNewUsersService(INewAdminService newUsersService) {
		this.newUsersService = newUsersService;
	}


	public UploadedFile getUsersExcel() {
		return usersExcel;
	}

	public void setUsersExcel(UploadedFile usersExcel) {
		this.usersExcel = usersExcel;
	}
	
	
	
}
