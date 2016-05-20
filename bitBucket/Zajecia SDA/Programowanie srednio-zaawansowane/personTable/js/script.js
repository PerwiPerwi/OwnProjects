(function ($) {

    $('button').click(function () {

        $(this).closest('tr').fadeOut(300, function () {

            $(this).remove();

        });

    });

    $('th').click(function () {

        var index = $(this).index();

        $('tbody tr').sort(function (tr1, tr2) {

            return $(tr1).find('td').eq(index).text() > $(tr2).find('td').eq(index).text() ? 1 : -1;

        }).detach().appendTo('tbody');

    })

})(jQuery)