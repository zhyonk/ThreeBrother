<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>登录</title>
<link rel="stylesheet" href="<%=basePath%>css/layui.css"
	media="all" />
<script type="text/javascript" src="<%=basePath%>js/sweet-alert.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/sweet-alert.css">
<link rel="stylesheet" href="<%=basePath%>css/login.css" />

</head>

<body class="beg-login-bg">
	<div class="beg-login-box">
		<header>
			<h1>后台登录</h1>
		</header>
		<div class="beg-login-main">
			<form class="layui-form" method="post">
				<div class="layui-form-item">
					<label class="beg-login-icon"> <i class="layui-icon">&#xe612;</i>
					</label> <input type="text" name="username" lay-verify="userName"
						autocomplete="off" placeholder="这里输入登录名" class="layui-input">
				</div>
				<div class="layui-form-item">
					<label class="beg-login-icon"> <i class="layui-icon">&#xe642;</i>
					</label> <input type="password" name="password" lay-verify="password"
						autocomplete="off" placeholder="这里输入密码" class="layui-input">
				</div>
				<div class="layui-form-item">
					<div class="beg-pull-left beg-login-remember">
						<label>记住帐号？</label> <input type="checkbox" name="rememberMe"
							value="true" lay-skin="switch" checked title="记住帐号">
					</div>
					<div class="beg-pull-right">
						<button class="layui-btn layui-btn-primary" lay-filter="login">
							<i class="layui-icon">&#xe650;</i> 登录
						</button>
					</div>
					<div class="beg-clear"></div>
				</div>
			</form>
		</div>
		<footer>
			<p>后台登录 © www.zhyonk.com</p>
		</footer>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/layui.js"></script>
	<script>

		layui.use([ 'layer', 'form' ], function() {
			var layer = layui.layer, $ = layui.jquery, form = layui.form();
			
			form.on('submit(login)', function(data) {
				$.ajax({
					  type: 'POST',
					  url: '<%=basePath%>login',
					  async:false,
					  data: data.field,
					  dataType:'html',
				});
					
			});});
	</script>
</body>

</html>