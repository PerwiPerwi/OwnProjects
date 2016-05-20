(function ($) {

    function factors(n) {

        var factors = [];

        for (var i = 2; i <= Math.sqrt(n); i++) {

            if (n % i === 0) {

                factors.push(i);

                if (i !== Math.sqrt(n)) {

                    factors.push(n / i);

                }

            }

        }

        return factors.sort(function(a, b) {
            
            return a > b;
            
        });
    }

    console.log(factors(50));
    console.log(factors(49));
    console.log(factors(8));

})(jQuery)