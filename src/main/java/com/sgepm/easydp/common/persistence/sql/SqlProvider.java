package com.sgepm.easydp.common.persistence.sql;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.log4j.Logger;

import com.sgepm.easydp.common.persistence.IBaseException;
import com.sgepm.easydp.common.persistence.validate.BeanValidate;

/**
 * SQL提供接口，实体类遵循Java Persistence 接口
 * 
 * @author Nan
 *
 * @param <T>
 */
public class SqlProvider <T extends Serializable> extends BeanValidate {
	
	private static final Logger logger = Logger.getLogger(SqlProvider.class);
	private String SCHEMA_TABLE;
	private Class<T> persistentClass;
	private Map<String, String> keyMap;
	private Map<String, String> columnMap;
	
	public SqlProvider(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.initialize();
		logger.debug("Initialize " + persistentClass.getName() + "'s SqlProvider");
	}
	
	/**
	 * 初始化SqlProvider
	 * 
	 */
	public void initialize() {
		Class<Id> 			idClazz 		= Id.class;
		Class<Table> 		tableClazz 		= Table.class;
		Class<Column> 		columnClazz 	= Column.class;
		
		keyMap = new LinkedHashMap<String, String>();
		columnMap = new LinkedHashMap<String, String>();
		
		if (persistentClass.isAnnotationPresent(tableClazz)) {
			Table table = (Table) persistentClass.getAnnotation(tableClazz);
			this.SCHEMA_TABLE = (table.schema() + "." +table.name()).toUpperCase();
		} else {
			logger.error("未找到对应的Table注解");
			throw new IBaseException("未找到对应的Table注解");
		}
		
		Method[] methods = persistentClass.getDeclaredMethods();
		for (Method method : methods) {
			boolean isKey = method.isAnnotationPresent(idClazz);
			if (method.isAnnotationPresent(columnClazz)) {
				Column column 		= method.getAnnotation(columnClazz);
				String columnName 	= column.name();
				String fieldName 	= getFiledName(method.getName());
				
				if (isKey) {
					keyMap.put(fieldName, columnName);
				}
				columnMap.put(fieldName, columnName);
			}
		}
	}
	
	/**
	 * 获取插入对象
	 * 
	 * @param entity
	 * 		对象实体
	 * @param exclude
	 * 		排除插入属性
	 * @return
	 */
	public SqlDefault getInserter(Object entity, String... exclude) {
		
		StringBuffer 		inserSql 		= new StringBuffer();
		StringBuffer 		valueSql 		= new StringBuffer();
		Set<String> 		columnKeySet 	= columnMap.keySet();
		Iterator<String> 	columnKeyIr 	= columnKeySet.iterator();
		
		List<Object> parameters = new ArrayList<Object>();
		inserSql.append("INSERT INTO ").append(SCHEMA_TABLE).append(" (");
		while (columnKeyIr.hasNext()) {
			String field = columnKeyIr.next();
			Object value = getValue(entity, field);
			if (!contains(field, exclude) && value != null) {
				String columnName = columnMap.get(field);
				inserSql.append(columnName).append(", ");
				valueSql.append("?").append(", ");
				parameters.add(value);
			}
		}
		
		inserSql.delete(inserSql.lastIndexOf(", "), inserSql.length());
		valueSql.delete(valueSql.lastIndexOf(", "), valueSql.length());
		inserSql.append(") VALUES (");
		inserSql.append(valueSql);
		inserSql.append(")");
		
		SqlDefault inserter = new SqlDefault();
		inserter.setSql(inserSql.toString());
		inserter.setParameters(parameters.toArray());
		return inserter;
	}
	
	/**
	 * 获得批量插入对象
	 * 
	 * @param list
	 * @param exclude
	 * @return
	 */
	public SqlBatch getInserter(List<T> list, String... exclude) {
		
		StringBuffer 		inserSql 		= new StringBuffer();
		StringBuffer 		valueSql 		= new StringBuffer();
		Set<String> 		columnKeySet 	= columnMap.keySet();
		Iterator<String> 	columnKeyIr 	= columnKeySet.iterator();
		List<Object[]> 		parameters 	= new ArrayList<Object[]>();
		
		inserSql.append("INSERT INTO ").append(SCHEMA_TABLE).append(" (");
		int i = 0;
		while (columnKeyIr.hasNext()) {
			String field = columnKeyIr.next();
			if (!contains(field, exclude)) {
				String columnName = columnMap.get(field);
				inserSql.append(columnName).append(", ");
				valueSql.append("?").append(", ");

				// 遍历参数
				for (int j = 0; j < list.size(); j++)  {
					Object[] o = null;
					if (i == 0) {
						o = new Object[columnMap.size() - exclude.length];
					} else {
						o = parameters.get(j);
					}
					Object columnValue = getValue(list.get(j), columnName);
					o[i] = (columnValue == null) ? "" : columnValue;
					if (i == 0) {parameters.add(o);}
				}
				i++;
			}
		}
		
		inserSql.delete(inserSql.lastIndexOf(", "), inserSql.length());
		valueSql.delete(valueSql.lastIndexOf(", "), valueSql.length());
		inserSql.append(") VALUES (");
		inserSql.append(valueSql);
		inserSql.append(")");
		
		SqlBatch inserter = new SqlBatch();
		inserter.setSql(inserSql.toString());
		inserter.setParameters(parameters);
		return inserter;
	}
	
	/**
	 * 获取更新对象
	 * 
	 * @param entity
	 * 		对象实体
	 * @param igNull
	 * 		是否忽略空值(null)
	 * @param exclude
	 * 		排除更新属性
	 * @return
	 */
	public SqlDefault getUpdater(Object entity, boolean igNull, String... exclude) {
		
		StringBuffer 		updateSql 		= new StringBuffer();
		Set<String> 		columnKeySet 	= columnMap.keySet();
		Iterator<String> 	columnKeyIr 	= columnKeySet.iterator();
		
		List<Object> parameters = new ArrayList<Object>();
		updateSql.append("UPDATE ").append(SCHEMA_TABLE).append(" SET ");
		while (columnKeyIr.hasNext()) {
			String field = columnKeyIr.next();
			Object value = getValue(entity, field);

			if (!keyMap.containsKey(field)
					&& !contains(field, exclude)) {
				if (igNull && value == null) {
					continue;
				}
				String columnName = columnMap.get(field);
				updateSql.append(columnName).append(" = ?").append(", ");;
				parameters.add(value);
			}
		}
		updateSql.delete(updateSql.lastIndexOf(", "), updateSql.length());
		updateSql.append(" WHERE 1=1");
		
		Set<String> 		keySet 	= keyMap.keySet();
		Iterator<String> 	keyIr 	= keySet.iterator();
		while (keyIr.hasNext()) {
			String keyFiled = keyIr.next();
			Object keyValue = getValue(entity, keyFiled);
			updateSql.append(" AND ").append(keyMap.get(keyFiled)).append("= ?");
			parameters.add(keyValue);
		}
		
		SqlDefault updater = new SqlDefault();
		updater.setSql(updateSql.toString());
		updater.setParameters(parameters.toArray());
		return updater;
	}
	
	
	/**
	 * 获取删除对象
	 * 
	 * @param entity
	 * @return
	 */
	public SqlDefault getDeleter(Object entity) {
		StringBuffer 		deleteSql 	= new StringBuffer();
		Set<String> 		keySet 		= keyMap.keySet();
		Iterator<String> 	keyIr 		= keySet.iterator();
		List<Object>		parameters 	= new ArrayList<Object>();
		
		deleteSql.append("DELETE FROM ").append(SCHEMA_TABLE).append(" WHERE 1=1");
		while (keyIr.hasNext()) {
			String keyFiled = keyIr.next();
			Object keyValue = getValue(entity, keyFiled);
			deleteSql.append(" AND ").append(keyMap.get(keyFiled)).append("= ?");
			parameters.add(keyValue);
		}
		
		SqlDefault deleter = new SqlDefault();
		deleter.setSql( deleteSql.toString());
		deleter.setParameters(parameters.toArray());
		return deleter;
	}

	/**
	 * 获取删除对象(批量)
	 * 
	 * @param list
	 * @return
	 */
	public SqlBatch getDeleter(List<T> list) {
		StringBuffer 		deleteSql 	= new StringBuffer();
		Set<String> 		keySet 		= keyMap.keySet();
		Iterator<String> 	keyIr 		= keySet.iterator();
		List<Object[]> 		parameters 	= new ArrayList<Object[]>();
		deleteSql.append("DELETE FROM ").append(SCHEMA_TABLE).append(" WHERE 1=1");
		
		int i = 0;
		while (keyIr.hasNext()) {
			String keyFiled = keyIr.next();
			String field = keyMap.get(keyFiled);
			deleteSql.append(" AND ").append(field).append("= ?");
			
			for (int j = 0; j < list.size(); j++)  {
				Object[] o = null;
				if (i == 0) {
					o = new Object[keySet.size()];
				} else {
					o = parameters.get(j);
				}
				Object keyValue = getValue(list.get(j), keyFiled);
				o[i] = keyValue;
				if (i == 0) {parameters.add(o);}
			}
			i++;
		}
		
		SqlBatch deleter = new SqlBatch();
		deleter.setSql(deleter.getSql());
		deleter.setParameters(parameters);
		return deleter;
	}
		
	/**
	 * 获取查询对象
	 * 
	 * @param entity
	 * 		查询实体类
	 * @param exclude
	 * 		排除查询属性
	 * @return
	 */
	public SqlDefault getQueryer(Object entity, String... exclude) {
		StringBuffer 		querySql 		= new StringBuffer();
		Set<String> 		columnKeySet 	= columnMap.keySet();
		Iterator<String> 	columnKeyIr 	= columnKeySet.iterator();
		
		querySql.append("SELECT ");
		while (columnKeyIr.hasNext()) {
			String field = columnKeyIr.next();
			if (!contains(field, exclude)) {
				String columnName = columnMap.get(field);
				querySql.append("T.").append(columnName).append(", ");
			}
		}
		
		querySql.delete(querySql.lastIndexOf(", "), querySql.length());
		querySql.append(" FROM ").append(SCHEMA_TABLE).append(" T WHERE 1=1");
		
		List<Object> 		parameters = new ArrayList<Object>();
		Set<String> 		keySet 	= keyMap.keySet();
		Iterator<String> 	keyIr 	= keySet.iterator();
		while (keyIr.hasNext()) {
			String keyFiled = keyIr.next();
			Object keyValue = getValue(entity, keyFiled);
			querySql.append(" AND ").append(keyMap.get(keyFiled)).append(" = ?");
			parameters.add(keyValue);
		}
		
		SqlDefault queryer = new SqlDefault();
		queryer.setSql(querySql.toString());
		queryer.setParameters(parameters.toArray());
		return queryer;
	}
	
	/**
	 * 获取查询对象
	 * 
	 * @param entity
	 * 		查询实体类
	 * @param orderBy
	 * 		排序字段（根据数据库字段）
	 * @param exclude
	 * 		排除查询属性
	 * @return
	 */
	public SqlDefault getQueryer(Object entity, OrderBy orderBy, String... exclude) {
		StringBuffer 		querySql 		= new StringBuffer();
		StringBuffer 		paramSql 		= new StringBuffer();
		Set<String> 		columnKeySet 	= columnMap.keySet();
		Iterator<String> 	columnKeyIr 	= columnKeySet.iterator();
		List<Object> 		parameters 		= new ArrayList<Object>();
		
		querySql.append("SELECT ");
		while (columnKeyIr.hasNext()) {
			String field = columnKeyIr.next();
			Object value = getValue(entity, field);
			String columnName = columnMap.get(field);
			if (!contains(field, exclude)) {
				querySql.append("T.").append(columnName).append(", ");
			}
			
			if (value != null && !value.equals("")) {
				paramSql.append(" AND ").append("T.").append(columnName).append(" = ?");
				parameters.add(value);
			}
		}
		
		querySql.delete(querySql.lastIndexOf(", "), querySql.length());
		querySql.append(" FROM ")
				.append(SCHEMA_TABLE)
				.append(" T WHERE 1=1")
				.append(paramSql)
				.append(" ")
				.append(orderBy.asSQL());
		
		
		SqlDefault queryer = new SqlDefault();
		queryer.setSql(querySql.toString());
		queryer.setParameters(parameters.toArray());
		return queryer;
	}
	
	public String getFiledName(String getterName) {
		String result = new String();
		result = getterName.replaceFirst("get", "");
		String s = result.substring(0, 1);
		String slc = s.toLowerCase();
		result = result.replaceFirst(s, slc);
		return result;
	}
	
	public Object getValue(Object entity, String fieldName) {
		try {
			Field field = persistentClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.get(entity);
			return field.get(entity);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (SecurityException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean contains(String fieldName, String... string) {
		for (String s : string) {
			if (fieldName.endsWith(s)) {
				return true;
			}
		}
		return false;
	}
	
}
