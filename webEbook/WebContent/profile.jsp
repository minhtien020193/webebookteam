<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="web/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="web/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="web/js/jquery.min.js"></script>
<script type="text/javascript" src="web/js/home.js"></script>
<script type="text/javascript" src="web/bootstrap/js/bootstrap.min.js"></script>

<title>Đăng kí thành viên</title>
</head>
<body class="ebook-product">
	<header class="wrap-header affix-top">
	<div class="container site-component">
		<!-- row 1 -->
		<%@ include file="include/header.jsp"%>

		<!-- row 2 -->
		<%@ include file="include/menu.jsp"%>
	</div>
	</header>

	<div class="breadcrumb-wrap">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ol class="breadcrumb">
						<li><a href="./">Trang chủ</a></li>
						<li>Thông tin tài khoản</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<div class="wrap">
		<div class="container register_account profile">
			<h4 class="title">Thông tin tài khoản</h4>
			<div class="col-sm-6 image-box">
				<div class="row">
					<img src="web/images/user.jpeg?width=50" />
				</div>
			</div>
			<div class="col-sm-6 profile-box">
				<div class="row">
					<div class="col-sm-4">Tên</div>
					<div class="col-sm-8"><s:property value="userDTO.firstName" /></div>
				</div>
				<div class="row">
					<div class="col-sm-4">Tên đệm</div>
					<div class="col-sm-8"><s:property value="userDTO.midName" /></div>
				</div>
				<div class="row">
					<div class="col-sm-4">Họ</div>
					<div class="col-sm-8"><s:property value="userDTO.lastName" /></div>
				</div>
				<div class="row">
					<div class="col-sm-4">Địa chỉ</div>
					<div class="col-sm-8"><s:property value="userDTO.address" /></div>
				</div>
				<div class="row">
					<div class="col-sm-4">Email</div>
					<div class="col-sm-8"><s:property value="userDTO.email" /></div>
				</div>
				<div class="row">
					<div class="col-sm-4">Số điện thoại</div>
					<div class="col-sm-8"><s:property value="userDTO.phone" /></div>
				</div>
				<div class="row">
					<div class="col-sm-4">role</div>
					<div class="col-sm-8"><s:property value="userDTO.roleId" /></div>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="include/footer.jsp"%>
</body>
</html>