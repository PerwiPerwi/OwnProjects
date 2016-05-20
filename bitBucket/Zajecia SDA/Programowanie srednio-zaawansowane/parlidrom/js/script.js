(function($) {
    
    function isPalidrome(string) {
        
        return string.split('').reverse().join('') === string;
        
    }
    
    console.log(isPalidrome('kajak'));
    console.log(isPalidrome('asd'));
    
})(jQuery)

