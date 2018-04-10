package com.rs.framwork.baseConfig;

/**
 * @Description: 支付状态枚举
 * @Title: TradeEnum.java
 * @Company: DOOR
 * @author jiangwenwu
 * @date 2018年4月10日上午11:15:06
 */
public enum TradeEnumStatus {
	SUCCESS(1, "支付成功"), FAILED(0, "支付失败"), UNKNOWN(-1, "未知错误");
	/* 0 失败 1 成功 */
	public int statusCode;
	public String message;

	private TradeEnumStatus(int statusCode, String message) {
		this.message = message;
		this.statusCode = statusCode;
	}

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

}
