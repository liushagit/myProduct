<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
</head>
<body>
<form id="form" class="form"  method="post" action="g">
	<input type="hidden" id="cmd" name="cmd" value="u_L"/> 
	用户名：<input type="text" id="1" name="1" /> <br/>
	密  码：<input type="password" id="2" name="2" /> <br/>
	<input type="submit" value="登录" /> <a href="/p?u_R">注册</a><br/>
</form >

</body>
</html>