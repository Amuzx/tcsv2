package com.meession.orga.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.meession.common.support.Pager;
import com.meession.common.support.dao.DaoSupport;
import com.meession.orga.dao.IUserDao;
import com.meession.orga.entity.User;

/**
 * @author  sam
 */
@Repository
public class UserDao extends DaoSupport implements IUserDao {

	@Override
	public long countByCompany(String company) {
		String queryString = "SELECT count(entity) FROM User entity WHERE entity.company = ? AND entity.disabled = false";

		return getDaoTemplate().count(queryString, company);
	}

	@Override
	public List<User> list(String company, String category, String userType) {
		String queryString = "SELECT entity FROM User entity WHERE entity.disabled = false";

		Map<String, Object> params = new HashMap<String, Object>();

//		if (StringUtils.isNotBlank(company)) {
//			params.put("company", company);
//			queryString += " AND company = :company";
//		}
//		if (StringUtils.isNotBlank(category)) {
//			params.put("category", category);
//			queryString += " AND category = :category";
//		}
//		if (EmployeeTypeConstant.TARIFF_EMPLOYEE.equals(userType)) {
//			queryString += " AND managementUser = false";
//		} else if (EmployeeTypeConstant.MANAGEMENT_EMPLOYEE.equals(userType)) {
//			queryString += " AND managementUser = true";
//		}

		return getDaoTemplate().list(User.class, queryString, params);
	}

	@Override
	public User findUserByStaffCode(String staffCode) {
		String queryString = "SELECT entity FROM User entity WHERE entity.staffCode = ? AND entity.disabled = false";

		return getDaoTemplate().find(User.class, queryString, staffCode);
	}

	@Override
	public User findUserAllStatus(String staffCode) {
		String queryString = "SELECT entity FROM User entity WHERE entity.staffCode = ?";

		return getDaoTemplate().find(User.class, queryString, staffCode);
	}

	@Override
	public User findUserByNtAccount(String ntAccount) {
		String queryString = "SELECT entity FROM User entity WHERE LOWER(entity.ntAccount) = ? AND entity.disabled = false";

		return getDaoTemplate().find(User.class, queryString,
				ntAccount.toLowerCase());
	}

	@Override
	public List<User> listByReportToCode(String reportToCode) {
		String queryString = "SELECT entity FROM User entity WHERE entity.reportToCode = ? AND entity.disabled = false";

		return getDaoTemplate().list(User.class, queryString, reportToCode);
	}

	@Override
	public List<User> listByReopen(String company, int year) {
		String queryString = "SELECT entity FROM User entity, EmployeeDialogue ed WHERE entity.staffCode = ed.staffCode"
				+ " AND entity.disabled = false AND entity.company=? AND ed.year=? AND ed.requestForReopen = true";

		return getDaoTemplate().list(User.class, queryString, company, year);
	}

//	@Override
//	public List<User> listByReopenCAP(String company, int year) {
//		String queryString = "SELECT entity FROM User entity, EmployeeDialogue ed WHERE entity.staffCode = ed.staffCode"
//				+ " AND entity.disabled = false AND entity.company=? AND ed.year=?"
//				+ " AND ((ed.status = ? AND ed.hasCap = false AND ed.afterCap = false AND ed.requestForReopen = false) OR (ed.status = ?))";
//
//		return getDaoTemplate().list(User.class, queryString, company, year,
//				EdStatus.APPROVED_AND_SUBMITTED_TO_HR,
//				EdStatus.OPENED_AFTER_CAP_BY_HR);
//	}

	@Override
	public List<User> listAdminUsers() {
		String queryString = "SELECT entity FROM User entity WHERE entity.hrAdminUser = true AND entity.disabled = false";

		return getDaoTemplate().list(User.class, queryString);
	}

	@Override
	public List<User> listAdminUsersForAdd() {
		String queryString = "SELECT entity FROM User entity WHERE entity.hrAdminUser = false AND entity.disabled = false";

		return getDaoTemplate().list(User.class, queryString);
	}

	@Override
	public List<User> listSuperAdminUsers() {
		String queryString = "SELECT entity FROM User entity WHERE entity.hrSuperAdminUser = true AND entity.disabled = false";

		return getDaoTemplate().list(User.class, queryString);
	}

	@Override
	public List<User> listSuperAdminUsersForAdd() {
		String queryString = "SELECT entity FROM User entity WHERE entity.hrSuperAdminUser = false AND entity.disabled = false";

		return getDaoTemplate().list(User.class, queryString);
	}

	private String getConditionalQuery(Map<String, Object> params,
			String filterValue) {
		String queryString = " WHERE entity.disabled = false";
		if (StringUtils.isNotBlank(filterValue)) {
			String[] filterFields = { "name", "staffCode", "position",
					"personalGrade", "functionalGrade", "company", "division",
					"department", "subDepartment1", "subDepartment2",
					"subDepartment3", "category", "costCenter", "reportToCode",
					"reportToName" };

			String conditionValue = "%" + filterValue.toLowerCase() + "%";

			String queryString2 = "";
			for (String field : filterFields) {
				params.put(field, conditionValue);
				queryString2 += " OR LOWER(" + field + ") LIKE :" + field;
			}
			queryString += " AND (" + queryString2.replaceFirst("OR", "") + ")";
		}

		return queryString;
	}

	@Override
	public Pager<User> search(Pager<User> pager, String filterValue) {
		Map<String, Object> params = new HashMap<String, Object>();
		String queryString = getConditionalQuery(params, filterValue);
		String countQueryString = "SELECT count(entity) FROM User entity"
				+ queryString;

		if (StringUtils.isNotBlank(pager.getOrderBy())) {
			queryString += pager.getOrderString();
		}

		String listQueryString = "SELECT entity FROM User entity" + queryString;

		long size = this.getDaoTemplate().count(countQueryString, params);
		List<User> resultList = this.getDaoTemplate().list(User.class,
				listQueryString, pager.getFirstNum(), pager.getPageSize(),
				params);
		pager.setTotalNum(size);
		pager.setDatas(resultList);
		return pager;
	}

	@Override
	public void disableAllUsers(String company) {
		String queryString = "UPDATE User SET disabled = true WHERE company = ? ";
		this.getDaoTemplate().execute(queryString, company);
	}

}
