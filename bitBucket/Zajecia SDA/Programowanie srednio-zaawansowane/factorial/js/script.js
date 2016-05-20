(function ($) {

    function factorial(n) {

        if (n <= 1) {

            return 1;

        } else {

            return factorial(n - 1) * n;

        }
    }

    console.log(factorial(5));
    console.log(factorial(30));
    console.log(factorial(50));
    console.log(factorial(200));

})(jQuery)