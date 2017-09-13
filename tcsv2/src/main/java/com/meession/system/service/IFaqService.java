package com.meession.system.service;

import java.util.List;

import com.meession.system.entity.Faq;

/**
 * @author sam
 */
public interface IFaqService {

	public Faq add(Faq faq);

	public Faq update(Faq faq);

	public void delete(Long faqId);

	public List<Faq> list();

}
