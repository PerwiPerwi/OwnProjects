$(document)
		.ready(
				function() {
					$("#buttonSubmit")
							.click(
									function(event) {
										var inputPassword = $("#inputPassword")
												.val(), inputUsername = $(
												"#inputUsername").val(), errorArray = [];
										errorArray.push("Check: ");

										if (inputPassword === ""
												|| (inputPassword.length < 3 || inputPassword.length > 20)) {
											errorArray
													.push(" Password = min. longer = 3, max. = 20");
										}

										if (inputUsername === ""
												|| (inputUsername.length < 3 || inputUsername.length > 20)) {
											errorArray
													.push(" Username = min. longer = 3, max. = 20");
										}
										if (errorArray.length > 1) {
											bootbox
													.alert(errorArray
															.toString());
											event.preventDefault();
										}
									});
				});
