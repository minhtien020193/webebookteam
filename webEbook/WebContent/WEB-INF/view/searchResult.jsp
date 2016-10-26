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

<title>Kết quả tìm kiếm</title>
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
						<li>Kết quả tìm kiếm</li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<div class="wrap" id="content">
		<div class="container search-result">
			<div class="tab-content slides">
				<s:if test="listPost.isEmpty()">
					<div class="col-sm-12 searchresult">
						<p>
							Từ khoá <span class="textSearch"><s:property
									value="txtsearch" /></span> không tìm thấy trong hệ thống.
						</p>
					</div>
				</s:if>

				<!-- list ebook -->
				<s:iterator status="stat" value="listPost">
					<!-- ebook -->
					<div class="col-md-3">
						<div class="product-item">
							<a href="detailPost?postId=<s:property value="postId" />">
								<div class="image">
									<img alt="<s:property value="postName" />"
										src="<s:property value="image"/>" />
								</div>
								<div class="cblock ctitle">
									<h3>
										<s:property value="postName" />
									</h3>
								</div>
							</a>
							<div class="cblock">
								<div class="row">
									<div class="col-md-6">
										<i class="glyphicon glyphicon-calendar margin-10"
											aria-hidden="true"></i><span><s:property
												value="createDate" /></span>
									</div>
									<div class="col-md-6">
										<i class="glyphicon glyphicon-file margin-10"
											aria-hidden="true"></i> <span class="fred"><s:property
												value="countChapter" /></span> <span>Chương</span>
									</div>
									<div class="col-md-12">
										<i class="glyphicon glyphicon-user margin-10"
											aria-hidden="true"></i><span class="user"><s:property
												value="authorName" /></span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</s:iterator>
			</div>
		</div>
	</div>



	<!-- footer -->
	<%@ include file="../../include/footer.jsp"%>
</body>
</html>