package com.rs.service.webservice_rs;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.rs.framwork.utils.Common;
import com.rs.model.Student;

public class Rs_Service_Impl implements Rs_Service {

	@Override
	public Student get(String id) {
		System.out.println("GET方法，id=" + id);
		Student user = new Student(1, "jww");
		return user;
	}

	@Override
	public Student put(String id) {
		System.out.println("PUT方法，id=" + id );
		Student user = new Student(1, "jww");
		return user;
	}

	@Override
	public Student post(String id) {
		System.out.println("POST方法，id=" + id );
		Student user = new Student(1, "jww");
		return user;
	}

	@Override
	public Student delete(String id) {
		System.out.println("DELETE方法，id=" + id);
		Student user = new Student(1, "jww");
		return user;
	}

	@Override
	public String getAPI(String req) {
		System.out.println("请求内容" + req);
		String ret = "receive 、  good  job " + "可以尝试在URL后面加上？req={你写的内容}" + "就会给你返回---->" + req;
		return ret;
	}

	@Override
	public String postApi(String req) {
		System.out.println("请求内容" + req);
		return req;
	}

	@Override
	public String notify(String request) {
		try {
			String callbackRequset = URLDecoder.decode(request, "utf-8");
			Map<String, String> data = new HashMap<String, String>();
			String[] splitdata = callbackRequset.split("&");
			for(int i=0, length=splitdata.length;i<length;i++){
				String str = splitdata[i];
				if(str.contains("sign=")){
					data.put("sign", str.substring("sign=".length()));
				}else{
					String[] s = str.split("=");
					data.put(s[0],s[1]);
				}
				
			}
			// 验签是否通过
			boolean rsacheckv1 = AlipaySignature.rsaCheckV1(data, Common.getAliConfig("alipay_public_key"), "UTF-8", "RSA2");
			if(rsacheckv1){
				System.out.println("支付成功！");
			}else{
				System.out.println("支付失败！");
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return "yes";
	}
	

}
