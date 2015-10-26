<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>优选食客-首页</title>

<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/fonts/font-awesome.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/jquery-ui.custom.css" />

<!-- text fonts -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
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
	<div id="navbar" class="navbar navbar-default">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'absolute');
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<button onClick="refresh()" type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span>
				<span class="icon-bar"></span>

				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>


			<div class="navbar-header pull-left">
				<!-- #section:basics/navbar.layout.brand -->
				<a href="#" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> 欢迎来到优选食客 </small> </a>
			</div>
		</div>
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed');
			} catch (e) {
			}
		</script>


		<div id="sidebar" class="sidebar responsive ">
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed');
				} catch (e) {
				}
			</script>
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed');
				} catch (e) {}
			</script>
		</div>

		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed');
						} catch (e) {}
					</script>

					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i>
							<a id="shopname" href="#">优选超市</a>
						</li>
						<li class="active">全部商品</li>
					</ul>

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon">
								<input type="text" placeholder="搜索..." class="nav-search-input" id="nav-search-input" autocomplete="off"/>
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>

				</div>

				<div class="page-content">
					<div class="row">
						<c:forEach var="TSellergoods" items="${goodDetail }" varStatus="status">
							<div class='form-group col-xs-12'>
									<div class='col-xs-6'>
										<img src='${pageContext.request.contextPath}/images/${TSellergoods.TGoods.goodsPic}' class='img-responsive img-rounded' alt='Responsive image' />
									</div>
									<div class='col-xs-6'>
										<p>${TSellergoods.TGoods.TGoodstype.goodsTypeName }</p>
										<p>${TSellergoods.TGoods.goodsPrice }￥/一份</p>
										<div class='ace-spinner middle touch-spinner' style='width: 125px;'>
											<div class='input-group'>
												<div class='spinbox-buttons input-group-btn'>
													<button name='${TSellergoods.TGoods.goodsId}' onClick='downclick(this)' type='button' class='btn spinbox-down btn-sm btn-danger'>
														<i class='icon-only  ace-icon ace-icon fa fa-minus bigger-110'></i>
													</button>
												</div>
												<input type='text' value='0' class='spinner form-control text-center' id='${TSellergoods.TGoods.goodsId}'/>
												<div class='spinbox-buttons input-group-btn'>
													<button name='${TSellergoods.TGoods.goodsId}' onClick='upclick(this)' type='button' class='btn spinbox-up btn-sm btn-success'>
														<i class='icon-only  ace-icon ace-icon fa fa-plus bigger-110'></i>
													</button>
												</div>
											</div>
										</div>
									</div>
									<hr>
							</div>
							<c:if test="${!status.isLast() }">
								<hr class='col-xs-11' style='margin-top:2px;margin-bottom:5px'>
							</c:if>
						</c:forEach>	
						<div id="goodsList" class="col-xs-12">
						</div>
					</div>
				</div>

			</div>
		</div>


		<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
			<ul class="nav navbar-nav">
				<li class="green col-xs-4">
					<a href="${pageContext.request.contextPath }/main.jsp">
						<i style="margin-left: 9px" class="ace-icon fa fa-home icon-animated-vertical"></i>
						商品首页
					</a>
				</li>
				<li class="green col-xs-4">
					<a style="margin-left: 9px" href="${pageContext.request.contextPath }/user/gotoCart">
						<i class="ace-icon fa fa-user icon-animated-vertical"></i>
						购物车
					</a>
				</li>
				<li style="padding-left:2px" class="green col-xs-4">
					<a href="javascript:void(0)">
						<i class="ace-icon fa fa-shopping-cart icon-animated-vertical"></i>
						<span onClick="goBuy()">
							加入购物车
							<span id="countSpan" style="display:none;position: absolute;" class="badge badge-red">
								<font id="count" color="red"></font>
							</span>
						</span>
					</a>
				</li>
			</ul>
		</nav>

		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>

	<!-- basic scripts -->

<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery || document.write("<script src='http://ace.zcdreams.com/assets/js/jquery.js'>"+ "<" + "/script>");
	</script>
<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
 	window.jQuery || document.write("<script src='http://ace.zcdreams.com/assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script type="text/javascript">
		if ("ontouchstart" in document.documentElement)
			document.write("<script src='http://ace.zcdreams.com/assets/js/jquery.mobile.custom.js'>"+ "<" + "/script>");
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
		var page=2;
		var flag="ok";
		$(function() {
			goodsTypeId=getQueryString("goodsTypeId");
			sellerId=getQueryString("sellerId");
			$(window).scroll(function() {
					if ($(document).height() - $(this).scrollTop()- $(this).height() < 20) {
						if(goodsTypeId==null){
							loadGoodsByType();
						}
						if(sellerId!==null){
							loadGoodsBySeller();
						}
					}
			});
		});
		function getQueryString(name) { 
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
			var r = window.location.search.substr(1).match(reg); 
			if (r != null)
				return unescape(r[2]);
			return null; 
		}
		var goodsTypeId;
		function loadGoodsByType() {
			if(flag=="end"){
				return;
			}
			$.ajax({
						type : "get",
						url : "user/findgoodsByType",
						data : {"page" : page,"goodsTypeId":goodsTypeId},
						dataType : "json",
						async : true,
						success : function(data){
							check(data);
						}
			});
		}
		var sellerId=101;
		function loadGoodsBySeller() {
			if(flag=="end"){
				return;
			}
			$.ajax({
				type : "get",
				url : "user/findSellergoods",
				data : {"page" : page,"sellerId":sellerId},
				dataType : "json",
				async : true,
				success : function(data){
							check(data);
				}
			});
		}
		function check(data) {
			if (data.TGoods.length < 10) {
				flag = "end";
			}else{
				page=page+1;
			}
			for( var i = 0; i < data.TGoods.length; i++) {
				var item = "";
				var item = "<div class='goodsId form-group col-xs-12 goods'>"
								+"<div class='col-xs-6'>"
									+"<img src='${pageContext.request.contextPath}/images/"+data.TGoods[i].goodsPic+"' class='img-responsive img-rounded' alt='Responsive image' />"
								+"</div>"
							+"<div class='col-xs-6'>"
										+ "<p>"
										+ data.TGoods[i].goodsName
										+ "</p>"
										+ "<p>"
										+ data.TGoods[i].goodsPrice
										+ "￥/一份</p>"
										+ "<div class='ace-spinner middle touch-spinner' style='width: 125px;'>"
										+ "<div class='input-group'><div class='spinbox-buttons input-group-btn'>"
										+ "<button name='"+data.TGoods[i].goodsId+"' onClick='downclick(this)' type='button' class='btn spinbox-down btn-sm btn-danger'>"
										+ "<i class='icon-only  ace-icon ace-icon fa fa-minus bigger-110'></i>"
										+ "</button></div>"
										+ "<input type='text' value='0' class='spinner form-control text-center' id='"+data.TGoods[i].goodsId+"'/>"
										+ "<div class='spinbox-buttons input-group-btn'>"
										+ "<button name='"+data.TGoods[i].goodsId+"' onClick='upclick(this)' type='button' class='btn spinbox-up btn-sm btn-success'>"
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
		var count=0;
		var map={};
		function downclick(obj) {
			var input = $(obj).parent().siblings("input");
			var value = input.val();
			var key=$(obj).attr("name");
			if (value < 1) {
				input.val("0");
				return;
			}else {
				input.val(value - 1);
				map[key]=map[key]-1;
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
			var key=$(obj).attr("name");
			var value = input.val();
			if (value >= 100) {
				input.val("100");
				map[key]=value;
			} else {
				input.val(parseInt(value) + 1);
				if(map.hasOwnProperty(key)){
					map[key]=parseInt(map[key]) + 1;
				}else{
					map[key]=parseInt(value) + 1;
				}
				count=parseInt(count)+1;
				if(parseInt(count)>0){
					$("#countSpan").css("display","inline");
				}
				$("#count").text(count);
			}
		}
		function goBuy(){
			var jsonString="{\"array\":[";
			for(var i in map){
				var goodsId=i;
				var goodsMount=map[i];
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
		}
	</script>
</body>
</html>
