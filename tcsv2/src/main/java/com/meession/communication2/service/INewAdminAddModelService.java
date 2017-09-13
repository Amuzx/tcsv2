package com.meession.communication2.service;

import java.util.List;

import com.meession.communication2.entity.NewModel;

public interface INewAdminAddModelService {
	
	public void addModel(NewModel newModel);
	public List<NewModel> listModel();
	public void deleteModel(int id);

}
