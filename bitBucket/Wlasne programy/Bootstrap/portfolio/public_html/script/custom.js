
//Background slider
$(window).ready(function () {
    $('body').vegas({
        delay: 7000,
        timer: false,
        shuffle: true,
        transition: 'blur2',
        transitionDuration: 2000,
        slides: [
            {src: 'images/bg-slider/bg-1.jpg'},
            {src: 'images/bg-slider/bg-2.jpg'},
            {src: 'images/bg-slider/bg-3.jpg'},
            {src: 'images/bg-slider/bg-4.jpg'}
        ],
        overlay: 'images/overlays/07.png'
    });
});

//Animations
$(document).ready(function () {
    'use strict';
    $('.animated').appear(function () {
        console.log("cyce");
        var element = $(this),
                animation = element.data('animation'),
                animationDelay = element.data('animation-delay');
        if (animationDelay) {

            setTimeout(function () {
                element.addClass(animation + " visible");
            }, animationDelay);

        } else {
            element.addClass(animation + " visible");
        }
    });
});

//Navigation
$(document).ready(function () {
    'use strict';
    $('#nav').onePageNav({
        scrollSpeed: 1000,
        easing: 'easeInOutQuint'
    });
});

//Scroll
$(document).ready(function () {
    'use strict';
    $("html").niceScroll({
        cursorcolor: '#999',
        cursoropacitymin: '1',
        cursorborder: '0px',
        cursorborderradius: '3px',
        cursorwidth: '7px',
        cursorminheight: 20,
        horizrailenabled: false,

    });
});

//Form validator


