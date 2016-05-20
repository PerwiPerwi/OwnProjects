(function($) {
    
    function alphabetOrder(word) {
        
        return word.split('').sort(function (a,b) {
            return a.localeCompare(b);
        }).join('');
        
    }
    
    console.log(alphabetOrder('wyraz'));
    
})(jQuery)