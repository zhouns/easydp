<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>欢迎页面</title>
	<jsp:include page="../common/inc-head.jsp"></jsp:include>
</head>

<body>
	<div class="wrapper-page">
		<div class="panel panel-color panel-primary panel-pages">
			<div class="panel-heading bg-img">
				<div class="bg-overlay"></div>
				<h3 class="text-center m-t-10 text-white">
					后台登录
				</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal m-t-20" action="admin/login" method="post">
					<div class="form-group">
						<div class="col-xs-12">
							<input class="form-control input-lg" type="text" placeholder="账号">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-xs-12">
							<input class="form-control input-lg" type="password" placeholder="密码">
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-12">
							<div class="checkbox checkbox-primary">
								<input id="checkbox-signup" type="checkbox" checked="checked"> 
								<label for="checkbox-signup"> 记住我 </label>
							</div>
						</div>
					</div>

					<div class="form-group text-center m-t-40">
						<div class="col-xs-12">
							<button class="btn btn-block btn-primary btn-lg w-lg waves-effect waves-light" type="submit">登&nbsp;&nbsp;录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- END wrapper -->

	<jsp:include page="../common/inc-script.jsp"></jsp:include>
</body>
</html>