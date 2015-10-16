<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- #section:basics/content.searchbox -->
<div class="nav-search" id="nav-search">
	<form class="form-search">
		<span class="input-icon"> <input type="text"
			placeholder="查询......" class="nav-search-input"
			id="nav-search-input" autocomplete="off" /> <i
			class="ace-icon fa fa-search nav-search-icon"></i> </span>
	</form>
</div>
<!-- /.nav-search -->