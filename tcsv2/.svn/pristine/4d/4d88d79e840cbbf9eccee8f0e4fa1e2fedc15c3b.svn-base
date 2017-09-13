package com.meession.orga.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * 学生信息，是一个用户
 * 
 * @author sam
 */
@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Student extends User{
	/**
	 * 学号
	 */
	private String studentNum;
	/**
	 * 学生姓名
	 */
	private String studentName;
	/**
	 * 班级信息
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classRoomId")
	private ClassRoom classRoom;
	/**
	 * 备注信息
	 */
	private String remark;

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Student() {
	}

	public Student(String name, String password, String email,
			String cellPhone, Boolean disabled, String studentNum,
			String studentName, String remark) {
		super(name, password, email, cellPhone, disabled);
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Student [studentNum=" + studentNum + ", studentName="
				+ studentName + ", classRoom=" + classRoom + ", remark="
				+ remark + "] super="+super.toString();
	}
	
}
