package com.rs.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.rs.framwork.baseConfig.BaseModel;

@XmlRootElement(name = "StudentInfo")
public class Student extends BaseModel<Student> {
	private static final long serialVersionUID = -8307041625389543390L;

	private int age;

	private String name;

	public Student() {
		super();
	}

	public Student(int age, String name) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
