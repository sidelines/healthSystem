<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>文件上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/UploadServlet3" method="post" enctype="multipart/form-data">
    	用户名:<input type="text" name="username"/><br/>
    	文件1:<input type="file" name="f1"/><br/>
    	文件2:<input type="file" name="f2"/><br/>
    	<input type="submit" value="保存"/>
    </form>
  </body>
</html>
