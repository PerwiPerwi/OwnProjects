(function ($) {

    var $clock = $('.clock'), //kazda zmienna ktora oznacza obiekt
        //jQuery'owy powinna byc zapisywana ze znakiem '$' z przodu
        state = 'ready',
        currentTime,
        interval;

    function resetTimer() {

        $clock.text('0:00:00');

    }

    resetTimer();

    $(document).keyup(function (e) {

        if (e.keyCode !== 32) {

            return;

        }

        switch (state) {

        case 'ready':

            currentTime = new Date().getTime();
            interval = setInterval(function () {
                var milliseconds = new Date().getTime() - currentTime;
                $clock.text(timeSplit(milliseconds));
            }, 50);
            state = 'running';
            break;

        case 'running':
            var milliseconds = new Date().getTime() - currentTime;
            clearInterval(interval);
            $clock.text(timeSplit(milliseconds));
            state = 'display';
            break;

        case 'display':
            resetTimer();
            state = 'ready';
            break;
        }


    });

    function timeSplit(milliseconds) {

        var minutes = Math.floor(milliseconds / 60000),
            seconds = Math.floor((milliseconds / 1000) - minutes * 60),
            hundredth = Math.floor(milliseconds / 10) - seconds * 100 - minutes * 60 * 100;

        if (seconds < 10) {

            seconds = "0" + seconds;

        }

        if (hundredth < 10) {

            hundredth = "0" + hundredth;

        }

        return minutes + ":" + seconds + ":" + hundredth;
    }


})(jQuery);