package com.rs.framwork.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.Random;

public class Common {
	private static Random random = new Random();
	private static final int ID_BYTES = 10;

	public static String getPro(String name) {
		String value = null;
		try {
			Properties pro = new Properties();
			InputStream in = Common.class.getClassLoader().getResourceAsStream("config.properties");
			pro.load(in);
			value = pro.getProperty(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String getConfig(String name) {
		String value = null;
		try {
			Properties pro = new Properties();
			InputStream in = Common.class.getClassLoader().getResourceAsStream("config.properties");
			pro.load(in);
			value = pro.getProperty(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String getAliConfig(String name) {
		String value = null;
		try {
			Properties pro = new Properties();
			InputStream in = Common.class.getClassLoader().getResourceAsStream("zfb.properties");
			pro.load(in);
			value = pro.getProperty(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String getConfigPropertites(String configName, String propertiesName) {
		String value = null;
		try {
			Properties pro = new Properties();
			InputStream in = Common.class.getClassLoader().getResourceAsStream(configName);
			pro.load(in);
			value = pro.getProperty(propertiesName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void writeFile(String name, String content) {

		String path = System.getProperty("user.dir") + "\\src\\" + name;
		System.out.println("path" + path);
		try {

			// ObjectOutputStream out=new ObjectOutputStream(new
			// FileOutputStream("E:\\person.txt"));
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(name), "gbk");
			// FileOutputStream fos = new FileOutputStream("E:\\person.txt");
			// ObjectOutputStream oos = new ObjectOutputStream(fos);
			out.write(content);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String readFile(String name) {
		// InputStream in =
		// Common.class.getClassLoader().getResourceAsStream(name);
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(new File(name)));
			String tempString = null;

			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString + "\r\n");
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		System.out.println("sb" + sb);
		return new String(sb);

	}

	/**
	 * 生成唯一ID
	* @Description: 
	* @Title: generateId
	* @Company: DOOR
	* @author jiangwenwu
	* @date 2018年4月4日下午3:04:47
	 */
	public synchronized static String generateId() {
		StringBuffer result = new StringBuffer();
		result = result.append(System.currentTimeMillis());
		for (int i = 0; i < ID_BYTES; i++) {
			result = result.append(random.nextInt(10));
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(Common.readFile("log.txt") + "path" + System.getProperty("user.dir"));
		Common.writeFile("log.txt", "rewry");
	}
}
