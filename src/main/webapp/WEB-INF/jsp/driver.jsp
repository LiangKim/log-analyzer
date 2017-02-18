<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="导航界面">
<meta name="author" content="LiangKim">
<title>导航</title>
<jsp:include page="static/head.jsp"></jsp:include>
</head>
<body>

	<div class="container">

		<jsp:include page="static/navbar.jsp"></jsp:include>

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>分析与管理工具</h1>
			<p>这个网站用于110应用系统的BUG排查以及常用的部署</p>
		</div>
		
	</div>
	<jsp:include page="static/foot.jsp"></jsp:include>
</body>
</html>