<%@ page contentType="text/html;charset=UTF-8"%>
<div class="row">
	<div class="col-md-3">
		<p class="header-logo">
			<a href="#" title="Ebook"> Logo </a>
		</p>
		<div class="clearfix"></div>
	</div>
	<div class="col-md-6 col-lg-6 header-search-wrap">
		<form id="search_form" action="search" method="get"
			class="header-search">
			<div class="input-group">
				<input type="text" name="txtsearch" autocomplete="off"
					class="form-control"
					placeholder="Tìm kiếm sản phẩm, danh mục mong muốn..." value="">
				<span class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<span class="hidden-sm hidden-xs">Tìm</span> <i
							class="fa fa-search hidden-lg hidden-md"></i>
					</button>
				</span>
			</div>
		</form>
	</div>
	<div class="col-md-3 col-lg-3">
		<div class="header-user">
			<div></div>

			<div class="user-name">
				<div class="user-name-link">
					<s:if test="#session.LOGINED == NULL">
						<div>
							<a href="login.jsp">Đăng nhập</a>
						</div>
					</s:if>
					<s:else>
						<div class="user-avatar">
							<img width="34" height="34"
								src="https://vcdn.tikicdn.com/assets/img/avatar-s.png" alt="">
						</div>
						<ul>
							<li class="user-name-short"><span>Chào, <s:property
										value="#session.LOGINED.userName" escapeHtml="false" />
							</span> <a href="logoutAction.action">Thoát</a></li>
							<li class="user-name-account"><span>Tài khoản</span><span>
									&amp; Đơn hàng</span></li>
						</ul>
					</s:else>
				</div>
			</div>
		</div>
	</div>
</div>