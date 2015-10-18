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
<title>德玛超市-首页</title>

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/bootstrap.css" />
<link rel="stylesheet" href="plugins/fonts/font-awesome.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/jquery-ui.custom.css" />

<!-- text fonts -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />
	<style type="text/css">
		.nav li a{padding:10px 3px}
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
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<!-- /section:basics/sidebar.mobile.toggle -->
			<div class="navbar-header pull-left">
				<!-- #section:basics/navbar.layout.brand -->
				<a href="#" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> 欢迎光顾德玛商店 </small> </a>

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
						<li class="active">所有商品</li>
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
						<div id="goodsList" class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

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
				<li class="green col-xs-4">
					<a href="${pageContext.request.contextPath }/index.jsp">
						<i style="margin-left: 9px" class="ace-icon fa fa-home icon-animated-vertical"></i>
						商品首页
					</a>
				</li>
				<li class="green col-xs-4">
					<a style="margin-left: 9px" href="${pageContext.request.contextPath }/custom/person.jsp">
						<i class="ace-icon fa fa-user icon-animated-vertical"></i>
						个人中心
					</a>
				</li>
				<li class="green col-xs-4">
					<a href="javascript:void(0)">
						<i class="ace-icon fa fa-shopping-cart icon-animated-vertical"></i>
						<span onClick="goBuy()">
							确认购买
							<span id="countSpan" style="display:none;position: absolute;" class="badge badge-red">
								<font id="count" color="red"></font>
							</span>
						</span>
					</a>
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
	<script src="http://ace.zcdreams.com/assets/js/jquery-ui.custom.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/fuelux/fuelux.spinner.js"></script>

	<!-- ace scripts -->
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/ace/ace.sidebar.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		var pageNum = "1";
		var flag = 0;
		function loadData() {
			if (flag != 0) {
				return;
			}
			$
					.ajax({
						type : "get",
						url : "user/findAllGoods",
						data : {
							page : pageNum
						},
						dataType : "json",
						success : function(data) {
							if (data.TGoods == null || data.TGoods.length < 1) {
								flag = 1;
								return;
							}
							if (data.TGoods.length < 10) {
								flag = 1;
							} else if (data.TGoods.length = 10) {
								pageNum++;
							}
							for ( var i = 0; i < data.TGoods.length; i++) {
								var item = "";
								var item = "<div class='form-group col-xs-12 goods'>"
										+ "<div class='col-xs-6'>"
										+ "<img src='${pageContext.request.contextPath}/images/"+data.TGoods[i].goodsPic+"' class='img-responsive img-rounded' alt='Responsive image' />"
										+ "</div>"
										+ "<div class='col-xs-6'>"
										+ "<p>"
										+ data.TGoods[i].goodsName
										+ "</p>"
										+ "<p>"
										+ data.TGoods[i].goodsPrice
										+ "￥/一份</p>"
										+ "<div class='ace-spinner middle touch-spinner' style='width: 125px;'>"
										+ "<div class='input-group'><div class='spinbox-buttons input-group-btn'>"
										+ "<button onClick='downclick(this)' type='button' class='btn spinbox-down btn-sm btn-danger'>"
										+ "<i class='icon-only  ace-icon ace-icon fa fa-minus bigger-110'></i>"
										+ "</button></div>"
										+ "<input type='text' value='0' class='spinner form-control text-center' id='"+data.TGoods[i].goodsId+" '/>"
										+ "<div class='spinbox-buttons input-group-btn'>"
										+ "<button onClick='upclick(this)' type='button' class='btn spinbox-up btn-sm btn-success'>"
										+ "<i class='icon-only  ace-icon ace-icon fa fa-plus bigger-110'></i>"
										+ "</button>"
										+ "</div>"
										+ "</div>"
										+ "</div>"
										+ "</div>"
										+ "<hr>"
										+ "</div>";
								if (i != data.TGoods.length) {
									item += "<hr class='col-xs-12' style='margin-top:2px;margin-bottom:5px'>";
								}
								$("#goodsList").append(item);
							}
						}
					});
		}
		var count=0;
		function downclick(obj) {
			var input = $(obj).parent().siblings("input");
			var value = input.val();
			if (input.val() < 1) {
				input.val("0");
			} else {
				input.val(input.val() - 1);
				if(parseInt(count)>0){
				count=count-1;
				if(count==0){
					$("#countSpan").css("display","none");
				}else{
					$("#countSpan").css("display","inline");
				}
				$("#count").text(count);
			}
			}
		}
		function upclick(obj) {
			var input = $(obj).parent().siblings("input");
			var value = input.val();
			if (input.val() >= 100) {
				input.val("100");
			} else {
				input.val(parseInt(value) + 1);
				count=parseInt(count)+1;
				if(parseInt(count)>0){
					$("#countSpan").css("display","inline");
				}
				$("#count").text(count);
			}
		}
		$(function() {
			loadData();
			$(window).scroll(
					function() {
						if ($(document).height() - $(this).scrollTop()
								- $(this).height() < 20) {
							loadData();
						}
					});
		});
		jQuery(function($) {
			$('.spinner').ace_spinner({
				value : 0,
				min : 0,
				max : 100,
				step : 1,
				on_sides : true,
				icon_up : 'ace-icon fa fa-plus bigger-110',
				icon_down : 'ace-icon fa fa-minus bigger-110',
				btn_up_class : 'btn-success',
				btn_down_class : 'btn-danger'
			});
		});
		function goBuy(){
			var goodsItem=$("input.spinner");
			var jsonString="{\"array\":[";
			for(var i=0;i<goodsItem.length;i++){
				var goodsId=goodsItem[i].id;
				var goodsMount=goodsItem[i].value;
				if(parseInt(goodsMount)>0){
					jsonString+="{\"goodsId\":\""+goodsId.trim()+"\",\"buyMount\":\""+goodsMount+"\"},";
				}
			}
			jsonString+="]}";
			var lastIndex = jsonString.lastIndexOf(',');
			if (lastIndex > -1) {
          		jsonString = jsonString.substring(0, lastIndex) + jsonString.substring(lastIndex + 1, jsonString.length);
      		}else if(lastIndex==-1){
      			return;
      		}
      		window.location.href="user/addOrders?jsonString="+jsonString;
			//$.post("user/addOrders",{jsonString:jsonString});
		}
	</script>
</body>
</html>
