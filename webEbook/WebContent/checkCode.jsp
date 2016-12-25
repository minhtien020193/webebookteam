<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="web/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="web/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="web/js/jquery.min.js"></script>
<script type="text/javascript" src="web/js/home.js"></script>
<script type="text/javascript" src="web/bootstrap/js/bootstrap.min.js"></script>
<link rel="shortcut icon" type="image/x-icon"
	href="web/images/favicon.gif" />

<title>Đăng nhập hệ thống</title>
</head>
<body class="ebook-product">
	<header class="wrap-header affix-top">
	<div class="container site-component">
		<!-- row 1 -->
		<%@ include file="../../include/header.jsp"%>

		<!-- row 2 -->
		<%@ include file="../../include/menu.jsp"%>
	</div>
	</header>

	<div class="breadcrumb-wrap">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ol class="breadcrumb">
						<li><a href="./">Trang chủ</a></li>
						<li>Nhập Code</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<div class="wrap">
		<div class="container" id="content-post">
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="login-title">
					<h4 class="title">Thông tin nhập code: </h4>
					<p>Kiểm tra email để có được code</p>
					<div class="comments-area">
						<form action="checkCodeAction" method="POST">
							<p>
								<label>Tên đăng nhập</label> <span>*</span> <input type="text"
									required placeholder="Tên đăng nhập" name="username">
							</p>
							<p>
								<label>Code</label> <span>*</span> <input type="text" required
									placeholder="Mã Code" name="code">
							</p>
							<p>
								<input type="submit" value="Kích hoạt" class="btn btn-primary">
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="../../include/footer.jsp"%>
</body>
</html>