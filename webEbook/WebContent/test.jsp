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
<title>AJAX in Struts 2 using JSON and jQuery</title>
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
						<li>Không có quyền</li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<!-- Test -->

	<s:select id="country" name="country"
		list="{'Select Country','India','US'}" label="Select Country" />
	<br />
	<br />
	<s:select id="states" name="states" list="{'Select State'}"
		label="Select State" />
	<br />
	<br />
	<div id="ajaxResponse"></div>

	<!-- End Test -->


	<div class="wrap">
		<div class="container" style="min-height: 400px;">
			<div class="noEbook">
				Bạn không có quyền truy cập chức năng này<br /> <a href="home">Hãy
					quay về trang chủ</a>
			</div>
		</div>
	</div>


	<!-- footer -->
	<%@ include file="include/footer.jsp"%>
</body>
<script>
	$(document).ready(function() {
		$('#country').change(function(event) {
			var country = $("select#country").val();
			/* $.getJSON('ajaxAction', {
				countryName : country
			}, function(jsonResponse) {
				$('#ajaxResponse').text(jsonResponse.dummyMsg);
				var select = $('#states');
				select.find('option').remove();
				$.each(jsonResponse.stateMap, function(key, value) {
					$('<option>').val(key).text(value).appendTo(select);
				});
			}); */

			$.ajax({
				url : "ajaxAction",
				type : 'GET',
				dataType : 'json',
				data : "countryName="+country,
				success : function(data) {
					console.log(data);
				}

			});
		});
	});
</script>
</html>