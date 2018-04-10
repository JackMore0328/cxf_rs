<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/include.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>扫码支付</title>
 <link rel="stylesheet" href="resources/css/tradepay.css">
</head>
	<div id="main">
		<div id="head">
            <span class="title">支付宝 当面付2.0 条码支付接口</span>
		</div>
        <div class="cashier-nav">
            <ol>
				<li class="current">1、确认信息 →</li>
				<li>2、点击确认 →</li>
				<li class="last">3、确认完成</li>
            </ol>
        </div>
        <form name=alipayment action="trade/toQrJsp" method=post target="_blank">
            <div id="body" style="clear:left">
                <dl class="content">
					<dt>商户订单号：</dt>
					<dd>
						<span class="null-star">*</span>
						<input size="30" name="outTradeNo" />
						<span>商户网站订单系统中唯一订单号，必填</span>
					</dd>
					<dt>订单名称：</dt>
					<dd>
						<span class="null-star">*</span>
						<input size="30" name="subject" />
						<span>必填</span>
					</dd>

                    <dt>付款金额：</dt>
                    <dd>
                        <span class="null-star">*</span>
                        <input size="30" name="totalAmount" />
                        <span>必填,单位为元，精确到小数点后2位</span>
                    </dd>

					<dt>不可打折金额：</dt>
					<dd>
						<span class="null-star">*</span>
						<input size="30" name="undiscountableAmount" />
						<span>可填,单位为元，精确到小数点后2位</span>
					</dd>
					
					<dt>付款条码：</dt>
					<dd>
						<span class="null-star">*</span>
						<input size="30" name="authCode" />
						<span>必填</span>
					</dd>

                    <dt></dt>
                    <dd>
                        <span class="new-btn-login-sp">
                            <button class="btn btn-primary" type="submit" style="text-align:center;">确 认</button>
                        </span>
                    </dd>
                </dl>
            </div>
		</form>
        <div id="foot">
			<ul class="foot-ul">
				<li><font class="note-help">如果您点击“确认”按钮，即表示您同意该次的执行操作。 </font></li>
			</ul>
		</div>
	</div>
<script type="text/javascript"  src="resources/js/jQuery-2.2.0.min.js"></script>

</html>