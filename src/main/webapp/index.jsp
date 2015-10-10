<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Blank Page - Ace Admin</title>

		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/font-awesome.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/jquery-ui.custom.css" />
		<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/colorbox.css">
		<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/chosen.css" />
		<!-- text fonts -->
		<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="ace-ie.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="http://ace.zcdreams.com/assets/js/ace-extra.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="http://ace.zcdreams.com/assets/js/html5shiv.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/respond.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
		<!-- #section:basics/navbar.layout -->
		<div id="navbar" class="navbar navbar-default navbar-fixed-top">
			<script type="text/javascript">
				try {
					ace.settings.check('navbar', 'fixed')
				} catch (e) {}
			</script>

			<div class="navbar-container" id="navbar-container">
				<!-- #section:basics/sidebar.mobile.toggle -->
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<!-- /section:basics/sidebar.mobile.toggle -->
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<a href="#" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							欢迎光顾xx商店
						</small>
					</a>

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->

					<!-- /section:basics/navbar.toggle -->
				</div>

				<!-- #section:basics/navbar.dropdown -->
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="grey">
							<a href="charge.aspx">
								<i class="ace-icon fa fa-tasks"></i>
								<span>费用</span>
								<!-- <span class="badge badge-grey">4</span> -->
							</a>

						</li>
<li class="grey">
							<a href="charge.aspx">
								<i class="ace-icon fa fa-tasks"></i>
								<span>费用</span>
								<!-- <span class="badge badge-grey">4</span> -->
							</a>

						</li>
						<li class="green">
							<a href="notice.aspx">
								<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
								<span>关于</span>
								<span class="badge badge-success">5</span>
							</a>

						</li>

						<li class="purple">
							<a href="about.aspx">
								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span>å³äº</span>
							</a>
						</li>

						<!-- #section:basics/navbar.user_menu -->
						<!--<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="../http://ace.zcdreams.com/assets/avatars/user.jpg" alt="Jason's Photo">
								<span class="user-info">
									<small>Welcome,</small>
									å¼ ä¸
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="info.aspx">
										<i class="ace-icon fa fa-user"></i> ä¸ªäººæ¶æ¯
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="index.aspx">
										<i class="ace-icon fa fa-power-off"></i> Logout
									</a>
								</li>
							</ul>
						</li>-->

						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>

				<!-- /section:basics/navbar.dropdown -->
			</div>
			<!-- /.navbar-container -->
		</div>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try {
					ace.settings.check('main-container', 'fixed')
				} catch (e) {}
			</script>

			<!-- #section:basics/sidebar èå-->
			<div id="sidebar" class="sidebar                  responsive">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<!-- #section:basics/sidebar.layout.shortcuts -->
						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>
						<!-- /section:basics/sidebar.layout.shortcuts -->
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- /.sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="">
						<a href="index.html">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Dashboard </span>
						</a>

						<b class="arrow"></b>
					</li>
					<li class="">
						<a href="index.html">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text">å¨ææ¾ç¤ºç©åç±»å«</span>
						</a>

						<b class="arrow"></b>
					</li>
				</ul>
				<!-- /.nav-list -->

				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {}
				</script>
			</div>

			<!-- /section:basics/sidebar å¯¼èªæ -->
			<div class="main-content">
				<div class="main-content-inner">
					<!-- #section:basics/content.breadcrumbs -->
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try {
								ace.settings.check('breadcrumbs', 'fixed')
							} catch (e) {}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">å°äºç¾è´§åº</a>
							</li>
							<li class="active">çæ´»ç¨å</li>
						</ul>
						<!-- /.breadcrumb -->

						<!-- #section:basics/content.searchbox -->
						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="æç´¢..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div>
						<!-- /.nav-search -->

						<!-- /section:basics/content.searchbox -->
					</div>

					<!-- /section:basics/content.breadcrumbs -->
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="form-group col-xs-12">
									<div class="col-xs-6">
										<img src="http://ace.zcdreams.com/assets/images/gallery/image-1.jpg" class="img-responsive" alt="Responsive image" />
									</div>
									<div class="col-xs-6">
										<p>æ©é¤</p>
										<p>10.00ï¿¥/ä¸ä»½</p>
										<input type="text" class="spinner" id="spinner1" />
									</div>
								</div>
								<div class="form-group col-xs-12">
									<div class="col-xs-6">
										<img src="http://ace.zcdreams.com/assets/images/gallery/image-1.jpg" class="img-responsive" alt="Responsive image" />
									</div>
									<div class="col-xs-6">
										<p>æ©é¤</p>
										<p>10.00ï¿¥/ä¸ä»½</p>
										<input type="text" class="spinner" id="spinner1" />
									</div>
								</div>
								<div class="form-group col-xs-12">
									<div class="col-xs-6">
										<img src="http://ace.zcdreams.com/assets/images/gallery/image-1.jpg" class="img-responsive" alt="Responsive image" />
									</div>
									<div class="col-xs-6">
										<p>æ©é¤</p>
										<p>10.00ï¿¥/ä¸ä»½</p>
										<input type="text" class="spinner" id="spinner1" />
									</div>
								</div>
								<div class="form-group col-xs-12">
									<div class="col-xs-6">
										<img src="http://ace.zcdreams.com/assets/images/gallery/image-1.jpg" class="img-responsive" alt="Responsive image" />
									</div>
									<div class="col-xs-6">
										<p>æ©é¤</p>
										<p>10.00ï¿¥/ä¸ä»½</p>
										<input type="text" class="spinner" id="spinner2" />
									</div>
								</div>
								<div class="form-group col-xs-12">
									<div class="col-xs-6">
										<img src="http://ace.zcdreams.com/assets/images/gallery/image-1.jpg" class="img-responsive" alt="Responsive image" />
									</div>
									<div class="col-xs-6">
										<p>æ©é¤</p>
										<p>10.00ï¿¥/ä¸ä»½</p>
										<input type="text" class="spinner" id="spinner3" />
									</div>
								</div>
							</div>
							<div class="col-xs-12 center">
								<a>å è½½æ´å¤...</a>
							</div>
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
			<ul class="nav navbar-nav">
				<li class="green col-xs-4">
					<a href="#">
						<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
						<span>éç¥</span>
					</a>
				</li>
				<li class="green col-xs-4">
					<a href="#">
						<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
						<span>éç¥</span>
					</a>
				</li>
				<li class="green col-xs-4">
					<a href="#">
						<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
						<span>éç¥</span>
					</a>
				</li>
			</ul>
		</nav>

		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
		</div>
		<!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='http://ace.zcdreams.com/assets/js/jquery.js'>" + "<" + "/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='http://ace.zcdreams.com/assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if ('ontouchstart' in document.documentElement) document.write("<script src='http://ace.zcdreams.com/assets/js/jquery.mobile.custom.js'>" + "<" + "/script>");
		</script>
		<script src="http://ace.zcdreams.com/assets/js/bootstrap.js"></script>

		<!-- page specific plugin scripts -->
		<script src="http://ace.zcdreams.com/assets/js/jquery.gritter.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/jquery.colorbox.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/jquery-ui.custom.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/jquery.ui.touch-punch.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/chosen.jquery.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/fuelux/fuelux.spinner.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/date-time/bootstrap-datepicker.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/date-time/bootstrap-timepicker.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/date-time/moment.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/date-time/daterangepicker.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/date-time/bootstrap-datetimepicker.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/bootstrap-colorpicker.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/jquery.knob.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/jquery.autosize.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/jquery.inputlimiter.1.3.1.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/jquery.maskedinput.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/bootstrap-tag.js"></script>

		<!-- ace scripts -->
		<script src="http://ace.zcdreams.com/assets/js/ace/elements.scroller.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/elements.colorpicker.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/elements.fileinput.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/elements.typeahead.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/elements.wysiwyg.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/elements.spinner.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/elements.treeview.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/elements.wizard.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/elements.aside.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.ajax-content.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.touch-drag.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.sidebar.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.sidebar-scroll-1.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.submenu-hover.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.widget-box.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.settings.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.settings-rtl.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.settings-skin.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.widget-on-reload.js"></script>
		<script src="http://ace.zcdreams.com/assets/js/ace/ace.searchbox-autocomplete.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				$('.spinner').ace_spinner({
					value: 0,
					min: 0,
					max: 100,
					step: 1,
					on_sides: true,
					icon_up: 'ace-icon fa fa-plus bigger-110',
					icon_down: 'ace-icon fa fa-minus bigger-110',
					btn_up_class: 'btn-success',
					btn_down_class: 'btn-danger'
				});
			});
			$(document).ready(function() {
				//é¡µé¢å è½½çæ¶ååå§å
				$.get("url", function(data) {
					if (data.substr(0, 3) == "{\"p") {} else {
						$.gritter.add({
							title: 'åºéå¦!',
							text: 'ä¸å¥½ææï¼å è½½å¤±è´¥ï¼',
							sticky: true,
							time: 1000,
							speed: 10,
							position: 'center',
							class_name: 'gritter-dark'
						});
					}
				});
				//xxxæé®
				$("#roleAddBtn").click(function() {
					//postå°åå°
					$.ajax({
						cache: false,
						type: "POST",
						url: "authority.null.roleSingle.roleAdd.do",
						datatype: "json",
						data: "roleName=" + roleName +
							"&roleType=" + roleType +
							"&roleNodes=" + v,
						async: true,
						error: function(request) {
							$.gritter.add({
								title: 'åºéå¦!',
								text: 'ç½ç»ä¼¼ä¹æé®é¢ï¼',
								sticky: true,
								time: 1000,
								speed: 10,
								position: 'center',
								class_name: 'gritter-light'
							});
						},
						success: function(data) {
							if (data == "1") {} else {
								$("#alertDiv strong").html("è§è²æ·»å å¤±è´¥ï¼ï¼ï¼");
								$.gritter.add({
									title: 'åºéå¦!',
									text: data,
									sticky: true,
									time: 1000,
									speed: 10,
									position: 'center',
									class_name: 'gritter-light'
								});
							}
						}
					});
				});
			});
		</script>

	</body>

</html>