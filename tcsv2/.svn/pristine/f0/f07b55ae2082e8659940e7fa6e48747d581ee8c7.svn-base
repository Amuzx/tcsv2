package com.meession.orga.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 班级表
 * @author sam
 */
@Entity
@Table
public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * 班级的名称
	 */
	private String name;
	/**
	 * 班级编号
	 */
	private String code;
	/**
	 * 班长
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "monitorId")
	private User monitor;
	/**
	 * 班主任
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chargeTeacherId")
	private User chargeTeacher;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public User getMonitor() {
		return monitor;
	}

	public void setMonitor(User monitor) {
		this.monitor = monitor;
	}

	public User getChargeTeacher() {
		return chargeTeacher;
	}

	public void setChargeTeacher(User chargeTeacher) {
		this.chargeTeacher = chargeTeacher;
	}
}
