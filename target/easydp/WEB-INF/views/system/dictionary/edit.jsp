<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<body>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal">
		<span aria-hidden="true">&times;</span>
	</button>
	<h3 class="modal-title">字典分组-新增</h3>
</div>
<div class="modal-body">
	<div class="form">
		<form class="cmxform form-horizontal tasi-form" id="form-edit">
			<input type="hidden" name="operation" value="${operation }">
			<div class="form-group">
				<label for="code" class="control-label col-lg-2"><em class="text-danger">*</em> 编码</label>
				<div class="col-lg-10">
					<input type="text" class="form-control" name="code" value="${sysDictGroup.code }"
						<c:if test="${operation != 'create' }">readonly="readonly"</c:if>
						required alphanumeric="true" maxlength="32"
						placeholder="必填,0-32位字母或数字">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="control-label col-lg-2"><em class="text-danger">*</em> 名称</label>
				<div class="col-lg-10">
					<input type="text" class="form-control" name="name" value="${sysDictGroup.name }"
					required maxlength="64"
					placeholder="必填,最多64个字符">
				</div>
			</div>
			<div class="form-group">
				<label for="type" class="control-label col-lg-2"><em class="text-danger">*</em> 类型</label>
				<div class="col-lg-10">
					<select class="form-control" name="type" value="${sysDictGroup.type }"
					required placeholder="必填,最多64个字符">
						<option value="0" <c:if test="${sysDictGroup.type == 0 }">selected="selected"</c:if>>系统编码</option>
						<option value="1" <c:if test="${sysDictGroup.type == 1 }">selected="selected"</c:if>>业务编码</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="remark" class="control-label col-lg-2">备注</label>
				<div class="col-lg-10">
					<textarea class="form-control" name="remark" maxlength="128"
					placeholder="最多128个字符">${sysDictGroup.remark }</textarea>
				</div>
			</div>
		</form>
	</div>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	<button type="button" class="btn btn-primary" id="btn-edit-save">保存</button>
</div>
</body>
</html>
<script src="resource/assets/jquery-form/jquery.form.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	if ('${operation }' == 'view') {
		$(':input', '#form-edit').attr('disabled', true);
		$('#btn-edit-save').attr('disabled', true);
	}

	$('#btn-edit-save').click(function() {
		$('#form-edit').ajaxSubmit({
			url: 'admin/dict/${operation }',
			type: 'post',
			dataType: 'json',
			beforeSubmit: function() {
				return $('#form-edit').valid();
			},
			success : function(responseText, statusText) {
				if (statusText != 'success') {
					swal({type: 'error', title: '保存失败!', text: '错误信息:请求服务器失败!', timer: 3000});
				} else {
					if (responseText && responseText.status) {
						swal({type: 'success', title: '保存成功!', timer: 1000});
						setTimeout(function() {
							searchGroup();
							$('#div-modal').modal('hide');
						}, 1500);
					} else {
						swal({type: 'error', title: '保存失败!', text: '错误信息:'+ responseText.message, timer: 3000});
					}
				}
			}
		});
		return false;
	});
});
</script>
	
