<%@ page contentType="text/html;charset=UTF-8"%>
<ul id="nav-menu">
	<li><a href="home"> <i
			class="ebook-icons glyphicon glyphicon-book"></i> <span>Tất cả</span>
	</a></li>
	<li><a href="home?categoryId=1"> <i
			class="ebook-icons glyphicon glyphicon-book"></i> <span>Tiểu
				thuyết</span>
	</a></li>
	<li><a href="home?categoryId=2"> <i
			class="ebook-icons glyphicon glyphicon-book"></i> <span>Lãng
				mạn</span>
	</a></li>
	<li><a href="home?categoryId=3"> <i
			class="ebook-icons glyphicon glyphicon-book"></i> <span>Trinh
				thám</span>
	</a></li>
	<s:if test="#session.ROLE == 'saler'">
		<li><a href="listPost"> <i
				class="ebook-icons glyphicon glyphicon-book"></i> <span>Danh
					sách bài viết</span>
		</a></li>
		<li><a href="sendCreatePost"> <i
				class="ebook-icons glyphicon glyphicon-book"></i> <span>Đăng
					bài viết mới</span>
		</a></li>
	</s:if>
	<s:if test="#session.ROLE == 'admin'">
		<li><a href="sendAcceptPost"> <i
				class="ebook-icons glyphicon glyphicon-book"></i> <span>Accept
					Post</span>
		</a></li>
		<li><a href="listSaler"> <i
				class="ebook-icons glyphicon glyphicon-book"></i> <span>DS
					đăng bài</span>
		</a></li>
		<li><a href="listUpgrande"> <i
				class="ebook-icons glyphicon glyphicon-book"></i> <span>DS
					nâng cấp</span>
		</a></li>
	</s:if>
</ul>
