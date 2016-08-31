<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<link href="resource/assets/datatables/jquery.dataTables.min.css" rel="stylesheet"/>
<link href="resource/assets/sweet-alert/sweet-alert.min.css" rel="stylesheet"/>
<link href="resource/css/style.css" rel="stylesheet" type="text/css" />
<!-- 页面标题 -->
<div class="row">
	<div class="col-sm-12">
		<h2 class="page-title pull-left"><i class="md md-dns"></i>字典管理</h2>
		<ol class="breadcrumb pull-right">
			<li>
				<a href="admin/index">后台管理</a>
			</li>
			<li class="active">字典管理</li>
		</ol>
	</div>
</div>
<!-- 正文内容 -->
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<ul class="nav nav-tabs navtab-bg">
			<li class="active">
				<a href="#div-dict-group" data-toggle="tab">字典分组</a>
			</li>
			<li>
				<a href="#div-dict-list" data-toggle="tab">字典编码</a>
			</li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="div-dict-group">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="manager-options">
							<div class="btn-group">
								<button type="button" onclick="editGroup('create', '');" class="btn btn-default">新增</button>
							</div>
						    <div class="navbar-form">
								<select class="form-control" id="select-grouptype">
									<option value="">全部</option>
									<option value="0" <c:if test="${sysDictGroup.type == 0 }">selected="selected"</c:if>>系统编码</option>
									<option value="1" <c:if test="${sysDictGroup.type == 1 }">selected="selected"</c:if>>业务编码</option>
								</select>			      
								<button type="button" class="btn btn-default" onclick="searchGroup();">搜 索</button>						      
						  	</div>													
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<table id="tb-group" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>编码</th>
									<th>名称</th>
									<th>类型</th>
									<th>操作</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>	
			</div>
			<div class="tab-pane" id="div-dict-list">
				
			</div>
		</div>
	</div>
</div>

<div class="modal animated slideInUp" id="div-modal">
	<div class="modal-dialog">
		<div class="modal-content"></div>
	</div>
</div>

<script src="resource/js/common.js"></script>
<script src="resource/assets/datatables/jquery.dataTables.min.js"></script>
<script src="resource/assets/datatables/dataTables.bootstrap.js"></script>
<script src="resource/assets/sweet-alert/sweet-alert.min.js"></script>
<script type="text/javascript">
var groupTb = null;
$(document).ready(function() {
	initGroupTb();
});

function initGroupTb() {
	groupTb = $('#tb-group').DataTable({
		processing : true,
		serverSide : true,
		ajax : {
			url : 'admin/dict/list',
			type : 'get',
			dataType : 'json',
			data : function(data) {
				data.type = $('#select-grouptype').val();
			}
		},
		columns : [
			{data : 'code'},
			{data : 'name'},
			{data : 'type'},
			{data : 'code'}
		],
		columnDefs : [{
			render : function(data, type, row) {
				var btn = 	'<button type="button" onclick="editGroup(\'view\', \'' + data + '\');" class="btn btn-primary btn-xs">查看</button>&nbsp;' + 
							'<button type="button" onclick="editGroup(\'update\', \'' + data + '\');" class="btn btn-primary btn-xs">修改</button>&nbsp;' + 
							'<button type="button" onclick="deleteGroup(\''+ data + '\');" class="btn btn-danger btn-xs">删除</button>&nbsp;';
				return btn;
			},
			targets : [ 3 ]
		}]
	});
}

// 查询
function searchGroup() {
	groupTb.ajax.reload();
};

// 编辑
function editGroup(operation, id) {
	$("#div-modal").modal({
		remote : 'admin/dict/edit?operation='+ operation +'&id='+ id
	});
};

// 删除
function deleteGroup(id) {
	swal({
		title: '确认删除',
		text : '删除后数据将不可恢复, 是否确认删除?',
		type : 'warning',
		confirmButtonText 	: '确认',
		cancelButtonText 	: '取消',
		confirmButtonColor 	: '#dd6b55',
		showCancelButton 	: true,
		closeOnConfirm 		: false
	},function() {
		$.post('admin/dict/delete', {code : id}, function(responseText) {
			if (responseText && responseText.status) {
				swal({type: 'success', title: '删除成功!', timer: 1000});
				setTimeout(function() {
					searchGroup();
				}, 1500);
			} else {
				swal({type: 'error', title: '删除失败!', text: '错误信息:'+ responseText.message, timer: 3000});
			}
		});
	});
};
</script>