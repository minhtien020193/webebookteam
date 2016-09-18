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

<title>Chi tiết bài viết</title>
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
						<li><s:property value="postDTO.postName" /></li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<div class="wrap">
		<div class="container">
			<div class="col-md-5">
				<div class="image-box">
					<img src="<s:property value="postDTO.image" />"
						class="image-detail" />
				</div>
			</div>
			<div class="col-md-7">
				<div class="item-box">
					<h1 class="item-name" itemprop="name">
						<s:property value="postDTO.postName" />
					</h1>
					<div class="item-row1">
						<div class="item-price">
							<!-- <div class="item-brand">
								<h6>Đánh giá:</h6>
								<p>4444</p>
								<div class="item-rating">
									<a id="reiews-url"
										href="/do-choi-go-vietoys-rut-go-moc-funny-tower-p162970-p162970/reviews">(43
										đánh giá)</a>
								</div>
							</div> -->
							<div class="item-brand">
								<h6>Tác giả</h6>
								<p>
									<a target="_blank" href="#"><s:property
											value="postDTO.authorName" /></a>
								</p>
							</div>
							<div class="item-brand">
								<h6>Thể loại</h6>
								<p>
									<s:property value="categoryName" />
								</p>
							</div>
							<s:if test="priceEmpty">
								<div class="item-brand">
									<h6>Giá:</h6>
									<p>
										<span><s:property value="postDTO.price" /> đ</span>
									</p>
								</div>
							</s:if>
							<div class="item-brand">
								<h6>Ngày đăng:</h6>
								<p>
									<span><s:property value="postDTO.createDate" /></span>
								</p>
							</div>
							<s:if test="postDTO.updateDate != null">
								<div class="item-brand">
									<h6>Ngày chỉnh sửa:</h6>
									<p>
										<span><s:property value="postDTO.updateDate" /></span>
									</p>
								</div>
							</s:if>
							<div class="item-brand">
								<h6>Lượt tải:</h6>
								<p>
									<span>2222</span>
								</p>
							</div>
						</div>
					</div>
				</div>
				<s:if test="priceEmpty">
					<div class="buy-box">
						<button type="button" class="btn btn btn-danger">
							<span class="glyphicon glyphicon-arrow-down"></span> <span>Tải
								Xuống</span>
						</button>
					</div>
				</s:if>
			</div>
		</div>
	</div>

	<!-- detail ebook -->
	<div class="wrap">
		<div class="container">
			<div class="product-content-box">
				<div class="row box-product-lifestyle">
					<h3 class="product-table-title">Thông Tin Chi Tiết</h3>
				</div>
				<div class="row box-product-lifestyle">
					<s:property value="postDTO.description" escapeHtml="false" />
				</div>
			</div>
		</div>
	</div>

	<!-- chapter -->
	<div class="wrap">
		<div class="container">
			<div class="product-content-box">
				<div class="row box-product-lifestyle">
					<h3 class="product-table-title">Chương đính kèm</h3>
				</div>
				<div class="row box-product-lifestyle">
					<ul>
						<s:iterator status="chap" value="listChapters">
							<li>Chương <s:property value="#chap.count" />: <a
								href="./chapterDetail?chapterId=<s:property value ="chapterId"/>">
									<s:property value="chapterName" />
							</a>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- comment -->
	<div class="wrap">
		<div class="container">
			<div class="product-content-box">
				<div class="row box-product-lifestyle">
					<h3 class="product-table-title">Nhận xét</h3>
				</div>
				<div class="product-review-content tab-content">
					<div class="review-list">
						<div class="row margin-comment">
							<div class="col-md-12">
								<form action="postCommentPost" method="post">
									<div class="col-md-11">
										<input type="hidden" name="postId"
											value="<s:property value="postDTO.postId"/>" /> <input
											type="text" name="content" id="content" data-product="162970"
											class="form-control" value=""
											placeholder="Hãy cho chúng tôi biết cảm nghĩ của bạn!">
									</div>
									<div class="col-md-1">
										<button type="submit" class="btn btn-primary btn-add-question">Gửi
											nhận xét</button>
									</div>
								</form>
							</div>
						</div>

						<!-- list comment -->
						<s:iterator status="stat" value="listComments">
							<div class="col-md-12 margin-comment">
								<div class="item">
									<div class="col-md-2 item-profile">
										<p class="image">
											<a><img class="img-responsive"
												src="web/images/user.jpeg?width=50" width="65" height="65"></a>
										</p>
										<p class="name" itemprop="author">
											<s:property value="userComment.get(#stat.count -1)" />
										</p>
										<p class="days">
											Đã đăng từ ngày:
											<s:property value="createDate" />
										</p>
									</div>
									<div class="col-md-10">
										<div class="description js-description">
											<span class="review_detail" itemprop="reviewBody"><s:property
													value="comment" /></span>
										</div>
										<s:if test="noFeedback">
											<div class="link">
												<span class="text-success"></span> <span>Nhận xét này
													hữu ích với bạn?</span>
												<s:if test="voteComment">
													<a
														href="./cancelFeedbackCommentPost?commentId=<s:property
													value="commentId" />"
														class="btn btn-primary"> <span
														class="glyphicon glyphicon-thumbs-down"></span> <span>Huỷ
															cảm ơn</span>
													</a>
												</s:if>
												<s:else>
													<a
														href="./feedbackCommentPost?commentId=<s:property
													value="commentId" />"
														class="btn btn-primary"> <span
														class="glyphicon glyphicon-thumbs-up"></span> <span>Cảm
															ơn</span>
													</a>

												</s:else>
											</div>
										</s:if>
									</div>
								</div>
							</div>
						</s:iterator>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="include/footer.jsp"%>
</body>
</html>