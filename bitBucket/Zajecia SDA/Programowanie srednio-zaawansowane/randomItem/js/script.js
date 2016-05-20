(function($) {
    
    function randomItem(array) {
        
        return array[Math.floor(Math.random() * array.length)];
        
    }
    
    console.log(randomItem([1, 'asd', 'zxc', 5]));
    
})()