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
<link rel="shortcut icon" type="image/x-icon"
	href="web/images/favicon.gif" />
<!-- text editer -->
<link rel="stylesheet" media="screen"
	href="cweb/textediter/ss/documentation.css" />
<script src="web/textediter/js/jquery.classyedit.js"></script>
<link rel="stylesheet" type="text/css"
	href="web/textediter/css/jquery.classyedit.css" />

<title>Detail Chapter</title>
</head>
<body class="ebook-product">
	<header class="wrap-header affix-top">
		<div class="container site-component" >
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
						<li><a
							href="./sendUpdatePost?postId=<s:property value="postDTO.postId" />">Chỉnh
								sửa bài viết</a></li>
						<li>Thêm chương mới</li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="row box-product-lifestyle col-sm-12 title-box">
						<h3 class="product-table-title">Nội dung bài viết:</h3>
					</div>
					<div class="col-md-5">
						<div class="image-box">
							<img src="<s:property value="postDTO.image" />" />
						</div>
					</div>
					<div class="col-md-7">
						<div class="item-brand">
							<h6>Tác giả</h6>
							<p class="author">
								<a target="_blank" href="#"><s:property
										value="postDTO.authorName" /></a>
							</p>
						</div>
						<div class="item-brand">
							<h6>Tên tác phẩm:</h6>
							<p class="author">
								<s:property value="postDTO.postName" />
							</p>
						</div>
						<div class="item-brand">
							<h6>Ngày đăng :</h6>
							<p class="author">
								<s:property value="chapterDTO.createDate" />
							</p>
						</div>
						<div class="item-brand">
							<h6>Ngày chỉnh sửa :</h6>
							<p class="author">
								<s:property value="chapterDTO.updateDate" />
							</p>
						</div>
						<div class="item-brand">
							<h6>Mô tả :</h6>
							<p class="author">
								<s:property value="chapterDTO.description" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="wrap">
				<div class="container" id="addChapter">
					<div class="product-content-box">
						<div class="row box-product-lifestyle">
							<h3 class="product-table-title">Thêm nội dung chương mới</h3>
						</div>
						<div class="col-sm-12">
							<div class="row box-product-lifestyle">
								<form action="addChapter" method="post">
									<div class="row">
										<input type="hidden" name="postId"
											value="<s:property value="postDTO.postId" />" />
										<div class="col-sm-2">Tên chương:</div>
										<div class="col-sm-10">
											<input type="text" name="chapterName" />
										</div>
									</div>
									<div class="row">
										<div class="col-sm-2">Mô tả:</div>
										<div class="col-sm-10">
											<textarea class="des-classy-editor" name="description"></textarea>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-2">Nội dung:</div>
										<div class="col-sm-10">
											<textarea class="classy-editor" name="contents"></textarea>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12">
											<input type="reset" value="Xoá nội dung"
												class="btn btn-danger" /> <input type="submit"
												value="Thêm chương mới" class="btn btn-primary" />
										</div>
									</div>

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- footer -->
	<%@ include file="../../include/footer.jsp"%>
	<script>
		$(document).ready(function() {
			$(".classy-editor").ClassyEdit();
			$(".des-classy-editor").ClassyEdit();
		});
	</script>
</body>
</html>