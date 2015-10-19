<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>德玛超市-我的订单</title>

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/bootstrap.css" />
<link rel="stylesheet" href="../plugins/fonts/font-awesome.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/jquery-ui.css" />
<!-- text fonts -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />
<style type="text/css">
.nav li a {
	padding: 10px 3px
}
</style>
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
				ace.settings.check('navbar', 'fixed');
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<!-- #section:basics/sidebar.mobile.toggle -->
			<!-- <button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button> -->

			<!-- /section:basics/sidebar.mobile.toggle -->
			<div class="navbar-header pull-left">
				<!-- #section:basics/navbar.layout.brand -->
				<a href="#" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> 欢迎光顾德玛超市 </small> </a>

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
				ace.settings.check('main-container', 'fixed');
			} catch (e) {
			}
		</script>

		<!-- #section:basics/sidebar 菜单-->
		<div id="sidebar" class="sidebar                  responsive">
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed');
				} catch (e) {
				}
			</script>

			<!-- <div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="ace-icon fa fa-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="ace-icon fa fa-pencil"></i>
					</button>

					#section:basics/sidebar.layout.shortcuts
					<button class="btn btn-warning">
						<i class="ace-icon fa fa-users"></i>
					</button>

					<button class="btn btn-danger">
						<i class="ace-icon fa fa-cogs"></i>
					</button>
					/section:basics/sidebar.layout.shortcuts
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div> -->
			<!-- /.sidebar-shortcuts -->

			<!-- <ul class="nav nav-list">
				<li class=""><a href="index.html"> <i
						class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
							Dashboard </span> </a> <b class="arrow"></b></li>
				<li class=""><a href="index.html"> <i
						class="menu-icon fa fa-tachometer"></i> <span class="menu-text">动态显示物品类别</span>
				</a> <b class="arrow"></b></li>
			</ul> -->
			<!-- /.nav-list -->

			<!-- #section:basics/sidebar.layout.minimize -->
			<!-- <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div> -->

			<!-- /section:basics/sidebar.layout.minimize -->
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed');
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
							ace.settings.check('breadcrumbs', 'fixed');
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">小二百货店</a>
						</li>
						<li class="active"><i class="ace-icon fa fa-list smaller-90"></i>订单列表</li>
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
						<div id="orderlist" class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="align-right">
								<span class="green middle bolder">商家电话：</span>

								<div class="btn-toolbar inline middle no-margin">
									<div data-toggle="buttons" class="btn-group no-margin">
										<label class="btn btn-sm btn-yellow active"> <span
											class="bigger-110">0791-83839936</span> </label>
									</div>
								</div>
							</div>
							<!-- <h3 class="header blue lighter smaller">
								<i class="ace-icon fa fa-list smaller-90"></i> 历史订单
							</h3> -->
								<div id="accordion" class="accordion-style2">
									<c:forEach var="order" items="${requestScope.orderList}">
									<div class="group">
										<h3 class="accordion-header">下单时间：<c:out value="${fn:replace(order.orderTime,'.0','') }"></c:out></h3>
	
										<div id="timeline-1">
											<div class="row">
												<div class="col-xs-12 col-sm-10 col-sm-offset-1">
													<!-- #section:pages/timeline -->
													<div class="timeline-container">
														<div class="timeline-label">
															<!-- #section:pages/timeline.label -->
															<span
																class="label label-primary arrowed-in-right label-lg">
																<b>订单编号：${order.orderNo }</b> </span>
	
															<!-- /section:pages/timeline.label -->
														</div>
	
														<div class="timeline-items">
															<!-- #section:pages/timeline.item -->
															<div class="timeline-item clearfix">
																<!-- #section:pages/timeline.info -->
																<div class="timeline-info">
																	<img alt="Susan't Avatar"
																		src="http://ace.zcdreams.com/assets/avatars/avatar1.png" />
																	<span class="label label-info label-sm"><c:out value="${fn:replace(fn:substring(order.orderTime,0,10),'-','') }"></c:out></span>
																</div>
	
																<!-- /section:pages/timeline.info -->
																<div class="widget-box transparent">
																	<div class="widget-header widget-header-small">
																		<h5 class="widget-title smaller">
																			<span class="grey">订单提交成功</span>
																		</h5>
	
																		<span class="widget-toolbar no-border"> <i
																			class="ace-icon fa fa-clock-o bigger-110"></i>
																			<c:out value="${fn:replace(order.orderTime,'.0','') }"></c:out> </span> <span class="widget-toolbar">
																			<!--  <a
																			href="#" data-action="reload"> <i
																				class="ace-icon fa fa-refresh"></i> </a>  --><a href="#"
																			data-action="collapse"> <i
																				class="ace-icon fa fa-chevron-up"></i> </a> </span>
																	</div>
	
																	<div class="widget-body">
																		<div class="widget-main">
																			<c:if test="${order.orderState=='0' }">
																				<span class="red">等待商家确认！</span><br/>
																			</c:if>
																			<ul class="list-unstyled spaced2">
																				<!-- 循环遍历TOrderdetails里的数据 -->
																				<table style="width:100%">
																					<c:forEach var="orderdetail" items="${order.TOrderdetails }">
																						<tr>
																							<td style="width:70%">
																								<i class="ace-icon fa fa-check green"></i>
																								${orderdetail.TGoods.goodsName }
																							</td>
																							<td style="width:10%">
																								x${orderdetail.buyMount }
																							</td>
																							<td style="width:20%;text-align:right">
																									￥<font class="buyCost">${orderdetail.buyCost }</font>
																							</td>
																						</tr>
																					</c:forEach>
																				</table>
																			</ul> 
																			<div class="space-6"></div>
	
																			<div class="widget-toolbox clearfix">
																				<div class="pull-left">
																					<i class="ace-icon fa fa-hand-o-right grey bigger-125"></i>
																					<a id="orderId" href="javascript:void(0)" class="bigger-110">详情</a>
																				</div>
	
																				<!-- #section:custom/extra.action-buttons -->
																				<div class="pull-right action-buttons">
																					<a href="javascript:void(0)"> <i
																						class="ace-icon fa fa-times red bigger-125"></i>取消订单</a>
																				</div>
	
																				<!-- /section:custom/extra.action-buttons -->
																			</div>
																		</div>
																	</div>
																</div>
															</div>
	
															<!-- /section:pages/timeline.item -->
															<c:if test="${order.orderState=='1'||order.orderState=='2'||order.orderState=='3' }">
																<div class="timeline-item clearfix">
																	<div class="timeline-info">
																		<i
																			class="timeline-indicator ace-icon fa fa-cutlery btn btn-success no-hover"></i>
																	</div>
		
																	<div class="widget-box transparent">
																		<div class="widget-body">
																			<div class="widget-main">
																				商家已确认订单！ 正在为你准备商品!
																				<!-- <div class="pull-right">
																					<i class="ace-icon fa fa-clock-o bigger-110"></i>
																					12:30
																				</div> -->
																			</div>
																		</div>
																	</div>
																</div>
															</c:if>
															<c:if test="${order.orderState=='2'||order.orderState=='3' }">
															<div class="timeline-item clearfix">
																<div class="timeline-info">
																	<i
																		class="timeline-indicator ace-icon fa fa-star btn btn-warning no-hover green"></i>
																</div>
	
																<div class="widget-box transparent">
																	<div class="widget-header widget-header-small">
																		<h5 class="widget-title smaller">配送中</h5>
	
																		<!-- <span class="widget-toolbar no-border"> 
																			<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		</span> -->
																		<span class="widget-toolbar">
																			<!-- <a href="#" data-action="reload">
																				<i class="ace-icon fa fa-refresh"></i>
																			</a> -->
																			<a href="#" data-action="collapse"> 
																				<i class="ace-icon fa fa-chevron-up"></i>
																			</a>
																		</span>
																	</div>
	
																	<div class="widget-body">
																		<div class="widget-main">
																			联系电话：12345678922
																		</div>
																	</div>
																</div>
															</div>
															</c:if>
															
															<c:if test="${order.orderState=='3' }">
															<div class="timeline-item clearfix">
																<div class="timeline-info">
																	<i
																		class="timeline-indicator ace-icon fa fa-check btn btn-success no-hover"></i>
																</div>
	
																<div class="widget-box transparent">
																	<div class="widget-body">
																		<div class="widget-main green">订单已完成</div>
																	</div>
																</div>
															</div>
															</c:if>
														</div>
														<!-- /.timeline-items -->
													</div>
													<!-- /.timeline-container -->
													<!-- /section:pages/timeline -->
												</div>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							<!-- #accordion -->
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
				<li class="green col-xs-4"><a
					href="${pageContext.request.contextPath }/index.jsp"> <i  style="margin-left: 9px"
						class="ace-icon fa fa-home icon-animated-vertical"></i> 商品首页 </a></li>
				<li class="green col-xs-4"><a href="/person.jsp"> <i  style="margin-left: 9px"
						class="ace-icon fa fa-user icon-animated-vertical"></i> 个人中心 </a></li>
				<li class="green col-xs-4"><a id="sureBuy"
					href="javascript:void(0)"> <i
						class="ace-icon fa fa-shopping-cart icon-animated-vertical"></i> <span>确认购买</span>
				</a></li>
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
	<script src="http://ace.zcdreams.com/assets/js/jquery-ui.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.ui.touch-punch.js"></script>
	<!-- ace scripts -->
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.touch-drag.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.sidebar.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/ace.sidebar-scroll-1.js"></script>
	<script
		src="http://ace.zcdreams.com/assets/js/ace/ace.submenu-hover.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.widget-box.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		//jquery accordion
		$("#accordion").accordion({
			collapsible : true,
			heightStyle : "content",
			animate : 250,
			header : ".accordion-header"
		}).sortable(
				{
					axis : "y",
					handle : ".accordion-header",
					stop : function(event, ui) {
						// IE doesn't register the blur when sorting
						// so trigger focusout handlers to remove .ui-state-focus
						ui.item.children(".accordion-header").triggerHandler(
								"focusout");
					}
				});
	</script>
</body>
</html>
