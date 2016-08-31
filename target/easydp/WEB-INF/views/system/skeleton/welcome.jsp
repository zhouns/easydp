<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<!-- 页面标题 -->
<div class="row">
	<div class="col-sm-12">
		<h4 class="pull-left page-title">空白页</h4>
		<ol class="breadcrumb pull-right">
			<li>
				<a href="admin/index">主页</a>
			</li>
			<li class="active">空白页</li>
		</ol>
	</div>
</div>
<!-- 正文内容 -->
<div class="row">
	内容
</div>