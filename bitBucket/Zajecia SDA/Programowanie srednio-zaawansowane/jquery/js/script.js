(function($) {
    
    $('#iloczyn').on('click', counting);
    
    function counting() {

        var firstNumber = parseInt($('#liczba1').val()),
        secondNumber = parseInt($('#liczba2').val()),
        multi = $('#iloczyn').val(firstNumber * secondNumber);
    }
    
})(jQuery);