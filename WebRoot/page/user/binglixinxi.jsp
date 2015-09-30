<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="../page/user/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="../page/user/style/authority/common_style.css" rel="stylesheet" type="text/css">

<title>病例信息</title>
<script type="text/javascript">
	
function show(dis){
document.getElementById('pp').innerHTML="<p>"+dis+"</p>";

document.getElementById('popup').style.display='block';

button2.onclick=function(){
document.getElementById('popup').style.display='none';
}
}

</script>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	 
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container">
			<div class="ui_content">     
				<div class="ui_tb">
					<table class="table" id="mytable" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" onClick="selectOrClearAllCheckbox(this);" />
							</th>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th>疾病类型</th>
							<th>病情状态</th>
							<th>健康报告</th>
							<th>会诊日期</th>
							<th>操作</th>
						</tr>
						<c:forEach var="showBingliDate" items="${showBingliDates1 }">
							<tr>
								<td><input type="checkbox" name="IDCheck" value="14458579642011" class="acb" /></td>
								<td>${showBingliDate.u_name }</td>
								<td>${showBingliDate.u_sex }</td>
                                <td>${showBingliDate.u_age }</td>
								<td>${showBingliDate.cond }</td>
								<td>${showBingliDate.state }</td>
								<td>${showBingliDate.report_name }</td>
                                <td>${showBingliDate.d_date }</td>
                                <td>
                                    <a  onClick="show('${showBingliDate.report }')" href="#">诊断</a>
                                    <form action="<%=basePath %>/diagnose/deldiagnose.do">
                                    <input style="display: none" name="deldiagparm" value="${showBingliDate.dia_id }">
                                  	<input type="submit" value="删除" onclick="return confirm('你确定要删除吗？')">
                                    </form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	
 <!-------------------------------------popup开始------------------------------------------>
<div id="popup" >
	<div class="popup-dia"></div>
	
<div class="popup-con" id="popup-con">
		<h2>病情分析<img id="button2" src='../page/user/images/common/cha.jpg' style="float:right;margin-top:5px;margin-right:5px;"></h2>
        <div class="abc" id="pp">
    </div>
  </div>
</div>
<!-------------------------------------popup结束------------------------------------------>
<div style="display:none"></div>
</body>
</html>

