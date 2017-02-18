<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author" content="LiangKim">
<title>应用服务器缓存清理</title>
<jsp:include page="../static/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">

		<jsp:include page="../static/navbar.jsp"></jsp:include>

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">服务器列表</div>

			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>ip</th>
						<th>port</th>
						<th>url</th>
						<th>interface</th>
						<th>status</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>1</th>
						<th>10.118.5.105</th>
						<th>80</th>
						<th>/psc110</th>
						<th>/cache/clear</th>
						<th>OK</th>
					</tr>
				</tbody>
			</table>
		</div>

	</div>

	<jsp:include page="../static/foot.jsp"></jsp:include>
</body>
</html>