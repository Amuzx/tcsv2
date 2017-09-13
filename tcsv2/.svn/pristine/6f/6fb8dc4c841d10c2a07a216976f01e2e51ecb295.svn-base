package com.meession.homework.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 作业通知
 * <br>
 * <p>老师布置作业的通知</p>
 * @author sam
 *
 */
@Entity
@Table
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * 通知的标题
	 */
	private String title;
	/**
	 * 通知的内容
	 */
	private String content;
	/**
	 * 通知是否被取消
	 */
	private Boolean isCanceled;
	/**
	 * 通知开始日期
	 */
	private Date startDate;
	/**
	 * 通知结束日期
	 */
	private Date endDate;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(Boolean isCanceled) {
		this.isCanceled = isCanceled;
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

}
