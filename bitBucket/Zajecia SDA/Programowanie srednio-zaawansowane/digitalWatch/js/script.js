(function ($) {

    function clock() {

        var currentDate = new Date();
        hours = currentDate.getHours();
        min = currentDate.getMinutes();
        secs = currentDate.getSeconds();


        if (min < 10) {
            min += ('0');
        }

        if (secs < 10) {
            secs += ('0');
        }
        
        $('.clock').text(hours + ':' + min + ':' + secs);

    }

    setInterval(clock, 1000);

})(jQuery);