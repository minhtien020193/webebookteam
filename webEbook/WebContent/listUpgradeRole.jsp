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

<title>Danh sách người dùng nâng cấp quyền</title>
</head>
<body class="ebook-product">
	<header class="wrap-header affix-top">
	<div class="container site-component">
		<!-- row 1 -->
		<div class="row">
			<div class="col-md-3">
				<p class="header-logo">
					<a href="#" title="Ebook"> Logo </a>
				</p>
				<div class="clearfix"></div>
			</div>
			<div class="col-md-6 col-lg-6 header-search-wrap">
				<form id="search_form" action="search" method="get"
					class="header-search">
					<div class="input-group">
						<input type="text" name="txtsearch" autocomplete="off"
							class="form-control"
							placeholder="Tìm kiếm sản phẩm, danh mục mong muốn..." value="">
						<span class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<span class="hidden-sm hidden-xs">Tìm</span> <i
									class="fa fa-search hidden-lg hidden-md"></i>
							</button>
						</span>
					</div>
				</form>
			</div>
			<div class="col-md-3 col-lg-3 visible-lg-block visible-md-block">
				<div class="header-user">
					<div class="user-name">
						<div class="user-name-link">
							<div class="user-avatar">
								<img width="34" height="34"
									src="https://vcdn.tikicdn.com/assets/img/avatar-s.png" alt="">
							</div>
							<ul>
								<li class="user-name-short"><span> <!-- react-text: 29 -->Chào,
										<!-- /react-text --> <!-- react-text: 30 -->Trương<!-- /react-text -->
								</span></li>
								<li class="user-name-account"><span>Tài khoản</span><span>
										&amp; Đơn hàng</span></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- row 2 -->
		<div class="row header-row2">
			<div class="col-md-3">
				<nav class="header-navigation first"> <a href="#"
					id="listEbookDetail" class="menu-all" title="Tất cả Danh Mục">
					<i class="glyphicon glyphicon-align-justify"></i>
					<h2 title="Tất Cả Danh Mục">Tất Cả Danh Mục</h2>
				</a>
				<ul id="nav-menu">
					<li><a href="#"> <i
							class="ebook-icons glyphicon glyphicon-book"></i> <span>The
								loai 1</span>
					</a></li>
					<li><a href="#"> <i
							class="ebook-icons glyphicon glyphicon-book"></i> <span>The
								loai 1</span>
					</a></li>
					<li><a href="#"> <i
							class="ebook-icons glyphicon glyphicon-book"></i> <span>The
								loai 1</span>
					</a></li>
					<li><a href="#"> <i
							class="ebook-icons glyphicon glyphicon-book"></i> <span>The
								loai 1</span>
					</a></li>
					<li><a href="#"> <i
							class="ebook-icons glyphicon glyphicon-book"></i> <span>The
								loai 1</span>
					</a></li>
				</ul>
				</nav>
			</div>
			<div class="col-md-6"></div>
			<div class="col-md-3"></div>
		</div>
	</div>
	</header>

	<div class="breadcrumb-wrap">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ol class="breadcrumb">
						<li><a href="./">Trang chủ</a></li>
						<li>Danh sách người dùng nâng cấp quyền</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<div class="wrap">
		<div class="container" style="min-height: 400px;">
			<s:if test="noData">
				<div class="noEbook">Không có người dùng cần nâng cấp quyền!.</div>
			</s:if>
			<s:else>
				<div class="row list-ebook">
					<div class="col-sm-1">Stt</div>
					<div class="col-sm-3">Tên đăng nhập</div>
					<div class="col-sm-2">Họ và tên</div>
					<div class="col-sm-2">Phone</div>
					<div class="col-sm-2">Email</div>
				</div>
				<s:iterator status="stat" value="listUsers">
					<div class="row list-ebook">
						<div class="col-sm-1">
							<s:property value="#stat.count" />
						</div>
						<div class="col-sm-3">
							<a href="./listPost"><s:property value="userName"
									escapeHtml="false" /></a>
						</div>
						<div class="col-sm-2">
							<s:property value="lastName" escapeHtml="false" />
							<s:property value="midName" escapeHtml="false" />
							<s:property value="firstName" escapeHtml="false" />
						</div>
						<div class="col-sm-2">
							<s:property value="phone" escapeHtml="false" />
						</div>
						<div class="col-sm-2">
							<s:property value="email" escapeHtml="false" />
						</div>
						<div class="col-sm-2">
							<a href="#"
								data-href="updateRoleUser?userId=<s:property value="userId"/>"
								data-toggle="modal" data-target="#confirm-update">Đồng ý</a>
						</div>
					</div>
				</s:iterator>
			</s:else>
			
			<div class="modal fade" id="confirm-update" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">Xác nhận nâng cấp quyền đăng bài viết</div>
							<div class="modal-body">Bạn có chắc nâng cấp quyền đăng bài viết này không?</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Huỷ  </button>
								<a class="btn btn-danger btn-ok">Đồng ý</a>
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>

	<!-- footer -->
	<footer class="wrap-footer">
	<div class="footer-content">
		<div class="container">
			<div class="bottom ">
				<p class="copyright">Giấy phép ICP số: 670/GP-BTTTT cấp ngày
					30/11/2015 Copyright © 2009-2015 TaiLieu.VN. All rights reserved.
					TaiLieu.VN hiển thị tốt nhất với trình duyệt Chrome, Firefox,
					Internet Explorer 8.</p>
			</div>
		</div>
	</div>
	</footer>
	<script>
		$('#confirm-update').on(
				'show.bs.modal',
				function(e) {
					$(this).find('.btn-ok').attr('href',
							$(e.relatedTarget).data('href'));
				});
	</script>
</body>
</html>