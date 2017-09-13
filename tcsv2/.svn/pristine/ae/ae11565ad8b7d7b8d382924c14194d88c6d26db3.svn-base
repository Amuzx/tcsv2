package com.meession.communication2.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
//import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.UploadedFile;

import com.meession.communication2.service.INewUserService;

@SuppressWarnings("serial")
@ManagedBean
public class ImportStudentView implements Serializable{

	@ManagedProperty("#{newUserServiceImpl}")
	private INewUserService newUserService;
	
	private UploadedFile studentExcel ;

	public void uploadStudent(){
		try{
			String result = this.newUserService.addStudent(studentExcel.getInputstream());
			if("successful".equals(result)){
				RequestContext.getCurrentInstance().execute("PF('importStudentDialog1').hide()");
				RequestContext.getCurrentInstance().update(":studentListPanel:studentListTable");
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succesful", "save Excel successful");				
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}catch(Exception e){
			System.out.println("读取表格失败！");
		}
	}
	
	public INewUserService getNewUserService() {
		return newUserService;
	}

	public void setNewUserService(INewUserService newUserService) {
		this.newUserService = newUserService;
	}

	public UploadedFile getStudentExcel() {
		return studentExcel;
	}

	public void setStudentExcel(UploadedFile studentExcel) {
		this.studentExcel = studentExcel;
	}
	
}
