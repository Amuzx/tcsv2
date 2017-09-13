package com.meession.communication2.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.meession.common.support.dao.DaoSupport;
import com.meession.communication2.dao.INewPlanDao;
import com.meession.communication2.entity.NewModel;
import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;
@Repository("newPlanDaoImpl")
public class NewPlanDaoImpl extends DaoSupport implements INewPlanDao {

	@Override
	public NewPlan save(NewPlan newplan) {
		getDaoTemplate().save(newplan);
		return newplan;
	}

	@Override
	public void update(NewPlan newplan) {
		getDaoTemplate().update(newplan);
	}

	@Override
	public void deleteById(Integer userid) {
		getDaoTemplate().delete(NewPlan.class, userid);
	}

	@Override
	public NewPlan findBystuNo(Integer id) {
		return  getDaoTemplate().find(NewPlan.class, id);
	}
	@Override
	public List<NewPlan> infolist() {
		List<NewPlan> list=getDaoTemplate().list(NewPlan.class);
		return list;
	}

	@Override
	public NewUser findUserById(Integer id) {
		NewUser user = getDaoTemplate().find(NewUser.class, id);
		return user;
	}

	/**
	 * 取得所有计划模板
	 */
	@Override
	public List<NewModel> listModel() {
		List<NewModel> listModel = this.getDaoTemplate().list(NewModel.class);
		return listModel;
	}
}