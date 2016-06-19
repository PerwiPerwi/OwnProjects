$(document).ready(function () {
    $(".deleteUser").click(function (event) {
        if (!confirm("Are You Sure?")) {
            event.preventDefault();
        }
    });
    console.log("Test");
});
