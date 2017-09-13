package com.meession.system.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meession.system.aop.Logable;
import com.meession.system.dao.IHomePageDao;
import com.meession.system.entity.HomePage;
import com.meession.system.service.IHomePageService;

/**
 * Home page service
 * 
 * @author sam
 */
@Service
public class HomePageService implements IHomePageService {

	@Resource
	private IHomePageDao homePageDao;

	@Override
	public HomePage findLatestHomePage() {
		return this.homePageDao.findLatestHomePage();
	}

	@Override
	@Logable(value = "save", message = "save home page")
	public HomePage addHomePage(HomePage homePage) {
		HomePage entity = new HomePage();
		entity.setContent(homePage.getContent());
		entity.setCreatedDate(new Date());
		this.homePageDao.save(entity);
		return entity;
	}

}
