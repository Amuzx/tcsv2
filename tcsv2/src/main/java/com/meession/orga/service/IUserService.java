package com.meession.orga.service;

import java.io.InputStream;
import java.util.List;

import com.meession.common.support.service.IPagerService;
import com.meession.orga.entity.User;

/**
 * @author sam
 */
public interface IUserService extends IPagerService<User> {

	public User loadCurrentUser();

	public User findUserByStaffCode(String staffCode);

	public User addUser(User user);

	public User updateUser(User user);

	public void importUsers(InputStream orgaInputStream,InputStream personalInputStream, boolean incremental);

	public List<User> listAdminUsers();

	public List<User> listAdminUsersForAdd();

	public List<User> listSuperAdminUsers();

	public List<User> listSuperAdminUsersForAdd();

	public void deleteAdminUser(Long id);

	public void deleteSuperAdminUser(Long id);

	public void addAdminUser(Long id);

	public void addSuperAdminUser(Long id);

}
