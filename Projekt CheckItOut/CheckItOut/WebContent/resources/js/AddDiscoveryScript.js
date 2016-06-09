$(document)
		.ready(
				function() {
					$("#buttonSubmit")
							.click(
									function(event) {

										var discoveryName = $("#discoveryName")
												.val(), discoveryUrl = $(
												"#discoveryUrl").val(), discoveryDescription = $(
												"#discoveryDescription").val();

										var errorArray = [];
										errorArray.push("Check: ")

										if (discoveryName.length < 3
												|| discoveryName.length > 200) {
											errorArray
													.push("Discovery name, min. length = 3 and max. length = 200 ");
										}
										if (discoveryUrl.length < 10
												|| discoveryName.length > 200) {
											errorArray
													.push("Discovery Url, min. length = 10 and max. length = 200 ");
										}
										if (discoveryDescription.length > 200) {
											errorArray
													.push("Discovery Description, max. length = 500");
										}
										if (errorArray.length > 1) {
											bootbox
													.alert(errorArray
															.toString());
											event.preventDefault();
										}
									});
				});