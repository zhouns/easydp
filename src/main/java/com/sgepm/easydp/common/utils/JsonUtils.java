package com.sgepm.easydp.common.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JOSN工具包
 * 
 * @author zhou
 */
public class JsonUtils {

	private static Logger logger = Logger.getLogger(JsonUtils.class);
	private static ObjectMapper objectMapper;

	/**
	 * 获取ObjectMapper实例
	 * 
	 * @return
	 */
	public static synchronized ObjectMapper getInstance() {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		return objectMapper;
	}

	/**
	 * 对象转JSON字符串
	 * @param obj
	 * @return
	 */
	public static String beanToJson(Object obj) {
		String json = null;
		try {
			ObjectMapper objectMapper = getInstance();
			json = objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("bean conver to json string error", e);
		}
		return json;
	}

	/**
	 * JSON字符串转对象
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static Object jsonToBean(String json, Class<?> clazz) {
		Object bean = null;
		try {
			ObjectMapper objectMapper = getInstance();
			bean = objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("json string conver to bean error", e);
		}
		return bean;
	}
	
	/**
	 * JSON字符串转对象
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> jsonToMap(String json) {
		Map<String, Object> map = null;
		try {
			ObjectMapper objectMapper = getInstance();
			map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() { });
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("json string conver to bean error", e);
		}
		return map;
	}

	/**
	 * 读取JSON文件转换为对象
	 * 
	 * @param path
	 * @param clazz
	 * @return
	 */
	public static Object readJsonFile(String path, Class<?> clazz) {
		Object obj = null;
		try {
			ObjectMapper objectMapper = getInstance();
			obj = objectMapper.readValue(new File(path), clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
			logger.error("json file conver to bean error", e);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			logger.error("json file conver to bean error", e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("json file conver to bean error", e);
		}
		return obj;
	}
	
	/**
	 * 读取JSON文件转换为Map
	 * 
	 * @param path
	 * @return
	 */
	public static Map<String, Object> readJsonFile(String path) {
		Map<String, Object> map = null;
		ObjectMapper objectMapper = getInstance();
		try {
			map = objectMapper.readValue(new File(path), new TypeReference<Map<String, Object>>() { });
		} catch (JsonParseException e) {
			e.printStackTrace();
			logger.error("json file conver to map error", e);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			logger.error("json file conver to map error", e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("json file conver to map error", e);
		}
		return map;
	}
	
	/**
	 * 将对象以JSON格式写入文件
	 * 
	 * @param path
	 * @param obj
	 */
	public static void writeJsonFile(String path, Object obj) {
		ObjectMapper objectMapper = getInstance();
		try {
			objectMapper.writeValue(new File(path), obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			logger.error("write json file error", e);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			logger.error("write json file error", e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("write json file error", e);
		}
	}
}
