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

			// slideshow
			$("#slideshow > div:gt(0)").hide();

			setInterval(function() {
				$('#slideshow > div:first').fadeOut(1000).next().fadeIn(1000)
						.end().appendTo('#slideshow');
			}, 3000);
		});