package com.meession.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meession.system.aop.Logable;
import com.meession.system.dao.IFaqDao;
import com.meession.system.entity.Faq;
import com.meession.system.service.IFaqService;

/**
 * FAQ service
 * 
 * @author sam
 */
@Service
public class FaqService implements IFaqService {

	@Resource
	private IFaqDao faqDao;

	@Override
	@Logable(value = "add", message = "add faq")
	public Faq add(Faq faq) {
		Faq entity = new Faq();
		entity.setQuestion(faq.getQuestion());
		entity.setAnswer(faq.getAnswer());
		this.faqDao.save(entity);
		return entity;
	}

	@Override
	@Logable(value = "update", message = "update faq")
	public Faq update(Faq faq) {
		Faq entity = this.faqDao.find(Faq.class, faq.getId());
		entity.setQuestion(faq.getQuestion());
		entity.setAnswer(faq.getAnswer());
		this.faqDao.update(entity);
		return faq;
	}

	@Override
	@Logable(value = "delete", message = "delete faq")
	public void delete(Long faqId) {
		this.faqDao.delete(Faq.class, faqId);
	}

	@Override
	public List<Faq> list() {
		return this.faqDao.list(Faq.class);
	}

}
