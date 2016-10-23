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

<title><s:property value="postDTO.postName" /></title>
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
		<div class="container box-detail">
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
							<div class="item-brand">
								<span>
									<h6>Ngày đăng:</h6>
									<p>
										<span><s:property value="postDTO.createDate" /></span>
									</p>
								</span> <span class="update-date"> <s:if
										test="postDTO.updateDate != null">
										<h6>Ngày chỉnh sửa:</h6>
										<p>
											<span><s:property value="postDTO.updateDate" /></span>
										</p>
									</s:if>
								</span>
							</div>
							<div class="margin-comment">
								Số lượt bình chọn: <span><s:property value="countVote" /></span>
							</div>
							<s:if test="#session.LOGINED != NULL">
								<div>

									<s:if test="postVoted">
									Đã bình chọn:
										<a id='vote'
											href='voteAction?postId=<s:property value="postId" />&voteValue=false'><span
											class="glyphicon glyphicon-heart"></span> </a>
									</s:if>
									<s:else>
									Hãy bình chọn:
										<a id='unVote'
											href='voteAction?postId=<s:property value="postId" />&voteValue=true'><span
											class="glyphicon glyphicon-heart-empty"></span> </a>
									</s:else>
								</div>
							</s:if>
							<div class="item-brand">
								<h6>Mô tả:</h6>
								<div class="box-description">
									<i><s:property value="postDTO.description"
											escapeHtml="false" /></i>
								</div>

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- chapter -->
	<div class="wrap">
		<div class="container ">
			<div class="col-sm-8">
				<div class="chapter-area col-sm-12">
					<h3 class="product-table-title">Các chương hiện có:</h3>
					<div class="row box-product-lifestyle">
						<ul>
							<s:iterator status="chap" value="listChapters">
								<li><a
									href="./chapterDetail?chapterId=<s:property value ="chapterId"/>">
										<div class="pic">
											<img width="100%" alt="a"
												src="http://novel.phinf.naver.net/20161001_69/novel_1475319723249Asd6V_JPEG/ED8CA8EC9995EC97B0EAB080%2BEC82BDED9994%2B262.jpg?type=n200_200_2">
										</div>
										<div class="info">
											<h2>
												<s:property value="chapterName" />
											</h2>
											<div class="rating">
												<span class="glyphicon glyphicon-heart voted"></span> <em>
													<s:property value="countVoteChapter.get(#chap.count -1)" />
												</em> <span class="glyphicon glyphicon-calendar date"></span><em><s:property
														value="createDate" /></em>
											</div>
										</div>
								</a></li>
							</s:iterator>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-4 post-cat">
				<h3 class="product-table-title">
					Top 5 truyện
					<s:property value="categoryName" />
					mới nhất.
				</h3>
				<div class="row box-product-lifestyle">
					<ul>
						<s:iterator status="cats" value="listPostbyCategory">
							<li><a
								href="detailPost?postId=<s:property value="postId" />">
									<div class="pic">
										<img src="<s:property value="image" />" width="100"
											height="80" alt="<s:property value="postName" />">
									</div>
									<div class="info">
										<h3>
											<s:property value="postName" />
										</h3>
										<div class="rating">
											<span class="glyphicon glyphicon-user user-icon"></span><em><s:property
													value="authorName" /></em>
										</div>
									</div>
							</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- comment -->
	<div class="wrap">
		<div class="container box-comment">
			<div class="product-content-box col-sm-12">
				<div class="row box-product-lifestyle">
					<h3 class="product-table-title">Nhận xét</h3>
				</div>
				<div class="product-review-content tab-content">
					<div class="review-list">
						<s:if test="#session.LOGINED != NULL">
							<div class="row margin-comment">
								<div class="col-md-12">
									<form action="postCommentPost" method="post">
										<div class="col-md-11">
											<input type="hidden" name="postId"
												value="<s:property value="postDTO.postId"/>" /> <input
												type="text" name="content" id="content" class="form-control"
												value=""
												placeholder="Hãy cho chúng tôi biết cảm nghĩ của bạn!">
										</div>
										<div class="col-md-1">
											<button type="submit"
												class="btn btn-primary btn-add-question">Gửi nhận
												xét</button>
										</div>
									</form>
								</div>
							</div>
						</s:if>

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