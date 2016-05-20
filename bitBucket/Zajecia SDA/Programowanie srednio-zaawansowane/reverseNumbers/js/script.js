(function ($) {
 
    function reverseNumbers(x) {
       
        return parseInt(x.toString().split('').reverse().join(''));
       
    }
   
    console.log(reverseNumbers(12345));
   
})(jQuery);