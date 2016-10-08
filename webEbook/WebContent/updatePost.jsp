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

<title>Update Ebook</title>
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
						<li>Chỉnh sửa bài viết</li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<div class="wrap">
		<div class="container">
			<div class="col-sm-12" id="createPost">
				<div class="row box-product-lifestyle">
					<h3 class="product-table-title">Chỉnh sửa nội dung bài viết:</h3>
				</div>
				<input type="hidden" value="<s:property value="messageError" />">
				<form action="updatePost" method="post"
					enctype="multipart/form-data" id="update_post">
					<div class="row">
						<div class="col-sm-2">Tên tác phẩm</div>
						<div class="col-sm-8">
							<input name="postId" type="hidden"
								value="<s:property value="postDTO.postId"/>" /> <input
								name="postName" type="text"
								value="<s:property value="postDTO.postName"/>" id="post_name" />
							<span style="color: red" id="postname_error"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Thể loại</div>
						<div class="col-sm-4">
							<s:select headerKey="-1" headerValue="Chọn thể loại"
								list="listCats" listKey="key" listValue="value"
								name="categoryId" value="postDTO.categoryId" id="catagory_name" />
							<span style="color: red" id="catagory_error"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Ảnh bìa</div>
						<div class="col-sm-4">
							<input name="image_inserted" type="hidden"
								value="<s:property value="postDTO.image"/>" />
							<div class="col-sm-6">
								<img src="<s:property value="postDTO.image"/>"
									class="list-ebook-image" name="image_inserted" />
							</div>
							<div class="col-sm-6">
								<input type="file" name="image" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Mô tả</div>
						<div class="col-sm-8">
							<textarea class="des-classy-editor" name="description"><s:property
									value="postDTO.description" /></textarea>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Tác giả</div>
						<div class="col-sm-8">
							<input name="author" type="text"
								value="<s:property value="postDTO.authorName"/>"
								id="author_name" /> <span style="color: red" id="author_error"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Nội dung</div>
						<div class="col-sm-12">
							<textarea class="classy-editor" name="content"><s:property
									value="postDTO.contents" /></textarea>
						</div>
					</div>
					<div class="row">
						<input type="reset" value="Xoá nội dung" class="btn btn-danger" />
						<input type="submit" value="Chỉnh sửa bài viết"
							class="btn btn-primary" />
					</div>
				</form>

			</div>
			<div class="wrap margin-bottom-30">
				<div class="container">
					<div class="chapter-area col-sm-12" style="border-right: none;">
						<h3 class="product-table-title">Các chương hiện có:</h3>
						<div class="row box-product-lifestyle">
							<ul>
								<s:iterator status="chap" value="listChapters">
									<li><a
										href="./sendUpdateChapter?chapterId=<s:property value ="chapterId"/>">
											<div class="pic">
												<img width="100%" alt="a"
													src="http://novel.phinf.naver.net/20161001_69/novel_1475319723249Asd6V_JPEG/ED8CA8EC9995EC97B0EAB080%2BEC82BDED9994%2B262.jpg?type=n200_200_2">
											</div>
											<div class="info">
												<h2>
													<s:property value="chapterName" />
												</h2>
												<div class="rating">
													<span class="glyphicon glyphicon-heart voted"></span><em>100</em>
													<span class="glyphicon glyphicon-calendar date"></span><em><s:property
															value="createDate" /></em>
												</div>
											</div>
									</a></li>
								</s:iterator>
								<li class="add-chapter"><a
									href="sendAddChapter?postId=<s:property
					value="postDTO.postId"/>"><span
										class="glyphicon glyphicon-plus"></span>Thêm chương mới</a></li>
							</ul>
						</div>
					</div>

					<<%-- div class="product-content-box col-sm-12"> <div class="row
					box-product-lifestyle"> <h3 class="product-table-title">Chương đọc
					thêm:</h3> </div> <div class="row box-product-lifestyle"> <ul>
					<s:iterator status="chap" value="listChapters"> <li>Chương
					<s:property value="#chap.count" />: <a
					href="./sendUpdateChapter?chapterId=<s:property value
					="chapterId"/>"><s:property value="chapterName" /></a> </li>
					</s:iterator> </ul> <a href="sendAddChapter?postId=<s:property
					value="postDTO.postId"/>">Thêm chương mới</a> </div> </div> --%>
				</div>
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