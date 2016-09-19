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
				<form action="updatePost" method="post"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col-sm-2">Tên tác phẩm</div>
						<div class="col-sm-4">
							<input name="postId" type="hidden"
								value="<s:property value="postDTO.postId"/>" /> <input
								name="postName" type="text"
								value="<s:property value="postDTO.postName"/>" />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Thể loại</div>
						<div class="col-sm-4">
							<s:select headerKey="-1" headerValue="Chọn thể loại"
								list="listCats" listKey="key" listValue="value"
								name="categoryId" value="postDTO.categoryId" />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">File upload</div>
						<div class="col-sm-4">
							<input name="linkdownload_inserted" type="hidden"
								value="<s:property value="postDTO.linkDownload"/>" />
							<s:if test="postDTO.linkDownload !=''">
								<div class="col-sm-6">
									<a href="<s:property value="postDTO.linkDownload"/>">file
										đính kèm</a>
								</div>
							</s:if>
							<div class="col-sm-6">
								<input type="file" name="ebook" />
							</div>

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
						<div class="col-sm-4">
							<input name="author" type="text"
								value="<s:property value="postDTO.authorName"/>" />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Số lượng chương:</div>
						<div class="col-sm-4">
							<input name="countChapter" type="text"
								value="<s:property value="postDTO.countChapter"/>" />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">Giá</div>
						<div class="col-sm-4">
							<input name="price" type="text"
								value="<s:property value="postDTO.price"/>" />
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
			<div class="wrap">
				<div class="container">
					<div class="product-content-box col-sm-12">
						<div class="row box-product-lifestyle">
							<h3 class="product-table-title">Chương đọc thêm:</h3>
						</div>
						<div class="row box-product-lifestyle">
							<ul>
								<s:iterator status="chap" value="listChapters">
									<li>Chương <s:property value="#chap.count" />: <a
										href="./sendUpdateChapter?chapterId=<s:property value ="chapterId"/>"><s:property
												value="chapterName" /></a>
									</li>
								</s:iterator>
							</ul>
							<a
								href="sendAddChapter?postId=<s:property value="postDTO.postId"/>">Thêm
								chương mới</a>
						</div>
					</div>
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