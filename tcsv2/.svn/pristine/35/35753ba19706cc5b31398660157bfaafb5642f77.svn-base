package com.meession.orga.dao;

import java.util.List;

import com.meession.common.support.Pager;
import com.meession.common.support.dao.IDaoSupport;
import com.meession.orga.entity.User;

/**
 * @author sam
 */
public interface IUserDao extends IDaoSupport {

	public long countByCompany(String company);

	public List<User> list(String company, String category, String userType);

	public User findUserByStaffCode(String staffCode);

	public User findUserAllStatus(String staffCode);

	public User findUserByNtAccount(String ntAccount);

	public Pager<User> search(Pager<User> pager, String filterValue);

	public void disableAllUsers(String company);

	public List<User> listByReportToCode(String reportToCode);

	public List<User> listAdminUsers();

	public List<User> listAdminUsersForAdd();

	public List<User> listSuperAdminUsers();

	public List<User> listSuperAdminUsersForAdd();

//	public List<User> listByReopenCAP(String company, int year);

	public List<User> listByReopen(String company, int year);

}
