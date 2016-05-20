(function($) {
    
    function truncate( text, wordNo) {
        
        var array = text.split(' ');
            
        return array.slice(0, wordNo).join(' ');
        
    }
    
    console.log(truncate('Kilka pojedynczych wyrazow a moze i wiecej', 4));
    
})()