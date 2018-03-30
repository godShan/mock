package com.zbjk.creditfactory.mock.config;

import java.util.ArrayList;
import java.util.List;

/**
 *@author wys
 *@date 2018/03/20
 *@description
 */
public class Pagination<T> {
	
	private Integer total = 0;
	
	private List<T> rows = new ArrayList<T>();

	private List<T> footer = new ArrayList<T>();

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public List<T> getFooter() {
		return footer;
	}

	public void setFooter(List<T> footer) {
		this.footer = footer;
	}
}
