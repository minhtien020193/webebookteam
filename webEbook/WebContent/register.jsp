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
						<li>Đăng kí thành viên</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<div class="wrap">
		<div class="container register_account">
			<h4 class="title">Đăng kí thành viên</h4>
			<form action="registerAction" method="POST">
				<div class="col-sm-6">
					<div class="row">
						<input type="text" name="username" placeholder="Tên đăng nhập"/>
					</div>
					<div class="row">
						<input type="password" placeholder="Mật Khẩu" name="password"/>
					</div>
					<div class="row">
						<input type="password" placeholder="Nhập lại mật Khẩu" name="re_password"/>
					</div>
					<div class="row">
						<input type="email" placeholder="email@gmail.com" name="email"/>
					</div>
					<div class="row">
						<input type="text" placeholder="Số điện thoại" name="phone"/>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<input type="text" placeholder="Họ" name="firstName"/>
					</div>
					<div class="row">
						<input type="text" placeholder="Tên đệm" name="midName"/>
					</div>
					<div class="row">
						<input type="text" placeholder="Tên" name="lastName"/>
					</div>
					<div class="row">
						<input type="text" placeholder="Địa chỉ" name="address"/>
					</div>
					<div class="row">
						<input type="submit" value="Đăng kí" class="btn btn-primary btn-register"/>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="include/footer.jsp"%>
</body>
</html>