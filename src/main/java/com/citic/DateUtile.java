package com.citic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtile {
	
	
	private static SimpleDateFormat dateForamt = new SimpleDateFormat(
			"yyyyMMdd");

	private static SimpleDateFormat timeForamt = new SimpleDateFormat("HHmmss");
	
	public static String getSqlDate(java.util.Date date) {
		// SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		// return sqlDate;
		if (date == null) {
			return "";
		}
		String pattern = "yyyy-MM-dd hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);
		String strDate = sdf.format(date);
		return strDate;

	}
	
	public static String getSqlDate24h(java.util.Date date) {
		if (date == null) {
			return "";
		}
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);
		String strDate = sdf.format(date);
		return strDate;
	}

	public static java.util.Date getUtilDate(String strdate) {
		if (strdate == null) {
			return null;
		}
		// String pattern = "yyyy-MM-dd hh:mm:ss";
		// SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);

		return new java.util.Date();

	}

	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String TIME_PATTERN = "HH:mm:ss";
	public static final String FULLTIMEPATTERN = "yyyyMMddHHmmss";
	public static final String DATE_TIME_PATTERN = DATE_PATTERN + " "
			+ TIME_PATTERN;
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final SimpleDateFormat sdf = new SimpleDateFormat(
			DATE_PATTERN + " " + TIME_PATTERN);

	/**
	 * 根据传入的data类型格式生成新日期
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrentDate(String pattern) {
		sdf.applyPattern(pattern);
		return sdf.format(new Date());
	}

	public static String getDate() {
		sdf.applyPattern(YYYYMMDD);
		return sdf.format(new Date());
	}

	public static String parseDate(Date date) {

		return dateForamt.format(date);
	}

	public static Date strToDate(String sDate) {
		try {
			return dateForamt.parse(sDate);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 得到当前日期
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		return dateForamt.format(new Date());
	}

	/**
	 * 得到当前时间
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		return timeForamt.format(new Date());
	}
	
	/**
	 * 获取指定时间格式的时间
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getSpecifiedFormatDate(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * 是否是润年
	 * 
	 * @param year
	 * @return
	 */
	public static boolean isLeapyear(int year) {
		boolean isproyear = false;
		if ((year % 400 == 0) | (year % 100 != 0 && year % 4 == 0)) {
			isproyear = true;
		} else {
			isproyear = false;
		}
		return isproyear;
	}

	public static String getFirstDayOfMonth() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DATE, 1);
		return dateForamt.format(calendar.getTime());
	}

	public static String getLastDayOfMonth() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		return dateForamt.format(calendar.getTime());
	}

	public static String getDateFormat(Date date) {
		return dateForamt.format(date);
	}

	public static String getDateFormat(Date date, SimpleDateFormat dateFormat) {
		return dateFormat.format(date);
	}

	public static String getFirstDayOfMonth(Integer year, Integer month) {
		Calendar calendar = new GregorianCalendar();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		if (month == null) {
			month = calendar.get(Calendar.MONTH);
		}
		calendar.set(year, month, 1);
		return dateForamt.format(calendar.getTime());
	}

	public static String getLastDayOfMonth(Integer year, Integer month) {
		Calendar calendar = new GregorianCalendar();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		if (month == null) {
			month = calendar.get(Calendar.MONTH);
		}
		calendar.set(year, month, 1);
		calendar.roll(Calendar.DATE, -1);
		return dateForamt.format(calendar.getTime());
	}

	public static String getLastDayOfMonth(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		return dateForamt.format(calendar.getTime());
	}

	public static boolean isLastDayOfMonth(Date date) {
		String lastTime = getLastDayOfMonth(date);
		String time = dateForamt.format(date);
		if (time.equalsIgnoreCase(lastTime)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取当年的第一天
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfYear() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		return dateForamt.format(calendar.getTime());
	}

	/**
	 * 获取当年的最后一天
	 * @param date
	 * @return
	 */
	public static String getLastDayOfYear() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		return dateForamt.format(calendar.getTime());
	}

	/**
	 * 获取当年的第一天
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfYear(Integer year) {
		Calendar calendar = new GregorianCalendar();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		calendar.set(year, 0, 1);
		return dateForamt.format(calendar.getTime());
	}

	/**
	 * 获取当年的最后一天
	 * @param date
	 * @return
	 */
	public static String getLastDayOfYear(Integer year) {
		Calendar calendar = new GregorianCalendar();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		calendar.set(year, 0, 1);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		return dateForamt.format(calendar.getTime());
	}

	/**
	 * 获取当年的最后一天
	 * @param date
	 * @return
	 */
	public static String getLastDayOfYear(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		return dateForamt.format(calendar.getTime());
	}

	/**
	 * 是否是当年的最后一天
	 * @param date
	 * @return
	 */
	public static boolean isLastDayOfYear(Date date) {
		String lastTime = getLastDayOfYear(date);
		String time = dateForamt.format(date);
		if (time.equalsIgnoreCase(lastTime)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 下一天的日期
	 * @param today
	 * @return
	 */
	public static Date getNextDay(Date today) {
		Calendar ca = new GregorianCalendar();
		ca.setTime(today);
		ca.add(Calendar.DAY_OF_YEAR, 1);
		return ca.getTime();
	}
	/**
	 * 前一天的日期
	 * @param today
	 * @return
	 */
	public static Date getLastDay(Date today) {
		Calendar ca = new GregorianCalendar();
		ca.setTime(today);
		ca.add(Calendar.DAY_OF_YEAR, -1);
		return ca.getTime();
	}

	
	/**
	 * 获取指定间隔天数后的日期
	 * @param today
	 * @param num 间隔天数
	 * @return
	 */
	public static Date getAfterDays(Date today,int num) {
		Calendar ca = new GregorianCalendar();
		ca.setTime(today);
		ca.add(Calendar.DAY_OF_YEAR, num);
		return ca.getTime();
	}

	
	/**
	 * 获取指定日期的月份
	 * 
	 * @param today
	 * @return
	 */
	public static int getDayMonth(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取指定日期的年份
	 * 
	 * @param today
	 * @return
	 */
	public static int getDayYear(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * 获取指定日期的星期
	 * 
	 * @param today
	 * @return
	 */
	public static int getDayWeek(Date aDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 获取某个日期是当月的第几天
	 * 
	 * @param today
	 * @return
	 */
	public static int getDayOfMonth(Date aDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 取两个日期的时间差
	 * 
	 * @param date1
	 *            起始日期
	 * @param date2
	 *            终点日期
	 * @return 负数代表起始日期比终点日期靠后 结果包含起始日期和终点日期
	 * @throws DateException 
	 */
	public static int getdaysbetween(String startDate, String endDate) throws Exception {
		if (null == startDate || startDate.length() != 8) {
			throw new Exception(startDate);
		}
		if (null == endDate || endDate.length() != 8) {
			throw new Exception(endDate);
		}
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date startD;
		try {
			startD = df.parse(startDate);
		} catch (ParseException e1) {
			throw new Exception(startDate);
		}
		Date endD;
		try {
			endD = df.parse(endDate);
		} catch (ParseException e1) {
			throw new Exception(endDate);
		}
		if (startD.after(endD)) {
			return (-1)*getdaysbetween(endDate, startDate) + 1;
		}
		int iYear = Integer.parseInt(startDate.substring(0, 4));
		int iMonth = Integer.parseInt(startDate.substring(4, 6)) - 1;
		int iDay = Integer.parseInt(startDate.substring(6, 8));
		GregorianCalendar ca1 = new GregorianCalendar(iYear, iMonth, iDay);

		iYear = Integer.parseInt(endDate.substring(0, 4));
		iMonth = Integer.parseInt(endDate.substring(4, 6)) - 1;
		iDay = Integer.parseInt(endDate.substring(6, 8));
		GregorianCalendar ca2 = new GregorianCalendar(iYear, iMonth, iDay);

		int year1 = ca1.get(Calendar.YEAR);
		int year2 = ca2.get(Calendar.YEAR);

		int dayofYear1 = ca1.get(Calendar.DAY_OF_YEAR);
		int dayofYear2 = ca2.get(Calendar.DAY_OF_YEAR);

		int ip = 0;
		
		for (int i = year1; i < year2; i++) {
			if (isLeapyear(i)) {
				ip = ip + 366;
			} else {
				ip = ip + 365;
			}
		}
		int temp = ip + (dayofYear2 - dayofYear1 + 1);
		return temp;
	}
	
	
	    public static void main(String[] args)
	    {
	        Calendar calendar = Calendar.getInstance();
	        Date date = new Date();
	        calendar.setTime(date);
	        calendar.add(Calendar.MONTH, 1);
	        date = calendar.getTime();
	        System.out.println(getSpecifiedFormatDate(date,"yyyyMMdd"));
	        
	    }

}
