<%@ page contentType="text/html;charset=UTF-8"%>
<link href="web/css/menu.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="web/css/iconic.css" rel="stylesheet" type="text/css"
	media="all" />
<div class="row header-row2">
<div class="col-sm-12">
	<nav>
		<ul class="menu">
			<li><a href="home"><span class="glyphicon glyphicon-home"></span>
					Trang chủ</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-plus-sign"></span>
					Truyện</a>
				<ul>
					<li><a href="home?categoryId=1">Tất cả</a></li>
					<li><a href="home?categoryId=2">Tiểu thuyết</a></li>
					<li><a href="home?categoryId=3">Trinh thám</a></li>
				</ul></li>
			<s:if test="#session.ROLE == 'saler'">
				<li><a href="listPost"><span
						class="glyphicon glyphicon-home"></span> Danh sách bài viết</a></li>
				<li><a href="sendCreatePost"><span
						class="glyphicon glyphicon-home"></span> Đăng bài viết mới</a></li>
			</s:if>
			<s:if test="#session.ROLE == 'admin'">
				<li><a href="sendAcceptPost"><span
						class="glyphicon glyphicon-home"></span>Accept Post</a></li>
				<li><a href="listSaler"><span
						class="glyphicon glyphicon-home"></span>DS đăng bài</a></li>
				<li><a href="listUpgrande"><span
						class="glyphicon glyphicon-home"></span>DS nâng cấp</a></li>
			</s:if>
			<li><a href="#"><span class="glyphicon glyphicon-envelope"></span>
					Contact</a>
				<ul>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">Directions</a></li>
				</ul></li>
		</ul>
		<div class="clearfix"></div>
	</nav>
</div></div>