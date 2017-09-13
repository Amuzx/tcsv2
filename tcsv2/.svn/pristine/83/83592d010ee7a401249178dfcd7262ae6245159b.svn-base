package com.meession.communication2.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.meession.common.support.dao.DaoSupport;
import com.meession.communication2.dao.INewAdminDao;
import com.meession.communication2.entity.NewUser;

@Repository("newAdminDao")
public class NewAdminDaoImpl extends DaoSupport implements INewAdminDao {

	@Override
	public void addTeacher(NewUser teacher) {
		getDaoTemplate().save(teacher);
		return;
	}

	@Override
	public List<NewUser> listTeacher() {
		String teaString = "select u from NewUser u where u.type=?";
		List<NewUser> teacher =getDaoTemplate().list(NewUser.class, teaString,1);
		
//		List<NewUser> lisTeacher = getDaoTemplate().list(NewUser.class);
		return teacher;
	}

	@Override
	public void delectTeacherById(int id) {
		getDaoTemplate().delete(NewUser.class, id);
	}

}
