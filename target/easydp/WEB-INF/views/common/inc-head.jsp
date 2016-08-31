	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	%>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="resource/images/favicon_1.ico">	
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
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
	
	<script src="resource/js/modernizr.min.js"></script>