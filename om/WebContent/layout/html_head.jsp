<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>在线垂直电商管理平台</title>
<!-- Mobile specific metas -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- Force IE9 to render in normal mode -->
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="author" content="SuggeElson" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="application-name" content="sprFlat admin template" />

<!-- Icons -->
<link href="assets/css/icons.css" rel="stylesheet" />
<!-- jQueryUI -->
<link href="assets/css/sprflat-theme/jquery.ui.all.css" rel="stylesheet" />
<!-- Bootstrap stylesheets (included template modifications) -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- Plugins stylesheets (all plugin custom css) -->
<link href="assets/css/plugins.css" rel="stylesheet" />
<!-- Main stylesheets (template main css file) -->
<link href="assets/css/main.css" rel="stylesheet" />
<!-- Custom stylesheets ( Put your own changes here ) -->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/img/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/img/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/img/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="assets/img/ico/apple-touch-icon-57-precomposed.png">
<link rel="icon" href="assets/img/ico/favicon.ico" type="image/png">
<!-- Windows8 touch icon ( http://www.buildmypinnedsite.com/ )-->
<meta name="msapplication-TileColor" content="#3399cc" />