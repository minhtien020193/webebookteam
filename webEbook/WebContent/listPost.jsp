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

<title>Danh sách Ebook</title>
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
						<li>Danh sách bài viết</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<div class="wrap">
		<div class="container" style="min-height: 400px;">
			<s:if test="noData">
				<div class="noEbook">
					Bạn chưa có ebook hoặc truyện nào.<br /> <a href="sendCreatePost">Hãy
						đăng bài</a>
				</div>

			</s:if>
			<s:else>
				<div class="row list-ebook">
					<div class="col-sm-1">Stt</div>
					<div class="col-sm-1">Ảnh</div>
					<div class="col-sm-3">Ebook/ Truyện</div>
					<div class="col-sm-3">Mô tả</div>
					<div class="col-sm-2">Ngày đăng</div>
					<div class="col-sm-2"></div>

				</div>
				<s:iterator status="stat" value="listPost">
					<div class="row list-ebook">
						<div class="col-sm-1">
							<s:property value="#stat.count" />
						</div>
						<div class="col-sm-1">
							<img alt="<s:property value="postName" />"
								src="<s:property value="image"/>" class="list-ebook-image" />
						</div>
						<div class="col-sm-3">
							<a href="detailPost?postId=<s:property value="postId" />"><s:property
									value="postName" /></a>
						</div>
						<div class="col-sm-3">
							<s:property value="description" escapeHtml="false"/>
						</div>
						<div class="col-sm-2">
							<s:property value="createDate" />
						</div>
						<div class="col-sm-1">
							<a href="sendUpdatePost?postId=<s:property value="postId" />">Chỉnh
								sửa</a>
						</div>
						<div class="col-sm-1">
							<a href="#"
								data-href="deletePost?postId=<s:property value="postId"/>"
								data-toggle="modal" data-target="#confirm-delete">Xoá</a>
						</div>
					</div>
				</s:iterator>

				<div class="modal fade" id="confirm-delete" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">Xác nhận xoá bài viết</div>
							<div class="modal-body">Bạn có chắc xoá bài viết này không?</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Huỷ xoá </button>
								<a class="btn btn-danger btn-ok">Xoá</a>
							</div>
						</div>
					</div>
				</div>
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