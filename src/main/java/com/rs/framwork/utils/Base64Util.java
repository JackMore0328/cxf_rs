package com.rs.framwork.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class Base64Util {
	public static final String DATA = "祖国你好！";

	public static void main(String[] args) throws Exception {
		String base64Result = Base64Util.encryptBase64(DATA.getBytes());
		System.out.println(DATA + "  >>>Base64>>>" + base64Result);
		String base64String = Base64Util.decryptBase64(base64Result);
		System.out.println(base64Result + "  >>>Base64>>>" + base64String);
	}

	/**
	 * base64加密
	 * 
	 * @Description:
	 * @Title: encryptBase64
	 * @Company: DOOR
	 * @author jiangwenwu
	 * @date 2017年11月24日下午2:17:19
	 */
	public static String encryptBase64(byte[] data) {
		return new BASE64Encoder().encode(data);

	}

	/**
	 * base64解密
	 * 
	 * @Description:
	 * @Title: decryptBase64
	 * @Company: DOOR
	 * @author jiangwenwu
	 * @date 2017年11月24日下午2:17:33
	 */
	public static String decryptBase64(String data) throws IOException {
		byte[] resultBytes = new BASE64Decoder().decodeBuffer(data);
		return new String(resultBytes);
	}

	
	public static byte[] base64Decode(String input) {

		BASE64Decoder decoder = new BASE64Decoder();
		try {
			return decoder.decodeBuffer(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String ClobToString(Clob clob) throws SQLException, IOException {

		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine().trim();
		StringBuffer sb = new StringBuffer();
		// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成String
		while (s != null) {
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}

	public static byte[] BlobToByte(Blob blob) throws SQLException, IOException {

		InputStream inStream = blob.getBinaryStream();
		byte[] data = null;
		long nLen = blob.length();
		int nSize = (int) nLen;
		data = new byte[nSize];
		inStream.read(data);
		inStream.close();
		return data;
	}

}