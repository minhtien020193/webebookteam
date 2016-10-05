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
			
			//items
			$('#myCarousel').carousel({
				interval : 10000
			})

			$('#myCarousel').on('slid.bs.carousel', function() {
				// alert("slid");
			});
		});
