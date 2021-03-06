<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>德玛超市后台管理系统</title>

<meta name="description" content="User login page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/bootstrap.css" />
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/font-awesome.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/jquery-ui.custom.css" />
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/jquery.gritter.css" />

<!-- text fonts -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace.css" />

<!--[if lte IE 9]>
	<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace-part2.css" />
<![endif]-->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace-rtl.css" />

<!--[if lte IE 9]>
	<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace-ie.css" />
<![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
	<script src="http://ace.zcdreams.com/assets/js/html5shiv.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/respond.js"></script>
<![endif]-->
</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-windows blue"></i> <span class="red"></span>
								<span class="white" id="id-text2">德玛超市后台管理系统</span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy; NCHU java Team</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> 请输入登录信息
										</h4>

										<div class="space-6"></div>

										<form id="form_login" method="post" action="${pageContext.request.contextPath }/sellerLogin">
											<fieldset>
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="text" class="form-control required" name="sellerName" placeholder="账号" />
														<i class="ace-icon fa fa-user"></i>
													</span>
												</label>
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="password" class="form-control" name="sellerPhone" placeholder="密码" />
														<i class="ace-icon fa fa-lock"></i>
													</span>
												</label>

												<div class="space"></div>

												<div class="clearfix">
													<label class="inline"> <input type="checkbox"
														class="ace" /> <span class="lbl">记住我</span> </label>

													<button id="btnlogin" type="submit"
														class="width-35 pull-right btn btn-primary"
														data-loading-text="登录..." autocomplete="off">
														<i class="ace-icon fa fa-key"></i> <span
															class="bigger-110">登录 </span>
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

										<!-- <div class="social-or-login center">
												<span class="bigger-110">Or Login Using</span>
											</div>

											<div class="space-6"></div>

											<div class="social-login center">
												<a class="btn btn-primary">
													<i class="ace-icon fa fa-facebook"></i>
												</a>

												<a class="btn btn-info">
													<i class="ace-icon fa fa-twitter"></i>
												</a>

												<a class="btn btn-danger">
													<i class="ace-icon fa fa-google-plus"></i>
												</a>
											</div> -->
									</div>
									<!-- /.widget-main -->

									<!-- <div class="toolbar clearfix">
										<div>
											<a href="#" data-target="#forgot-box"
												class="forgot-password-link"> <i
												class="ace-icon fa fa-arrow-left"></i> 忘记密码 </a>
										</div>

										<div>
											<a href="#" data-target="#signup-box"
												class="user-signup-link"> 注册 <i
												class="ace-icon fa fa-arrow-right"></i> </a>
										</div>
									</div> -->
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.login-box -->

							<div id="forgot-box" class="forgot-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header red lighter bigger">
											<i class="ace-icon fa fa-key"></i> 重置密码
										</h4>

										<div class="space-6"></div>
										<p>输入你的邮箱重置密码</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="Email" />
														<i class="ace-icon fa fa-envelope"></i> </span> </label>

												<div class="clearfix">
													<button type="button"
														class="width-35 pull-right btn btn-sm btn-danger">
														<i class="ace-icon fa fa-lightbulb-o"></i> <span
															class="bigger-110">发送</span>
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<!-- /.widget-main -->

									<div class="toolbar center">
										<a href="#" data-target="#login-box"
											class="back-to-login-link"> 返回登录 <i
											class="ace-icon fa fa-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.forgot-box -->

							<div id="signup-box" class="signup-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header green lighter bigger">
											<i class="ace-icon fa fa-users blue"></i> 新用户注册
										</h4>

										<div class="space-6"></div>
										<p>输入你的详细信息以注册：</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="Email" />
														<i class="ace-icon fa fa-envelope"></i> </span> </label> <label
													class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" placeholder="Username" />
														<i class="ace-icon fa fa-user"></i> </span> </label> <label
													class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control"
														placeholder="Password" /> <i class="ace-icon fa fa-lock"></i>
												</span> </label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control"
														placeholder="Repeat password" /> <i
														class="ace-icon fa fa-retweet"></i> </span> </label> <label class="block">
													<input type="checkbox" class="ace" /> <span class="lbl">
														I accept the <a href="#">User Agreement</a> </span> </label>

												<div class="space-24"></div>

												<div class="clearfix">
													<button type="reset" class="width-30 pull-left btn btn-sm">
														<i class="ace-icon fa fa-refresh"></i> <span
															class="bigger-110">Reset</span>
													</button>

													<button type="button"
														class="width-65 pull-right btn btn-sm btn-success">
														<span class="bigger-110">Register</span> <i
															class="ace-icon fa fa-arrow-right icon-on-right"></i>
													</button>
												</div>
											</fieldset>
										</form>
									</div>

									<div class="toolbar center">
										<a href="#" data-target="#login-box"
											class="back-to-login-link"> <i
											class="ace-icon fa fa-arrow-left"></i> Back to login </a>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.signup-box -->
						</div>
						<!-- /.position-relative -->

						<div class="navbar-fixed-top align-right">
							<br /> &nbsp; <a id="btn-login-dark" href="#">黑色</a> &nbsp; <span
								class="blue">/</span> &nbsp; <a id="btn-login-blur" href="#">蓝色</a>
							&nbsp; <span class="blue">/</span> &nbsp; <a id="btn-login-light"
								href="#">高亮</a> &nbsp; &nbsp; &nbsp;
						</div>
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery
				|| document.write("<script src='http://ace.zcdreams.com/assets/js/jquery.js'>"
						+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='http://ace.zcdreams.com/assets/js/jquery1x.js'>"+"<"+"/script>");
		</script>
	<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document.write("<script src='http://ace.zcdreams.com/assets/js/jquery.mobile.custom.js'>"
					+ "<"+"/script>");
	</script>
	<script type="text/javascript" src="http://ace.zcdreams.com/assets/js/jquery.gritter.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery-ui.custom.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.ui.touch-punch.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/bootbox.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.validate.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.easypiechart.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/bootstrap.min.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.validate.min.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.metadata.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery.extend(jQuery.validator.messages, {
			required : "必选字段",
			remote : "请修正该字段",
			email : "请输入正确格式的电子邮件",
			url : "请输入合法的网址",
			date : "请输入合法的日期",
			dateISO : "请输入合法的日期 (ISO).",
			number : "请输入合法的数字",
			digits : "只能输入整数",
			creditcard : "请输入合法的信用卡号",
			equalTo : "请再次输入相同的值",
			accept : "请输入拥有合法后缀名的字符串",
			maxlength : jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
			minlength : jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
			rangelength : jQuery.validator
					.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
			range : jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
			max : jQuery.validator.format("请输入一个最大为{0} 的值"),
			min : jQuery.validator.format("请输入一个最小为{0} 的值")
		});

		$(function() {
			$("[rel=drevil]")
					.popover(
							{
								trigger : 'manual',
								placement : 'bottom', //placement of the popover. also can use top, bottom, left or right
								title : '<div style="text-align:center; color:red; text-decoration:underline; font-size:14px;"> Muah ha ha</div>', //this is the top title bar of the popover. add some basic css
								html : 'true', //needed to show html of course
								content : '<div id="popOverBox"><img src="http://www.hd-report.com/wp-content/uploads/2008/08/mr-evil.jpg" width="251" height="201" /></div>', //this is the content of the html box. add the image here or anything you want really.
								animation : false
							}).on(
							"mouseenter",
							function() {
								var _this = this;
								$(this).popover("show");
								$(this).siblings(".popover").on("mouseleave",
										function() {
											$(_this).popover('hide');
										});
							}).on("mouseleave", function() {
						var _this = this;
						setTimeout(function() {
							if (!$(".popover:hover").length) {
								$(_this).popover("hide")
							}
						}, 100);
					});
		});
		$(document).ready(function() {
			$("#form_login").validate();
			$('[data-toggle="popover"]').popover();
			$("#gritter-notice-wrapper").mouseleave(function() {
				$('#btnlogin span').html('登录');
				$('#btnlogin').removeClass('disabled');
				$('gritter-notice-wrapper').remove();
			});
			//登录点击
			$('[data-toggle="popover"]').popover();
			$("#gritter-notice-wrapper").mouseleave(function() {
				$('#btnlogin span').html('登录');
				$('#btnlogin').removeClass('disabled');
				$('gritter-notice-wrapper').remove();
			});
			//登录点击
			$('#btnlogin').click(function() {
				//$("form_login").submit();
				//var $btn = $(this).button('loading');
				//var sellerName=$("input[name='sellerName']").val();
				//var sellerPwd=$("input[name='sellerPhone']").val();
				//$('#btnlogin span').html('登录...');
				//$('#btnlogin').addClass('disabled');
				/* $.ajax({
					cache : false,
					type : "post",
					url : "${pageContext.request.contextPath}/seller/sellerLogin",
					data : {"sellerName":sellerName,"sellerPhone":sellerPwd},
					async : false,
					error : function(request) {
						$btn.button('reset');
						$.gritter.add({
							title : '出错啦!',
							text : '网络似乎有问题！',
							sticky : true,
							//time : 1000,
							speed : 10,
							position : 'center',
							class_name : 'gritter-light'
						});
					},
					success : function(data) {
						if (data == "1") {
							$btn.button('reset');
							location.href = "/login.jsp";
						} else {
							$btn.button('reset');
							$.gritter.add({
								title : '出错啦!',
								text : '账号或密码错误，请重试！' + data,
								sticky : true,
								//time: 1000,
								speed : 10,
								position : 'center',
								class_name : 'gritter-light'
							});
						}
					}
				}); */
			});
		});

		jQuery(function($) {
			$(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			});
		});

		//you don't need this, just used for changing background
		jQuery(function($) {
			$('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');

				e.preventDefault();
			});

		});
	</script>
</body>
</html>

