package com.meession.orga.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色
 * 
 * @author sam
 *
 */
@Entity
@Table
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/**
	 * 角色id
	 */
	private Integer roleId;
	/**
	 * 角色名
	 */
	private String name;
	/**
	 * 角色是否可用
	 */
	private Boolean disabled;
	/**
	 * 角色描述
	 */
	private String remark;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Role() {
		super();
	}

	public Role(String name, String remark) {
		super();
		this.name = name;
		this.remark = remark;
	}

	public Role(Integer roleId, String name, String remark) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.remark = remark;
	}

}
