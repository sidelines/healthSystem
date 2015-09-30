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

<link href="../page/user/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="../page/user/style/authority/common_style.css" rel="stylesheet" type="text/css">

<title>数据监测</title>
<script type="text/javascript">
	
function show(){
	
	document.getElementById('popup').style.display='block';
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
            <a style="font:'Times New Roman', Times, serif; font-size:large; color:#0066FF; margin-bottom:10px;">数据采集</a>
            <a style="float:right;font:'Times New Roman', Times, serif; font-size:large; color:#0066FF;margin-bottom:10px;" onClick="show()" href="#">发布</a>
            
				<div class="ui_tb">
					<table class="table" id="mytable" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" onClick="selectOrClearAllCheckbox(this);" />
							</th>
							<th>发布日期</th>
							<th>咨询问题</th>
							<th>咨询医生</th>
							<th>问题描述</th>
							<th>操作</th>
						</tr>
							<c:forEach var="showcontext" items="${showcontexts }">
							
							
							
							<tr>
								<td><input type="checkbox" name="IDCheck" value="14458579642011" class="acb" /></td>
								<td>${showcontext.t_date }</td>
								<td>${showcontext.title }</td>
								<td>${showcontext.doctorname }</td>
								<td>${showcontext.context }</td>
								<td>
								<form action="<%=basePath %>/title/deltitleuser.do" method="post">
								<input hidden="display:none" id="text1" name="delparm" type="text" value="${showcontext.t_id}" >
								<input type="submit" value="删除" onclick="return confirm('你确定要删除吗？')">
								
								</form>
								<!--<a href="javascript:del('14458579642011');">删除</a>  -->
								</td>
							</tr>
							</c:forEach>
							<!-- 删除功能重新做一个表单，循环出一个隐藏数据，讲该数据提交到表单 -->
						
					</table>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						共有
						<span class="ui_txt_bold04">90</span>
						条记录，当前第
						<span class="ui_txt_bold04">1
						/
						9</span>
						页
					</div>
					<div class="ui_frt">
						<!--    如果是第一页，则只显示下一页、尾页 -->
						
							<input type="button" value="首页" class="ui_input_btn01" />
							<input type="button" value="上一页" class="ui_input_btn01" />
							<input type="button" value="下一页" class="ui_input_btn01"
								onclick="jumpNormalPage(2);" />
							<input type="button" value="尾页" class="ui_input_btn01"
								onclick="jumpNormalPage(9);" />
						
						
						
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01" />页
							 <input type="button" class="ui_input_btn01" value="跳转" onClick="jumpInputPage(9);" />
					</div>
				</div>
			</div>
            
            
		</div>
 <!-------------
 
 ------------------------popup开始------------------------------------------>
<div id="popup" >
	<div class="popup-dia"></div>
<div class="popup-con" id="popup-con">
		<h2>数据采集</h2>
        <div class="abc">
                <form action="<%= basePath%>title/addcontext.do" method="post">
                
                   <div class="text">
                      <label class="user label">标题</label>
                      <div class="text-input">
                        <input type="text" name="title" value="">
                      </div>
                   </div>
                   
                   <div class="text">
                      <label class="user label">诊治医生</label>
                      
                         <select name="doctor" id="#" class="#">
                                <option value="">--请选择--</option>
                                <option value="张三">张三</option>
                                <option value="李四">李四</option>
                                <option value="王五">王五</option>
                            </select>
                     
                   </div>
                   
                     <div class="text">
                      <label class="user label">内容</label>
                      <div class="text-input">
                        <textarea  name="context" rows=10 cols=40></textarea>
                      </div>
                   </div>
                   
                   <div class="text">
                      <div class="text-input">
                        <input class="btn" type="submit" value="确认">
                         <button class="btn" href="#" id="myfault" onClick="document.getElementById('popup').style.display='none';">取消</button>                      
                         </div>
                   </div>
                </form>
    </div>
  </div>
</div>
<!-------------------------------------popup结束------------------------------------------>
<div style="display:none"></div>
</body>
</html>
