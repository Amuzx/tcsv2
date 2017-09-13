package com.meession.system.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;

import com.meession.system.entity.Faq;
import com.meession.system.service.IFaqService;

/**
 * @author sam
 */
@ManagedBean
@ViewScoped
public class FaqListView {

	@ManagedProperty("#{faqService}")
	private IFaqService faqService;

	private List<Faq> faqList;

	public IFaqService getFaqService() {
		return faqService;
	}

	public void setFaqService(IFaqService faqService) {
		this.faqService = faqService;
	}

	public List<Faq> getFaqList() {
		return faqList;
	}

	@PostConstruct
	public void init() {
		faqList = this.getFaqService().list();
	}

	public void updateFaq(RowEditEvent event) {
		Faq faq = (Faq) event.getObject();
		this.faqService.update(faq);
	}

	public void deleteFaq(ActionEvent event) {
		Long faqId = (Long) event.getComponent().getAttributes().get("faqId");
		this.faqService.delete(faqId);
		this.init();
	}

}
