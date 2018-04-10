package com.rs.framwork.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.util.Assert;

public class DateUtil {

	public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";

	public static final String PATTERN_DATE = "yyyy-MM-dd";
	
    /**
     * 时间转化成2009-05-07 00:00:00的格式
     *
     * @return comboList
     * @throws Exception
     */
    public static Date strToDate2(String value) throws Exception {
        if (value.split(" ").length == 1) {
            value += " 00:00:00";
        }
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date mydate = null;
        try {
            mydate = df2.parse(value);

        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return mydate;

    }
    /**
     * 时间转化成2009-05-07 00:00:00的格式
     *
     * @return comboList
     * @throws Exception
     */
    public static Date strToDate(String value){
        
        SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMdd");
        Date mydate = null;
        try {
            mydate = df2.parse(value);

        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return mydate;

    }
    
   public static Date standardDate(String value){
        value=value.replaceAll("\\-", "\\/");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date mydate = null;
        try {
            mydate = df2.parse(value);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return mydate;

    }
   
   public static Date standardMonth(String value){
	   value=value.replaceAll("\\-", "\\/");
	   SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
	   Date mydate = null;
	   try {
		   mydate = df2.parse(value);
	   } catch (java.text.ParseException e) {
		   e.printStackTrace();
	   }
	   return mydate;
	   
   }
    

	public static String timestamp2String(Timestamp timestamp, String pattern) {
		if (timestamp == null) {
			return "";
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date(timestamp.getTime()));
	}

	public static String date2String(java.util.Date date, String pattern) {
		if (date == null) {
			throw new java.lang.IllegalArgumentException("timestamp null illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Timestamp currentTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	public static String currentTimestamp2String(String pattern) {
		return timestamp2String(currentTimestamp(), pattern);
	}

	public static Timestamp string2Timestamp(String strDateTime, String pattern) {
		if (strDateTime == null || strDateTime.equals("")) {
			throw new java.lang.IllegalArgumentException("Date Time Null Illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(strDateTime);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return new Timestamp(date.getTime());
	}
	
	
	public static Date getStanderTime(String strDateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_STANDARD);
		Date date = null;
		try {
			date = sdf.parse(strDateTime);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return new Timestamp(date.getTime());
	}

	public static Date string2Date(String strDate, String pattern) {
		if (strDate == null || strDate.equals("")) {
			throw new RuntimeException("str date null");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = DateUtil.PATTERN_DATE;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;

		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	public static String stringToYear(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return String.valueOf(c.get(Calendar.YEAR));
	}

	public static String stringToMonth(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// return String.valueOf(c.get(Calendar.MONTH));
		int month = c.get(Calendar.MONTH);
		month = month + 1;
		if (month < 10) {
			return "0" + month;
		}
		return String.valueOf(month);
	}

	public static String stringToDay(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// return String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		int day = c.get(Calendar.DAY_OF_MONTH);
		if (day < 10) {
			return "0" + day;
		}
		return "" + day;
	}

	public static Date getFirstDayOfMonth(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = 1;
		c.set(year, month, day, 0, 0, 0);
		return c.getTime();
	}

	public static Date getLastDayOfMonth(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = 1;
		if (month > 11) {
			month = 0;
			year = year + 1;
		}
		c.set(year, month, day - 1, 0, 0, 0);
		return c.getTime();
	}

	public static String date2GregorianCalendarString(Date date) {
		if (date == null) {
			throw new java.lang.IllegalArgumentException("Date is null");
		}
		long tmp = date.getTime();
		GregorianCalendar ca = new GregorianCalendar();
		ca.setTimeInMillis(tmp);
		try {
			XMLGregorianCalendar t_XMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(ca);
			return t_XMLGregorianCalendar.normalize().toString();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			throw new java.lang.IllegalArgumentException("Date is null");
		}

	}

	public static boolean compareDate(Date firstDate, Date secondDate) {
		if (firstDate == null || secondDate == null) {
			throw new java.lang.RuntimeException();
		}

		String strFirstDate = date2String(firstDate, "yyyy-MM-dd");
		String strSecondDate = date2String(secondDate, "yyyy-MM-dd");
		if (strFirstDate.equals(strSecondDate)) {
			return true;
		}
		return false;
	}
	
	public static Date getStartTimeOfDate(Date currentDate) {
		Assert.notNull(currentDate);
		String strDateTime = date2String(currentDate,"yyyy-MM-dd") + " 00:00:00";
		return string2Date(strDateTime,"yyyy-MM-dd hh:mm:ss");
	}
	
	public static Date getEndTimeOfDate(Date currentDate) {
		Assert.notNull(currentDate);
		String strDateTime = date2String(currentDate,"yyyy-MM-dd") + " 59:59:59";
		return string2Date(strDateTime,"yyyy-MM-dd hh:mm:ss");
	}
	
	public static String getCurrentDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	public static String getCurrentDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(new Date());
	}
	public static String getCurrentDateTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		return df.format(new Date());
	}
	
	
	public static String getCurrentMonth(){
		 Calendar cale = null;  
		 // 获取当月第一天和最后一天  
	    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");  
	    String firstday;
	    // 获取前月的第一天  
	    cale = Calendar.getInstance();  
	    cale.add(Calendar.MONTH, 0);  
	    cale.set(Calendar.DAY_OF_MONTH, 1);  
	    firstday = format.format(cale.getTime()); 
	    return firstday;
	}
	
	
	
	
	public static void main(String[] args){
		/*String str1 = "2011-01-01";
		String str2 = "1988-09-09";
		Date date1 = DateUtil.string2Date(str1, "yyyy-MM-dd");
		Date date2 = DateUtil.string2Date(str2, "yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(date1);
		c2.setTime(date2);
		c2.add(Calendar.YEAR, 4);
		if (c2.before(c1)) {
			System.out.println("illegal");
		} else {
			System.out.println("ok");
		}*/
		//System.out.println(getCurrentDate());
		
		
		/*String value="2017-12/27 02:12:17";
		  value=value.replaceAll("\\-", "\\/");
		System.out.println(value);*/
		
		/*Date standerTime = getStanderTime("2017-12-21 15:20:10");
		
		System.out.println(standerTime);*/
		
	}
}