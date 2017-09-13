package com.meession.communication2.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.meession.common.support.dao.DaoSupport;
import com.meession.communication2.dao.INewAdminAddModelDao;
import com.meession.communication2.entity.NewModel;

@Repository("newAdminModel")
public class NewAdminModelDaoImpl extends DaoSupport implements INewAdminAddModelDao {

	@Override
	public void addModel(NewModel newModel) {
			getDaoTemplate().save(newModel);
	}

	@Override
	public List<NewModel> listModel() {
		List<NewModel> listModel = getDaoTemplate().list(NewModel.class);
		return listModel;
	}

	@Override
	public void deleteModel(int id) {
			getDaoTemplate().delete(NewModel.class, id);
	}

}
