package com.meession.orga.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * 老师信息，是一个用户
 * 
 * @author sam
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Teacher extends User {

	/**
	 * 职工号
	 */
	private String workerNum;
	/**
	 * 教师姓名
	 */
	private String teacherName;
	/**
	 * 职称
	 */
	private String title;
	/**
	 * 班级信息
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="teacher_classRoom",joinColumns={@JoinColumn(name="teacherId")},inverseJoinColumns={@JoinColumn(name="classRoomId")})
	private List<ClassRoom> classRooms;
	/**
	 * 备注信息
	 */
	private String remark;

	public List<ClassRoom> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(List<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}

	public String getWorkerNum() {
		return workerNum;
	}

	public void setWorkerNum(String workerNum) {
		this.workerNum = workerNum;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Teacher() {
	}

}
