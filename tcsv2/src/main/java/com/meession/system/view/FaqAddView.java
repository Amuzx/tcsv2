package com.meession.system.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.context.RequestContext;

import com.meession.system.entity.Faq;
import com.meession.system.service.IFaqService;

/**
 * @author sam
 */
@ManagedBean
public class FaqAddView {

	@ManagedProperty("#{faqService}")
	private IFaqService faqService;

	private Faq faq;

	public IFaqService getFaqService() {
		return faqService;
	}

	public void setFaqService(IFaqService faqService) {
		this.faqService = faqService;
	}

	public Faq getFaq() {
		return faq;
	}

	public void setFaq(Faq faq) {
		this.faq = faq;
	}

	@PostConstruct
	public void init() {
		faq = new Faq();
	}

	public void addFaq() {
		this.faqService.add(faq);
	}

	public void reset() {
		RequestContext.getCurrentInstance().reset(
				":adminTab:addFaqForm:addFaqPanel");
	}
}
