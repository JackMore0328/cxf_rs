package com.rs.model;

import com.rs.framwork.baseConfig.BaseModel;
/**
 * 生成二维码记录请求参数
* @Description: 
* @Title: TradeReq.java
* @Company: DOOR
* @author jiangwenwu
* @date 2018年4月2日上午10:17:45
 */
public class TradeReq extends BaseModel<TradeReq> {

	private static final long serialVersionUID = 1245453313134L;

	/* 商户网站订单系统中唯一订单号 */
	private String outTradeNo;
	/* 订单名称 */
	private String subject;
	/* 付款金额:单位为元，精确到小数点后2位 */
	private Double totalAmount;
	/* 不可打折金额 单位为元，精确到小数点后2位 */
	private Double undiscountableAmount;
	/* 付款条码 */
	private String authCode;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getUndiscountableAmount() {
		return undiscountableAmount;
	}

	public void setUndiscountableAmount(Double undiscountableAmount) {
		this.undiscountableAmount = undiscountableAmount;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	@Override
	public String toString() {
		return "TradeReq [outTradeNo=" + outTradeNo + ", subject=" + subject + ", totalAmount=" + totalAmount
				+ ", undiscountableAmount=" + undiscountableAmount + ", authCode=" + authCode + "]";
	}

	
}
