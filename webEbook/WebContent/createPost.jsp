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
<script src="web/textediter/js/jquery.classyedit.js"></script>
<link rel="stylesheet" type="text/css"
	href="web/textediter/css/jquery.classyedit.css" />

<title>Create Ebook</title>
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
						<li>Tạo mới ebook/truyện</li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<div class="wrap">
		<div class="container">
			<div class="col-sm-12" id="createPost">
				<input type="hidden" value="<s:property value="messageError" />">
				<form action="createPost" method="post"
					enctype="multipart/form-data" id="create_post">
					<div class="row">
						<div class="col-sm-2">Tên tác phẩm</div>
						<div class="col-sm-8">
							<input name="postName" type="text" value="" id="post_name" /> <span
								style="color: red" id="postname_error"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Thể loại</div>
						<div class="col-sm-8">
							<s:select headerKey="-1" headerValue="Chọn thể loại"
								list="listCats" listKey="key" listValue="value"
								name="categoryId" value="0" id="catagory_name" />
							<span style="color: red" id="catagory_error"></span>
						</div>
					</div>
					<!-- <div class="row">
						<div class="col-sm-2">File upload</div>
						<div class="col-sm-4">
							<input type="file" name="ebook" />
						</div>
					</div> -->
					<div class="row">
						<div class="col-sm-2">Ảnh bìa</div>
						<div class="col-sm-4">
							<input type="file" name="image" />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Mô tả</div>
						<div class="col-sm-8">
							<textarea class="des-classy-editor" name="description"></textarea>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Tác giả</div>
						<div class="col-sm-8">
							<input name="author" type="text" value="" id="author_name" /> <span
								style="color: red" id="author_error"></span>
						</div>
					</div>
					<!-- <div class="row">
						<div class="col-sm-2">Số lượng chương:</div>
						<div class="col-sm-4">
							<input name="countChapter" type="text" />
						</div>
					</div> -->
					<!-- <div class="row">
						<div class="col-sm-2">Giá</div>
						<div class="col-sm-4">
							<input name="price" type="text" />
						</div>
					</div> -->
					<div class="row">
						<div class="col-sm-2">Nội dung</div>
						<div class="col-sm-12">
							<textarea class="classy-editor" name="content"></textarea>
						</div>
					</div>
					<div class="row">
						<input type="reset" value="Xoá nội dung" class="btn btn-danger" />
						<input type="submit" value="Gửi yêu cầu đăng bài"
							class="btn btn-primary" />
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="include/footer.jsp"%>
	<script>
		$(document).ready(function() {
			$(".classy-editor").ClassyEdit();
			$(".des-classy-editor").ClassyEdit();
		});
	</script>
</body>
</html>