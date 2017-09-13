package com.meession.orga.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 用户信息
 * 
 * @author sam
 *
 */
@Entity
@Table(name = "UserInfo")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 邮箱地址
	 */
	private String email;
	/**
	 * 电话号码
	 */
	private String cellPhone;
	/**
	 * 是否被禁用
	 */
	private Boolean disabled;
	/**
	 * 用户具有的权限
	 */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns={@JoinColumn(name="uId")},inverseJoinColumns={@JoinColumn(name="rId")})
	private List<Role> roles;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User() {
	}

	public User(String name, String password, String email, String cellPhone, Boolean disabled) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.cellPhone = cellPhone;
		this.disabled = disabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", cellPhone=" + cellPhone
				+ ", disabled=" + disabled + ", roles=" + roles + "]";
	}
	
}
