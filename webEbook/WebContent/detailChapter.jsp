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

<title><s:property value="postDTO.postName" /> > <s:property
		value="chapterDTO.chapterName" /></title>
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
						<li><a
							href="./detailPost?postId=<s:property value="postDTO.postId" />"><s:property
									value="postDTO.postName" /></a></li>
						<li><s:property value="chapterDTO.chapterName" /></li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<div class="wrap">
		<div class="container">

			<div class="wrap">
				<div class="container">
					<div class="product-content-box">

						<div class="row change-style">
							<div class="col-sm-8">
								<h3>
									<s:property value="postDTO.postName" />
									>
									<s:property value="chapterDTO.chapterName" />
								</h3>
								<div class="margin-comment">
									Số lượt bình chọn: <span><s:property value="countVote" /></span>
								</div>
								<s:if test="#session.LOGINED != NULL">
									<div class="margin-comment">

										<s:if test="chapterVoted">
										Đã bình chọn:
											<a id='vote'
												href='voteChapter?chapterId=<s:property value="chapterId" />&voteValue=false'><span
												class="glyphicon glyphicon-heart"></span> </a>
										</s:if>
										<s:else>
										Hãy bình chọn:
											<a id='unVote'
												href='voteChapter?chapterId=<s:property value="chapterId" />&voteValue=true'><span
												class="glyphicon glyphicon-heart-empty"></span> </a>
										</s:else>
									</div>
								</s:if>

							</div>
							<div class="col-sm-4">
								<button class="btn gray-btn">&ensp;</button>
								<button class="btn yellow-btn ">&ensp;</button>
								<button class="btn black-btn">&ensp;</button>
							</div>
						</div>
						<div class="row box-product-lifestyle content-box">
							<p>
								<s:property value="chapterDTO.contents" escapeHtml="false" />
							</p>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- comment -->
	<div class="wrap margin-comment20">
		<div class="container">
			<div class="product-content-box">
				<div class="row box-product-lifestyle">
					<h3 class="product-table-title">Nhận xét</h3>
				</div>
				<div class="product-review-content tab-content">
					<div class="review-list">
						<s:if test="#session.LOGINED != NULL">
							<div class="row margin-comment">
								<div class="col-md-12">
									<form action="postCommentChapter" method="post">
										<div class="col-md-11">
											<input type="hidden" name="chapterId"
												value="<s:property value="ChapterDTO.chapterId"/>" /> <input
												type="text" name="content" id="content"
												data-product="162970" class="form-control" value=""
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
														href="./cancelFeedbackCommentChapter?commentId=<s:property
													value="commentId" />"
														class="btn btn-primary"> <span
														class="glyphicon glyphicon-thumbs-down"></span> <span>Huỷ
															cảm ơn</span>
													</a>
												</s:if>
												<s:else>
													<a
														href="./feedbackCommentChapter?commentId=<s:property
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