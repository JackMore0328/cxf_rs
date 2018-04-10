package com.rs.framwork.baseConfig;

import java.io.Serializable;

import org.springframework.web.servlet.ModelAndView;

public class ResultCode implements Serializable{

	private static final long serialVersionUID = -6609852879286350608L;
	public static final int SUCCESSCODE = 1;
	public static final int ERRORCODE = 0;
	public static final String SUCCESSMSG = "success";
	public static final String ERRORMSG = "false";
	public static final String view_404 = "false";
	public static final String view_500 = "false";

	/* 0 失败 1 成功 */
	public int statusCode;
	public String message;
	/* 跳转视图 */
	public String viewName;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public ModelAndView ajaxDone(int statusCode, String message) {
		ModelAndView mav = new ModelAndView("ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		return mav;
	}

	public ResultCode() {
		super();
	}

	public ResultCode(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public ResultCode(int statusCode, String message, String viewName) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.viewName = viewName;
	}
	
	
}
