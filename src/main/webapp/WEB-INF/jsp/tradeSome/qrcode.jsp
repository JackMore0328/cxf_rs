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
<script type="text/javascript"  src="resources/js/jQuery-2.2.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>二维码生成页面</title>
<style>
.content {
	text-aline: center
}

.div {
	margin-left: 10px;
	margin-top: 10px
}
</style>
</head>
<body>

	<input type="hidden" id="filename" value="${perfixName}">
	<div class="content" style="width: 10%; height: 10%; text-align: center">
	      支付二维码 用支付宝扫一扫支付
		<img id="qrImg" style="width: 100%" src="files/${perfixName}.png" alt="qrcode">
	</div>
</body>




</html>