(function ($) {
 
    function range(first, last) {
        if(first >= last) {
            console.error('Chyba ty');
        }
       
        var resultArray = [];
       
        for(var i = first + 1; i < last; i++) {
            resultArray.push(i);
        }
       
        return resultArray;
     
    }
 
    console.log(range(2, 10));
   
})(jQuery);