package com.meession.system.view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * @author sam
 */
@ManagedBean
public class EmailView {


	@PostConstruct
	public void init() {
		
	}

	public void sendEmail() throws Exception {
		this.init();

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Email notification has been sent.", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
