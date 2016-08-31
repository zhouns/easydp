<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
		<base href="<%=basePath%>">
		<div class="left side-menu">
			<div class="sidebar-inner slimscrollleft">
				<div class="user-details">
					<div class="pull-left">
						<img src="resource/images/users/avatar-1.jpg" class="thumb-md img-circle">
					</div>
					<div class="user-info">
						<div class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle">
								Administrator
							</a>
						</div>
						<p class="text-muted m-0">系统管理员</p>
					</div>
				</div>
				<!--- Divider -->
				<div id="sidebar-menu">
					<ul>
						<li>
							<a href="javascript:ajaxLoad('admin/welcome/init');" class="waves-effect">
								<i class="md md-event"></i><span> 公司管理 </span>
							</a>
						</li>
						<li>
							<a href="javascript:ajaxLoad('admin/welcome/init');" class="waves-effect">
								<i class="md md-event"></i><span> 群组管理 </span>
							</a>
						</li>
						<li>
							<a href="calendar.html" class="waves-effect">
								<i class="md md-event"></i><span> 角色管理 </span>
							</a>
						</li>
						<li>
							<a href="calendar.html" class="waves-effect">
								<i class="md md-event"></i><span> 功能管理 </span>
							</a>
						</li>
						<li>
							<a href="calendar.html" class="waves-effect">
								<i class="md md-event"></i><span> 权限管理 </span>
							</a>
						</li>
						<li>
							<a href="javascript:ajaxLoad('admin/dict/init', true);" class="waves-effect">
								<i class="md md-dns"></i><span> 字典管理 </span>
							</a>
						</li>
						<li>
							<a href="calendar.html" class="waves-effect">
								<i class="md md-event"></i><span> 接口管理 </span>
							</a>
						</li>
						<li>
							<a href="calendar.html" class="waves-effect">
								<i class="md md-event"></i><span> 定时任务 </span>
							</a>
						</li>
						<li>
							<a href="calendar.html" class="waves-effect">
								<i class="md md-event"></i><span> 系统通知 </span>
							</a>
						</li>
						<li>
							<a href="calendar.html" class="waves-effect">
								<i class="md md-event"></i><span> 操作日志 </span>
							</a>
						</li>
						<li>
							<a href="calendar.html" class="waves-effect">
								<i class="md md-event"></i><span> 运行监控 </span>
							</a>
						</li>
						<li class="has_sub">
							<a href="#" class="waves-effect"><i class="md md-now-widgets"></i><span> 代码生成</span><span class="pull-right"><i class="md md-add"></i></span></a>
							<ul class="list-unstyled">
								<li><a href="form-elements.html"><i class="md md-chevron-right"></i> 模型管理</a></li>
								<li><a href="form-elements.html"><i class="md md-chevron-right"></i> 模板管理</a></li>
								<li><a href="javascript:ajaxLoad('system/codegen/index', true);"><i class="md md-chevron-right"></i> 代码生成</a></li>
							</ul>
						</li>
						<li class="has_sub">
							<a href="#" class="waves-effect"><i class="md md-now-widgets"></i><span> 功能示例</span><span class="pull-right"><i class="md md-add"></i></span></a>
							<ul class="list-unstyled">
								<li><a href="form-elements.html"><i class="md md-chevron-right"></i> 模型管理</a></li>
								<li><a href="form-elements.html"><i class="md md-chevron-right"></i> 模板管理</a></li>
								<li><a href="javascript:ajaxLoad('system/codegen/index', true);"><i class="md md-chevron-right"></i> 代码生成</a></li>
							</ul>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>