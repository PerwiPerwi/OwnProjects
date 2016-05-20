/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


lokata = function (kwotaPoczatkowa, oprocentowanie, liczba_lat) {
    var belka = 19;
    var kwotaPoczatkowa = parseInt(document.getElementById('kwota').value);
    var oprocentowanie = parseInt(document.getElementById('oprocentowanie').value);
    var liczba_lat = parseInt(document.getElementById('lata').value);
    var kwota = kwotaPoczatkowa;
    for (i = 1; i <= liczba_lat; i++) {
        kwota = kwota + (oprocentowanie / 100) * (1 - belka / 100) * kwota;
    }
    alert("Twoj hajs wynosi: " + (kwota).toFixed(2) + " PLN");
}

var element = document.getElementById('oblicz');
element.addEventListener('click', lokata);
