package com.rs.framwork.baseConfig;

import java.io.Serializable;
import java.util.List;

public class BaseModel<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private T t;
	private List<T> list;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
