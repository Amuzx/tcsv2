package com.meession.communication2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="newModel")
public class NewModel {
	
	@Id
	@GeneratedValue
	private int Id;
	
	/**
	 * 沟通标题
	 */
	private String title;
	/**
	 * 沟通内容
	 */
	private String content;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	
}
