package com.sgepm.easydp.common.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public abstract class BaseController implements Constants{

	protected static final Logger logger = Logger.getLogger(BaseController.class);
	
	
	protected Short getShort(HttpServletRequest request, String paramName) {
		String value = getString(request, paramName);
		if (value == null || value.equals("")) {
			return null;
		}
		return Short.parseShort(value);
	}
	
	protected Integer getInt(HttpServletRequest request, String paramName) {
		String value = getString(request, paramName);
		if (value == null || value.equals("")) {
			return null;
		}
		return Integer.parseInt(value);
	}
	
	protected Double getDouble(HttpServletRequest request, String paramName) {
		String value = getString(request, paramName);
		if (value == null || value.equals("")) {
			return null;
		}
		return Double.parseDouble(value);
	}
	
	protected String getString(HttpServletRequest request, String paramName) {
		return request.getParameter(paramName);
	}
	
	protected String render(HttpServletResponse response, String text, String contentType) {
		try {
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 直接输出字符串.
	 */
	protected String renderText(HttpServletResponse response, String text) {
		return render(response, text, "text/plain;charset=UTF-8");
	}

	/**
	 * 直接输出字符串GBK编码.
	 */
	protected String renderHtmlGBK(HttpServletResponse response, String html) {
		return render(response, html, "text/html;charset=GBK");
	}
	
	protected String renderHtml(HttpServletResponse response, String html) {
		return render(response, html, "text/html;charset=UTF-8");
	}

	/**
	 * 直接输出XML.
	 */
	protected String renderXML(HttpServletResponse response, String xml) {
		return render(response, xml, "text/xml;charset=UTF-8");
	}
	
	/**
	 * 直接输出Json
	 * @return
	 */
	protected String renderJson(HttpServletResponse response, String json){
		return render(response, json, "text/json;charset=UTF-8");
	}
	
	/**
	 * 直接输出流文件
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	protected String renderFile(HttpServletResponse response, File file) throws FileNotFoundException {
		if (file == null) {
			logger.error("下载文件失败, 信息：未找到的文件[file=null]");
			throw new FileNotFoundException();
		}
		return renderFile(response, file.getName(), file);
	}	
	
	/**
	 * 直接输出流文件
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	protected String renderFile(HttpServletResponse response, String fileName, File file) {
		try {
			fileName = new String(fileName.getBytes(), "ISO8859-1");
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName);
			ServletOutputStream os = response.getOutputStream();
			InputStream is = new FileInputStream(file);
			byte[] buffer = new byte[2048];
			int n = -1;
			while ((n = is.read(buffer, 0, buffer.length)) != -1) {
				os.write(buffer, 0, n);
			}
			os.flush();
			os.close();
			is.close();
		} catch (UnsupportedEncodingException e) {
			logger.error("下载文件失败, 信息：文件名编码转换错误, e:" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.error("下载文件失败, 信息：未找到的文件, e:" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("下载文件失败, 信息：文件输出失败, e:" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return null;
	}	
	
}
