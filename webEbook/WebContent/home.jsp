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
<link href="web/css/slider.css" rel="stylesheet" type="text/css"
	media="all" />
<link rel="stylesheet" href="web/css/sliderRight.css">
<script type="text/javascript" src="web/js/prefix-free.js"></script>
<script type="text/javascript" src="web/js/jquery.min.js"></script>
<script type="text/javascript" src="web/js/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="web/js/home.js"></script>
<script type="text/javascript" src="web/bootstrap/js/bootstrap.min.js"></script>
<link rel="shortcut icon" type="image/x-icon"
	href="web/images/favicon.gif" />
<script type="text/javascript" charset="utf-8">
	var $ = jQuery.noConflict();
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "fade"
		});

		$(function() {
			$('.show_menu').click(function() {
				$('.menu').fadeIn();
				$('.show_menu').fadeOut();
				$('.hide_menu').fadeIn();
			});
			$('.hide_menu').click(function() {
				$('.menu').fadeOut();
				$('.show_menu').fadeIn();
				$('.hide_menu').fadeOut();
			});
		});
	});
</script>

<title>Ebook</title>
</head>
<body class="ebook-home">
	<header class="wrap-header affix-top">
	<div class="container site-component">
		<!-- row 1 -->
		<%@ include file="include/header.jsp"%>

		<!-- row 2 -->
		<%@ include file="include/menu.jsp"%>
	</div>
	</header>
	<!-- silder -->
	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="slider_container">
						<div class="flexslider">
							<ul class="slides">
								<li><a href="#"><img src="web/images/slider/slide1.jpg"
										alt="" title="" /></a>
									<div class="flex-caption">
										<div class="caption_title_line">
											<h2>Party Hairstyles</h2>
											<p>Find the perfect hairstyle a la Lauren Conrad for
												every type of festive fête.</p>
										</div>
									</div></li>
								<li><a href="#"><img src="web/images/slider/slide2.jpg"
										alt="" title="" /></a>
									<div class="flex-caption">
										<div class="caption_title_line">
											<h2>Beautiful Hairstyle</h2>
											<p>The latest hairstyles and instructions on how to
												create them here. Total Beauty has your complete hairstyles
												guide</p>
										</div>
									</div></li>
								<li><a href="#"><img src="web/images/slider/slide3.jpg"
										alt="" title="" /></a>
									<div class="flex-caption">
										<div class="caption_title_line">
											<h2>Party Dresses</h2>
											<p>If you are looking for something a little special for
												your big night out, check out Rare London's collection of
												stunning party dresses</p>
										</div>
									</div></li>
								<li><a href="#"><img src="web/images/slider/slide4.jpg"
										alt="" title="" /></a>
									<div class="flex-caption">
										<div class="caption_title_line">
											<h2>Bodycon Dresses</h2>
											<p>The bodycon dress is a key silhouette for this
												season's party girl; from sleek colour-block panelling to
												geometric prints the bodycon.</p>
										</div>
									</div></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="button-slider">
						<div class="col-sm-8">
							<h2 class="title-silder">Top</h2>
						</div>
						<div class="col-sm-4">
							<div class="pull-right">
								<a onclick="plusDivs(-1)"><span
									class="glyphicon glyphicon-chevron-left"></span></a> <a
									onclick="plusDivs(1)"><span
									class="glyphicon glyphicon-chevron-right"></span></a>
							</div>
						</div>
					</div>
					<div class="rightSlider">
						<img class="mySlides" src="web/images/slider/slide4.jpg"
							style="width: 100%"> <img class="mySlides"
							src="web/images/slider/slide1.jpg" style="width: 100%"> <img
							class="mySlides" src="web/images/slider/slide3.jpg"
							style="width: 100%"> <img class="mySlides"
							src="web/images/slider/slide2.jpg" style="width: 100%">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="wrap" id="content">
		<div class="container">
			<!-- 			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#home">Truyen
						Hay</a></li>
			</ul>
 -->
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
	</div>
	<div class="wrap">
		<div class="container">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#home">Top Review</a></li>
			</ul>
			<div class="tab-content">
				<div class="col-lg-8">123</div>
				<div class="col-lg-4">123</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="include/footer.jsp"%>
</body>
<script>
	var slideIndex = 1;
	showDivs(slideIndex);

	function plusDivs(n) {
		showDivs(slideIndex += n);
	}

	function showDivs(n) {
		var i;
		var x = document.getElementsByClassName("mySlides");
		if (n > x.length) {
			slideIndex = 1
		}
		if (n < 1) {
			slideIndex = x.length
		}
		for (i = 0; i < x.length; i++) {
			x[i].style.display = "none";
		}
		x[slideIndex - 1].style.display = "block";
	}

	
</script>