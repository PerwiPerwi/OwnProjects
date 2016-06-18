$(document)
		.ready(
				function() {
					$("#buttonDelete").click(function(event) {
						if (!confirm("Are You Sure?")) {
							event.preventDefault();
						}
					});
					$("#buttonSubmit")
							.click(
									function(event) {
										var inputPassword = $("#inputPassword")
												.val(), inputConfirmPassword = $(
												"#inputConfirmPassword").val(), errorArray = [];

										if (inputPassword !== inputConfirmPassword
												|| inputPassword === ""
												&& inputConfirmPassword === "") {
											errorArray
													.push("Passwords do not match! ");
										}

										if (inputPassword.length < 3
												|| inputPassword.length > 20) {
											errorArray
													.push(" Wrong Password  = min. longer = 3, max. = 20");
										}
										if (errorArray.length > 0) {
											bootbox
													.alert(errorArray
															.toString());
											event.preventDefault();
										}
									});
				});
