package com.meession.system.service;

import com.meession.system.entity.HomePage;

/**
 * @author sam
 */
public interface IHomePageService {

	public HomePage findLatestHomePage();

	public HomePage addHomePage(HomePage homePage);

}
