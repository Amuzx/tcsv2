package com.meession.system.view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.meession.system.entity.HomePage;
import com.meession.system.service.IHomePageService;

/**
 * @author sam
 */
@ManagedBean
public class HomePageEditView {

	@ManagedProperty("#{homePageService}")
	private IHomePageService homePageService;

	private HomePage homePage;

	public IHomePageService getHomePageService() {
		return homePageService;
	}

	public void setHomePageService(IHomePageService homePageService) {
		this.homePageService = homePageService;
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public void setHomePage(HomePage homePage) {
		this.homePage = homePage;
	}

	@PostConstruct
	public void init() {
		this.homePage = this.homePageService.findLatestHomePage();
		if (this.homePage == null) {
			this.homePage = new HomePage();
		}
	}

	public void save() {
		this.homePageService.addHomePage(homePage);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Your changes have been saved.", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
