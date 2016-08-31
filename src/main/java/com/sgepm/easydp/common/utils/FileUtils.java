package com.sgepm.easydp.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

public class FileUtils {
	
	private static final Logger logger = Logger.getLogger(FileUtils.class);
	
	private static final int BUFFER_SIZE = 1024 * 2;
	
	public static final String SEPARATOR = File.separator;
	
	public static boolean uploadFile(File file, String filePath) {
		try {
			return uploadFile(new FileInputStream(file), filePath);
		} catch (FileNotFoundException e) {
			logger.error(e);
			e.printStackTrace();
		}
		return false;
	}

	public static boolean uploadFile(InputStream is, String filePath) {

		boolean retCode = false;
		byte[] buffer = new byte[BUFFER_SIZE];
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(new File(filePath));

			int n = -1;
			while ((n = is.read(buffer, 0, buffer.length)) != -1) {
				fos.write(buffer, 0, n);
			}

			retCode = true;
			logger.debug("+++++++上传文件成功++++++++");
		} catch (FileNotFoundException fnfe) {
			System.out.println("fnfe:" + fnfe);
		} catch (IOException ioe) {
			System.out.println("ioe:" + ioe);
		} finally {
			if (fos != null) {
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
					logger.error(e);
				}
			}
			if (is != null) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}

		return retCode;
	}
	
	public static boolean copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
				logger.debug("+++++++拷贝文件成功++++++++");
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean createFolder(String folder) {
		File file = new File(folder);
		if (!file.exists()) {
			file.mkdirs();
			logger.debug("创建文件夹[" + folder + "]");
		}
		return true;
	}

	public static String formatFileSize(double size) {
		double kiloByte = size / 1024;
		if (kiloByte < 1) {
			return size + "Byte(s)";
		}

		double megaByte = kiloByte / 1024;
		if (megaByte < 1) {
			BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
			return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
					.toPlainString() + "KB";
		}

		double gigaByte = megaByte / 1024;
		if (gigaByte < 1) {
			BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
			return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
					.toPlainString() + "MB";
		}

		double teraBytes = gigaByte / 1024;
		if (teraBytes < 1) {
			BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
			return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
					.toPlainString() + "GB";
		}
		BigDecimal result4 = new BigDecimal(teraBytes);
		return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
				+ "TB";
	}
	
	public static void main(String[] args) {
		System.out.println(1024L * 1024L * 1024L * 1024L);
	}
}
