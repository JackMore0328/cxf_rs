package com.rs.service.trade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.model.TradeStatus;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.google.common.base.Preconditions;
import com.rs.framwork.baseConfig.ResultCode;
import com.rs.framwork.baseConfig.ResultFactory;
import com.rs.framwork.baseConfig.TradeEnumStatus;
import com.rs.framwork.utils.Common;
import com.rs.framwork.utils.QRUtil;
import com.rs.model.TradeReq;

@Service
public class AliTradePayServiceImpl implements AliTradePayService {

	// 日志记录
	@Override
	public ResultCode dealAliTradeReqReturnQr(HttpServletRequest request,TradeReq tradereq) {
		 Preconditions.checkArgument(tradereq.getOutTradeNo() != null, "请求参数不能为空!", tradereq);
		
		ResultCode resultcode = ResultFactory.createSuccessResultCode();
		TradeEnumStatus tEnumStatus = tradeByAliPayEn(tradereq);
		int statusCode = tEnumStatus.getStatusCode();
		if(statusCode!=1){
			String fileName = QRUtil.generateImg(request, tEnumStatus.getMessage());
			resultcode.setMessage(fileName);
		}else{
			resultcode = ResultFactory.create500ResultCode();
		}
		return resultcode;
	}

	@Override
	public ResultCode dealAliTradeByQr(HttpServletRequest req,TradeReq tradereq) {

		return null;
	}

	/**
	 * 支付宝被扫
	 * @Description:
	 * @Title: tradeByAliPayEn
	 * @Company: DOOR
	 * @author jiangwenwu
	 * @date 2018年4月2日上午11:45:02
	 */
	public TradeEnumStatus tradeByAliPayEn(TradeReq tradereq) {
		TradeEnumStatus tradeEnumStatus =TradeEnumStatus.SUCCESS;
		AlipayTradeService tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();
		Double total = tradereq.getTotalAmount();
		String totalAmount = total.toString();
		String outTradeNo = tradereq.getOutTradeNo();

		AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder()
				.setSubject("订单号-" + outTradeNo).setTotalAmount(totalAmount).setOutTradeNo(outTradeNo).setSellerId("")
				.setBody(" ").setStoreId("001").setTimeoutExpress("120m").setNotifyUrl(Common.getAliConfig("notify"));
		AlipayF2FPrecreateResult res = tradeService.tradePrecreate(builder);
		TradeStatus tradeStatus = res.getTradeStatus();
		switch (tradeStatus) {
		case SUCCESS:
			logger.info("支付宝预下单成功: )");
			AlipayTradePrecreateResponse response = res.getResponse();
			TradeEnumStatus.SUCCESS.setMessage(response.getQrCode());
			break;

		case FAILED:
			tradeEnumStatus=TradeEnumStatus.FAILED;
			logger.info("支付宝预下单失败!!!");
			break;

		case UNKNOWN:
			tradeEnumStatus=TradeEnumStatus.UNKNOWN;
			logger.info("系统异常，预下单状态未知!!!");
			break;

		default:
			tradeEnumStatus=TradeEnumStatus.UNKNOWN;
			logger.info("不支持的交易状态，交易返回异常!!!");
			break;
		}
		return tradeEnumStatus;
	}

}
