package com.sgepm.easydp.common.utils;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * Date工具包
 * 
 * @author Nan
 *
 */
public class DateUtils {
	
	private static final Logger logger = Logger.getLogger(DateUtils.class);
    private static final Object lock = new Object();
    private static Map<String, ThreadLocal<SimpleDateFormat>> localThreadMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
    
    public final static String PATTERN_YYYYMM = "yyyy-MM";
    public final static String PATTERN_YYYYMMDD = "yyyy-MM-dd";
    public final static String PATTERN_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public final static String PATTERN_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public final static String PATTERN_YYYYMMDDHHMMSSMI = "yyyy-MM-dd HH:mm:ss.SSS";
  
    
    /**
     * 返回当前线程唯一的 DateFormat
     * 
     * @param pattern
     * @return
     */
    public static SimpleDateFormat getDateFormat(final String pattern) {
        ThreadLocal<SimpleDateFormat> threadLoacl = localThreadMap.get(pattern);
        if (threadLoacl == null) {
            synchronized (lock) {
                threadLoacl = localThreadMap.get(pattern);
                if (threadLoacl == null) {
                    threadLoacl = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    localThreadMap.put(pattern, threadLoacl);
                }
            }
        }
        return threadLoacl.get();
    }
    
    /**
     * 转换成日期格式
     * 
     * @param source
     * @param formater
     * @return
     */
    public static Date toDate(String source, String formater) {
    	SimpleDateFormat format = getDateFormat(formater);
    	Date date = null;
		try {
			date = format.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("date conver error", e);
		}
    	return date;
    }
    
    /**
     * 转换成字符串格式
     * 
     * @param source
     * @param formater
     * @return
     */
    public static String toString(Date source, String formater) {
    	SimpleDateFormat format = getDateFormat(formater);
    	return format.format(source);
    }
    
    /**
     * 获得当前年份
     * 
     * @return
     */
	public static int getYear() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR);
	}
	
    /**
     * 获得当前年份
     * 
     * @return
     */	
	public static int getMonth() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.MONTH) + 1;
	}
	
    /**
     * 获得当前年份
     * 
     * @return
     */	
	public static int getWeek() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.DAY_OF_WEEK) - 1;
	}
	
    /**
     * 获得当前年份
     * @return
     */	
	public static int getDay() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 获得当前时间（YYYYMMDDHHMM）
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		return getCurrentTime(PATTERN_YYYYMMDDHHMM);
	}
	
	/**
	 * 获得当前时间
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrentTime(String pattern) {
		SimpleDateFormat format = getDateFormat(pattern);
		return format.format(new Date());
	}
    
	/**
	 * 获得今天
	 * 
	 * @return
	 */
	public static String getToday() {
		return toString(new Date(), PATTERN_YYYYMMDD);
	}

	/**
	 * 获得明天
	 * 
	 * @return
	 */
	public static String getTomorrow() {
		return getNextDate(getToday(), PATTERN_YYYYMMDD);
	}

	/**
	 * 获得后一天
	 * 
	 * @param date
	 * @param formater
	 * @return
	 */
	public static String getNextDate(String date, String formater) {
		Calendar c = Calendar.getInstance();
		c.setTime(toDate(date, formater));
		c.add(Calendar.DAY_OF_MONTH, 1);
		return toString(c.getTime(), formater);
	}

	/**
	 * 获得昨天
	 * 
	 * @return
	 */
	public static String getYesterday() {
		return getPrevDate(getToday(), PATTERN_YYYYMMDD);
	}

	/**
	 * 获得前一天
	 * 
	 * @param date
	 * @param formater
	 * @return
	 */
	public static String getPrevDate(String date, String formater) {
		Calendar c = Calendar.getInstance();
		c.setTime(toDate(date, formater));
		c.add(Calendar.DAY_OF_MONTH, -1);
		return toString(c.getTime(), formater);
	}
	

	/**
	 * 获得当前月中的日期数组
	 * 
	 * @return
	 */
	public static Integer[] getMonthArray() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		int days = c.getActualMaximum(Calendar.DATE);
		Integer[] month = new Integer[days];
		for (int i = 0; i < days; i++) {
			month[i] = i + 1;
		}
		return month;
	}
	
	/**
	 * 获得当前年月
	 * 
	 * @return
	 */
	public static String getYearAndMonth() {
		return toString(new Date(), PATTERN_YYYYMM);
	}
	
	/**
	 * 获取日期集合
	 * 
	 * @param d	起始日期
	 * @param size	集合大小
	 * @return
	 */
	public static List<String> getDateCollection(String d, int size) {
		return getDateCollection(d, PATTERN_YYYYMMDD, 1, size);
	}

	/**
	 * 获得日期集合
	 * 
	 * @param date	起始日期
	 * @param formater	
	 * @param increment	增量
	 * @param size	集合大小
	 * @return	List<String>
	 */
	public static List<String> getDateCollection(String date, String formater,
			int increment, int size) {
		List<String> dateCollection = new ArrayList<String>();
		Calendar c = Calendar.getInstance();
		c.setTime(toDate(date, formater));
		dateCollection.add(toString(c.getTime(), formater));
		for (int i = 0; i < size - 1; i++) {
			c.add(Calendar.DAY_OF_MONTH, increment);
			dateCollection.add(toString(c.getTime(), formater));
		}
		return dateCollection;
	}
	
	/**
	 * 获得两个日期间的集合
	 * 
	 * @param sd
	 * @param ed
	 * @return
	 */
	public static List<String> getDateCollection(String sd, String ed) {
		
		List<String> dateCollection = new ArrayList<String>();
		Calendar sCa = Calendar.getInstance();
		Calendar eCa = Calendar.getInstance();
		
		sCa.setTime(toDate(sd, PATTERN_YYYYMMDD));
		eCa.setTime(toDate(ed, PATTERN_YYYYMMDD));
		
		Long sTime = sCa.getTimeInMillis();
		Long eTime = eCa.getTimeInMillis();
		Long oneDay = 1000 * 60 * 60 * 24L;

		Long time = sTime;
		while (time <= eTime) {
			Date d = new Date(time);
			dateCollection.add(toString(d, PATTERN_YYYYMMDD));
			time += oneDay;
		}
		return dateCollection;
	}
	
	/**
	 * 日期计算
	 * 
	 * @param source
	 * @param time
	 * @return
	 */
	public static Date computeTime(Date source, long time) {
		return new Date(source.getTime() + time);
	}

	/**
	 * 日期计算
	 * 
	 * @param source
	 * @param time
	 * @param sformater
	 * @param eformater
	 * @return
	 */
	public static String computeTime(String source, long time,
			String sformater, String eformater) {
		Date tempDate1 = toDate(source, sformater);
		Date tempDate2 = computeTime(tempDate1, time);
		return toString(tempDate2, eformater);
	}
	
}