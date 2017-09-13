package com.meession.homework.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.meession.common.model.ILoadData;
import com.meession.orga.entity.Student;

/**
 * 作业 <br>
 * <p>
 * 代表学生的一次作业
 * </p>
 * 
 * @author sam
 *
 */
@Entity
@Table
public class HomeWork {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * 作业通知id
	 */
	private Long notifactionId;
	/**
	 * 提交作业的用户id
	 */
	private Long userId;
	/**
	 * 作业类型： Audit，Independent，Other
	 */
	private String type;
	/**
	 * 作业评级 A,B,C,D
	 */
	private String grade;
	/**
	 * 作业点评
	 */
	private String evaluation;

	/**
	 * 作业提交时间
	 */
	private Date submitDate;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 最后一次更改日期
	 */
	private Date lastModifyDate;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 作业状态
	 * ，CREATED=1;WAITING_SUBMISSION=2;EXPIRED=3;SUBMITTED=4;CHECKED_NOT_PASS
	 * =5;CHECKED_PASS=6;
	 */
	private int status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNotifactionId() {
		return notifactionId;
	}

	public void setNotifactionId(Long notifactionId) {
		this.notifactionId = notifactionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifyDate() {
		return lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	// 临时数据
	@Transient
	private List<HomeWorkItem> homeWorkItemList;
	@Transient
	private Notification notification;
	@Transient
	private Student student;

	/**
	 *通过HomeWork的id 动态加载HomeWorkItem数据
	 * 
	 * @param load
	 */
	public void loadItemsByHomeWorkId(ILoadData<List<HomeWorkItem>> load) {
		Long loadId = getId();
		homeWorkItemList = load.load(loadId);
	}

	/**
	 * 通过notification的id动态加载notification数据
	 * 
	 * @param load
	 */
	public void loadNotification(ILoadData<Notification> load) {
		Long loadId = getNotifactionId();
		notification = load.load(loadId);
	}

	/**
	 * 通过student的id动态加载student数据
	 * 
	 * @param load
	 */
	public void loadStudent(ILoadData<Student> load) {
		Long loadId = getUserId();
		student = load.load(loadId);
	}

	public List<HomeWorkItem> getHomeWorkItemList() {
		return homeWorkItemList;
	}

	public Notification getNotification() {
		return notification;
	}

	public Student getStudent() {
		return student;
	}

}
