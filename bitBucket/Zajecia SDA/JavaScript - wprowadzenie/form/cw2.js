/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function pokaz() {
    var imie = document.getElementById("name");
    var nazwisko = document.getElementById("surname");
    var wiek = document.getElementById("age");
    var plec = document.getElementsByName("plec");
    var plec2 = "mezczyzna ";
    
    if(parseInt(wiek.value)>105 || parseInt(wiek.value)<1){
        alert("Popraw wiek!");
        return;
    }

    if ((imie.value === "" || nazwisko.value === "" || wiek.value === "") || (plec[0].checked === false && plec[1].checked === false)) {
        alert("Wypelnij cos");
    } else {
        if (plec[0].checked === true) {
            plec2 = "kobieta ";
        }
        alert("Witaj " + imie.value + " " + nazwisko.value + "!" + "\nJestes " + plec2 + "i masz " + wiek.value + " lat.");
    }



}



