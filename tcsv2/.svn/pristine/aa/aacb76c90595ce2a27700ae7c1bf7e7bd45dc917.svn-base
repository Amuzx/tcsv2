package com.meession.homework.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.meession.homework.entity.Notification;
import com.meession.orga.service.IUserService;

@ManagedBean
@ViewScoped
public class MarkingView {
	@ManagedProperty("#{userService}")
	private IUserService userService;

	private List<Notification> notificationList;

	private List<Notification>  notificationManagementList;
	
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<Notification> getNotificationList() {
		return notificationList;
	}

	public void setNotificationList(List<Notification> notificationList) {
		this.notificationList = notificationList;
	}

	public List<Notification> getNotificationManagementList() {
		return notificationManagementList;
	}

	public void setNotificationManagementList(
			List<Notification> notificationManagementList) {
		this.notificationManagementList = notificationManagementList;
	}

	@PostConstruct
	public void init(){
		notificationList=new ArrayList<Notification>();
		notificationManagementList=new ArrayList<Notification>();
		
		for(int i=0;i<10;i++){
			Notification n=new Notification();
			n.setTitle("作业通知标题"+i);
			n.setContent("这是通知的内容，请大家带好雨具啊，这俩天要小雨了..."+i);
			n.setCreateDate(new Date());
			Calendar cal=Calendar.getInstance();
			n.setCreateDate(cal.getTime());
			n.setLastModifyDate(cal.getTime());
			
			cal.set(Calendar.DAY_OF_MONTH, 0-i);
			n.setStartDate(cal.getTime());
			
			cal.set(Calendar.DAY_OF_MONTH, i);
			n.setEndDate(cal.getTime());
			n.setIsCanceled(false);
			n.setRemark("这是测试通知");
			notificationList.add(n);
			notificationManagementList.add(n);
		}
	}
	
	
	
}
