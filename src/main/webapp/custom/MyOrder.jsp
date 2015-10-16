<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title>德玛超市-订单确认</title>

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
							Dashboard </span> </a> <b class="arrow"></b>
				</li>
				<li class=""><a href="index.html"> <i
						class="menu-icon fa fa-tachometer"></i> <span class="menu-text">动态显示物品类别</span>
				</a> <b class="arrow"></b>
				</li>
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
						<li class="active">确认订单</li>
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
						<div id="order" class="col-xs-12" style="margin-bottom: 10px">
							<!-- PAGE CONTENT BEGINS -->
							<div class="col-xs-6 col-sm-3 pricing-box" style="height:100%">
								<div class="widget-box widget-color-blue" style="height:100%">
									<div class="widget-header">
										<h5 class="widget-title bigger lighter">确认订单</h5>
									</div>

									<div class="widget-body">
										<div class="widget-main">
											<ul class="list-unstyled spaced2">
												<!-- 循环遍历域里的数据 -->
												<table style="width:100%">
													<c:forEach var="orderdetail" items="${odersdetails }">
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

											<hr />
											<div id="orderPrice" class="price">
												<strong>${sessionScope.allCost }</strong><small>元</small>
											</div>
											<!-- 加载默认地址 -->
   											<c:if test="${requestScope.address==null }">
		   										<font color='red'>
	   												<c:out value="您还没地址，请先设置地址!"></c:out>
	   											</font>
	   										</c:if>
   											<c:forEach var="address" items="${address}">
		   										<p><c:out value="接收人：${address.receiverName }"></c:out></p>
		   										<p><c:out value="地址：${address.adsContent }"></c:out></p>
		   										<p><c:out value="联系方式：${address.adsPhone }"></c:out></p>
		   										<div style="height:25px;width:100%;text-align:right">
													<div style="float:right;width:50%">
														<button id="update" style="margin-right:5px" class="btn btn-minier btn-info btn-bold col-xs-5">
															<i class="bigger-120 orange"></i>
															<font>修改</font>
														</button>
														<button id="add" style="margin-right:5px;float:right" class="btn btn-minier btn-info btn-bold col-xs-5">
															<i class="bigger-120 orange"></i>
															<font>添加</font>
														</button>
													</div>
												</div>
												<!-- 修改地址 -->
											<div id="updateAddress" style="display:none;height:150px">
												<c:forEach var="address" items="${requestScope.address}">
												<form id="fromAddress" action="${pageContext.request.contextPath }/user/addAddress" role="form">
													<div class="form-group">
														<label class="col-xs-3 control-label no-padding-right"
															for="userName" style="margin-top: 5px">姓名：</label>
														<div class="col-xs-9" style="margin-bottom: 3px">
															<input type="text" name="receiverName" id="userName" value="${address.receiverName }"
																class="b col-xs-12" />
														</div>
														<label class="col-xs-3 control-label no-padding-right"
															for="userAddress" style="margin-top: 5px">地址：</label>
	
														<div class="col-xs-9" style="margin-bottom: 3px">
															<input type="text" name="adsContent" id="userAddress" value="${address.adsContent }"
																class="b col-xs-12" />
														</div>
														<label class="col-xs-3 control-label no-padding-right"
															for="userPhone" style="margin-top: 5px">电话：</label>
														<div class="col-xs-9" style="margin-bottom: 3px">
															<input onkeyup="value=value.replace(/[^0-9]/g,'')" type="text" name="adsPhone" id="userPhone" value="${address.adsPhone }"
																class="b col-xs-12" />
														</div>
													</div>
													<button style="margin-left:13px" disabled id="updateButton" class="btn btn-white btn-info btn-bold col-xs-5">
														<i class="ace-icon fa fa-pencil bigger-120 orange"></i>
														<font>修改</font>
													</button>
												</form>
													<button style="margin-left:25px" id="cancelUpdate" class="btn btn-white btn-info btn-bold col-xs-5">
														<i class="ace-icon fa fa-pencil bigger-120 orange"></i>
														<font>取消</font>
													</button>
												</c:forEach>
											</div>
   											</c:forEach>
   											<!-- 添加地址 -->
											<div id="addAddress" style="display:none">
												<form id="fromAddress" action="${pageContext.request.contextPath }/user/addAddress" role="form">
													<div class="form-group">
														<label class="col-xs-3 control-label no-padding-right"
															for="userName" style="margin-top: 5px">姓名：</label>
														<div class="col-xs-9" style="margin-bottom: 3px">
															<input type="text" name="receiverName" id="userName" placeholder="收货人" value="${sessionScope.user.userName }"
																class="a col-xs-12" />
														</div>
														<label class="col-xs-3 control-label no-padding-right"
															for="userAddress" style="margin-top: 5px">地址：</label>
	
														<div class="col-xs-9" style="margin-bottom: 3px">
															<input type="text" name="adsContent" id="userAddress" placeholder="客户地址"
																class="a col-xs-12" />
														</div>
														<label class="col-xs-3 control-label no-padding-right"
															for="userPhone" style="margin-top: 5px">电话：</label>
														<div class="col-xs-9" style="margin-bottom: 3px">
															<input onkeyup="value=value.replace(/[^0-9]/g,'')" type="text" name="adsPhone" id="userPhone" placeholder="客户电话"
																class="a col-xs-12" />
														</div>
													</div>
													<button style="margin-left:13px" disabled id="savaOrUpdate" class="btn btn-white btn-info btn-bold col-xs-5">
														<i class="ace-icon fa fa-pencil bigger-120 orange"></i>
														<font>保存</font>
													</button>
												</form>
													<button style="margin-left:25px" id="cancelAdd" class="btn btn-white btn-info btn-bold col-xs-5">
														<i class="ace-icon fa fa-pencil bigger-120 orange"></i>
														<font>取消</font>
													</button>
											<p style="margin-top: 5px"><font color="red">请检查地址正确后再确认订单！</font></p>
											
											</div>
											
										</div>

										<div id="dialog_sureBuy_confirm" class="hide">
											<font color="red">提示</font>
											<div class="space-6"></div>
											<p class="bigger-110 bolder center grey">
												<i class="ace-icon fa fa-hand-o-right blue bigger-120"></i>
												确定提交?
											</p>
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
				<li class="green col-xs-4">
					<a href="${pageContext.request.contextPath }/index.jsp">
						<i class="ace-icon fa fa-home icon-animated-vertical"></i>
						商品首页
					</a>
				</li>
				<li class="green col-xs-4">
					<a href="/person.jsp">
						<i class="ace-icon fa fa-user icon-animated-vertical"></i>
						个人中心
					</a>
				</li>
				<li class="green col-xs-4">
					<a id="sureBuy" href="javascript:void(0)">
						<i class="ace-icon fa fa-shopping-cart icon-animated-vertical"></i>
						<span>确认购买</span>
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
	<script src="http://ace.zcdreams.com/assets/js/jquery.gritter.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.colorbox.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery-ui.js"></script>
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
		var flag="${requestScope.address}";
		function changeStyle(){
			if(flag.length<1){
				$("#addAddress").css("display","inline");
			}
		}
		$(document).ready(function(){
			changeStyle();
			$("#update").click(function(){
				$("#updateAddress").css("display","");
				$("#update").attr("disabled",true);
				$("#add").attr("disabled",true);
			});
			$("#add").click(function(){
				$("#add").attr("disabled",true);
				$("#update").attr("disabled",true);
				$("#addAddress").css("display","inline");
			});
			$("#cancelUpdate").click(function(){
				$("#updateAddress").hide();
				$("#update").attr("disabled",false);
				$("#add").attr("disabled",false);
			});
			$("#cancelAdd").click(function(){
				$("#addAddress").hide();
				$("#update").attr("disabled",false);
				$("#add").attr("disabled",false);
			});
			$(".a").keyup(function(){
				var input=$(".a");
				for(var i=0;i<input.length;i++){
					var item=input[i];
					if(item.value!=""&&i==input.length-1){
						$("#savaOrUpdate").attr("disabled",false);
					}else{
						$("#savaOrUpdate").attr("disabled",true);
					}
				}
			});
			$(".b").keyup(function(){
				var input=$(".b");
				for(var i=0;i<input.length;i++){
					var item=input[i];
					if(item.value!=""&&i==input.length-1){
						$("#updateButton").attr("disabled",false);
					}else{
						$("#updateButton").attr("disabled",true);
					}
				}
			});
			$('#sureBuy').click(function (e) {
                e.preventDefault();
                $('#dialog_sureBuy_confirm').removeClass('hide').dialog({
                    resizable: false,
                    width: '320',
                    modal: true,
                    title: "",
                    title_html: true,
                    buttons: [
                        {
                            html: "<i class='ace-icon fa fa-save bigger-110'></i>确认下单",
                            "class": "btn btn-success btn-minier",
                            click: function () {
                                $(this).dialog("close");
                                $.ajax({
                                    cache: false,
                                    type: "POST",
                                    url: "../user/buy",
                                    data: "123",//$('#form_Menu').serialize(),
                                    async: false,
                                    error: function (request) {
                                        console.log("error");
                                    },
                                    success: function (data) {
                                        if (data == "1") {
                                        	//console.log("ok");
                                            //$("#menuState").html('按钮提交成功！');
                                            window.location.href="${pageContext.request.contextPath}/index.jsp";
                                        }
                                        else {
                                        	$("#buttonBuy").removeClass('hide');
                                        	console.log("someCatch");
                                            //$("#menuState").html(data);
                                        }
                                    }
                                });
                            }
                        },
                        {
                            html: "<i class='ace-icon fa fa-times bigger-110'></i>取消",
                            "class": "btn btn-minier",
                            click: function () {
                                $(this).dialog("close");
                            }
                        }
                    ]
                });
            });
            
            
		});
	</script>
</body>
</html>
