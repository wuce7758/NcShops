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
<title>Blank Page - Ace Admin</title>

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/bootstrap.css" />
<link rel="stylesheet" href="../plugins/fonts/font-awesome.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/jquery-ui.custom.css" />
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/colorbox.css">
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/chosen.css" />

<!-- text fonts -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace-ie.css" />
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
	<div id="navbar" class="navbar navbar-default">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<!-- #section:basics/sidebar.mobile.toggle -->
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<!-- /section:basics/sidebar.mobile.toggle -->
			<div class="navbar-header pull-left">
				<!-- #section:basics/navbar.layout.brand -->
				<a href="#" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> 欢迎光顾xx商店 </small> </a>

				<!-- /section:basics/navbar.layout.brand -->

				<!-- #section:basics/navbar.toggle -->

				<!-- /section:basics/navbar.toggle -->
			</div>

			<!-- #section:basics/navbar.dropdown -->


			<!-- /section:basics/navbar.dropdown -->
		</div>
		<!-- /.navbar-container -->
	</div>

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<!-- #section:basics/sidebar 菜单-->
		<div id="sidebar" class="sidebar                  responsive">
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed')
				} catch (e) {
				}
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
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<!-- /.sidebar-shortcuts -->

			<ul class="nav nav-list">
				<li class=""><a href="index.html"> <i
						class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
							Dashboard </span> </a> <b class="arrow"></b></li>
				<li class=""><a href="index.html"> <i
						class="menu-icon fa fa-tachometer"></i> <span class="menu-text">动态显示物品类别</span>
				</a> <b class="arrow"></b></li>
			</ul>
			<!-- /.nav-list -->

			<!-- #section:basics/sidebar.layout.minimize -->
			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>

			<!-- /section:basics/sidebar.layout.minimize -->
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch (e) {
				}
			</script>
		</div>

		<!-- /section:basics/sidebar 导航栏-->
		<div class="main-content">
			<div class="main-content-inner">
				<!-- #section:basics/content.breadcrumbs -->
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">小二百货店</a>
						</li>
						<li class="active">生活用品</li>
					</ul>
					<!-- /.breadcrumb -->

					<!-- #section:basics/content.searchbox -->
					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="搜索..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i> </span>
						</form>
					</div>
					<!-- /.nav-search -->

					<!-- /section:basics/content.searchbox -->
				</div>

				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<div class="row">
						<div id="order" class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="col-xs-6 col-sm-3 pricing-box">
								<div class="widget-box widget-color-blue">
									<div class="widget-header">
										<h5 class="widget-title bigger lighter">确认订单</h5>
									</div>

									<div class="widget-body">
										<div class="widget-main">
											<ul class="list-unstyled spaced2">
												<li><i class="ace-icon fa fa-check green"></i> 200 GB
													Disk Space</li>

												<li><i class="ace-icon fa fa-check green"></i>
													Unlimited Bandwidth</li>

												<li><i class="ace-icon fa fa-check green"></i> 1000
													Email Accounts</li>

												<li><i class="ace-icon fa fa-check green"></i> 1000
													Email Accounts</li>
												<li><i class="ace-icon fa fa-check green"></i> 1000
													Email Accounts</li>
												<li><i class="ace-icon fa fa-check green"></i> 1000
													Email Accounts</li>
												<li><i class="ace-icon fa fa-check green"></i> 1000
													Email Accounts</li>
												<li><i class="ace-icon fa fa-check green"></i> 200
													MySQL Databases</li>

												<li><i class="ace-icon fa fa-check green"></i> $25 Ad
													Credit</li>

												<li><i class="ace-icon fa fa-check green"></i> Free
													Domain</li>
											</ul>

											<hr />
											<div id="orderPrice" class="price">
												共计 <strong>15</strong> <small>元</small>
											</div>
											<div id="orderAddress">
												<p>Twitter, Inc.</p>
												<p>795 Folsom Ave, Suite 600
												<p>(123) 456-7890</p>
											</div>
											<form id="fromAddress" role=from>
												<div class="form-group">
													<label class="col-xs-3 control-label no-padding-right"
														for="userName">客户名称</label>

													<div class="col-xs-9">
														<input type="text" id="userName" placeholder="客户名称"
															class="col-xs-12" />
													</div>
													<hr class="col-xs-12">
													<label class="col-xs-3 control-label no-padding-right"
														for="userAddress">客戶地址</label>

													<div class="col-xs-9">
														<input type="text" id="userAddress" placeholder="客户地址"
															class="col-xs-12" />
													</div>
													<hr class="col-xs-12">
													<label class="col-xs-3 control-label no-padding-right"
														for="userPhone">客戶电话</label>

													<div class="col-xs-9">
														<input type="text" id="userPhone" placeholder="客户电话"
															class="col-xs-12" />
													</div>
												</div>
												<hr class="col-xs-12">
												<button class="btn btn-white btn-info btn-bold col-xs-12">
													<i class="ace-icon fa fa-pencil bigger-120 orange"></i> 修改/保存
												</button>
											</form>
											<hr>
											<p id="other">一些文字说明</p>
										</div>

										<div>
											<a href="#" class="btn btn-block btn-primary"> <i
												class="ace-icon fa fa-shopping-cart bigger-110"></i> <span>Buy</span>
											</a>
										</div>
									</div>
								</div>
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

		<nav class="navbar navbar-default navbar-fixed-bottom"
			role="navigation">
			<ul class="nav navbar-nav">
				<li class="green col-xs-3"><a href="#"> <i
						class="ace-icon fa fa-list icon-animated-vertical"></i> </a>
				</li>
				<li class="green col-xs-3"><a href="#"> <i
						class="ace-icon fa fa-user icon-animated-vertical"></i> </a>
				</li>
				<li class="green col-xs-6"><a href="#"> <i
						class="ace-icon fa fa-shopping-cart icon-animated-vertical"></i> <span>确认购买</span><span
						class="badge badge-red">4</span> </a>
				</li>
			</ul>
		</nav>

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i> </a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='http://ace.zcdreams.com/assets/js/jquery.js'>"
								+ "<" + "/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='http://ace.zcdreams.com/assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='http://ace.zcdreams.com/assets/js/jquery.mobile.custom.js'>"
							+ "<" + "/script>");
	</script>
	<script src="http://ace.zcdreams.com/assets/js/bootstrap.js"></script>

	<!-- page specific plugin scripts -->
	<script src="plugins/infinite-scroll/jquery.infinitescroll.min.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.gritter.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.colorbox.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery-ui.custom.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/jquery.ui.touch-punch.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/chosen.jquery.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/fuelux/fuelux.spinner.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/date-time/bootstrap-datepicker.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/date-time/bootstrap-timepicker.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/date-time/moment.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/date-time/daterangepicker.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/date-time/bootstrap-datetimepicker.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/bootstrap-colorpicker.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.knob.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.autosize.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/jquery.inputlimiter.1.3.1.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.maskedinput.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/bootstrap-tag.js"></script>

	<!-- ace scripts -->
	<script
		src="http://ace.zcdreams.com/assets/js/ace/elements.scroller.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/elements.colorpicker.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/elements.fileinput.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/elements.typeahead.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/elements.wysiwyg.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/elements.spinner.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/elements.treeview.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/elements.wizard.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/elements.aside.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.ajax-content.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.touch-drag.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.sidebar.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/ace.sidebar-scroll-1.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/ace.submenu-hover.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.widget-box.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.settings.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.settings-rtl.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/ace.settings-skin.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/ace.widget-on-reload.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/ace.searchbox-autocomplete.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		
	</script>
</body>
</html>
