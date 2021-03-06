<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../comm/include.inc.jsp"%>
<%

%>

<!doctype html>
<html>
<head> 
<%@ include file="../comm/basepath.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /><meta name = "viewport" content = "width = device-width, user-scalable = no,initial-scale=0.5,maximum-scale=0.5,minimum-scale=0.5">

<%@include file="../comm/link.inc.jsp" %>

<link rel="stylesheet" href="${oss_url}/static/mobile2018/css/reset.css?v=20181126201750" type="text/css"></link>
<link rel="stylesheet" href="${oss_url}/static/front/css/index/main.css?v=20181126201750" type="text/css"></link>
</head>
<body style="background:#1d2c43;">
	

<%@include file="../comm/header.jsp" %>


	<div class="container-full " style="min-height:810px; padding-top:100px;">
		<div class="container reset">
			<div class="col-xs-12 ">
				<p class="choose-title"><spring:message code="security.selectpassword" /></p>
			</div>
			<div class="col-xs-12 reset padding-top-30" align="center" style="margin-top: 0.5rem;">
				<div class="col-xs-5 col-xs-offset-1 text-center" >
					<span class="choose-body">
						<span class="choose-icon choose-icon-email"></span>
						<h3><spring:message code="security.retrievebyemail" /></h3>
						<h4><spring:message code="security.needtolog" /></h4>
						<a href="validate/resetEmail.html" class="btn btn-danger btn-find" style="width:67%;margin: 0 auto;margin-top: 0.3rem;"><spring:message code="security.retrieve" /></a>
					</span>
				</div>
				<div class="col-xs-5  text-center">
					<span class="choose-body">
						<span class="choose-icon choose-icon-phone"></span>
						<h3 class=""><spring:message code="security.retrievebyphone" /></h3>
						<h4><spring:message code="security.needmobile" /></h4>
						<a href="validate/resetPhone.html" class="btn btn-danger btn-find" style="width:67%;margin: 0 auto;margin-top: 0.3rem;"><spring:message code="security.retrieve" /></a>
					</span>
				</div>
			</div>
		</div>
	</div>


<%@include file="../comm/tabbar.jsp"%>
	<%@include file="../comm/footer.jsp" %>	
<script src="${oss_url}/static/mobile2018/js/fluckydraw/com.js?v=20181126201750"></script>
</body>
</html>
