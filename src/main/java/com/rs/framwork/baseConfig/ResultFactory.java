package com.rs.framwork.baseConfig;

import com.google.gson.Gson;

public class ResultFactory {

	public static ResultCode createSuccessResultCode() {
		return new ResultCode(ResultCode.SUCCESSCODE, ResultCode.SUCCESSMSG);
	}

	public static ResultCode createFailResultCode() {
		return new ResultCode(ResultCode.ERRORCODE, ResultCode.ERRORMSG);
	}

	public static ResultCode create404ResultCode() {
		return new ResultCode(ResultCode.ERRORCODE, ResultCode.ERRORMSG, ResultCode.view_404);
	}

	public static ResultCode create500ResultCode() {
		return new ResultCode(ResultCode.ERRORCODE, ResultCode.ERRORMSG, ResultCode.view_500);
	}
	
	public static Gson createGson() {
		return 	new Gson();
	}
	
	

}
