package com.meession.communication2.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meession.communication2.dao.INewStudentDao;
import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;
import com.meession.communication2.service.INewStudentService;
/**
 * 
 * @author xxw
 *
 */
@Service
public class NewStudentServiceImpl implements INewStudentService {

	@Resource(name="newStudentDaoImpl")
	private INewStudentDao newStudentDao;
	
	@Override
	public NewUser findStudent(int id) {
		NewUser user = this.newStudentDao.findStudent(id);
		return user;
	}

	@Override
	public List<NewPlan> findPlanForStudent() {
		List<NewPlan> listStudentPLan = this.newStudentDao.findPlanForStudent();
		return listStudentPLan;
	}

	@Override
	public NewPlan findPlanById(int planId) {
		NewPlan newPlan = this.newStudentDao.findPlanById(planId);
		return newPlan;
	}

	@Override
	public void updateFinishPlan(int chooseStars,int pId) {
		NewPlan newPlan = this.newStudentDao.findPlanById(pId);
		newPlan.setScore(chooseStars);
		newPlan.setStustatus(1);
		this.newStudentDao.updateFinishPlan(newPlan);
	}

	//===========================================================图表 start
	@Override
	public int findStarsAccount(int starAccount) {
		int stars = this.newStudentDao.findStarsAccount(starAccount);
		return stars;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int[] findAffirmedUser() {
		int[] array = new int[4];
		List list1 = this.newStudentDao.findHaveContentPlan("", "content");//没有结果的计划数，未完成
		List list2 = this.newStudentDao.findAffirmedUser(1,1, "status","stustatus");//已完成，双方已确认
		List list3 = this.newStudentDao.findAffirmedUser(0,1, "status","stustatus");//已完成，学生已确认，老师未确认
		List list4 = this.newStudentDao.findAffirmedUser(0,0, "status","stustatus");//已完成，双方未确认
		
		if(list1.size() > 0){
			array[0] =  (int) list1.get(0);
		}else{
			array[0] = 0;
		}
		
		if(list2.size() > 0){
			array[1] = (int) list2.get(0);
		}else{
			array[1] = 0;
		}
		
		if(list2.size() > 0){
			array[2] = (int) list3.get(0);
		}else{
			array[2] = 0;
		}
		
		if(list3.size() > 0){
			array[3] = (int) list4.get(0);
		}else{
			array[3] = 0;
		}
		return array;
	}
	//===============================================================图表 end
}
