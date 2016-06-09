$(".deleteDiscovery").click(function(event) {
	if (!confirm("Are You Sure?")) {
		event.preventDefault();
	}
});
