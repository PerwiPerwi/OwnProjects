/*
 
 */

(function ($) {

    var randomNumber = Math.floor((Math.random() * 5) + 1);
    
    var userAnswer = parseInt(prompt('Podaj liczbę'));
    
    
    if(userAnswer === randomNumber) {
        alert('Ekstra zgadłeś');
    } else {
        alert('Liczba wynosiła:' + randomNumber);
    }

})(jQuery);