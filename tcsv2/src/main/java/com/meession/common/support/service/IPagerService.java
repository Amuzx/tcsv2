package com.meession.common.support.service;

import com.meession.common.support.Pager;

/**
 * @author sam
 */
public interface IPagerService<T> {

	public Pager<T> search(Pager<T> pager, String filterValue);

}
