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

<title>Ebook</title>
</head>
<body class="ebook-home">
	<header class="wrap-header affix-top">
	<div class="container site-component">
		<!-- row 1 -->
		<%@ include file="include/header.jsp"%>

		<!-- row 2 -->
		<div class="row header-row2">
			<div class="col-md-3">
				<nav class="header-navigation first"> <a href="#"
					id="listEbook" class="menu-all" title="Tất cả Danh Mục"> <i
					class="glyphicon glyphicon-align-justify"></i>
					<h2 title="Tất Cả Danh Mục">Tất Cả Danh Mục</h2>
				</a> <%@ include file="include/contentMenu.jsp"%> </nav>
			</div>
			<div class="col-md-6"></div>
			<div class="col-md-3"></div>
		</div>
	</div>
	</header>
	<div class="wrap">
		<div class="container home-slideshow-root">
			<div class="row">
				<div class="col-lg-12">
					<div class="home-slideshow">
						<div
							class="swiper-container home-slideshow-content swiper-container-vertical">
							<div id="slideshow">
								<div>
									<img
										src="https://vcdn.tikicdn.com/media/custom/banners/File-1470367814.jpg">
								</div>
								<div>
									<img
										src="https://vcdn.tikicdn.com/media/custom/banners/File-1470961433.jpg">
								</div>
								<div>
									<img
										src="https://vcdn.tikicdn.com/media/custom/banners/File-1470961433.jpg">
								</div>
								<div>
									<img
										src="https://vcdn.tikicdn.com/media/custom/banners/File-1470961433.jpg">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="wrap" id="content">
		<div class="container">
			<div class="col-md-12">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#home">Hàng
							mới</a></li>
					<li><a data-toggle="tab" href="#menu1">Giảm giá</a></li>
					<li><a data-toggle="tab" href="#menu2">Bán chạy</a></li>
				</ul>

				<div class="tab-content slides">
					<div id="home" class="tab-pane fade in active">

						<!-- list ebook -->
						<s:iterator status="stat" value="listPost">
							<!-- ebook -->
							<div class="col-md-3 margin-top">
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
											<div class="col-md-6">
												<i class="glyphicon glyphicon-eye-open margin-10"
													aria-hidden="true"></i><span>8888</span>
											</div>
											<div class="col-md-6">
												<i class="glyphicon glyphicon-arrow-down margin-10"
													aria-hidden="true"></i><span>123</span>
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
					<div id="menu1" class="tab-pane fade">
						<h3>Menu 1</h3>
						<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
							laboris nisi ut aliquip ex ea commodo consequat.</p>
					</div>
					<div id="menu2" class="tab-pane fade">
						<h3>Menu 2</h3>
						<p>Sed ut perspiciatis unde omnis iste natus error sit
							voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="include/footer.jsp"%>
</body>