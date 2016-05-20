(function($) {
    
    function vowelCount(text) {
        
        var vowels = 'aąeęoóuyiAĄEĘOÓUYI'.split(''),
            vCount = 0;
        
        for (var i = 0; i < text.length; i++) {
            
            if(vowels.indexOf(text.charAt(i)) !== -1) {
             
                vCount++;
                
            }
        }
        
        return vCount;
    }
    
    console.log(vowelCount('Zadaęnie Ala mA Kota'));
    
})(jQuery)