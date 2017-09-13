package com.meession.homework.constant;

public abstract class HomeWorkConstant {

	//Homework status
	/**
	 * 通知创建的同时创建作业，已经创建
	 */
	public static final int CREATED=0;
	/**
	 * 作业通知已经获知，作业等待提交
	 */
	public static final int WAITING_SUBMISSION=1;
	/**
	 * 作业超过规定的时间未提交，已经过期
	 */
	public static final int EXPIRED=2;
	/**
	 * 已经提交
	 */
	public static final int  SUBMITTED=3;
	/**
	 * 审阅作业不合格, 重新提交
	 */
	public static final int RESUBMITTING=4;
	/**
	 * 作业最终审阅，不通过
	 */
	public static final int NOT_PASS=5;
	/**
	 * 作业最终审阅，通过
	 */
	public static final int PASS=6;	
	
	
	public static final String [] strStatus={
		"已创建","等待提交","已过期","提交完成","重新提交","不通过","通过"
	};
	
	public static String getStatusName(int status){
		if(0<=status&status<strStatus.length){
		    return strStatus[status];
		}else{
			return "错误的状态";
		}
	}
	
	//Homework type
	/**
	 * 审核型作业，收到通知的人必须提交作业
	 */
	public static final String HOMEWORK_TYPE_AUDIT="Audit";
	/**
	 * 自主型作业，收到通知的人自由提交作业，可以提交也可以不提交
	 */
	public static final String HOMEWORK_TYPE_INDEPENDENT="Independent";
	/**
	 * 其他类型的作业
	 */
	public static final String HOMEWORK_TYPE_OTHER="Other";
	
	
	
}
