package com.rs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rs.framwork.baseConfig.ResultCode;
import com.rs.model.TradeReq;
import com.rs.service.trade.AliTradePayService;

@Controller
@RequestMapping("/trade")
public class TradePayController {

	@Autowired
	private AliTradePayService alitradePayService;
	
	@RequestMapping("/toQrJsp")
	public ModelAndView toQrJsp(HttpServletRequest request,TradeReq tradereq){
		ModelAndView mav = new ModelAndView();
		System.out.println(tradereq);
		ResultCode resultCode = alitradePayService.dealAliTradeReqReturnQr(request,tradereq);
		int statusCode = resultCode.getStatusCode();
		switch (statusCode) {
		case ResultCode.SUCCESSCODE:
			mav.setViewName("tradeSome/qrcode");
			break;

		default:
			mav.setViewName(resultCode.getViewName());
			break;
		}
		String message = resultCode.getMessage();
		mav.addObject("perfixName", message);
		return mav;
	}
}
