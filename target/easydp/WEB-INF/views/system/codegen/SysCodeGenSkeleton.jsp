<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<link href="resource/css/style.css" rel="stylesheet" type="text/css" />
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">标准骨架模型</h3>
			</div>
			<div class="panel-body">
				<div class="form">
					<form class="cmxform form-horizontal tasi-form" >
						<div class="form-group">
							<label class="control-label col-lg-2">模块编码</label>
							<div class="col-lg-4">
								<input type="text" class="form-control" id="txt-moudel" placeholder="如：system">
							</div>
							<label class="control-label col-lg-2">功能编码</label>
							<div class="col-lg-4">
								<input type="text" class="form-control" id="txt-menu" placeholder="如：menu">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-lg-2">数据库</label>
							<div class="col-lg-10">
								<select class="form-control" id="select-dblist">
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-lg-2">功能表</label>
							<div class="col-lg-10">
								<select class="form-control" id="select-tblist">
									
								</select>
							</div>
						</div>
					</form>
				</div>		
			</div>
			<div class="panel-footer">
				<div class="m-l-15">
					<button type="button" class="btn btn-primary" id="btn-gencode">生成代码</button>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="resource/js/common.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$.get('gen/db/dblist', function(responseText) {
		$('#select-dblist').empty();
		$.each(responseText, function(i, n) {
			$('#select-dblist').append('<option value="'+ n.dbName +'">'+ n.dbName +'</option>');
		});
	});
	
	$('#select-dblist').change(function() {
		loadTbList($(this).val());
	});
	
	$('#btn-gencode').click(function() {
		var moudel = $('#txt-moudel').val();
		var menu = $('#txt-menu').val();
		var schema = $('#select-dblist').val();
		var tbName = $('#select-tblist').val();
		$.post('system/codegen/generater', {tmpCode:'1',moudel:moudel,menu:menu,schema:schema,tbName:tbName}, function(responseText) {
			if (responseText && responseText.status) {
				swal({type: 'success', title: '生成成功!', timer: 1000});
			} else {
				swal({type: 'error', title: '生成失败!', text: '错误信息:'+ responseText.message, timer: 3000});
			}
		});
	});
});


function loadTbList(dbName) {
	$.get('gen/db/tblist', {dbName: dbName}, function(responseText) {
		$('#select-tblist').empty();
		$.each(responseText, function(i, n) {
			$('#select-tblist').append('<option value="'+ n.table_name +'">'+ n.table_name +'</option>');
		});
	});
};

</script>