package com.meession.system.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.meession.common.support.Pager;
import com.meession.common.support.dao.DaoSupport;
import com.meession.system.dao.ISystemLogDao;
import com.meession.system.entity.SystemLog;

/**
 * @author sam
 */
@Repository
public class SystemLogDao extends DaoSupport implements ISystemLogDao {

	private String getConditionalQuery(Map<String, Object> params,
			String filterValue) {
		String[] filterFields = { "staffCode", "actionType", "message" };
		String queryString = "";
		if (StringUtils.isNotBlank(filterValue)) {
			String conditionValue = "%" + filterValue.toLowerCase() + "%";

			for (String field : filterFields) {
				params.put(field, conditionValue);
				queryString += " OR LOWER(" + field + ") LIKE :" + field;
			}
		}
		queryString = queryString.replaceFirst("OR", "WHERE");
		return queryString;
	}

	@Override
	public Pager<SystemLog> search(Pager<SystemLog> pager, String filterValue) {
		Map<String, Object> params = new HashMap<String, Object>();
		String queryString = getConditionalQuery(params, filterValue);
		String countQueryString = "SELECT count(entity) FROM SystemLog entity"
				+ queryString;

		if (StringUtils.isNotBlank(pager.getOrderBy())) {
			queryString += pager.getOrderString();
		}

		String listQueryString = "SELECT entity FROM SystemLog entity"
				+ queryString;

		long size = this.getDaoTemplate().count(countQueryString, params);
		List<SystemLog> resultList = this.getDaoTemplate().list(
				SystemLog.class, listQueryString, pager.getFirstNum(),
				pager.getPageSize(), params);
		pager.setTotalNum(size);
		pager.setDatas(resultList);
		return pager;
	}

}
