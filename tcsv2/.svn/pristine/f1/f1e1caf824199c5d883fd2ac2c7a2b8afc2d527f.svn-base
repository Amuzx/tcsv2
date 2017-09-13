package com.meession.orga.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meession.common.exception.BusinessException;
import com.meession.common.support.Pager;
import com.meession.common.util.ExcelReader;
import com.meession.orga.context.UserContextHolder;
import com.meession.orga.dao.IUserDao;
import com.meession.orga.entity.User;
import com.meession.orga.service.IUserService;
import com.meession.system.aop.Logable;

/**
 * 用户管理服务
 * @author sam
 *
 */
@Service
public class UserService implements IUserService {

	@Resource
	private IUserDao userDao;


	@Override
	public User loadCurrentUser() {
		String staffCode = UserContextHolder.getCurrentStaffCode();
		User user = (staffCode == null) ? null : this.findUserByStaffCode(staffCode);
		return user;
	}

	@Override
	public User findUserByStaffCode(String staffCode) {
		return this.userDao.findUserByStaffCode(staffCode);
	}


	@Override
	public Pager<User> search(Pager<User> pager, String filterValue) {
		return this.userDao.search(pager, filterValue);
	}

	@Override
	public User addUser(User user) {
		this.userDao.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		this.userDao.update(user);
		return user;
	}

	private boolean isManagementUser(String personalGrade) {
		String[] managementGrades = { "29", "30", "31", "32", "33", "34", "35",
				"36" };
		for (String managementGrade : managementGrades) {
			if (managementGrade.equals(personalGrade)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public List<User> listAdminUsers() {
		return this.userDao.listAdminUsers();
	}

	@Override
	public List<User> listAdminUsersForAdd() {
		return this.userDao.listAdminUsersForAdd();
	}

	@Override
	public List<User> listSuperAdminUsers() {
		return this.userDao.listSuperAdminUsers();
	}

	@Override
	public List<User> listSuperAdminUsersForAdd() {
		return this.userDao.listSuperAdminUsersForAdd();
	}

	@Override
	@Logable(value = "delete", message = "delete admin user")
	public void deleteAdminUser(Long id) {
		User user = this.userDao.find(User.class, id);
//		user.setHrAdminUser(false);
		this.userDao.save(user);
	}

	@Override
	@Logable(value = "delete", message = "delete super admin user")
	public void deleteSuperAdminUser(Long id) {
		User user = this.userDao.find(User.class, id);
//		user.setHrSuperAdminUser(false);
		this.userDao.save(user);
	}

	@Override
	@Logable(value = "add", message = "add admin user")
	public void addAdminUser(Long id) {
		User user = this.userDao.find(User.class, id);
//		user.setHrAdminUser(true);
		this.userDao.save(user);
	}

	@Override
	@Logable(value = "add", message = "add super admin user")
	public void addSuperAdminUser(Long id) {
		User user = this.userDao.find(User.class, id);
//		user.setHrSuperAdminUser(true);
		this.userDao.save(user);
	}

	@Override
	@Logable(value = "import", message = "import users")
	@Transactional
	public void importUsers(InputStream orgaInputStream,
			InputStream personalInputStream, boolean incremental) {
		try {
			ExcelReader orgaExcelReader = new ExcelReader(orgaInputStream);
			String[][] orgaData = orgaExcelReader.readExcel(0, 0, 1);

			ExcelReader personalExcelReader = new ExcelReader(personalInputStream);
			String[][] personalData = personalExcelReader.readExcel(0, 0, 1);

			
			
			String companyName = orgaData[0][0];
			if (!incremental) {
				this.userDao.disableAllUsers(companyName);
			}

			Map<String, String[]> orgaRecordMap = new HashMap<String, String[]>();
			for (int i = 0; i < orgaData.length; i++) {
				String[] record = orgaData[i];
				String staffCode = record[6];
				if ("0".equals(staffCode)) {
					continue;
				}
				orgaRecordMap.put(staffCode, record);
			}

			Map<String, String[]> personalRecordMap = new HashMap<String, String[]>();
			Map<String, String> supervisorMap = new HashMap<String, String>();
			for (int i = 0; i < personalData.length; i++) {
				String[] record = personalData[i];
				String staffCode = record[6];
				if ("0".equals(staffCode) || StringUtils.isBlank(staffCode)) {
					continue;
				}
				personalRecordMap.put(staffCode, record);

				String reportTo = record[15];
				if (StringUtils.isBlank(reportTo)) {
					continue;
				}
				String reportToCode = reportTo.substring(reportTo.length() - 6);
				supervisorMap.put(reportToCode, reportToCode);
			}

			for (String[] personalRecord : personalRecordMap.values()) {
				String staffCode = personalRecord[6];

				String[] orgaRecord = orgaRecordMap.get(staffCode);
				if (orgaRecord == null) {
					continue;
				}
				String company = orgaRecord[0];
				String division = orgaRecord[1];
				String department = orgaRecord[2];
				String subDepartment1 = orgaRecord[3];
				String subDepartment2 = orgaRecord[4];
				String subDepartment3 = orgaRecord[5];

				String name = personalRecord[4];
				String position = personalRecord[7];
				String personalGrade = personalRecord[13];
				String functionalGrade = personalRecord[14];
				String costCenter = personalRecord[3];
				String category = personalRecord[8];
				String companyStartingDate = personalRecord[17];

				String reportTo = personalRecord[15];
				String reportToCode = "";
				String reportToName = "";
				if (StringUtils.isNotBlank(reportTo)) {
					reportToCode = reportTo.substring(reportTo.length() - 6);
					String[] supervisorPersonalRecord = personalRecordMap
							.get(reportToCode);
					if (supervisorPersonalRecord != null) {
						reportToName = supervisorPersonalRecord[4];
					} else {
						User supervisor = this
								.findUserByStaffCode(reportToCode);
						if (supervisor != null) {
							reportToName = supervisor.getName();
						}
					}
				}

				boolean managementUser = this.isManagementUser(personalGrade);
				boolean supervisorUser = supervisorMap.get(staffCode) != null;

				User user = this.userDao.findUserAllStatus(staffCode);
				if (user == null) {
					user = new User();
				}
//				user.setStaffCode(staffCode);
//				user.setName(name);
//				user.setCompany(company);
//				user.setDivision(division);
//				user.setDepartment(department);
//				user.setSubDepartment1(subDepartment1);
//				user.setSubDepartment2(subDepartment2);
//				user.setSubDepartment3(subDepartment3);

				String directDepartment = department;
				if (StringUtils.isNotBlank(subDepartment1)) {
					directDepartment = subDepartment1;
				}
				if (StringUtils.isNotBlank(subDepartment2)) {
					directDepartment = subDepartment2;
				}
				if (StringUtils.isNotBlank(subDepartment3)) {
					directDepartment = subDepartment3;
				}
//				user.setDirectDepartment(directDepartment);
//
//				user.setPosition(position);
//				user.setPersonalGrade(personalGrade);
//				user.setFunctionalGrade(functionalGrade);
//				user.setCostCenter(costCenter);
//				user.setCategory(category);
//				user.setCompanyStartingDate(DateUtils.getDateSince1900(Integer
//						.parseInt(companyStartingDate)));
//				user.setReportToCode(reportToCode);
//				user.setReportToName(reportToName);
//				user.setDisabled(false);
//				user.setManagementUser(managementUser);
//				user.setSupervisorUser(supervisorUser);

//				LdapUser ldapUser = ldapUserService.findByStaffCode(staffCode);
//				if (ldapUser != null) {
//					user.setNtAccount(ldapUser.getNtAccount());
//					user.setEmail(ldapUser.getEmail());
//					user.setOfficeTelephone(ldapUser.getOfficeTelephone());
//				} else {
//					logger.error("Not found in LDAP for user:{}", staffCode);
//				}

				this.userDao.update(user);
			}

			if (incremental) {
				for (String staffCode : supervisorMap.keySet()) {
					User user = this.findUserByStaffCode(staffCode);
					if (user != null) {
//						user.setSupervisorUser(true);
						this.userDao.update(user);
					}
				}
			}
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
}
