package com.sgepm.easydp.common.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import com.sgepm.easydp.common.entity.Pagination;
import com.sgepm.easydp.common.persistence.sql.OrderBy;
import com.sgepm.easydp.common.persistence.sql.SqlDefault;
import com.sgepm.easydp.common.persistence.sql.SqlProvider;

@Repository
public abstract class IBaseDaoImpl<T extends Serializable> implements IBaseDao<T> {
	
	protected static Logger log = Logger.getLogger(IBaseDaoImpl.class);
	protected static final String dataSourceType = "mysql";
	protected JdbcTemplate jdbcTemplate;
	protected SqlProvider<T> sqlProvider;
	protected Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public IBaseDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.sqlProvider = new SqlProvider<T>(persistentClass);
    }
	
	/**
	 * 查询实体对象
	 * 
	 * @param sql
	 * @param parameters
	 * 
	 * @return 
	 */
	@Override
	public T findBean(String sql, Object... parameters) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(persistentClass);
		return jdbcTemplate.queryForObject(sql, rowMapper, parameters);
	}
	
	/**
	 * 查询实体对象
	 * 
	 * @param entity
	 * @param exclude
	 * 
	 * @return
	 */
	@Override
	public T findBean(T entity, String... exclude) {
		Assert.notNull(entity, "Class instance must not be null");
		SqlDefault sqlDefault = sqlProvider.getQueryer(entity, exclude);
		String sql = sqlDefault.getSql();
		Object[] parameters = sqlDefault.getParameters();
		return this.findBean(sql, parameters);
	}
	
	/**
	 * 查询Map对象
	 * 
	 * @param sql
	 * @param parameters
	 * 
	 * @return
	 */
	@Override
	public Map<String, Object> findMap(String sql, Object... parameters) {
		return jdbcTemplate.queryForMap(sql, parameters);
	}
	
	/**
	 * 查询List实体集合
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	@Override
	public List<T> findBeanList(String sql, Object... parameters) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(persistentClass);
        return jdbcTemplate.query(sql, rowMapper, parameters);
	}
	
	/**
	 * 查询List实体集合
	 * 
	 * @param entity
	 * @param orderBy
	 * @param exclude
	 * 
	 * @return
	 */
	@Override
	public List<T> findBeanList(T entity, OrderBy orderBy, String... exclude) {
		Assert.notNull(entity, "Class instance must not be null");
		SqlDefault sqlDefault = sqlProvider.getQueryer(entity, orderBy, exclude);
		String sql = sqlDefault.getSql();
		Object[] parameters = sqlDefault.getParameters();
        return findBeanList(sql, parameters);
	}
	
	/**
	 * 查询List Map集合
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findMapList(String sql, Object... parameters) {
		 return jdbcTemplate.queryForList(sql, parameters);
	}
	
	/**
	 * 分页查询，返回实体List
	 * 
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @param parameters
	 * @return
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Pagination findBeanPage(String sql, Integer draw, Integer pageNo, Integer pageSize, Object... parameters) {
		Integer totalCnt = findTotalCount(sql, parameters);
		Pagination pagination = new Pagination(draw, pageNo, pageSize, totalCnt);
		String page_sql = null;
		if (dataSourceType.equals("mysql")) {
			page_sql = sql + " LIMIT "+ pagination.getSrt() +", "+ pagination.getEnd() +"";
		}
		if (dataSourceType.equals("oracle")) {
			page_sql = "SELECT * FROM (SELECT ROWNUM NUM, T.* FROM (" + sql + ") T) " +
					"WHERE NUM > "+ pagination.getSrt() +" AND NUM <= "+ pagination.getEnd() +"";
		}
		List list = this.findBeanList(page_sql, parameters);
		pagination.setData(list);
		return pagination;
	}
	
	/**
	 * 分页查询，返回实体List
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param entity
	 * @param orderBy
	 * @param exclude
	 * 
	 * @return
	 */
	@Override
	public Pagination findBeanPage(Integer draw, Integer pageNo, Integer pageSize, T entity,
			OrderBy orderBy, String... exclude) {
		Assert.notNull(entity, "Class instance must not be null");
		SqlDefault sqlDefault = sqlProvider.getQueryer(entity, orderBy, exclude);
		String sql = sqlDefault.getSql();
		Object[] parameters = sqlDefault.getParameters();

		Integer totalCnt = findTotalCount(sql, parameters);
		Pagination  pagination = new Pagination(draw, pageNo, pageSize, totalCnt);
		String page_sql = null;
		if (dataSourceType.equals("mysql")) {
			page_sql = sql + " LIMIT "+ pagination.getSrt() +", "+ pagination.getEnd() +"";
		}
		if (dataSourceType.equals("oracle")) {
			page_sql = "SELECT * FROM (SELECT ROWNUM NUM, T.* FROM (" + sql + ") T) " +
					"WHERE NUM > "+ pagination.getSrt() +" AND NUM <= "+ pagination.getEnd() +"";
		}
		List<T> list = this.findBeanList(page_sql, parameters);
		pagination.setData(list);
		return pagination;
	}
	
	/**
	 * 分页查询，返回实体List
	 * 
	 * @param sql
	 * @param request
	 * @param parameters
	 * 
	 * @return
	 */
	@Override
	public Pagination findBeanPageByReq(String sql, HttpServletRequest request, Object... parameters) {
		Integer draw = Integer.parseInt(request.getParameter("draw"));
		Integer start = Integer.parseInt(request.getParameter("start"));
		Integer pageSize = Integer.parseInt(request.getParameter("length"));
		Integer pageNo = start / pageSize;
		pageNo = (pageNo == 0) ? pageNo : (pageNo + 1);
		Integer totalCnt = findTotalCount(sql, parameters);
		Pagination pagination = new Pagination(draw, pageNo, pageSize, totalCnt);
		String page_sql = null;
		if (dataSourceType.equals("mysql")) {
			page_sql = sql + " LIMIT "+ pagination.getSrt() +", "+ pagination.getEnd() +"";
		}
		if (dataSourceType.equals("oracle")) {
			page_sql = "SELECT * FROM (SELECT ROWNUM NUM, T.* FROM (" + sql + ") T) " +
					"WHERE NUM > "+ pagination.getSrt() +" AND NUM <= "+ pagination.getEnd() +"";
		}
		List<Map<String, Object>> list = this.findMapList(page_sql, parameters);
		pagination.setData(list);
		return pagination;
	}
	
	/**
	 * 分页查询，返回Map List
	 * 
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @param parameters
	 * @return
	 */
	@Override
	public Pagination findMapPage(String sql, Integer draw, Integer pageNo, Integer pageSize,
			Object... parameters) {
		Integer totalCnt = findTotalCount(sql, parameters);
		Pagination pagination = new Pagination(draw, pageNo, pageSize, totalCnt);
		String page_sql = null;
		if (dataSourceType.equals("mysql")) {
			page_sql = sql + " LIMIT "+ pagination.getSrt() +", "+ pagination.getEnd() +"";
		}
		if (dataSourceType.equals("oracle")) {
			page_sql = "SELECT * FROM (SELECT ROWNUM NUM, T.* FROM (" + sql + ") T) " +
					"WHERE NUM > "+ pagination.getSrt() +" AND NUM <= "+ pagination.getEnd() +"";
		}
		List<Map<String, Object>> list = this.findMapList(page_sql, parameters);
		pagination.setData(list);
		return pagination;
	}
	
	/**
	 * 分页查询，返回Map List
	 * 
	 * @param sql
	 * @param request
	 * @param parameters
	 * @return
	 */
	@Override
	public Pagination findMapPageByReq(String sql, HttpServletRequest request, Object... parameters) {
		Integer draw = Integer.parseInt(request.getParameter("draw"));
		Integer start = Integer.parseInt(request.getParameter("start"));
		Integer pageSize = Integer.parseInt(request.getParameter("length"));
		Integer pageNo = start / pageSize;
		pageNo = (pageNo == 0) ? pageNo : (pageNo + 1);
		Integer totalCnt = findTotalCount(sql, parameters);
		Pagination pagination = new Pagination(draw, pageNo, pageSize, totalCnt);
		String page_sql = null;
		if (dataSourceType.equals("mysql")) {
			page_sql = sql + " LIMIT "+ pagination.getSrt() +", "+ pagination.getEnd() +"";
		}
		if (dataSourceType.equals("oracle")) {
			page_sql = "SELECT * FROM (SELECT ROWNUM NUM, T.* FROM (" + sql + ") T) " +
					"WHERE NUM > "+ pagination.getSrt() +" AND NUM <= "+ pagination.getEnd() +"";
		}
		List<Map<String, Object>> list = this.findMapList(page_sql, parameters);
		pagination.setData(list);
		return pagination;
	}
	
	/**
	 * 查询记录总数
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public int findTotalCount(String sql, Object... parameters) {
		String total_count_sql = "SELECT COUNT(1) TOTAL FROM ("+ sql +") TT";
		Map<String, Object> unique = this.findMap(total_count_sql, parameters);
		Integer total_count = Integer.parseInt(unique.get("TOTAL").toString());
		return total_count;
	}
	
	/**
	 * 更新记录
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	@Override
	public int update(String sql, Object... parameters) {
		return jdbcTemplate.update(sql, parameters);
	}
	
	/**
	 * 更新记录
	 * 
	 * @param entity
	 * @param igNull
	 * @param exclude
	 * @return
	 */
	@Override
	public int update(T entity, boolean igNull, String... exclude) {
		Assert.notNull(entity, "Class instance must not be null");
		SqlDefault sqlDefault = sqlProvider.getUpdater(entity, igNull, exclude);
		String sql = sqlDefault.getSql();
		Object[] parameters = sqlDefault.getParameters();
		return update(sql, parameters);
	}
	
	/**
	 * 更新记录
	 * 
	 * @param entity
	 * @param exclude
	 * @return
	 */
	@Override
	public int update(T entity, String... exclude) {
		Assert.notNull(entity, "Class instance must not be null");
		return update(entity, true, exclude);
	}
	
	
	/**
	 * 插入记录
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int save(T entity, String... exclude) {
		Assert.notNull(entity, "Class instance must not be null");
		SqlDefault sqlDefault = sqlProvider.getInserter(entity, exclude);
		String sql = sqlDefault.getSql();
		Object[] parameters = sqlDefault.getParameters();
		return update(sql, parameters);
	}
	
	/**
	 * 批量插入
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	@Override
	public int[] batchSave(List<T> entitys, String... exclude) {
		int[] x = {};
		return x;
	}
	
	/**
	 * 批量更新
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	@Override
	public int[] batchUpdate(String sql, List<Object[]> parameters) {
		return jdbcTemplate.batchUpdate(sql, parameters);
	}
	
	/**
	 * 执行删除
	 * 
	 * @param keys
	 * @return
	 */
	@Override
	public int delete(T entity) {
		SqlDefault sqlDefault = sqlProvider.getDeleter(entity);
		String sql = sqlDefault.getSql();
		Object[] parameters = sqlDefault.getParameters();
		return update(sql, parameters);
	}
	
	
	//////////////////////// 以下是一些帮助方法 /////////////////////////////
	/**
	 * 快速生成参数列表,空参数会被自动忽略掉(查询使用)
	 * 
	 * @param agrs
	 * @return
	 */
	public Object[] quickQueryParam(Object... parameters) {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < parameters.length; i++) {
			if (parameters[i] == null 
					|| parameters[i].toString().equals("")) {
				continue;
			}
			list.add(parameters[i]);
		}
		return list.toArray();
	}	
	
	/**
	 * 快速生成参数列表（批量删除使用）
	 * 
	 * @param primaryKeys: "a||1","b||2","c||3"
	 * @return
	 */
	public List<Object[]> quickDeleteParam(String primaryKeys) {
		String[] keyArray = primaryKeys.split(",");
		List<Object[]> pkArray = new ArrayList<Object[]>();
		
		for (int i = 0; i < keyArray.length; i++) {
			String primaryKey = keyArray[i];
			String[] primaryFields = primaryKey.split("\\|\\|");
			Object[] o = new Object[primaryFields.length];
			for (int j = 0; j < primaryFields.length; j++) {
				o[j] = primaryFields[j];
			}
			pkArray.add(o);
		}
		return pkArray;
	}	
	
	/**
	 * 快速生成参数列表,将对象转数组(保存使用)
	 * 
	 * @param object
	 * @param ignore
	 * @return
	 */
	public Object[] quickAddParam(Object object, String... ignore) {
		List<Object> list = new ArrayList<Object>();
		for (Field f : object.getClass().getDeclaredFields()) {
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			boolean ig = false;
			if (ignore != null && ignore.length > 0) {
				for (String i : ignore) {
					if (i.equals(f.getName())) {
						ig = true;
						break;
					}
				}
			}
			if (ig || f.getName().equals("serialVersionUID")) {
				continue;
			} else {
				Object o = null;
				try {
					o = f.get(object);
				} catch (IllegalArgumentException e) {
					log.error(e.getMessage(), e);
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					log.error(e.getMessage(), e);
					e.printStackTrace();
				}
				list.add(o);
			}
		}
		return list.toArray();
	}
	
	
	/**
	 * 快速生成参数列表 将对象转数组, 会把ignore的部分追加到最后(更新使用)
	 * 
	 * @param object
	 * @param igNull
	 * @param ignore
	 * @return
	 */
	public Object[] quickUpdateParam(Object object, boolean igNull, String... ignore) {
		List<Object> tpLst = new ArrayList<Object>();
		List<Object> igLst = new ArrayList<Object>();
		
		for (Field f : object.getClass().getDeclaredFields()) {
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			boolean ig = false;
			if (ignore != null && ignore.length > 0) {
				for (String i : ignore) {
					if (i.equals(f.getName())) {
						ig = true;
						break;
					}
				}
			}
			
			//获得值
			Object o = null;
			try {
				o = f.get(object);
			} catch (IllegalArgumentException e) {
				log.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				log.error(e.getMessage(), e);
				e.printStackTrace();
			}
			
			if (f.getName().equals("serialVersionUID")) {
				continue;
			}
			
			if (igNull) {
				if (o != null) {
					if(ig) igLst.add(o); else tpLst.add(o);
				}
			} else {
				if(ig) igLst.add(o); else tpLst.add(o);
			}
		}
		//追加全部
		tpLst.addAll(igLst);
		return tpLst.toArray();
	}
	
	protected String toLikeParam(String param) {
		if (param == null) {
			return null;
		}
		return "%" + param + "%";
	}

}
