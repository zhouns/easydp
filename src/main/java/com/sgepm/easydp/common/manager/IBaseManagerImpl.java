package com.sgepm.easydp.common.manager;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import com.sgepm.easydp.common.entity.Pagination;
import com.sgepm.easydp.common.persistence.IBaseDao;
import com.sgepm.easydp.common.persistence.sql.OrderBy;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public abstract class IBaseManagerImpl<T extends Serializable> implements IBaseManager<T> {
	
	protected Logger log = Logger.getLogger(getClass());
	
	public IBaseDao<T> dao;

	public void setDao(IBaseDao<T> dao) {
		this.dao = dao;
	}

	public IBaseDao<T> getDao() {
		return dao;
	}

	@Override
	public T findBean(T entity, String... exclude) {
		return dao.findBean(entity, exclude);
	}
	
	@Override
	public List<T> findBeanList(String sql, Object... parameters) {
		return dao.findBeanList(sql, parameters);
	}

	@Override
	public List<T> findBeanList(T entity, OrderBy orderBy, String... exclude) {
		return dao.findBeanList(entity, orderBy, exclude);
	}
	
	@Override
	public Pagination findBeanPage(HttpServletRequest request, T entity, OrderBy orderBy, String... exclude) {
		Integer draw = Integer.parseInt(request.getParameter("draw"));
		Integer start = Integer.parseInt(request.getParameter("start"));
		Integer pageSize = Integer.parseInt(request.getParameter("length"));
		Integer result = start / pageSize;
		Integer pageNo = (result == 0) ? result : (result + 1);
		return findBeanPage(draw, pageNo, pageSize, entity, orderBy, exclude);
	}
	
	@Override
	public Pagination findBeanPage(Integer draw, Integer pageNo, Integer pageSize, T entity,
			OrderBy orderBy, String... exclude) {
		return dao.findBeanPage(draw, pageNo, pageSize, entity, orderBy, exclude);
	}
	
	@Override
	public boolean update(T entity, String... exclude) {
		return dao.update(entity, exclude) == 1;
	}

	@Override
	public boolean save(T entity, String... exclude) {
		return dao.save(entity, exclude) == 1;
	}
	
	@Override
	public int[] batchSave(List<T> entitys, String... exclude) {
		return dao.batchSave(entitys, exclude);
	}

	@Override
	public int delete(T entity) {
		return dao.delete(entity);
	}
}
