


//deklaracja zmiennych globalnych 
var imie = prompt("Podaj swoje imię graczu :)"),
        odpA = document.getElementById('odpA'),
        odpB = document.getElementById('odpB'),
        odpC = document.getElementById('odpC'),
        odpD = document.getElementById('odpD'),
        popr_odp = null;//Zmienna do ktorej zostanie przypisana prawidlowa odpowiedz z tablicy z odpowiedziami
        licznik = 0;    // Zmienna przy pomocy ktorej okreslany jest numer pytania do wyswietlenia
        odp = document.getElementsByTagName('li');

//deklaracja flag wykorzystywanych w kolach ratunkowych    
var pytanieUzyte = false,
        telefonUzyty = false,
        polNaPolUzyte = false;

// deklaracja zmiennych zawierajacych dzwieki
var dobraOdpowiedz = new Audio('dzwieki/dobraOdpowiedz.wav'),
        zlaOdpowiedz = new Audio('dzwieki/zlaOdpowiedz.wav'),
        wygrana = new Audio('dzwieki/wygrana.wav'),
        pytanieDoPublicznosciDzwiek = new Audio('dzwieki/pytanieDoPublicznosci.wav'),
        telefonDoPrzyjacielaDzwiek = new Audio('dzwieki/telefonDoPrzyjaciela.wav'),
        polNaPolDzwiek = new Audio('dzwieki/polNaPol.wav');

//Deklaracja tablicy asocjacyjnej zawierajacej pytania oraz poprawne odpowiedzi        
var tab = [{'pytanie': imie + ', pytanie numer 1: Jakie miasto jest stolicą Meksyku?',
        'odpA': 'Gwatemala',
        'odpB': 'Katar',
        'odpC': 'Paryż',
        'odpD': 'Mexico City',
        'poprawna': 'Mexico City'
    },
    
    {'pytanie': imie + ', pytanie numer 2: Jakie miasta wchodzą w skład Trójmiasta?',
        'odpA': 'Reda, Pruszcz Gdański, Sopot',
        'odpB': 'Lębork, Wejherowo, Gdańsk',
        'odpC': 'Gdańsk, Sopot, Gdynia',
        'odpD': 'Gdańsk, Słupsk, Gdynia',
        'poprawna': 'Gdańsk, Sopot, Gdynia'
    },
    
    {'pytanie': imie + ', pytanie numer 3: Kto nie był prezydentem Polski?',
        'odpA': 'Stanisław Bierut',
        'odpB': 'Lech Wałęsa',
        'odpC': 'Donald Tusk',
        'odpD': 'Bronisław Komorowski',
        'poprawna': 'Donald Tusk'
    },
    
    {'pytanie': imie + ', pytanie numer 4: w którym roku Polska wstąpiła do Uni Europejskiej?',
        'odpA': 'Polska nigdy nie wstąpiła',
        'odpB': 'w 2003',
        'odpC': 'w 1989',
        'odpD': 'w 2004',
        'poprawna': 'w 2004'
    },
    
    {'pytanie': imie + ', pytanie numer 5: Czy chcielibyście \n\
                przyjąć Łukasza Perwejnis na staż do Waszej firmy?',
        'odpA': 'Tak',
        'odpB': 'Tak',
        'odpC': 'Tak',
        'odpD': 'Tak',
        'poprawna': 'Tak'
    }];


//Funkcja odpowiadajaca za sprawdzanie poprawnosci udzielonych informacji oraz
//wyswietlanie poszczegolnych elementow w zaleznosci od etapu rozgrywki
function correct(e) {
    if (e.target.innerHTML === popr_odp) {
        wygryw();
        
        if (tab.length - 1 > licznik) {
            uzupelnij(tab[++licznik]);
        } 
        else {
            koniec_gry();
        }
    } 
    else {
        przegryw();
    }
};

//Funkcja odpowiadajaca za uzupelnianie pytan w HTML-u oraz weryfikowanie usuwanie
//elementow po wykorzystanych kolach ratunkowych
function uzupelnij(tablica) {

    var pyt = document.getElementById('pytanie'),
            odpA = document.getElementById('odpA'),
            odpB = document.getElementById('odpB'),
            odpC = document.getElementById('odpC'),
            odpD = document.getElementById('odpD');
    
    pyt.innerHTML = tablica['pytanie'];
    odpA.innerHTML = tablica['odpA'];
    odpB.innerHTML = tablica['odpB'];
    odpC.innerHTML = tablica['odpC'];
    odpD.innerHTML = tablica['odpD'];
    
    popr_odp = tablica['poprawna']; //przypisanie poprawnej odpowiedzi do zmiennej globalnej


//Usuwanie zaznaczania wynikajacego z wykorzystania podpowiedzi w formie pomocy publicznosci
    var publicznosc = document.querySelectorAll('odpowiedzi');
   
    if (pytanieUzyte == true) {
   
        odpA.classList.remove('dwadziescia', 'czterdziesci');
        odpB.classList.remove('dwadziescia', 'czterdziesci');
        odpC.classList.remove('dwadziescia', 'czterdziesci');
        odpD.classList.remove('dwadziescia', 'czterdziesci');
        
    }
    //Usuwanie elementu background uzyskanego z kola ratunkowego telefon do przyjaciela
    if (telefonUzyty == true){
    
        odpA.style.removeProperty('background');
        odpB.style.removeProperty('background');
        odpC.style.removeProperty('background');
        odpD.style.removeProperty('background');
}

//Ponowne dodanie Event Listenerow po wczesniejszym usunieciu przez kolo ratunkowe pol na pol
    if(polNaPolUzyte == true){
        odpA.addEventListener("click", correct);
        odpB.addEventListener("click", correct);
        odpC.addEventListener("click", correct);
        odpD.addEventListener("click", correct);
    }
}



// Event listenery do poszczegolnych elementow HTML z odpowiedziami
odpA.addEventListener("click", correct);
odpB.addEventListener("click", correct);
odpC.addEventListener("click", correct);
odpD.addEventListener("click", correct);


//wywolanie funkcji uzupelniania pytan i odpowiedzi
uzupelnij(tab[licznik]);



//Funkcja wyswietlajaca skutki blednej odpowiedzi
function przegryw() {
    zlaOdpowiedz.play();
    var element = document.getElementById('przegrana');
    element.style.display = 'block';
}


//Funkcja wyswietlajaca blok informujacy o dobrej odpowiedzi
function wygryw() {
    var element = document.getElementById('popOdp');
    dobraOdpowiedz.play();
    element.style.display = 'block';
    setTimeout(function () {
        element.style.display = 'none';
    }, 1500);
}


//Funkcja wyswietlajaca blok po przejsciu gry
function koniec_gry() {
    wygrana.play();
    var element = document.getElementById('wygrana');
    element.style.display = 'block';
}



// Kolo ratunkowe - telefon do przyjaciela
var telefonDoPrzyjaciela = document.getElementById('telefonDoPrzyjaciela');

telefonDoPrzyjaciela.addEventListener('click', function (e) {

    if (telefonUzyty == false) {
        telefonDoPrzyjacielaDzwiek.play();
        var podpowiedzPrzyjaciela = document.querySelectorAll('.pytania');
        //Przetwarzanie Node List na typ Array
        var przerobionaTablica = Array.prototype.slice.call(podpowiedzPrzyjaciela);
        //wybieranie losowej odpowiedzi sposrod dostepnych
        var losowaPodpowiedz = przerobionaTablica[Math.floor(Math.random() * przerobionaTablica.length)];
        //edycja tla elementu z wybrana odpowiedzia
        losowaPodpowiedz.style.background = 'pink';
        alert(imie + " ,podpowiedz Twojego przyjaciela jest zaznaczona na różowo.");
    }
    telefonDoPrzyjaciela.style.background = 'red';
    telefonUzyty = true; //deklaracja flagi odpowiadajaca za wykorzystanie kola ratunkowego
});




//Funkcja kola ratunkowego pol na pol
var polNaPol = document.getElementById('polNaPol');

polNaPol.addEventListener('click', function (e) {
    if (polNaPolUzyte === false) {   // Warunek sprawdzajacy uzycie kola
        var index = null;
        polNaPolDzwiek.play();

        //petla wybierajaca bledne odpowiedzi w zaleznosci od pozycji poprawnej
        for (i = 0; i < odp.length; i++) {
            if (odp[i].innerHTML == popr_odp) {
                index = i;
                zle = [];
            }
        }
        //Usuwanie odpowiedzi blednych
        zle = znajdzZle(index);
        odp[zle[0]].innerHTML = '&nbsp';
        odp[zle[1]].innerHTML = '&nbsp';
        odp[zle[0]].removeEventListener('click', correct);
        odp[zle[1]].removeEventListener('click', correct);
        polNaPol.style.background = 'red';
        polNaPolUzyte = true;   //deklaracja flagi odpowiadajaca za wykorzystanie kola ratunkowego
    }
});



//Funkcja wybierajaca zle odpowiedzi w stostunku do polozenia wlasciwej
function znajdzZle(index) {
    var indexPlus = null, 
        inexMinus = null;

    //pierwszy if
    if (index + 1 > 3) {
        indexPlus = 0;
    } else {
        indexPlus = index + 1;
    }
    //drugi if
    if (index - 1 < 0) {
        indexMinus = 3;
    } else {
        indexMinus = index - 1;
    }
    
    return [indexMinus, indexPlus];

}



//Kolo ratunkowe pytanie do publicznosci
var pytanieDoPublicznosci = document.getElementById('pytanieDoPublicznosci');

    pytanieDoPublicznosci.addEventListener('click', function (e) {

    if (pytanieUzyte === false) {
        pytanieDoPublicznosciDzwiek.play();
        var index = null;
        //Dodanie after z CSS z procentami do wlasciwej oraz blednych odpowiedzi
        for (i = 0; i < odp.length; i++) {
            if (odp[i].innerHTML == popr_odp) {
                odp[i].classList.add('czterdziesci');
            } else {
                odp[i].classList.add('dwadziescia');
            }
        }
        pytanieUzyte = true;    //deklaracja flagi odpowiadajaca za wykorzystanie kola ratunkowego
        pytanieDoPublicznosci.style.background = 'red';

    }
});

