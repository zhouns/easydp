<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<link href="resource/assets/sweet-alert/sweet-alert.min.css" rel="stylesheet"/>
<link href="resource/assets/form-wizard/jquery.steps.css" rel="stylesheet" type="text/css"/>
<link href="resource/css/style.css" rel="stylesheet" type="text/css" />
<!-- 页面标题 -->
<div class="row">
	<div class="col-sm-12">
		<h2 class="page-title pull-left"><i class="md md-dns"></i>代码生成</h2>
		<ol class="breadcrumb pull-right">
			<li class="active">代码生成</li>
		</ol>
	</div>
</div>
<!-- 正文内容 -->
<div class="row">
	<div class="col-md-4 col-lg-3">
		<a href="javascript:void();" class="btn btn-danger waves-effect waves-light btn-block">创建模板</a>
		<div class="panel panel-default p-0 m-t-20">
			<div class="panel-body p-0">
				<div class="list-group mail-list">
					<a href="javascript:loadsteps('skeleton');" class="list-group-item no-border">
						<i class="md md-assignment m-r-5"></i> 标准骨架模型
					</a>
					<a href="javascript:void();" class="list-group-item no-border">
						<i class="md md-assignment m-r-5"></i> 简单查询模型
					</a>
					<a href="javascript:void();" class="list-group-item no-border">
						<i class="md md-assignment m-r-5"></i> 增删改查模型
					</a>
					<a href="javascript:void();" class="list-group-item no-border">
						<i class="md md-assignment m-r-5"></i> 列表表格模型
					</a>
					<a href="javascript:void();" class="list-group-item no-border">
						<i class="md md-assignment m-r-5"></i> 树形表格模型
					</a>
					<a href="javascript:void();" class="list-group-item no-border">
						<i class="md md-assignment m-r-5"></i> 列表XXX模型
					</a>
					<a href="javascript:void();" class="list-group-item no-border">
						<i class="md md-assignment m-r-5"></i> 树形XXX模型
					</a>
					<a href="javascript:void();" class="list-group-item no-border">
						<i class="md md-assignment m-r-5"></i> XXXXXX模型
					</a>
					<a href="javascript:void();" class="list-group-item no-border">
						<i class="md md-assignment m-r-5"></i> XXXXXX模型
					</a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="col-md-8 col-lg-9" id ="div-gensteps">
		
	</div>
</div>


<!-- <div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Basic Form Wizard</h3>
			</div>
			<div class="panel-body">
				<form id="basic-form" action="#">
					<div>
						<h3>选择模板</h3>
						<section>
							<div class="list-group">
								<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
								<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
								<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
								<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
							</div>
						</section>
						<h3>选择数据库</h3>
						<section>2</section>
						<h3>选择功能表</h3>
						<section>3</section>
						<h3>配置信息</h3>
						<section>4</section>
					</div>
				</form>
			</div>
		</div>
	</div>
</div> -->
<script src="resource/js/common.js"></script>
<script src="resource/assets/sweet-alert/sweet-alert.min.js"></script>
<script src="resource/assets/form-wizard/jquery.steps.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#basic-form').children("div").steps({
		headerTag: "h3",
		bodyTag: "section",
		transitionEffect: "slideLeft"
	});
});

function loadsteps(code) {
	$('#div-gensteps').load('system/codegen/steps?code='+ code);
};
</script>