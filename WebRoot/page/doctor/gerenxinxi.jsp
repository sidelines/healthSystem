<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
<title>个人信息</title>
</head>
<body>
			<div class="ui_content">
            <p style="font:'Times New Roman', Times, serif; font-size:large; color:#0066FF; margin-bottom:10px;">基本信息</p>
				<div class="ui_tb" align="center">
					<c:forEach var="DoctorInfo" items="${DoctorInfos }">
					<p style="font:'Times New Roman', Times, serif; font-size:small; color:#999999; margin-bottom:15px;">账号：${DoctorInfo.d_username }</p>
                    <p style="font:'Times New Roman', Times, serif; font-size:small; color:#999; margin-bottom:15px;">姓名：${DoctorInfo.d_name }</p>
                    <p style="font:'Times New Roman', Times, serif; font-size:small; color:#999; margin-bottom:15px;">性别：${DoctorInfo.d_sex }</p>
                    <p style="font:'Times New Roman', Times, serif; font-size:small; color:#999; margin-bottom:15px;">年龄：${DoctorInfo.d_age }</p>
                     <p style="font:'Times New Roman', Times, serif; font-size:small; color:#999; margin-bottom:15px;">主治病症：${DoctorInfo.indications }</p>
                    </c:forEach>
				</div>
			</div>
</body>
</html>
