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
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="resource/images/favicon_1.ico">
	<title>登录平台</title>
	
	<!-- Base Css Files -->
	<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
	
	<!-- Font Icons -->
	<link href="resource/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
	<link href="resource/assets/ionicon/css/ionicons.min.css" rel="stylesheet" />
	<link href="resource/css/material-design-iconic-font.min.css" rel="stylesheet">
	
	<!-- animate css -->
	<link href="resource/css/animate.css" rel="stylesheet" />
	
	<!-- Waves-effect -->
	<link href="resource/css/waves-effect.css" rel="stylesheet">
	
	<!-- Custom Files -->
	<link href="resource/css/helper.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/style.css" rel="stylesheet" type="text/css" />
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
	
	<script src="resource/js/modernizr.min.js"></script>
</head>

<body>
	<div class="wrapper-page">
		<div class="panel panel-color panel-primary panel-pages">
			<div class="panel-heading bg-img">
				<div class="bg-overlay"></div>
				<h3 class="text-center m-t-10 text-white">
					登录平台
				</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal m-t-20" action="index.html">
					<div class="form-group ">
						<div class="col-xs-12">
							<input class="form-control input-lg" type="text" placeholder="账号">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-xs-12">
							<input class="form-control input-lg" type="password" placeholder="密码">
						</div>
					</div>

					<div class="form-group ">
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

					<div class="form-group m-t-30">
						<div class="col-sm-7">
							<a href="recoverpw.html">
								<i class="fa fa-lock m-r-5"></i>忘记密码?
							</a>
						</div>
						<div class="col-sm-5 text-right">
							<a href="register.html">创建账户</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- END wrapper -->

	<!-- javascripts -->
	<script>
	    var resizefunc = [];
	</script>	
	<script src="resource/js/jquery.min.js"></script>
	<script src="resource/js/bootstrap.min.js"></script>
	<script src="resource/js/waves.js"></script>
	<script src="resource/js/wow.min.js"></script>
	<script src="resource/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="resource/js/jquery.scrollTo.min.js"></script>
	<script src="resource/assets/jquery-detectmobile/detect.js"></script>
	<script src="resource/assets/fastclick/fastclick.js"></script>
	<script src="resource/assets/jquery-slimscroll/jquery.slimscroll.js"></script>
	<script src="resource/assets/jquery-blockui/jquery.blockUI.js"></script>
	<script src="resource/js/jquery.app.js"></script>
</body>
</html>