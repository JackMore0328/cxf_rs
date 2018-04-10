package com.rs.framwork.utils;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.rs.model.Student;

/**
 * 科目获取接口
 * 
 * @Description:
 * @Title: AccMaps.java
 * @Company: DOOR
 * @author jiangwenwu
 * @date 2017年12月21日上午11:23:40
 */
public interface MyMaps {
	// 这个是省立医院的
	final static Map<String, Student> STUDENT_MAP = new ImmutableMap.Builder<String, Student>()
			.put("jww", new Student(1, "jww")).put("xjp", new Student(2, "xjp")).put("lwj", new Student(3, "lwj"))
			.build();

}
