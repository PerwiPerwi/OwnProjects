(function($) {
    
    function isLeapYear(year) {
        
        if( !(year%4) && year%100 || !(year%400) ) {
        
            console.log('rok jest przestępny');
            
        } else {
            
            console.log('rok nie jest przestępny');
            
        }
    
    }
    
    isLeapYear(2001);
    isLeapYear(2000);
    isLeapYear(2400);
    isLeapYear(2100);
    
})(jQuery)

