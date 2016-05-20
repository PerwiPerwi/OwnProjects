(function ($) {

    function isPrime(number) {

        if (number < 2) {
            return false;
        }

        for (var i = 2; i < number; i++) {

            if (number % i === 0) {
                return false;
            }
        }

        return true;
    }

    function primes(n) {

        var resultArray = [];

        for (var i = 2; i <= n; i++) {

            if (isPrime(i)) {

                resultArray.push(i);

            }
        }

        return resultArray;
    }

    function fastPrimes(n) {

        var resultArray = [], // tu wpisujemy znalezione liczby pierwsze
            tempArray = new Array(n + 1); // tworzymy pusta tablice n-elementów

        for (var i = 2; i <= Math.sqrt(n); i++) {

            if (tempArray[i]) {

                continue;

            }

            for (var j = 2 * i; j <= n; j += i) {

                tempArray[j] = true;

            }

        }

        for (var i = 2; i <= n; i++) {

            if (!tempArray[i]) {

                resultArray.push(i);

            }
        }

        return resultArray;

    }
    
    var now = new Date().getTime();

    console.log(fastPrimes(1000000));
    console.log(new Date().getTime() - now);
    
    now = new Date().getTime();
    console.log(primes(1000000));
    console.log(new Date().getTime() - now);

})(jQuery)