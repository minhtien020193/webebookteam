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
<link rel="shortcut icon" type="image/x-icon" href="web/images/favicon.gif" />

<title>Danh sách bài viết đang đợi</title>
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
						<li>Danh sách người đăng bài</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<div class="wrap">
		<div class="container" style="min-height: 400px;">
			<s:if test="noData">
				<div class="noEbook">
					Hệ thống chưa tồn tại người đăng bài.<br /> <a href="listUpgrande">Hãy
						xem qua danh sách đang đợi</a>
				</div>
			</s:if>
			<s:else>
				<div class="row list-ebook">
					<div class="col-sm-1">Stt</div>
					<div class="col-sm-3">Tên đăng nhập</div>
					<div class="col-sm-3">Họ và tên</div>
					<div class="col-sm-3">Email</div>
					<div class="col-sm-2">Số điện thoại</div>
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
						<div class="col-sm-3">
							<s:property value="lastName" escapeHtml="false" />
							<s:property value="midName" escapeHtml="false" />
							<s:property value="firstName" escapeHtml="false" />
						</div>
						<div class="col-sm-3">
							<s:property value="email" escapeHtml="false" />
						</div>
						<div class="col-sm-2">
							<s:property value="phone" escapeHtml="false" />
						</div>
					</div>
				</s:iterator>
			</s:else>
		</div>

	</div>

	<!-- footer -->
	<%@ include file="include/footer.jsp"%>
	<script>
		$('#confirm-delete').on(
				'show.bs.modal',
				function(e) {
					$(this).find('.btn-ok').attr('href',
							$(e.relatedTarget).data('href'));
				});
	</script>
</body>
</html>