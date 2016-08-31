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
	<jsp:include page="inc-head.jsp"></jsp:include>
</head>

<body class="fixed-left">
	<div id="wrapper">
		<!-- 页面顶部 -->
		<jsp:include page="inc-top.jsp"></jsp:include>
		<!-- 导航菜单 -->
		<jsp:include page="inc-menu.jsp"></jsp:include>
		<!-- 页面容器 -->
		<div class="content-page">
			<!-- 页面内容 -->
			<div class="content">
				<div class="preloader">
					<div class="status">
						<i class="fa fa-refresh fa-spin"></i>
					</div>
				</div>	
				<div class="container" id="div-container">
                            <div class="col-lg-6"> 
                                <ul class="nav nav-tabs tabs">
                                    <li class="active tab">
                                        <a href="#home-2" data-toggle="tab" aria-expanded="false"> 
                                            <span class="visible-xs"><i class="fa fa-home"></i></span> 
                                            <span class="hidden-xs">Home</span> 
                                        </a> 
                                    </li> 
                                    <li class="tab"> 
                                        <a href="#profile-2" data-toggle="tab" aria-expanded="false"> 
                                            <span class="visible-xs"><i class="fa fa-user"></i></span> 
                                            <span class="hidden-xs">Profile</span> 
                                        </a> 
                                    </li> 
                                    <li class="tab"> 
                                        <a href="#messages-2" data-toggle="tab" aria-expanded="true"> 
                                            <span class="visible-xs"><i class="fa fa-envelope-o"></i></span> 
                                            <span class="hidden-xs">Messages</span> 
                                        </a> 
                                    </li> 
                                    <li class="tab"> 
                                        <a href="#settings-2" data-toggle="tab" aria-expanded="false"> 
                                            <span class="visible-xs"><i class="fa fa-cog"></i></span> 
                                            <span class="hidden-xs">Settings</span> 
                                        </a> 
                                    </li> 
                                </ul> 
                                <div class="tab-content"> 
                                    <div class="tab-pane active" id="home-2"> 
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p> 
                                        <p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p> 
                                    </div> 
                                    <div class="tab-pane" id="profile-2">
                                        <p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p> 
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p> 
                                    </div> 
                                    <div class="tab-pane" id="messages-2">
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p> 
                                            <p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p> 
                                    </div> 
                                    <div class="tab-pane" id="settings-2">
                                        <p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p>  
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p> 
                                    </div> 
                                </div> 
                            </div> 

                            <div class="col-lg-6"> 
                                <ul class="nav nav-tabs tabs tabs-top">
                                    <li class="active tab">
                                        <a href="#home-21" data-toggle="tab" aria-expanded="false"> 
                                            <span class="visible-xs"><i class="fa fa-home"></i></span> 
                                            <span class="hidden-xs">Home</span> 
                                        </a> 
                                    </li> 
                                    <li class="tab"> 
                                        <a href="#profile-21" data-toggle="tab" aria-expanded="false"> 
                                            <span class="visible-xs"><i class="fa fa-user"></i></span> 
                                            <span class="hidden-xs">Profile</span> 
                                        </a> 
                                    </li> 
                                    <li class="tab"> 
                                        <a href="#messages-21" data-toggle="tab" aria-expanded="true"> 
                                            <span class="visible-xs"><i class="fa fa-envelope-o"></i></span> 
                                            <span class="hidden-xs">Messages</span> 
                                        </a> 
                                    </li> 
                                    <li class="tab"> 
                                        <a href="#settings-21" data-toggle="tab" aria-expanded="false"> 
                                            <span class="visible-xs"><i class="fa fa-cog"></i></span> 
                                            <span class="hidden-xs">Settings</span> 
                                        </a> 
                                    </li> 
                                </ul> 
                                <div class="tab-content"> 
                                    <div class="tab-pane active" id="home-21"> 
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p> 
                                        <p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p> 
                                    </div> 
                                    <div class="tab-pane" id="profile-21">
                                        <p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p> 
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p> 
                                    </div> 
                                    <div class="tab-pane" id="messages-21">
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p> 
                                            <p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p> 
                                    </div> 
                                    <div class="tab-pane" id="settings-21">
                                        <p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p>  
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p> 
                                    </div> 
                                </div> 
                            </div> 
                        </div>
				</div>
			</div>
			<footer class="footer text-center"> ©2015 沈阳普奥玛特科技有限公司  京ICP证XXXXXX号 </footer>
		</div>
	</div>

	<!-- javascripts -->
	<jsp:include page="inc-script.jsp"></jsp:include>
</body>
</html>
