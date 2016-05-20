(function ($) {

    function timeConver(minutes) {

        var hours = Math.floor(minutes / 60);
        var min = minutes % 60;
        
        return hours + ':' + min;

    }
    
    console.log(timeConver(200));

})(jQuery)