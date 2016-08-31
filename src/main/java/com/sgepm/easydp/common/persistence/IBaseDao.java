package com.sgepm.easydp.common.persistence;

import java.util.Map;
import java.util.List;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.sgepm.easydp.common.entity.Pagination;
import com.sgepm.easydp.common.persistence.sql.OrderBy;

public interface IBaseDao <T extends Serializable> {
	
	public T findBean(String sql, Object... values);
	
	public T findBean(T entity, String... exclude);
	
	public Map<String, Object> findMap(String sql, Object... values);
	
	public List<T> findBeanList(String sql, Object... values);
	
	public List<T> findBeanList(T entity, OrderBy orderBy, String... exclude);
	
	public List<Map<String, Object>> findMapList(String sql, Object... values);
	
	public Pagination findBeanPage(String sql, Integer draw, Integer pageNo, Integer pageSize, Object... values);
	
	public Pagination findBeanPage(Integer draw, Integer pageNo, Integer pageSize, T entity, OrderBy orderBy, String... exclude);
	
	public Pagination findBeanPageByReq(String sql, HttpServletRequest request, Object... values);

	public Pagination findMapPage(String sql, Integer draw, Integer pageNo, Integer pageSize, Object... values);
	
	public Pagination findMapPageByReq(String sql, HttpServletRequest request, Object... values);
	
	public int update(String sql, Object... values);
	
	public int update(T entity, String... exclude);
	
	public int update(T entity, boolean igNull, String... exclude);
	
	public int save(T entity, String... exclude);
	
	public int[] batchSave(List<T> entitys, String... exclude);
	
	public int[] batchUpdate(String sql, List<Object[]> values);

	public int delete(T entity);
}
