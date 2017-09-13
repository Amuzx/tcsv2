package com.meession.communication2.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RateEvent;
import com.meession.communication2.entity.NewPlan;
import com.meession.communication2.entity.NewUser;
import com.meession.communication2.service.INewStudentService;
import com.meession.communication2.service.INewUserService;
import com.meession.communication2.util.ThreadCache;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class LoginView implements Serializable{
	
	@ManagedProperty("#{newUserServiceImpl}")
	private INewUserService newUsersService;
	@ManagedProperty("#{newStudentServiceImpl}")
	private INewStudentService newStudentService;
	
	private NewUser student;
	private String username;
	private String pwd;
	private NewUser user;
    private Integer rating3 = 0;
	private NewPlan newPlan;
	private Integer chooseStars = 0;
	private String status = "";
	private String isAffirm = "";
	private List<NewPlan> studentListPlan;
	@PostConstruct
	public void init(){
		student=new NewUser();
		user=new NewUser();
		//studentListPlan=this.newUsersService.listuserplan(username);
	}
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	//登陆
	public int login(){
		int result;
	    user=this.newUsersService.findByUsername(username);
	    studentListPlan=this.newUsersService.listuserplan(username);
         /*for(int i=0;i<studentListPlan.size();i++){
			
			if(studentListPlan.get(i).getStatus() == 1){
				isAffirm = "已确认";
			}else{
				isAffirm = "确认";
			}
			if(!"".equals(studentListPlan.get(i).getStatus()) && ((studentListPlan.get(i).getResult()) != null)){
				status = "已完成";
			}else{
				status = "未完成";
			}
		}*/
	    for(NewPlan plan : studentListPlan){
			rating3 = plan.getScore();
			if(plan.getStustatus() == 1){
				isAffirm = "已确认";
			}else{
				isAffirm = "确认";
			}
			if(!"".equals(plan.getResult()) && plan.getResult() != null){
				status = "已完成";
			}else{
				status = "未完成";
			}
		}
		ThreadCache.setNewUser(user);
		if(user.getUsername().equals(username)&&user.getPwd().equals(pwd)){
			if(user.getType()==0){
				result= 0;
			}else if(user.getType()==1){
				result= 1;
			}else{
				result= 2;
			}
		}else{
			addMessage("登陆失败！用户名或密码错误！");
			result= 3;
		}
		return result;
	}
	/**
	 * 根据计划ID查找该计划
	 * @param e
	 */
	public void findPlanById(ActionEvent e){
		int planId = (int) e.getComponent().getAttributes().get("planId");
		newPlan = this.newStudentService.findPlanById(planId);
		studentListPlan=this.newUsersService.listuserplan(username);
		System.out.println(newPlan.getContent());
	}
	
	/**
	 * 学生确认完成沟通
	 */
	public void affirmFinishPlan(ActionEvent e){
		int pId = (int) e.getComponent().getAttributes().get("pId");
		studentListPlan=this.newUsersService.listuserplan(username);
		this.newStudentService.updateFinishPlan(chooseStars,pId);
	}

	/**
	 * 选择的星星数
	 * @param rateEvent
	 */
    public void onrate(RateEvent rateEvent) {
    	chooseStars =  ((Integer) rateEvent.getRating()).intValue();
    }
	
	public INewUserService getNewUsersService() {
		return newUsersService;
	}
	public void setNewUsersService(INewUserService newUsersService) {
		this.newUsersService = newUsersService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public NewUser getUser() {
		return user;
	}
	public void setUser(NewUser user) {
		this.user = user;
	}
	public NewUser getStudent() {
		return student;
	}
	public void setStudent(NewUser student) {
		this.student = student;
	}
	public List<NewPlan> getStudentListPlan() {
		return studentListPlan;
	}
	public void setStudentListPlan(List<NewPlan> studentListPlan) {
		this.studentListPlan = studentListPlan;
	}
	public Integer getRating3() {
		return rating3;
	}
	public void setRating3(Integer rating3) {
		this.rating3 = rating3;
	}
	public Integer getChooseStars() {
		return chooseStars;
	}
	public void setChooseStars(Integer chooseStars) {
		this.chooseStars = chooseStars;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsAffirm() {
		return isAffirm;
	}
	public void setIsAffirm(String isAffirm) {
		this.isAffirm = isAffirm;
	}
	public INewStudentService getNewStudentService() {
		return newStudentService;
	}
	public void setNewStudentService(INewStudentService newStudentService) {
		this.newStudentService = newStudentService;
	}
	public NewPlan getNewPlan() {
		return newPlan;
	}
	public void setNewPlan(NewPlan newPlan) {
		this.newPlan = newPlan;
	}
	
}
