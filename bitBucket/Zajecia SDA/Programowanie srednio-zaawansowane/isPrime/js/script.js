(function($) {
    
    function isPrime(number) {
        
        if(number < 2) {
            return false;
        }
        
/*        if(number === 2) {
            return true;
        }*/
        
        for(var i = 2; i<number; i++ ) {
            
            if(number % i === 0) {
                return false;
            }
        }
        
        return true;
    }
    
    console.log(isPrime(1));
    console.log(isPrime(5));
    console.log(isPrime(50));
    console.log(isPrime(23));
    console.log(isPrime(2));
    
})(jQuery) 