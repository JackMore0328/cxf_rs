package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class HttpClientTest {
	 public static final String BASE_URI = "http://124.113.18.234:10000/jax_rs/cxf/restful/";
	 public static final String resource = "post/3";
	@Test
	public void testCxf() throws Exception{
		
		
		//URL url = new URL(BASE_URI+ resource);
		URL url = new URL("http://124.113.0.62:10000/cxf_rs/cxf/restful/notify");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");// 提交模式
		conn.setDoInput(true);// 是否允许输入
		conn.setDoOutput(true);// 是否允许输出
		// 设置请求头里面的数据，以下设置用于解决http请求code415的问题
		conn.setRequestProperty("Content-Type", "application/json");
		//conn.setRequestProperty("connection", "Keep-Alive");
		conn.connect();
		OutputStreamWriter writer = new OutputStreamWriter( conn.getOutputStream());
		String data="id=1";
		writer.write(data);// 发送参数
		writer.flush();// 清理当前编辑器的左右缓冲区，并使缓冲区数据写入基础流
		int code = conn.getResponseCode();
		System.out.println("得到响应---》"+code);
		// 读取方式2
		BufferedReader reader = new BufferedReader(new InputStreamReader( conn.getInputStream()));
		String lines = reader.readLine();// 读取请求结果
		reader.close();
		System.out.println("输出为---》"+lines);

		conn.disconnect();
	}
}
