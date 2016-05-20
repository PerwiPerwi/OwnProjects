var inputy = document.getElementsByTagName('input');
 
function liczenie() {
 
    var liczba1,
        liczba2,
        wynik;
 
    liczba1 = document.getElementById('liczba1').value;
    liczba2 = document.getElementById('liczba2').value;
   
    parseInt(liczba1);
    parseInt(liczba2);
   
    wynik = document.getElementById('iloczyn');
   
    wynik.value = liczba1 * liczba2;
 
}
 
for(var i = 0; i < inputy.length; i++) {
    inputy[i].onchange = liczenie;
}