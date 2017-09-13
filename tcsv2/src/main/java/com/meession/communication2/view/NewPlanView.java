package com.meession.communication2.view;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

import com.meession.communication2.entity.NewModel;
import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;
import com.meession.communication2.service.INewPlanService;
import com.meession.communication2.service.INewUserService;
import com.meession.communication2.util.ThreadCache;
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class NewPlanView implements Serializable{
	@ManagedProperty("#{newPlanServiceImpl}")
	private INewPlanService newPlanService;
	
	@ManagedProperty("#{newUserServiceImpl}")
	private INewUserService newUserService;
	
	private NewUser user;
	private String studentname;
	private String studentnum;
	private String teachername;
	private NewPlan newplan1;
	private NewPlan newplan;
	private NewPlan addleaveplan;
	private NewPlan leaveplan;
	private NewPlan updatePlan;
	private NewPlan completeplan;
	private List<NewPlan> infolist;
	private String newnum;
	
	private NewUser newUser;
	
	private List<NewUser> selectedStudentList;
	
	private NewPlan newPlan;
	
	private List<NewModel> listModel;
	
	private NewModel model;
	
	private NewModel newModel;
	
	@PostConstruct
	public void init(){
		 user=new NewUser();
		 newUser = new NewUser();
		 newPlan = new NewPlan();
		 model = new NewModel();
		 newModel = new NewModel();
		 listModel = this.newUserService.listModel();
		 
		 completeplan=new  NewPlan();
		 newplan1=new NewPlan();
		 updatePlan=new NewPlan();
		 addleaveplan=new NewPlan();
		 leaveplan =new NewPlan();
		infolist=this.newPlanService.infolist();
	}
	
	public void showDialog(ActionEvent e){
		newplan=new NewPlan();
		int id = (int) e.getComponent().getAttributes().get("y");
		System.out.println(id);
		user = this.newPlanService.findUserById(id);
		studentname=user.getStuName();
		studentnum=user.getStuNumber();
		teachername=user.gettName();
		newplan.setTeachername(teachername);
		newplan.setStudentname(studentname);
		newplan.setStudentnum(studentnum);
		newplan.setNewuser(user);
		System.out.println(user.getStuNumber());
		if(user == null){
			System.out.println("user is null");
		}else{
			RequestContext.getCurrentInstance().execute("PF('communicationplanDialog').show()");
		}
	}
	
	   //添加计划
		public void addPlan(){
			NewPlan newplan1=this.newPlanService.save(newplan);
			if(newplan1 != null){
				infolist=this.newPlanService.infolist();
				RequestContext.getCurrentInstance().execute("PF('communicationplanDialog').hide()");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "add "+newplan1.getTeachername()+" successful!"));
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error!", "the user is null"));
			}
		}
	//删除
	public void delete(ActionEvent e) {
		Integer id = (Integer) e.getComponent().getAttributes().get("deleteplan");
		newPlanService.deleteById(id);
		infolist = newPlanService.infolist();
		addMessage("删除成功");
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void showchangedialog(ActionEvent e){
		updatePlan = (NewPlan) e.getComponent().getAttributes().get("updateplan");
	}
	//更新计划
	public void update() {
		if (null != updatePlan) {
			newPlanService.update(updatePlan);
			if(null != updatePlan.getLeaveplan()&&updatePlan.getLeaveplan()!=""){
				System.out.println("leave"+updatePlan.getLeaveplan());
				leaveplan =new NewPlan();
				leaveplan.setContent(updatePlan.getLeaveplan());
				leaveplan.setStudentname(updatePlan.getStudentname());
				leaveplan.setStudentnum(updatePlan.getStudentnum());
				RequestContext.getCurrentInstance().execute("PF('addleaveplandialog').show()");
			}
		}else{
			System.out.println("update is null");
		}
	}
	//添加遗留计划
	public void addleaveplan(){
		addleaveplan=this.newPlanService.save(leaveplan);
		if(null!=updatePlan){
			infolist=this.newPlanService.infolist();
		}
		else{
			addMessage("添加失败");
		}
	}
	//确认计划
	public void completetalk(ActionEvent e){
		completeplan= (NewPlan) e.getComponent().getAttributes().get("finishplan");
		if(completeplan.getStustatus()==1){
			completeplan.setStatus(1);
			this.newPlanService.update(completeplan);
			System.out.println("jjjjj"+completeplan.getStatus());
			addMessage("操作成功，此次沟通计划结束");
		}else{
			addMessage("操作失败，学生未查看沟通计划，请稍后进行操作");
		}
	}
	
	/**
	 * 将选中的模板赋给model对象
	 */
	public void selectModel(){
		model = newModel;
	}
	
	/**
	 * 为学生添加计划
	 */
	public void addPlanForStudent(){
		newUser = ThreadCache.getNewUser();
		if(newUser == null){
			System.out.println("user is null");
		}else{
			System.out.println(newUser.gettName()+"=====ThreadLocal");
		}
		newPlan.setTeachername("teacher");
		if(selectedStudentList == null){
			System.out.println("为选择 学生");
		}else{
			System.out.println(selectedStudentList.size());
			for(int i=0; i<selectedStudentList.size(); i++){			
				System.out.println(selectedStudentList.get(i));
			}
			this.newUserService.insertPlanToStudent(selectedStudentList,newPlan);
		}
	}
	
	public NewModel getNewModel() {
		return newModel;
	}

	public void setNewModel(NewModel newModel) {
		this.newModel = newModel;
	}

	public List<NewModel> getListModel() {
		return listModel;
	}

	public void setListModel(List<NewModel> listModel) {
		this.listModel = listModel;
	}

	public NewModel getModel() {
		return model;
	}

	public void setModel(NewModel model) {
		this.model = model;
	}
	
	public INewUserService getNewUserService() {
		return newUserService;
	}

	public void setNewUserService(INewUserService newUserService) {
		this.newUserService = newUserService;
	}

	public NewPlan getNewPlan() {
		return newPlan;
	}

	public void setNewPlan(NewPlan newPlan) {
		this.newPlan = newPlan;
	}

	public List<NewUser> getSelectedStudentList() {
		return selectedStudentList;
	}

	public void setSelectedStudentList(List<NewUser> selectedStudentList) {
		this.selectedStudentList = selectedStudentList;
	}
	public NewUser getNewUser() {
		return newUser;
	}

	public void setNewUser(NewUser newUser) {
		this.newUser = newUser;
	}

	public List<NewPlan> getInfolist() {
		return infolist;
	}

	public void setInfolist(List<NewPlan> infolist) {
		this.infolist = infolist;
	}

	
	public INewPlanService getNewPlanService() {
		return newPlanService;
	}

	public void setNewPlanService(INewPlanService newPlanService) {
		this.newPlanService = newPlanService;
	}

	public NewPlan getNewplan() {
		return newplan;
	}

	public void setNewplan(NewPlan newplan) {
		this.newplan = newplan;
	}
	public NewUser getUser() {
		return user;
	}
	public void setUser(NewUser user) {
		this.user = user;
	}
	public String getNewnum() {
		return newnum;
	}
	public void setNewnum(String newnum) {
		this.newnum = newnum;
	}
	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentnum() {
		return studentnum;
	}

	public void setStudentnum(String studentnum) {
		this.studentnum = studentnum;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public NewPlan getNewplan1() {
		return newplan1;
	}

	public void setNewplan1(NewPlan newplan1) {
		this.newplan1 = newplan1;
	}
	public NewPlan getUpdatePlan() {
		return updatePlan;
	}

	public void setUpdatePlan(NewPlan updatePlan) {
		this.updatePlan = updatePlan;
	}

	public NewPlan getLeaveplan() {
		return leaveplan;
	}

	public void setLeaveplan(NewPlan leaveplan) {
		this.leaveplan = leaveplan;
	}

	public NewPlan getAddleaveplan() {
		return addleaveplan;
	}

	public void setAddleaveplan(NewPlan addleaveplan) {
		this.addleaveplan = addleaveplan;
	}

	public NewPlan getCompleteplan() {
		return completeplan;
	}

	public void setCompleteplan(NewPlan completeplan) {
		this.completeplan = completeplan;
	}
	
}
