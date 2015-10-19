<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="initial-scale=1.0" />
<meta name="format-detection" content="telephone=no" />
<title></title>

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/chosen.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/plugins/fonts/font-awesome.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/jquery-ui.css" />
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/chosen.css" />
<link rel="stylesheet"
	href="http://ace.zcdreams.com/assets/css/jquery.gritter.css" />
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

<!-- inline styles related to this page -->
<style type="text/css">
body {
	width: 100%;
	margin: 0;
	padding: 0;
	-webkit-font-smoothing: antialiased;
}

@media only screen and (max-width: 600px) {
	table[class="table-row"] {
		float: none !important;
		width: 98% !important;
		padding-left: 20px !important;
		padding-right: 20px !important;
	}
	table[class="table-row-fixed"] {
		float: none !important;
		width: 98% !important;
	}
	table[class="table-col"],table[class="table-col-border"] {
		float: none !important;
		width: 100% !important;
		padding-left: 0 !important;
		padding-right: 0 !important;
		table-layout: fixed;
	}
	td[class="table-col-td"] {
		width: 100% !important;
	}
	table[class="table-col-border"]+table[class="table-col-border"] {
		padding-top: 12px;
		margin-top: 12px;
		border-top: 1px solid #E8E8E8;
	}
	table[class="table-col"]+table[class="table-col"] {
		margin-top: 15px;
	}
	td[class="table-row-td"] {
		padding-left: 0 !important;
		padding-right: 0 !important;
	}
	table[class="navbar-row"],td[class="navbar-row-td"] {
		width: 100% !important;
	}
	img {
		max-width: 100% !important;
		display: inline !important;
	}
	img[class="pull-right"] {
		float: right;
		margin-left: 11px;
		max-width: 125px !important;
		padding-bottom: 0 !important;
	}
	img[class="pull-left"] {
		float: left;
		margin-right: 11px;
		max-width: 125px !important;
		padding-bottom: 0 !important;
	}
	table[class="table-space"],table[class="header-row"] {
		float: none !important;
		width: 98% !important;
	}
	td[class="header-row-td"] {
		width: 100% !important;
	}
}

@media only screen and (max-width: 480px) {
	table[class="table-row"] {
		padding-left: 16px !important;
		padding-right: 16px !important;
	}
}

@media only screen and (max-width: 320px) {
	table[class="table-row"] {
		padding-left: 12px !important;
		padding-right: 12px !important;
	}
}

@media only screen and (max-width: 458px) {
	td[class="table-td-wrap"] {
		width: 100% !important;
	}
}
</style>
</head>

<body
	style="font-family: Arial, sans-serif; font-size:13px; color: #444444; min-height: 200px;"
	bgcolor="#E4E6E9" leftmargin="0" topmargin="0" marginheight="0"
	marginwidth="0">
	<table width="100%" height="100%" bgcolor="#E4E6E9" cellspacing="0"
		cellpadding="0" border="0">
		<tr>
			<td width="100%" align="center" valign="top" bgcolor="#E4E6E9"
				style="background-color:#E4E6E9; min-height: 200px;">
				<table>
					<tr>
						<td class="table-td-wrap" align="center" width="458">
							<table class="table-space" height="18"
								style="height: 18px; font-size: 0px; line-height: 0; width: 450px; background-color: #e4e6e9;"
								width="450" bgcolor="#E4E6E9" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr>
										<td class="table-space-td" valign="middle" height="18"
											style="height: 18px; width: 450px; background-color: #e4e6e9;"
											width="450" bgcolor="#E4E6E9" align="left">&nbsp;</td>
									</tr>
								</tbody>
							</table>
							<table class="table-space" height="8"
								style="height: 8px; font-size: 0px; line-height: 0; width: 450px; background-color: #ffffff;"
								width="450" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr>
										<td class="table-space-td" valign="middle" height="8"
											style="height: 8px; width: 450px; background-color: #ffffff;"
											width="450" bgcolor="#FFFFFF" align="left">&nbsp;</td>
									</tr>
								</tbody>
							</table>

							<table class="table-row" width="450" bgcolor="#FFFFFF"
								style="table-layout: fixed; background-color: #ffffff;"
								cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td class="table-row-td"
											style="font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 36px; padding-right: 36px;"
											valign="top" align="left">
											<table class="table-col" align="left" width="378"
												cellspacing="0" cellpadding="0" border="0"
												style="table-layout: fixed;">
												<tbody>
													<tr>
														<td class="table-col-td" width="378"
															style="font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; width: 378px;"
															valign="top" align="left">
															<table class="header-row" width="378" cellspacing="0"
																cellpadding="0" border="0" style="table-layout: fixed;">
																<tbody>
																	<tr>
																		<td id="headname" class="header-row-td text-center"
																			width="378"
																			style="font-family: Arial, sans-serif; font-weight: normal; line-height: 19px; color: #478fca; margin: 0px; font-size: 18px; padding-bottom: 10px; padding-top: 15px;"
																			valign="top" align="left"></td>
																	</tr>
																	<tr>
																		<td id="ordertime" class="text-center"></td>
																	</tr>
																	<tr>
																		<td id="orderno" class="text-center"></td>
																	</tr>
																	<tr>
																		<td><hr>
																		</td>
																	</tr>
																</tbody>
															</table>
															<div
																style="font-family: Arial, sans-serif; line-height: 20px; color: #444444; font-size: 13px;">
																<div class="widget-body">
																	<div class="widget-main">
																		<ul class="list-unstyled spaced2">
																			<table style="width:100%">
																				<thead>
																					<th style="width:40%">商品名</th>
																					<th style="width:20%">数量</th>
																					<th style="width:20%">单价</th>
																					<th style="width:20%;" class="text-right">金额</th>
																				</thead>
																				<tbody id="orderdetails">

																				</tbody>
																			</table>
																		</ul>
																		<hr />
																		<div id="orderuserdetail">加载中...</div>
																	</div>
																</div>
															</div></td>
													</tr>
												</tbody>
											</table></td>
									</tr>
								</tbody>
							</table>

							<table class="table-space" height="12"
								style="height: 12px; font-size: 0px; line-height: 0; width: 450px; background-color: #ffffff;"
								width="450" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr>
										<td class="table-space-td" valign="middle" height="12"
											style="height: 12px; width: 450px; background-color: #ffffff;"
											width="450" bgcolor="#FFFFFF" align="left">&nbsp;</td>
									</tr>
								</tbody>
							</table>
							<table class="table-space" height="12"
								style="height: 12px; font-size: 0px; line-height: 0; width: 450px; background-color: #ffffff;"
								width="450" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr>
										<td class="table-space-td" valign="middle" height="12"
											style="height: 12px; width: 450px; padding-left: 16px; padding-right: 16px; background-color: #ffffff;"
											width="450" bgcolor="#FFFFFF" align="center">&nbsp;
											<table bgcolor="#E8E8E8" height="0" width="100%"
												cellspacing="0" cellpadding="0" border="0">
												<tbody>
													<tr>
														<td bgcolor="#E8E8E8" height="1" width="100%"
															style="height: 1px; font-size:0;" valign="top"
															align="left">&nbsp;</td>
													</tr>
												</tbody>
											</table></td>
									</tr>
								</tbody>
							</table>
							<table class="table-space" height="16"
								style="height: 16px; font-size: 0px; line-height: 0; width: 450px; background-color: #ffffff;"
								width="450" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr>
										<td class="table-space-td" valign="middle" height="16"
											style="height: 16px; width: 450px; background-color: #ffffff;"
											width="450" bgcolor="#FFFFFF" align="left">&nbsp;</td>
									</tr>
								</tbody>
							</table>

							<table class="table-row" width="450" bgcolor="#FFFFFF"
								style="table-layout: fixed; background-color: #ffffff;"
								cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td class="table-row-td"
											style="font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 36px; padding-right: 36px;"
											valign="top" align="left">
											<table class="table-col" align="left" width="378"
												cellspacing="0" cellpadding="0" border="0"
												style="table-layout: fixed;">
												<tbody>
													<tr>
														<td class="table-col-td" width="378"
															style="font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; width: 378px;"
															valign="top" align="left">
															<div
																style="font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; text-align: center;">

															</div>
															<table class="table-space" height="16"
																style="height: 16px; font-size: 0px; line-height: 0; width: 378px; background-color: #ffffff;"
																width="378" bgcolor="#FFFFFF" cellspacing="0"
																cellpadding="0" border="0">
																<tbody>
																	<tr>
																		<td class="table-space-td" valign="middle" height="16"
																			style="height: 16px; width: 378px; background-color: #ffffff;"
																			width="378" bgcolor="#FFFFFF" align="left">&nbsp;</td>
																	</tr>
																</tbody>
															</table></td>
													</tr>
												</tbody>
											</table></td>
									</tr>
								</tbody>
							</table>

							<table class="table-space" height="6"
								style="height: 6px; font-size: 0px; line-height: 0; width: 450px; background-color: #ffffff;"
								width="450" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr>
										<td class="table-space-td" valign="middle" height="6"
											style="height: 6px; width: 450px; background-color: #ffffff;"
											width="450" bgcolor="#FFFFFF" align="left">&nbsp;</td>
									</tr>
								</tbody>
							</table>

							<table class="table-row-fixed" width="450" bgcolor="#FFFFFF"
								style="table-layout: fixed; background-color: #ffffff;"
								cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td class="table-row-fixed-td"
											style="font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 1px; padding-right: 1px;"
											valign="top" align="left">
											<table class="table-col" align="left" width="448"
												cellspacing="0" cellpadding="0" border="0"
												style="table-layout: fixed;">
												<tbody>
													<tr>
														<td class="table-col-td" width="448"
															style="font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal;"
															valign="top" align="left">
															<table width="100%" cellspacing="0" cellpadding="0"
																border="0" style="table-layout: fixed;">
																<tbody>
																	<tr>
																		<td width="100%" align="center" bgcolor="#f5f5f5"
																			style="font-family: Arial, sans-serif; line-height: 24px; color: #bbbbbb; font-size: 13px; font-weight: normal; text-align: center; padding: 9px; border-width: 1px 0px 0px; border-style: solid; border-color: #e3e3e3; background-color: #f5f5f5;"
																			valign="top"><a href="#"
																			style="color: #428bca; text-decoration: none; background-color: transparent;">优选商城&copy;2015</a>
																			<br> <a href="#"
																			style="color: #478fca; text-decoration: none; background-color: transparent;">电话：12312331233
																		</a> <a href="#"
																			style="color: #dd5a43; text-decoration: none; background-color: transparent;">微信公众号：yxsk88</a>
																		</td>
																	</tr>
																</tbody>
															</table></td>
													</tr>
												</tbody>
											</table></td>
									</tr>
								</tbody>
							</table>
							<table class="table-space" height="1"
								style="height: 1px; font-size: 0px; line-height: 0; width: 450px; background-color: #ffffff;"
								width="450" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr>
										<td class="table-space-td" valign="middle" height="1"
											style="height: 1px; width: 450px; background-color: #ffffff;"
											width="450" bgcolor="#FFFFFF" align="left">&nbsp;</td>
									</tr>
								</tbody>
							</table>
							<table class="table-space" height="36"
								style="height: 36px; font-size: 0px; line-height: 0; width: 450px; background-color: #e4e6e9;"
								width="450" bgcolor="#E4E6E9" cellspacing="0" cellpadding="0"
								border="0">
								<tbody>
									<tr>
										<td class="table-space-td" valign="middle" height="36"
											style="height: 36px; width: 450px; background-color: #e4e6e9;"
											width="450" bgcolor="#E4E6E9" align="left">&nbsp;</td>
									</tr>
								</tbody>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
	<jsp:include page="../WebPart/Script.jsp"></jsp:include>
	<!-- page specific plugin scripts -->
	<script src="http://ace.zcdreams.com/assets/js/jquery-ui.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/chosen.jquery.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/jquery.ui.touch-punch.js"></script>
	<script src="http://ace.zcdreams.com/assets/js/bootstrap.min.js"></script>
	
	<!-- inline scripts related to this page -->
	<script>
	function getQueryString(name) { 
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
				var r = window.location.search.substr(1).match(reg); 
				if (r != null) return unescape(r[2]); return null; 
			} 
		$(document).ready(function() {
			
			$("#headname").html("优选商城订单");
			var orderuserId;
			var orderId = getQueryString("orderId");
		$("#orderdetails").html("");
		$.ajax({
			type: "post",
			url: "${pageContext.request.contextPath }/user/findOrderById",
			dataType:"json",
			data: {"orderId":orderId},
			async: true,
			success: function(data) {
				var orderdetails = JSON.stringify(data.TOrder);
				console.log(orderdetails);
				var orderdetailsobj = JSON.parse(orderdetails);
				var obj = orderdetailsobj[0].TOrderdetails;
				$("#ordertime").html("下单时间："+new Date(orderdetailsobj[0].orderTime).toLocaleString());
				$("#orderno").html("订单编号："+orderdetailsobj[0].orderNo);
				for (var i = 0; i < obj.length; i++) {
					$("#orderdetails").append("<tr><td style='width:40%'><i class='ace-icon fa fa-check green'></i>"+
												   obj[i].TGoods.goodsName+"</td>"+
												   "<td style='width:20%'>"+ obj[i].buyMount+"</td>"+
												   "<td style='width:20%'>"+ obj[i].TGoods.goodsPrice+"</td>"+
												   "<td style='width:20%;text-align:right'>"+
												   "   <i class='ace-icon fa fa-rmb red'></i>"+obj[i].buyCost+
												   "</td>"+
											  "</tr>");
					orderuserId = orderdetailsobj[0].userId;
					$.ajax({
						type: "post",
						url: "${pageContext.request.contextPath }/seller/getUserById",
						dataType: "json",
						data: {
							"userId": orderuserId
						},
						async: true,
						success: function(data) {
							var orderuser = JSON.stringify(data.TUser);
							var obj = JSON.parse(orderuser);
							$("#orderuserdetail").html("<div id='orderPrice' class='price'>"+
														"<strong>加载中...</strong>"+
													"</div>");
							var address = obj[0].TAddresses;
							for (var j = 0; j < address.length; j++) {
								if (address[j].isDefault) {
									$("#orderuserdetail").html("<div id='orderPrice' class='price text-center'>"+
														"<strong>应付--"+orderdetailsobj[0].orderTotalCost+"</strong><small>--元</small>"+
													"</div>"+
													"<p>姓名："+address[j].receiverName+"</p>"+
													"<p>电话："+address[j].adsPhone+"</p>"+
													"<p>地址："+address[j].adsContent+"</p>");
									break;
								}
							}
						},
						error: function(XMLHttpRequest, textStatus, errorThrown) {
							$("#orderuserdetail").html("");
							$("#orderuserdetail").html(errorThrown);
						}
					});
					
					console.log(obj[i].TGoods.goodsName + obj[i].TGoods.goodsPrice + obj[i].buyMount + obj[i].buyCost);
				}
			},error: function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
			}
		});
	});
	</script>
</body>
</html>