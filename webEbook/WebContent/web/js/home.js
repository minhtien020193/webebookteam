$(document).ready(
		function() {
			$("#listEbook").click(
					function() {
						if ($(window).width() <= 1200) {
							if ($("#nav-menu").attr('style') === undefined) {
								$("header.wrap-header .header-navigation>ul")
										.css("display", "block");
							} else {
								$("header.wrap-header .header-navigation>ul")
										.removeAttr("style");
							}
						}
					});

			$("#listEbookDetail").click(
					function() {
						if ($("#nav-menu").attr('style') === undefined) {
							$("header.wrap-header .header-navigation>ul").css(
									"display", "block");
						} else {
							$("header.wrap-header .header-navigation>ul")
									.removeAttr("style");
						}
					});

			// items
			$('#myCarousel').carousel({
				interval : 10000
			})

			$('#myCarousel').on('slid.bs.carousel', function() {
				// alert("slid");
			});
		});

$(document).ready(function() {
	$('#create_post').submit(function() {
		return validateFromPost();
	});
	$('#update_post').submit(function() {
		return validateFromPost();
	});
	$('.gray-btn').click(function() {
		$('.product-content-box .content-box').css('background', '#f5f5f5');
		$('.product-content-box .content-box p').css('color', '#333');
	});
	$('.yellow-btn').click(function() {
		$('.product-content-box .content-box').css('background', '#f7f5b9');
		$('.product-content-box .content-box p').css('color', '#333');
	});
	$('.black-btn').click(function() {
		$('.product-content-box .content-box').css('background', '#333333');
		$('.product-content-box .content-box p').css('color', '#fff');
	});
});

function validateFromPost() {
	var post_name = $.trim($('#post_name').val());
	var catagory_name = $('#catagory_name').val();
	var author_name = $.trim($('#author_name').val());

	var flag = true;
	// postname
	if (post_name === '' || (post_name.length < 5)) {
		$.jGrowl("Tên tác phẩm phải lớn hơn 5 kí tự.", {
			sticky : !1,
			position : "top-right",
			theme : "bg-red"
		});
		flag = false;
	} else {
		$('#postname_error').text('');
	}
	// catagory name
	if (catagory_name == -1) {
		$.jGrowl("Không được để trống thể loại.", {
			sticky : !1,
			position : "top-right",
			theme : "bg-red"
		});
		flag = false;
	} else {
		$('#catagory_error').text('');
	}

	// catagory name
	if (author_name === '' || author_name.length < 5) {
		$.jGrowl("Tên tác giả phải lớn hơn 5 kí tự.", {
			sticky : !1,
			position : "top-right",
			theme : "bg-red"
		});
		flag = false;
	} else {
		$('#author_error').text('');
	}

	return flag;
}
