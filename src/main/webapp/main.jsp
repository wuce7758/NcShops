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
<title>优选食客-首页</title>

<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/bootstrap.css" />
<link rel="stylesheet" href="plugins/fonts/font-awesome.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/jquery-ui.custom.css" />

<!-- text fonts -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
	<style type="text/css">
		.nav li a{padding:10px 3px}
		body{font-family:"微软雅黑"}
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
			<div class="navbar-header">
				<!-- #section:basics/navbar.layout.brand -->
				<a href="#" class="navbar-brand text-center">
					<small>
						<i class="fa fa-leaf"></i>
						欢迎来到优选食客 
					</small>
				</a>
			</div>
		</div>
	</div>

	<div class="main-container container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed');
			} catch (e) {
			}
		</script>



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
						<!-- <li class="active">全部商品</li> -->
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
						<!-- 广告 -->
						<div class="row">
							<div id="carousel-example-generic" style="padding-left:0px;padding-right:0px" class="carousel slide responsive col-xs-12" data-ride="carousel">
							  <!-- Indicators -->
							  <!-- <ol class="carousel-indicators">
							    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
							  </ol> -->
							
							  <!-- Wrapper for slides -->
							  <div class="carousel-inner" role="listbox" id="ads">
							    
							  </div>
							</div>
						</div>
						<!-- 分类 -->
						<div class="row" style="margin-top:5px">
							<div id="goods_type">
								
							</div>
						</div>
						<!-- 商家 -->
						<div class="row">
							  <ul class="nav nav-tabs" role="tablist">
							    <li style="width:50%" role="presentation" class="active text-center">
							    	<a href="#seller_tab" aria-controls="seller_tab" role="tab" data-toggle="tab"><strong>特色商家</strong></a>
							    </li>
							    <li id="recommend" style="width:50%" role="presentation" class="text-center">
							    	<a href="#goods_tab" aria-controls="goods_tab" role="tab" data-toggle="tab"><strong>推荐套餐</strong></a>
							    </li>
							  </ul>
							  <div class="tab-content">
							    <div style="height:10px" role="tabpanel" class="tab-pane active fade in center" id="seller_tab">
							    	<div id="all_seller">
							    		
							    	</div>
							    </div>
							    
							    <div style="height:10px" role="tabpanel" class="tab-pane fade" id="goods_tab">
							    	<div id="set_goods">
									
									</div>
							    </div>
							  </div>
						</div>
					</div>
				</div>

			</div>
		</div>


		<nav class="navbar navbar-default navbar-fixed-bottom"
			role="navigation">
			<ul class="nav navbar-nav">
				<li style="padding-left: 10px" class="green col-xs-4">
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
				<li style="padding-left: 2px" class="green col-xs-4">
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
		var type="off";
		$(function() {
			loadADS();
			loadGoodsType();
			loadSeller();
			loadSetGoods();
			$("#recommend").click(function(){
				type="on";
			});
			$(window).scroll(function() {
					if ($(document).height() - $(this).scrollTop()- $(this).height() < 20) {
						if(flag=="ok"&&type=="on"){
							loadSetGoods();
						}
					}
			});
		});
		function loadADS(){
			$.ajax({
				type : "get",
				url : "${pageContext.request.contextPath}/user/getAds",
				dataType : "json",
				async : true,
				success : function(data) {
						for ( var i = 0; i < data.TAds.length; i++) {
							if(i==3){
								break;
							}
							var item = "";
							item= "<div class='item";
							if(i==0){
								item+=" active";
							}
							item+="' style='height:128px'>"+
							      "<img width='100%' height='186px' src='images/"+data.TAds[i].adsPic+"' alt='...' class='img-responsive'>"+
							    "</div>";
							$("#ads").append(item);
						}
					}
			});
		}
		function loadGoodsType(){
			$.ajax({
				type : "get",
				url : "${pageContext.request.contextPath}/user/getAllGoodsType",
				dataType : "json",
				async : true,
				success : function(data) {
						for ( var i = 0; i < data.TGoodstype.length; i++) {
							var item = "";
							item= "<div class='col-xs-3 col-md-3 center-block center'>"+
    								"<a href='${pageContext.request.contextPath}/user/findGoodsByTypeId?page=1&goodsTypeId="+data.TGoodstype[i].goodsTypeId+"' class='circle'>"+
      									"<img width='50px' height='50px' src='${pageContext.request.contextPath}/images/"+data.TGoodstype[i].goodsTypeImg+"' alt='...' class='img-circle'>"+
    								"</a>"+
    								"<p class=''><strong>"+data.TGoodstype[i].goodsTypeName+"</strong></p>"+
  								"</div>";
							$("#goods_type").append(item);
						}
					}
			});
		}
		var page=1;
		var flag="ok";
		function loadSeller(){
			$.ajax({
						type : "get",
						url : "${pageContext.request.contextPath}/user/findAllShops",
						dataType : "json",
						async : true,
						success : function(data) {
							for ( var i = 0; i < data.TSeller.length; i++) {
								var item = "<div class='col-xs-12'>"+
											"<div class='col-xs-6 text-center'>"+
												"<img src='images/"+data.TSeller[i].shopPic+"' class='img-responsive img-rounded' alt='Responsive image' />"+
												"<p><strong>"+data.TSeller[i].shopName+"</strong></p>"+
											"</div>"+
											"<div class='col-xs-6'>"+
												"<p class='text-left'>"+data.TSeller[i].sellerMsg+"</p>"+
												"<div class='input-group pull-right'>"+
													"<button onClick='javascript:window.location.href=\"${pageContext.request.contextPath}/user/findGoodsBySeller?page=1&sellerId="+data.TSeller[i].sellerId+"\"' type='button' class='btn btn-danger'>瞧一瞧</button>"+
												"</div>"+
											"</div>"+
										"</div>";
								if(i!=data.TSeller.length-1){
									item+="<hr class='col-xs-11' style='margin-top:2px;margin-bottom:5px'>";
								}
								var height=$("#seller_tab").css("height");
								height=height.substring(0,height.lastIndexOf("px"));
								$("#seller_tab").css("height",parseInt(height)+105);
								$("#all_seller").append(item);
							}
						}
					});
		}
		function loadSetGoods(){
			if(flag!="ok"){
				return;
			}
			$.ajax({
						type : "get",
						url : "${pageContext.request.contextPath}/user/findgoodsByType?goodsTypeId=8&page="+page,
						dataType : "json",
						async : true,
						success : function(data) {
							if(data.TGoods.length<10){
								flag="end";
							}
							for ( var i = 0; i < data.TGoods.length; i++) {
								var item = "<div class='goodsId form-group col-xs-12 goods'>"
											+"<div class='col-xs-6 text-center'>"
												+"<img src='${pageContext.request.contextPath}/images/"+data.TGoods[i].goodsPic+"' class='img-responsive img-rounded' alt='Responsive image' />"
												+ "<p>"+ data.TGoods[i].goodsName+ "</p>"
											+"</div>"
												+"<div class='col-xs-6'>"
												+ "<p>"+ data.TGoods[i].goodsPrice+ "￥/一份</p>"
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
								if(i!=data.TGoods.length-1){
									item+="<hr class='col-xs-11' style='margin-top:2px;margin-bottom:5px'>";
								}
								var height=$("#goods_tab").css("height");
								height=height.substring(0,height.lastIndexOf("px"));
								$("#goods_tab").css("height",parseInt(height)+105);
								$("#set_goods").append(item);
								page++;
							}
						}
					});
		}
	    /*function loadGoodsByType(object,goodsTypeId) {
			if(object!=null){
				var nav= $(object).text();
				$(".active").text(nav);
				if(obj!=object){
					$("#goodsList").html("");
					obj=object;
				}
			}
			$("#sidebar").removeClass("display");
			if (flag != "2") {
				return;
			}
			if(preGoodsType!=goodsTypeId){
				preGoodsType=goodsTypeId;
				$("#goodsList").html("");
			}
			$.ajax({
						type : "get",
						url : "user/findgoodsByType",
						data : {"page" : page,"goodsTypeId":preGoodsType},
						dataType : "json",
						async : true,
						success : function(data){
							check(data);
						}
			});
			$("#goodsType").html("");
		} */
		/* function loadGoodsBySeller(object,goodsSellerId) {
			sellerId=goodsSellerId;
			count=0;
			if(object!=null){
				var nav= $(object).attr("name");
				$(".active").text("");
				$("#shopname").text(nav);
				if(obj!=object){
					$("#goodsList").html("");
					obj=object;
				}
			}
			$("#sidebar").removeClass("display");
			if (flag != "3") {
				return;
			}
			if(preSellerId!=goodsSellerId){
				preSellerId=goodsSellerId;
				$("#goodsList").html("");
			}
			$.ajax({
				type : "get",
				url : "user/findSellergoods",
				data : {"page" : page,"sellerId":goodsSellerId},
				dataType : "json",
				async : true,
				success : function(data){
							check(data);
				}
			});
			$("#goodsType").html("");
		} */
		/* function check(data) {
			if (data.TGoods == null || data.TGoods.length < 1) {
				flag = "0";
				return;
			}
			if (data.TGoods.length < 10) {
				flag = "0";
			} else if (data.TGoods.length = 10) {
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
		} */
		
		/* function loadData() {
			if (flag != "1") {
				return;
			}
			$.ajax({
				type : "get",
				url : "user/findAllGoods",
				data : {"page" : page},
				dataType : "json",
				async : true,
				success : function(data){
						check(data);
				}
			});
		} */
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
		/* jQuery(function($) {
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
		}); */
		function goBuy(){
			//var goodsItem=$("input.spinner");
			var jsonString="{\"array\":[";
			for(var i in map){
				var goodsId=i;
				var goodsMount=map[i];
				if(parseInt(goodsMount)>0){
					jsonString+="{\"goodsId\":\""+goodsId.trim()+"\",\"buyMount\":\""+goodsMount+"\"},";
				}
			}
			/* for(var i=0;i<map.size;i++){
				var goodsId=goodsItem[i].id;
				var goodsMount=goodsItem[i].value;
				if(parseInt(goodsMount)>0){
					jsonString+="{\"goodsId\":\""+goodsId.trim()+"\",\"buyMount\":\""+goodsMount+"\"},";
				}
			} */
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
