/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
        var button = document.getElementById("start"),
            secondsRemaining = 0,
            intervalHandle = 0;

    button.addEventListener("click", function () {
        startCountdown();
    });

    function startCountdown() {
        var $time = $('#addTime').val();
        if (isNaN($time)) {
            alert("Please enter a number!");
            return;
        }
        secondsRemaining = $time * 60;
        intervalHandle = setInterval(tick, 1000);
    }
    function tick() {
        var timeDisplay = document.getElementById("time");
        min = Math.floor(secondsRemaining / 60),
                sec = secondsRemaining - (min * 60);

        if (sec < 10) {
            sec = "0" + sec;
        }
        var message = min.toString() + ":" + sec;
        timeDisplay.innerHTML = message;

        if (secondsRemaining === 0) {
            alert("Done!");
            clearInterval(intervalHandle);
            location.reload();
        }
        secondsRemaining--;
    }
});