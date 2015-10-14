<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- #section:basics/sidebar -->
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
		<li id="tachometer" class="">
			<a href="index.jsp" class="">
				<i class="menu-icon fa fa-tachometer"></i>
				<span class="menu-text">控制台</span>
				<b class="arrow"></b>
			</a>
			<b cite="arrow"></b>
		</li>
		<li id="authority" name="menu1" class="">
			<a href="goods.jsp" class="">
				<i class="menu-icon fa fa-unlock-alt"></i>
				<span class="menu-text"> 商品管理 </span>
				<b class="arrow"></b> 
			</a> 
			<b class="arrow"></b>
		</li>
		<li id="authority" name="menu1" class="">
			<a href="store.jsp" class="">
				<i class="menu-icon fa fa-unlock-alt"></i>
				<span class="menu-text">商家管理 </span>
				<b class="arrow"></b> 
			</a> 
			<b class="arrow"></b>
		</li>
		<li id="authority" name="menu1" class="">
			<a href="order.jsp" class="">
				<i class="menu-icon fa fa-unlock-alt"></i>
				<span class="menu-text">订单管理</span>
				<b class="arrow"></b> 
			</a> 
			<b class="arrow"></b>
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
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>


<!-- /section:basics/sidebar -->
