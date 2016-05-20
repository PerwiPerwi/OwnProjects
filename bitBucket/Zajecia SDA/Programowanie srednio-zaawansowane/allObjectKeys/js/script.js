(function ($) {
 
    function allKeys(person) {
        var keysArray = [];
       
        for(var propt in person ) {
           
            keysArray.push(propt);
           
        }
       
        return keysArray;
 
    }
 
    var person = {
        name: 'Jan',
        surname: 'Kowalski',
        age: 35
    };
 
    console.log(allKeys(person));
})(jQuery);