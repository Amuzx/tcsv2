package com.meession.orga.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

import com.meession.orga.service.IUserService;

/**
 * @author sam
 */
@ManagedBean
public class OrgaImportView {

	@ManagedProperty("#{userService}")
	private IUserService userService;

	private UploadedFile personalExcel;

	private UploadedFile orgaExcel;

	private boolean incremental;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public UploadedFile getPersonalExcel() {
		return personalExcel;
	}

	public void setPersonalExcel(UploadedFile personalExcel) {
		this.personalExcel = personalExcel;
	}

	public UploadedFile getOrgaExcel() {
		return orgaExcel;
	}

	public void setOrgaExcel(UploadedFile orgaExcel) {
		this.orgaExcel = orgaExcel;
	}

	public boolean getIncremental() {
		return incremental;
	}

	public void setIncremental(boolean incremental) {
		this.incremental = incremental;
	}

	public void upload() throws Exception {
		this.userService.importUsers(orgaExcel.getInputstream(),
				personalExcel.getInputstream(), incremental);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Succesful", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		RequestContext.getCurrentInstance().update(
				":adminTab:orgaListForm:orgaListTable");
	}

}
