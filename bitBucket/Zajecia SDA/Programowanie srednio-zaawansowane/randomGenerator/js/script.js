(function($) {
   
    function generateString(length) {
       
        var chars = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm",
        generatedString = '';
   
        for(var i = 0; i < length; i++) {
           
            var randomNumber = Math.floor((Math.random() * chars.length));
           
           
            generatedString += chars[randomNumber];
           
        }
       
        console.log(generatedString);
    }
   
    generateString(100);
   
})()