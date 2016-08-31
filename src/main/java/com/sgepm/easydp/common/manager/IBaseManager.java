package com.sgepm.easydp.common.manager;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sgepm.easydp.common.entity.Pagination;
import com.sgepm.easydp.common.persistence.sql.OrderBy;

public interface IBaseManager<T extends Serializable> {
	
	public T findBean(T entity, String... exclude);
	
	public List<T> findBeanList(T entity, OrderBy orderBy, String... exclude);
	
	public List<T> findBeanList(String sql, Object... parameters);
	
	public Pagination findBeanPage(HttpServletRequest request, T entity, OrderBy orderBy, String... exclude);
	
	public Pagination findBeanPage(Integer draw, Integer pageNo, Integer pageSize, T entity, OrderBy orderBy, String... exclude);
	
	public boolean update(T entity, String... exclude);
	
	public boolean save(T entity, String... exclude);

	public int[] batchSave(List<T> entitys, String... exclude);
	
	public int delete(T entity);

	
}
