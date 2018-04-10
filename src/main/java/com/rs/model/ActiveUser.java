package com.rs.model;

import com.rs.framwork.baseConfig.BaseModel;

public class ActiveUser extends BaseModel<ActiveUser>{

	private static final long serialVersionUID = 1234565464L;
	private String userid;//用户id（主键）
	private String usercode;// 用户账号
	private String username;// 用户名称
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	//private List<SysPermission> menus;// 菜单
	//private List<SysPermission> permissions;// 权限
	
}
