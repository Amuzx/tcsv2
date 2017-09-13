package com.meession.communication2.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.meession.common.support.dao.DaoSupport;
import com.meession.communication2.dao.INewUserDao;
import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;

@Repository("newUserDao")
public class NewUserDaoImpl extends DaoSupport implements INewUserDao {

	/**
	 * 添加学生
	 */
	@Override
	public void addStudentUser(NewUser newuser) {
		String sql = "from NewUser where type=2";
		List<NewUser> listUser = getDaoTemplate().list(NewUser.class,sql);
		if(listUser.size() > 0){
			boolean isUpdate = false;
			for(NewUser user : listUser){
					//当学生学号相同，则表示数据库含有该学生，更新该对象
					if(user.getStuNumber().equals(newuser.getStuNumber())){
						user.setUsername(newuser.getUsername());
						user.setPwd(newuser.getPwd());
						user.setType(newuser.getType());
						user.setStatus(newuser.getStatus());
						user.setStuNumber(newuser.getStuNumber());
						user.setStuName(newuser.getStuName());
						user.setStuSex(newuser.getStuSex());
						user.setStuQQ(newuser.getStuQQ());
						user.setStuTel(newuser.getStuTel());
						user.setStuClass(newuser.getStuClass());
						user.setStuYear(newuser.getStuYear());
						getDaoTemplate().update(user);
						isUpdate = true;
						break;
					}else{
						continue;
					}
			}
			//当循环执行完成时还没更新，则表示数据库没有该对象，将该对象持久化
			if(isUpdate){
				System.out.println("更新成功！");
			}else{
				getDaoTemplate().save(newuser);
			}
		}else{
			//当数据库中的没有数据时，直接将该对象持久化
			getDaoTemplate().save(newuser);
		}
	}
	
	/**
	 * 查询所有的学生
	 */
	@Override
	public List<NewUser> listStudentUser() {
		String stuString = "select u from NewUser u where u.type=?";
		List<NewUser> student =getDaoTemplate().list(NewUser.class, stuString,2);
		
//		List<NewUser> listStudent = getDaoTemplate().list(NewUser.class);
		return student;
	}

	/**
	 * 删除学生
	 */
	@Override
	public void deleteStudentUserById(int id) {
		getDaoTemplate().delete(NewUser.class, id);
	}

	@Override
	public NewUser findByUsername(String username) {
		String queryString="SELECT entity FROM NewUser entity WHERE entity.username=?";
		return getDaoTemplate().find(NewUser.class, queryString, username);
	}

	@Override
	public void addstudent(NewUser student) {
		getDaoTemplate().save(student);
	}

	@Override
	public List<NewPlan> listuserplan(String username) {
		String stuString = "select u from NewPlan u where u.studentnum=?";
		List<NewPlan> list =getDaoTemplate().list(NewPlan.class, stuString,username);
		return list;
	}
}
