<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="web/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="web/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="web/js/jquery.min.js"></script>
<script type="text/javascript" src="web/js/home.js"></script>
<script type="text/javascript" src="web/bootstrap/js/bootstrap.min.js"></script>

<title>Đăng nhập hệ thống</title>
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
						<li>Đăng nhập</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<div class="wrap">
		<div class="container">
			<div class="col-sm-6">
				<div class="login-title">
					<h4 class="title">Đăng nhập hệ thống</h4>
					<div class="comments-area">
						<form action="loginAction" method="POST">
							<p>
								<label>Tên đăng nhập</label> <span>*</span> <input type="text"
									required placeholder="Tên đăng nhập" name="username">
							</p>
							<p>
								<label>Mật khẩu</label> <span>*</span> <input type="password"
									required placeholder="Mật khẩu" name="password">
							</p>
							<p>
								<input type="submit" value="Login" class="btn btn-primary">
							</p>
							<p id="login-form-remember">
								<label><a href="#">Forget Your Password ? </a></label>
							</p>
						</form>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="login-title">
					<h4 class="title">Thành viên mới</h4>
					<h5 class="sub_title">Đăng kí tài khoản mới</h5>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
						sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna
						aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud
						exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea
						commodo consequat. Duis autem vel eum iriure dolor in hendrerit in
						vulputate velit esse molestie consequat, vel illum dolore eu
						feugiat nulla facilisis at vero eros et accumsan</p>
					<div class="button1">
						<a href="register.jsp"><input type="submit" name="Submit"
							value="Tiếp tục" class="btn btn-primary"></a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="include/footer.jsp"%>
</body>
</html>