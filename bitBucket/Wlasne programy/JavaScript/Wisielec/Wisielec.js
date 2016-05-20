/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var haslo;
var haslo1 = "";

var polskiePrzyslowia = ["Bez pracy nie ma kołaczy", "Nie wszystko złoto co się świeci", 
                         "Pieniądze to nie wszystko", "A kto z nami nie wypije tego we dwa kije",
                         "Będą takie mrozy że przymarznie cap do kozy"];
                     
var nazwyPanstw = ["Polska", "Madagaskar", "Korea Północna","Uzbekistan","Portugalia"];

var sportowcy = ["Adam Małysz", "Robert Lewandowski", "Agnieszka Radwańska","Robert Kubica","Mariusz Pudzianowski"];

var liczbaProb = 0;
var kontenerKategorii = document.getElementById('kontenerKategorii');
var tak = new Audio('dzwieki/dobraOdpowiedz.wav');
var nie = new Audio('dzwieki/zlaOdpowiedz.wav');
var wygrana = new Audio('dzwieki/Wygrana.wav');
var przegrana = new Audio('dzwieki/przegrana.wav');

var kategoria1 = document.getElementById('pierwszaKategoria'),
        kategoria2 = document.getElementById('drugaKategoria'),
        kategoria3 = document.getElementById('trzeciaKategoria');

kategoria1.addEventListener("click", function (e) {
    if (e.target.innerHTML == 'Przysłowia') {
        kontenerKategorii.style.display = 'none';
        haslo = polskiePrzyslowia[Math.floor(Math.random() * polskiePrzyslowia.length)];
        for (i = 0; i < haslo.length; i++) {
            if (haslo.charAt(i) == " ")
                haslo1 = haslo1 + " ";
            else
                haslo1 = haslo1 + "-";
        }
        wyswietl_haslo();
        haslo = haslo.toUpperCase();
    }

});

kategoria2.addEventListener("click", function (e) {
    if (e.target.innerHTML == 'Państwa') {
        kontenerKategorii.style.display = 'none';
        haslo = nazwyPanstw[Math.floor(Math.random() * nazwyPanstw.length)];
        for (i = 0; i < haslo.length; i++) {
            if (haslo.charAt(i) == " ")
                haslo1 = haslo1 + " ";
            else
                haslo1 = haslo1 + "-";
        }
        wyswietl_haslo();
        haslo = haslo.toUpperCase();
    }

});

kategoria3.addEventListener("click", function (e) {
    if (e.target.innerHTML == 'Sportowcy') {
        kontenerKategorii.style.display = 'none';
        haslo = sportowcy[Math.floor(Math.random() * sportowcy.length)];
        for (i = 0; i < haslo.length; i++) {
            if (haslo.charAt(i) == " ")
                haslo1 = haslo1 + " ";
            else
                haslo1 = haslo1 + "-";
        }
        wyswietl_haslo();
        haslo = haslo.toUpperCase();
    }

});


function wyswietl_haslo() {
    document.getElementById("pole").innerHTML = haslo1;
}

window.onload = poczatek;
var literki = ["A", "Ą", "B", "C", "Ć", "D", "E", "Ę", "F",
    "G", "H", "I", "J", "K", "L", "Ł", "M", "N", "Ń", "O",
    "Ó", "P", "Q", "R", "S", "Ś", "T", "U", "V", "W", "X",
    "Y", "Z", "Ź", "Ż"];

function poczatek() {

    var zawartosc_alfabetu = "";
    for (i = 0; i < 35; i++) {
        var element = "literka" + i;
        zawartosc_alfabetu = zawartosc_alfabetu + '<div id="' + element + '" onClick="weryfikuj(' + i + ')" class="litera">' + literki[i] + '</div>';

        if ((i + 1) % 7 == 0)
            zawartosc_alfabetu = zawartosc_alfabetu + '<div style="clear:both;"></div>'
    }
    document.getElementById("alfabet").innerHTML = zawartosc_alfabetu;

    wyswietl_haslo();
}
String.prototype.przyjmijLitere = function (pozycja, znak) {
    if (pozycja > this.lenght - 1) {
        return this.toString();
    }
    else {
        return this.substr(0, pozycja) + znak + this.substr(pozycja + 1);
    }
}


function weryfikuj(nr) {
    var znaleziona = false;
    for (i = 0; i < haslo.length; i++) {
        if (haslo.charAt(i) == literki[nr]) {
            haslo1 = haslo1.przyjmijLitere(i, literki[nr]);
            znaleziona = true;
        }
    }
    if (znaleziona == true) {
        tak.play();
        var elemencik = "literka" + nr;
        document.getElementById(elemencik).style.background = "green";
        document.getElementById(elemencik).style.cursor = "default";
        wyswietl_haslo();
    }
    else {
        nie.play();
        var elemencik = "literka" + nr;
        document.getElementById(elemencik).style.background = "red";
        document.getElementById(elemencik).style.cursor = "default";
        document.getElementById(elemencik).setAttribute("onClick", ";");

        //skucha
        liczbaProb = liczbaProb + 1;
        var obrazek = "img/s" + liczbaProb + ".jpg";
        document.getElementById("szubienica").innerHTML = '<img src="' + obrazek + '" alt="" />';

    }
    //wygrana
    if (haslo == haslo1) {
        wygrana.play();
        document.getElementById("alfabet").innerHTML = "Tak, podano prawidłowe hasło!\n" + haslo + '<br><br><span class="reset" onClick="location.reload()">Jeszcze jedno podejście?</span>';
    }
    if (liczbaProb == 9) {
        przegrana.play();
        document.getElementById("alfabet").innerHTML = "Przegrana!<br> Prawidłowe hasło to:\n" + haslo + '<br><br><span class="reset" onClick="location.reload()">Jeszcze jedno podejście?</span>';

    }
}
