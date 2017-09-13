package com.meession.communication2.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meession.communication2.dao.INewAdminAddModelDao;
import com.meession.communication2.entity.NewModel;
import com.meession.communication2.service.INewAdminAddModelService;

@SuppressWarnings("serial")
@Service
public class NewAdminModelServiceImpl implements INewAdminAddModelService,Serializable {
	
	@Resource(name="newAdminModel")
	private INewAdminAddModelDao newAdminAddmodel;
	
	public void setNewAdminAddmodel(INewAdminAddModelDao newAdminAddmodel) {
		this.newAdminAddmodel = newAdminAddmodel;
	}

	@Override
	public void addModel(NewModel newModel) {
			newAdminAddmodel.addModel(newModel);
	}

	@Override
	public List<NewModel> listModel() {
		List<NewModel> listModel = newAdminAddmodel.listModel();
		return listModel;
	}

	@Override
	public void deleteModel(int id) {
			newAdminAddmodel.deleteModel(id);
	}

}
