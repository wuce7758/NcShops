<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<%
String path = request.getContextPath(); String basePath =
request.getScheme() + "://" + request.getServerName() + ":" +
request.getServerPort() + path + "/"; %>

		<html lang="en">

		<head>
			<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
			<meta charset="utf-8" />
			<title>商城管理后台</title>

			<meta name="description" content="" />
			<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

			<!-- bootstrap & fontawesome -->
			<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/bootstrap.css" />
			<link rel="stylesheet" href="../../plugins/fonts/font-awesome.css" />

			<!-- page specific plugin styles -->
			<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/jquery.gritter.css" />
			<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/jquery-ui.css" />
			<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/datepicker.css" />
			<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ui.jqgrid.css" />
			<!-- text fonts -->
			<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace-fonts.css" />

			<!-- ace styles -->
			<link rel="stylesheet" href="http://ace.zcdreams.com/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

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
			<jsp:include page="../WebPart/Head.jsp"></jsp:include>
			<div class="main-container" id="main-container">
				<script type="text/javascript">
					try {
						ace.settings.check('main-container', 'fixed')
					} catch (e) {}
				</script>
				<jsp:include page="../WebPart/Menu.jsp"></jsp:include>
				<!-- /section:basics/sidebar -->
				<div class="main-content">
					<div class="main-content-inner">
						<div class="breadcrumbs" id="breadcrumbs">
							<script type="text/javascript">
								try {
									ace.settings.check('breadcrumbs', 'fixed')
								} catch (e) {}
							</script>
							<ul class="breadcrumb">
								<li><i class="ace-icon fa fa-home home-icon"></i><a href="#">商城管理后台</a>
								</li>
								<li><a href="#">商品管理</a>
								</li>
							</ul>
							<jsp:include page="../WebPart/SearchBox.jsp"></jsp:include>
						</div>
						<div class="page-content">
							<jsp:include page="../WebPart/Skin.jsp"></jsp:include>
							<div class="row">
								<div class="col-xs-12">
									<!-- PAGE CONTENT BEGINS -->
									<div class="well well-sm">
										对商品的管理操作集中在一个页面完成。
										<a href="http://www.trirand.com/blog/?page_id=6" target="_blank">
									    查看jqgrid
									<i class="fa fa-external-link bigger-110"></i>
								</a>
									</div>
									<table id="grid-table"></table>
									<div id="grid-pager"></div>
									<script type="text/javascript">
										var $path_base = ".."; //in Ace demo this will be used for editurl parameter
									</script>
									<!-- PAGE CONTENT ENDS -->
								</div>
							</div>
						</div>
					</div>
				</div>
				<jsp:include page="../WebPart/CopyRight.jsp"></jsp:include>
			</div>
			<jsp:include page="../WebPart/Script.jsp"></jsp:include>
			<!-- page specific plugin scripts -->
			<script src="http://ace.zcdreams.com/assets/js/jquery.gritter.js"></script>
			<script src="http://ace.zcdreams.com/assets/js/date-time/bootstrap-datepicker.js"></script>
			<script src="http://ace.zcdreams.com/assets/js/jqGrid/jquery.jqGrid.src.js"></script>
			<script src="http://ace.zcdreams.com/assets/js/jqGrid/i18n/grid.locale-en.js"></script>
			<!-- inline scripts related to this page -->
			<script type="text/javascript">
				$(document).ready(function() {
					$('.goodsPic').click(function() {
						//图片名称
						var picname = this.name;
						alert(picname);
						//显示图片
						$.gritter.add({
							title: "商品图片",
							text: "<img width='100px' height='100px' src='http://d.hiphotos.baidu.com/zhidao/wh%3D800%2C450/sign=3915b125a20f4bfb8c85965c337f54c4/cdbf6c81800a19d807295abf35fa828ba61e4666.jpg'>",
							sticky: true,
							time: 10000,
							speed: 10,
							position: 'center',
							class_name: 'gritter-dark'
						});
					});
				});
				var goods_data;
				$.ajax({
					type: "post",
					url: "../../user/findGoodsdetail",
					data: "hello" + "world!",
					async: false,
					success: function(data) {
						goods_data = JSON.stringify(data.TSellergoods);
					}
				});
				var grid_data = JSON.parse(goods_data);
				var subgrid_data = [{
					id: "1",
					name: "sub grid item 1",
					qty: 11
				}, {
					id: "2",
					name: "sub grid item 2",
					qty: 3
				}, {
					id: "3",
					name: "sub grid item 3",
					qty: 12
				}, {
					id: "4",
					name: "sub grid item 4",
					qty: 5
				}, {
					id: "5",
					name: "sub grid item 5",
					qty: 2
				}, {
					id: "6",
					name: "sub grid item 6",
					qty: 9
				}, {
					id: "7",
					name: "sub grid item 7",
					qty: 3
				}, {
					id: "8",
					name: "sub grid item 8",
					qty: 8
				}];
				jQuery(function($) {
					var grid_selector = "#grid-table";
					var pager_selector = "#grid-pager";
					//resize to fit page size
					$(window).on('resize.jqGrid', function() {
							$(grid_selector).jqGrid('setGridWidth', $(".page-content").width());
						})
						//resize on sidebar collapse/expand
					var parent_column = $(grid_selector).closest('[class*="col-"]');
					$(document).on('settings.ace.jqGrid', function(ev, event_name, collapsed) {
							if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
								//setTimeout is for webkit only to give time for DOM changes and then redraw!!!
								setTimeout(function() {
									$(grid_selector).jqGrid('setGridWidth', parent_column.width());
								}, 0);
							}
						})
						//if your grid is inside another element, for example a tab pane, you should use its parent's width:
						/**
						$(window).on('resize.jqGrid', function () {
							var parent_width = $(grid_selector).closest('.tab-pane').width();
							$(grid_selector).jqGrid( 'setGridWidth', parent_width );
						})
						//and also set width when tab pane becomes visible
						$('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
						  if($(e.target).attr('href') == '#mygrid') {
							var parent_width = $(grid_selector).closest('.tab-pane').width();
							$(grid_selector).jqGrid( 'setGridWidth', parent_width );
						  }
						})
						*/
					jQuery(grid_selector).jqGrid({
						//direction: "rtl",
						//subgrid options
						subGrid: true,
						//subGridModel: [{ name : ['No','Item Name','Qty'], width : [55,200,80] }],
						//datatype: "xml",
						subGridOptions: {
							plusicon: "ace-icon fa fa-plus center bigger-110 blue",
							minusicon: "ace-icon fa fa-minus center bigger-110 blue",
							openicon: "ace-icon fa fa-chevron-right center orange"
						},
						//for this example we are using local data
						subGridRowExpanded: function(subgridDivId, rowId) {
							var subgridTableId = subgridDivId + "_t";
							$("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table>");
							$("#" + subgridTableId).jqGrid({
								datatype: 'local',
								data: subgrid_data,
								colNames: ['No', 'Item Name', 'Qty'],
								colModel: [{
									name: 'id',
									width: 50
								}, {
									name: 'name',
									width: 150
								}, {
									name: 'qty',
									width: 50
								}]
							});
						},
						data: grid_data,
						datatype: "local",
						height: 250,
						colNames: [' ', 'ID', '名称', '商家' , '价格', '类型', '图片', '简介'],
						colModel: [{
								name: 'myac',
								index: '',
								width: 80,
								fixed: true,
								sortable: false,
								resize: false,
								formatter: 'actions',
								formatoptions: {
									keys: true,
									//delbutton: false,//disable delete button
									delOptions: {
										recreateForm: true,
										beforeShowForm: beforeDeleteCallback
									},
									//editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
								}
							}, {
								name: 'TGoods.goodsId',
								index: 'TGoods.goodsId',
								width: 30,
								sorttype: "int",
								editable: false
							},{
								name: 'TGoods.goodsName',
								index: 'TGoods.goodsName',
								width: 80,
								editable: true,
								editoptions: {
									size: "20",
									maxlength: "20"
								}
							}, {
								name: 'seller.shopName',
								index: 'seller.shopName',
								width: 80,
								editable: true,
								edittype: "select",
								editoptions: {
									size: "20",
									maxlength: "20"
								}
							}, {
								name: 'TGoods.goodsPrice',
								index: 'TGoods.goodsPrice',
								width: 50,
								sorttype: "int",
								editable: true,
								edittype: "text",
								/* editoptions: {
									value: "Yes:No"
								}, */
								unformat: aceSwitch
							}, {
								name: 'TGoods.TGoodstype.goodsTypeName',
								index: 'TGoods.TGoodstype.goodsTypeName',
								width: 70,
								editable: true,
								edittype: "select",
								editoptions: {
									dataUrl:"../../seller/getAllGoodsType"
								}
							}, {
								name: 'TGoods.goodsPic',
								index: 'TGoods.goodsPic',
								width: 100,
								editable: true,
								edittype:"file",
								formatter: function(cellvalue, option, rowObject) {
									return "<a href='javascript:void(0)' name='" + cellvalue + "'><span calss='goodsPic'>查看</span></a>";
								}
							},
							/* {name:'goodsPic',index:'goodsPic', width:50, editable: true, formatter:function(cellvalue,option,rowObject){
							return "<a name='goodPicLink' href='javascript:void(0);' data-container='body'"+
							"data-toggle='popover' data-placement='bottom'"+
							"data-content='<img src=\"1.jpg\">'>1</a>";}}, */
							{
								name: 'TGoods.goodsMsg',
								index: 'TGoods.goodsMsg',
								width: 150,
								sortable: false,
								editable: true,
								edittype: "textarea",
								editoptions: {
									rows: "2",
									cols: "100"
								}
							}
						],
						viewrecords: true,
						rowNum: 10,
						rowList: [10, 20, 30],
						pager: pager_selector,
						altRows: true,
						//toppager: true,
						multiselect: true,
						//multikey: "ctrlKey",
						multiboxonly: true,
						loadComplete: function() {
							var table = this;
							setTimeout(function() {
								styleCheckbox(table);
								updateActionIcons(table);
								updatePagerIcons(table);
								enableTooltips(table);
							}, 0);
						},
						editurl: "../../seller/addGoods", //nothing is saved
						caption: "商品管理列表"
							//,autowidth: true,
							/**
							,
							grouping:true, 
							groupingView : { 
								 groupField : ['name'],
								 groupDataSorted : true,
								 plusicon : 'fa fa-chevron-down bigger-110',
								 minusicon : 'fa fa-chevron-up bigger-110'
							},
							caption: "Grouping"
							*/
					});
					$(window).triggerHandler('resize.jqGrid'); //trigger window resize to make the grid get the correct size
					//enable search/filter toolbar
					//jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
					//jQuery(grid_selector).filterToolbar({});
					//switch element when editing inline
					function aceSwitch(cellvalue, options, cell) {
							setTimeout(function() {
								$(cell).find('input[type=checkbox]')
									.addClass('ace ace-switch ace-switch-5')
									.after('<span class="lbl"></span>');
							}, 0);
						}
						//enable datepicker

					function pickDate(cellvalue, options, cell) {
							setTimeout(function() {
								$(cell).find('input[type=text]')
									.datepicker({
										format: 'yyyy-mm-dd',
										autoclose: true
									});
							}, 0);
						}
						//navButtons
					jQuery(grid_selector).jqGrid('navGrid', pager_selector, { //navbar options
						edit: true,
						editicon: 'ace-icon fa fa-pencil blue',
						add: true,
						addicon: 'ace-icon fa fa-plus-circle purple',
						del: true,
						delicon: 'ace-icon fa fa-trash-o red',
						search: true,
						searchicon: 'ace-icon fa fa-search orange',
						refresh: true,
						refreshicon: 'ace-icon fa fa-refresh green',
						view: true,
						viewicon: 'ace-icon fa fa-search-plus grey',
					}, {
						//edit record form
						//closeAfterEdit: true,
						//width: 700,
						recreateForm: true,
						beforeShowForm: function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						}
					}, {
						//new record form
						//width: 700,
						closeAfterAdd: true,
						recreateForm: true,
						viewPagerButtons: false,
						beforeShowForm: function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
								.wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						}
					}, {
						//delete record form
						recreateForm: true,
						beforeShowForm: function(e) {
							var form = $(e[0]);
							if (form.data('styled')) return false;
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_delete_form(form);
							form.data('styled', true);
						},
						onClick: function(e) {
							//alert(1);
						}
					}, {
						//search form
						recreateForm: true,
						afterShowSearch: function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
							style_search_form(form);
						},
						afterRedraw: function() {
							style_search_filters($(this));
						},
						multipleSearch: true,
						/**
						multipleGroup:true,
						showQuery: true
						*/
					}, {
						//view record form
						recreateForm: true,
						beforeShowForm: function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						}
					})

					function style_edit_form(form) {
						//enable datepicker on "sdate" field and switches for "stock" field
						form.find('input[name=sdate]').datepicker({
							format: 'yyyy-mm-dd',
							autoclose: true
						})
						form.find('input[name=stock]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
						//don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
						//.addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
						//update buttons classes
						var buttons = form.next().find('.EditButton .fm-button');
						buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide(); //ui-icon, s-icon
						buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
						buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')
						buttons = form.next().find('.navButton a');
						buttons.find('.ui-icon').hide();
						buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
						buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
					}

					function style_delete_form(form) {
						var buttons = form.next().find('.EditButton .fm-button');
						buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide(); //ui-icon, s-icon
						buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
						buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>')
					}

					function style_search_filters(form) {
						form.find('.delete-rule').val('X');
						form.find('.add-rule').addClass('btn btn-xs btn-primary');
						form.find('.add-group').addClass('btn btn-xs btn-success');
						form.find('.delete-group').addClass('btn btn-xs btn-danger');
					}

					function style_search_form(form) {
						var dialog = form.closest('.ui-jqdialog');
						var buttons = dialog.find('.EditTable')
						buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
						buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
						buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
					}

					function beforeDeleteCallback(e) {
						var form = $(e[0]);
						if (form.data('styled')) return false;
						form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						style_delete_form(form);
						form.data('styled', true);
					}

					function beforeEditCallback(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						}
						//it causes some flicker when reloading or navigating grid
						//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
						//or go back to default browser checkbox styles for the grid

					function styleCheckbox(table) {
							/**
					$(table).find('input:checkbox').addClass('ace')
					.wrap('<label />')
					.after('<span class="lbl align-top" />')
			
			
					$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
					.find('input.cbox[type=checkbox]').addClass('ace')
					.wrap('<label />').after('<span class="lbl align-top" />');
				*/
						}
						//unlike navButtons icons, action icons in rows seem to be hard-coded
						//you can change them like this in here if you want

					function updateActionIcons(table) {
							/**
							var replacement = 
							{
								'ui-ace-icon fa fa-pencil' : 'ace-icon fa fa-pencil blue',
								'ui-ace-icon fa fa-trash-o' : 'ace-icon fa fa-trash-o red',
								'ui-icon-disk' : 'ace-icon fa fa-check green',
								'ui-icon-cancel' : 'ace-icon fa fa-times red'
							};
							$(table).find('.ui-pg-div span.ui-icon').each(function(){
								var icon = $(this);
								var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
								if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
							})
							*/
						}
						//replace icons with FontAwesome icons like above

					function updatePagerIcons(table) {
						var replacement = {
							'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-140',
							'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-140',
							'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-140',
							'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-140'
						};
						$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function() {
							var icon = $(this);
							var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
							if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
						})
					}

					function enableTooltips(table) {
							$('.navtable .ui-pg-button').tooltip({
								container: 'body'
							});
							$(table).find('.ui-pg-div').tooltip({
								container: 'body'
							});
						}
						//var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					$(document).one('ajaxloadstart.page', function(e) {
						$(grid_selector).jqGrid('GridUnload');
						$('.ui-jqdialog').remove();
					});
				});
			</script>
		</body>

		</html>