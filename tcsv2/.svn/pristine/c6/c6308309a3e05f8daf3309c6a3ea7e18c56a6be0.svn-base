package com.meession.communication2.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.meession.communication2.entity.NewModel;
import com.meession.communication2.service.INewAdminAddModelService;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AddModelView implements Serializable{
	
	@ManagedProperty("#{newAdminModelServiceImpl}")
	private INewAdminAddModelService adminAddModel;
	
	/**
	 * 要添加的模板
	 */
	private NewModel addModel;
	
	/**
	 * 要删除的模板
	 */
	private NewModel deleteModel;
	
	/**
	 * 模板列表
	 */
	private List<NewModel> listModel;
	
	/*
	 * 初始化模板
	 */
	@PostConstruct
	public void modelinit(){
		listModel = this.adminAddModel.listModel();
		addModel = new NewModel();
	}
	
	/*
	 * 添加模板
	 */
	public void addModel(){
		this.adminAddModel.addModel(addModel);
		listModel = this.adminAddModel.listModel();
	}
	
	/*
	 * 删除模板
	 */
	public void deleteModel(ActionEvent e){
		Integer deleteModelId = (Integer) e.getComponent().getAttributes().get("modelId");
		adminAddModel.deleteModel(deleteModelId);
		listModel = this.adminAddModel.listModel();
		
	}

	public INewAdminAddModelService getAdminAddModel() {
		return adminAddModel;
	}

	public void setAdminAddModel(INewAdminAddModelService adminAddModel) {
		this.adminAddModel = adminAddModel;
	}

	public NewModel getAddModel() {
		return addModel;
	}

	public void setAddModel(NewModel addModel) {
		this.addModel = addModel;
	}

	public NewModel getDeleteModel() {
		return deleteModel;
	}

	public void setDeleteModel(NewModel deleteModel) {
		this.deleteModel = deleteModel;
	}

	public List<NewModel> getListModel() {
		return listModel;
	}

	public void setListModel(List<NewModel> listModel) {
		this.listModel = listModel;
	}
	
	

}
