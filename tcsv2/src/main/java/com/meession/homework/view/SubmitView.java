package com.meession.homework.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.UploadedFile;

import com.meession.common.model.ILoadData;
import com.meession.homework.constant.HomeWorkConstant;
import com.meession.homework.entity.HomeWork;
import com.meession.homework.entity.HomeWorkItem;
import com.meession.homework.entity.Notification;
import com.meession.orga.service.IUserService;

@ManagedBean
@ViewScoped
public class SubmitView {
	@ManagedProperty("#{userService}")
	private IUserService userService;
    /**
     * 要提交的作业
     */
	private HomeWork     homeWork;
	/**
	 * 要提交的作业项的文件
	 */
	private UploadedFile   uploadFile;
	/**
	 * 要提交的作业项
	 */
	private HomeWorkItem    homeWorkItem;
	/**
	 * 用户作业列表
	 */
	private List<HomeWork>    homeWorkList;
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public HomeWork getHomeWork() {
		return homeWork;
	}

	public void setHomeWork(HomeWork homeWork) {
		this.homeWork = homeWork;
	}

	public HomeWorkItem getHomeWorkItem() {
		return homeWorkItem;
	}

	public void setHomeWorkItem(HomeWorkItem homeWorkItem) {
		this.homeWorkItem = homeWorkItem;
	}

	public List<HomeWork> getHomeWorkList() {
		return homeWorkList;
	}

	public void setHomeWorkList(List<HomeWork> homeWorkList) {
		this.homeWorkList = homeWorkList;
	}

	public UploadedFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(UploadedFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@PostConstruct
	public void init(){
		homeWorkList=new ArrayList<HomeWork>();
		for(int i=0;i<5;i++){
		HomeWork hw=new HomeWork();
		hw.setCreateDate(new Date());
		hw.setEvaluation("evaluation ");
		hw.setGrade("A");
		hw.setLastModifyDate(new Date());
		hw.setRemark("this is homework remark");
		hw.setStatus(i%6);
		hw.setSubmitDate(new Date());
		hw.setType(HomeWorkConstant.HOMEWORK_TYPE_AUDIT);
		hw.setUserId(new Long(i));
		hw.loadNotification(new ILoadData<Notification>() {
			@Override
			public Notification load(Long id) {
				Notification n=new Notification();
				n.setTitle("作业通知标题");
				n.setContent("这是通知的内容，请大家带好雨具啊，这俩天要小雨了...");
				n.setCreateDate(new Date());
				Calendar cal=Calendar.getInstance();
				n.setCreateDate(cal.getTime());
				n.setLastModifyDate(cal.getTime());
				n.setStartDate(cal.getTime());
				n.setEndDate(cal.getTime());
				n.setIsCanceled(false);
				n.setRemark("这是测试通知");
				return n;
			}
		});
		hw.loadItemsByHomeWorkId(new ILoadData<List<HomeWorkItem>>() {
			
			@Override
			public List<HomeWorkItem> load(Long id) {
				List<HomeWorkItem> list=new ArrayList<HomeWorkItem>();
				for(int i=0;i<5;i++){
				HomeWorkItem item=new HomeWorkItem();
				item.setCreateDate(new Date());
				item.setEvaluation("this is homework item evaluation"+i);
				item.setFilePath("");
				item.setLastModifyDate(new Date());
				item.setRemark("this is homework item remark"+i);
				item.setTitle("title"+i);
				item.setType("simple");
				list.add(item);
				}
				return list;
			}
		});
		
		homeWorkList.add(hw);
		}
	}
	
	public void uploadItem(ActionEvent e){
		System.out.println("uploadItem(); is called");
		homeWorkItem=(HomeWorkItem)e.getComponent().getAttributes().get("homeWorkItem");
		System.out.println(homeWorkItem);
	}
	
	
}
