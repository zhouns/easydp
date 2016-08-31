package com.sgepm.easydp.system.flt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.sgepm.easydp.common.utils.FileUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkEngine {
	
	private static final Logger logger = Logger.getLogger(FreemarkEngine.class);
	private static Configuration cfg = null;
	
	public synchronized static Configuration getInstance() throws IOException {
		if (cfg == null) {
			cfg = new Configuration();
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
			ServletContext servletContext = webApplicationContext.getServletContext();
			cfg.setServletContextForTemplateLoading(servletContext, "/resource/flt");
		}
		return cfg;
	}
	
	public static void write(String flt, String file, Object data) {
		try {
			getInstance();
			FileUtils.createFolder(file.substring(0, file.lastIndexOf("/")));
			Template temp = cfg.getTemplate(flt);
	        OutputStream os = new FileOutputStream(file);
	        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			temp.process(data, osw);
			osw.close();			
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (TemplateException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}
	
}
