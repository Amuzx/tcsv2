package com.meession.homework.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 作业项
 * <br>
 * <p>学生的一次作业有很多题目，一个作业项可以认为是一个题目（如果你是分多次提交你的作业的话）</p>
 * @author sam
 *
 */
@Entity
@Table
public class HomeWorkItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * 作业id
	 */
	private Long homeworkId;
	/**
	 * 作业项类型： Simple(简单类型，作业在记录里),File(文件类型，作业在提交的文件中)
	 */
	private String type;
	/**
	 * 作业项标题
	 */
    private String title;	
	/**
	 * 作业项内容
	 */
	private String content;
	/**
	 * 作业项文件路径
	 */
	private String filePath;
	/**
	 * 作业项的点评
	 */
	private String evaluation;
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

	public Long getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(Long homeworkId) {
		this.homeworkId = homeworkId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

}
