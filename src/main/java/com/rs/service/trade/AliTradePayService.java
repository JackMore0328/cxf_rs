package com.rs.service.trade;

import javax.servlet.http.HttpServletRequest;

import com.rs.framwork.baseConfig.BaseService;
import com.rs.framwork.baseConfig.ResultCode;
import com.rs.model.TradeReq;

public interface AliTradePayService extends BaseService {

	public ResultCode dealAliTradeReqReturnQr(HttpServletRequest req,TradeReq tradereq);
	
	public ResultCode dealAliTradeByQr(HttpServletRequest req,TradeReq tradereq);
	
}
