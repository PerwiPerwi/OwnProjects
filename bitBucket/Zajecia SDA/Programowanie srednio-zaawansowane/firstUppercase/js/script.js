(function($) {
    function firstUppercase(text) {
        
        var array = text.split(' ');
        
        for(var i = 0; i<array.length; i++) {
            array[i] = array[i].charAt(0).toUpperCase() + array[i].substring(1);
        }
        
        return array.join(' ');
        
    }
    
    console.log(firstUppercase('to jest przykładowe zdanie'));
    
})(jQuery)