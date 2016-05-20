(function ($) {

    function sum(arg1, arg2) {

        if (arguments.length === 2) {

            return arg1 + arg2;

        }

        return function (a) {

            return a + arg1;

        }

    }

    console.log(sum(2, 3));
    console.log(sum(4)(5));

})(jQuery)