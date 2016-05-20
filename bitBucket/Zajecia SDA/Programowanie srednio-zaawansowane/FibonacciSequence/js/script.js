(function($) {
    
    function fibonacci(n) {
        
        if(n === 1) {
            return [0];
        }
        
        if(n === 2) {
            return[0, 1];
        }
        
        var previousArray = fibonacci(n - 1);
        
        previousArray.push(previousArray[previousArray.length - 1] + previousArray[previousArray.length - 2]);
        
        return previousArray;
        
    }
    
    console.log(fibonacci(10));
    console.log(fibonacci(50));
    console.log(fibonacci(150));
    
})()