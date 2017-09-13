package com.meession.system.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * Mail entity
 * 
 * @author sam
 */
@Entity
public class Mail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 收件地址
	 */
	@ElementCollection
	@OrderColumn
	private Set<String> toAddresses;

	/**
	 * 抄送地址
	 */
	@ElementCollection
	@OrderColumn
	private Set<String> ccAddresses;

	/**
	 * 密送地址
	 */
	@ElementCollection
	@OrderColumn
	private Set<String> bccAddresses;
	/**
	 * 标题
	 */
	@Size(max = 100)
	private String title;
    /**
     * 内容
     */
	@Size(max = 4000)
	private String content;

	private boolean html;

	/**
	 * 创建日期
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	/**
	 * 发送日期
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date sentDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<String> getToAddresses() {
		return toAddresses;
	}

	public void setToAddresses(Set<String> toAddresses) {
		this.toAddresses = toAddresses;
	}

	public Set<String> getCcAddresses() {
		return ccAddresses;
	}

	public void setCcAddresses(Set<String> ccAddresses) {
		this.ccAddresses = ccAddresses;
	}

	public Set<String> getBccAddresses() {
		return bccAddresses;
	}

	public void setBccAddresses(Set<String> bccAddresses) {
		this.bccAddresses = bccAddresses;
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

	public boolean isHtml() {
		return html;
	}

	public void setHtml(boolean html) {
		this.html = html;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

}
