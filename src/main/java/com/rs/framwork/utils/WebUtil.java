package com.rs.framwork.utils;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class WebUtil {
	
	public static String WebServiceUrl = Common.getPro("ecardwebservice");
	
	/**
	 * 配置文件
	 */
	public static ResourceBundle resources = null;

	/**
	 * 字符串obj为空或"",则返回style
	 * 
	 * @param obj
	 * @param style
	 * @return
	 */
	public static String null2String(String obj, String style) {
		if (obj == null || obj.equals("")) {
			if (!style.equals(""))
				return style;
			else
				return "";
		}
		return obj;
	}

	/**
	 * 将null字符串转化成空字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String null2String(String obj) {
		if (obj == null) {
			return "";
		}
		return obj;
	}

	/**
	 * 将null转化成0
	 * 
	 * @param obj
	 * @return
	 */
	public static int null2String(Integer obj) {
		if (obj == null) {
			return 0;
		}
		return obj;
	}
    
	/**
	 * 将null转化成0
	 * @param obj
	 * @return
	 */
	public static int null20(Integer obj) {
		if (obj == null) {
			return 0;
		}
		return obj;
	}
	/**
	 * 对字符串补空格（右补）
	 * 
	 * @param obj
	 * @param len
	 *            期望长度
	 * @return
	 */
	public static String zhString(Object obj, int len) {
		String rs = "";
		int lenght = 0;
		try {
			if (obj != null) {
				lenght = obj.toString().getBytes("GBK").length;
				lenght = len - lenght;
			} else {
				obj = "";
				lenght = len;
			}
			rs += "" + new String(obj.toString().getBytes("GBK"), "GBK");

			for (int i = 0; i < lenght; i++) {
				rs += " ";
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return zhString(null, len);
		}
		return rs;
	}

	/**
	 * 对整数补0（左补）
	 * 
	 * @param obj
	 * @param len
	 *            期望长度
	 * @return
	 */
	public static String zhInt(Integer obj, int len) {
		String rs = "";
		int lenght = 0;
		if (obj == null) {
			obj = 0;
			lenght = len - 1;
		} else {
			lenght = (obj + "").length();
			lenght = len - lenght;
		}
		for (int i = 0; i < lenght; i++) {
			rs += "0";
		}
		rs += "" + obj;
		return rs;
	}

	/**
	 * 对数组截取并返回字符串（GBK）
	 * 
	 * @param obj
	 * @param start
	 * @param end
	 * @return
	 */
	public static String getByte(byte[] obj, int start, int end) {
		String rs = "";
		byte[] b = new byte[end - start];
		for (int i = start; i < end; i++) {
			b[i - start] = obj[i];
		}
		try {
			rs = new String(b, "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 对字符串截取并返回字符串数组（GBK）
	 * 
	 * @param json
	 * @param lens
	 *            参数长度数组
	 * @return
	 */
	public static String[] getByte2(String json, int[] lens) {
		String[] rs = new String[lens.length];
		int indexo = 0;// 起始索引
		try {
			byte[] b = json.getBytes("GBK");
			for (int i = 0; i < lens.length; i++) {
				byte[] bb = new byte[lens[i]];
				for (int k = indexo; k < indexo + lens[i]; k++) {
					bb[k - indexo] = b[k];
				}
				indexo += lens[i];
				rs[i] = new String(bb, "GBK").trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}

	/**
	 * 判断是否超时
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isTimeout(String date) {
		if (resources == null) {
			resources = ResourceBundle.getBundle("config");
		}
		Integer timeOut = Integer.valueOf(null2String(resources
				.getString("time-out"), "0"));
		if (timeOut <= 0)// 没有超时限制
			return false;
		if (date != null && !date.equals("")) {
			Timestamp stam = DateUtil.string2Timestamp(date, "yyyyMMddHHmmss");
			long time = stam.getTime();
			if (System.currentTimeMillis() - time >= timeOut * 60 * 1000) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 清除sql语句最后的逗号,如果最后一个字符是逗号
	 * 
	 * @param sql
	 * @return
	 */
	public static String clean(String sql) {
		if (sql != null && !sql.equals("")) {
			if (sql.lastIndexOf(",") == sql.length() - 1) {
				sql = sql.substring(0, sql.length() - 1);
			}
		}
		return sql;
	}
  
}
