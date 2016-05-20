(function ($) {
    // konstruktor klasy Person
    function Person(nameOrJSON, surname, age, pesel) {

        // możliwość podania łańcucha JSON do konstruktora
        // w pierwszym parametrze
        if (arguments.length === 1) {
            var fieldsJSON = JSON.parse(nameOrJSON);

            this.name = fieldsJSON.name;
            this.surname = fieldsJSON.surname;
            this.age = parseInt(fieldsJSON.age);
            this.pesel = fieldsJSON.pesel;

        } else {

            this.name = nameOrJSON;
            this.surname = surname;
            this.age = parseInt(age);
            this.pesel = pesel;
        }

        // sprawdzenie wejścia

        if (!isCorrectPesel(this.pesel)) {
            console.error('Nieprawidłowy PESEL.');
            return false;
        }
        if (this.name.trim() === '' || this.surname.trim() === '') {
            console.error('Brak imienia lub nazwiska.');
            return false;
        }

        if (!isCorrectAge(this.age)) {
            console.error('Nieprawidłowy wiek.');
            return false;
        }

        // metoda klasy Person zwracająca pełne imię i nazwisko
        this.getFullName = function () {
            return this.name + ' ' + this.surname;
        };

        // metoda klasy Person zwracająca płeć na podstawie przedostatniej cyfry numeru PESEL
        this.gender = function ()
        {
            return parseInt(this.pesel.charAt(9)) % 2 === 0 ? 'Kobieta' : 'Mężczyzna';
        };

        // metoda klasy Person zwracająca rok urodzenia na podstawie pola age
        this.getYearBorn = function () {
            return new Date().getFullYear() - this.age;
        };

        // metoda klasy Person zwracająca w postaci obiektu jQuery
        // wiersz tabeli wypełniony danymi
        this.getAsTr = function () {
            var $tr = $('<tr/>')
                    .append($('<td/>').text(this.name))
                    .append($('<td/>').text(this.surname))
                    .append($('<td/>').text(this.age))
                    .append($('<td/>').text(this.pesel))
                    .append('<td><button>usuń</button></td>');

            if (this.gender() === 'Kobieta') {
                $tr.css('background', 'rgb(200, 200, 255)');
            }

            return $tr;
        };
    }

    // edycja komórek
    $(document).on('click', 'tbody td', function () {

        // ignorujemy komórki z przyciskiem do usuwania
        if ($(this).find('button').length > 0) {
            return;
        }

        // deklarujemy zmienną $td potrzebną
        // później przy opuszczeniu inputa
        var $td = $(this);

        // ustawiamy na sztywno szerokość komórki
        $td.css('width', $td.css('width'));

        // tworzymy inputa z wartością pobraną z komórki
        // nadajemy mu szerokość 100%
        var $input = $('<input/>')
                .val($(this).text().trim())
                .css('width', '100%');

        // czyścimy komórkę i wstawiamy do niej inputa
        $(this).text('').append($input);

        // zaznaczamy tekst w inpucie
        $input.select();

        // po opuszczeniu inputa, jego wartość
        // wpisujemy do komórki tabeli,
        // tym samym go usuwamy
        $input.on('blur', function () {
            $td.text($(this).val());

            // z powrotem ustawiamy automatyczną
            // szerokość komórki
            $td.css('width', '');
        });
    });

    // po zmianie wartości pola
    // ustawia się odpowiednio klasa has-error
    // na elemencie .form-group
    // w zależności od wartości funkcji isCorrect()
    $('form input').change(function () {
        var $formGroup = $(this).closest('.form-group');

        if (isCorrect($(this))) {
            $formGroup.removeClass('has-error');
        } else {
            $formGroup.addClass('has-error');
        }
        refreshButton();
    });

    // sprawdza poprawność PESEL-u na podstawie sumy kontrolnej
    function isCorrectPesel(pesel) {
        // czy 11 cyfr
        if (!/^[0-9]{11}$/.test(pesel)) {
            return false;
        }

        var arr = pesel.split('');
        var control = (1 * parseInt(arr[0]) + 3 * parseInt(arr[1]) + 7 * parseInt(arr[2]) + 9 * parseInt(arr[3]) + 1 * parseInt(arr[4]) + 3 * parseInt(arr[5]) + 7 * parseInt(arr[6]) + 9 * parseInt(arr[7]) + 1 * parseInt(arr[8]) + 3 * parseInt(arr[9])) % 10;

        if (control === 0) {
            control = 10;
        }

        control = 10 - control;

        return parseInt(arr[10]) === control;

    }

    // sprawdza poprawność wieku:
    function isCorrectAge(age) {

        // czy same cyfry
        if (!/^\d+$/.test(age)) {
            return false;
        }

        // czy przedział 1 - 120
        return !(age > 120 || age < 1);
    }

    // wyłącza lub włącza przycisk
    // w zależności od tego, czy są jakieś
    // nieprawidłowo wypełnione pola
    function refreshButton() {
        $('form button')
                .attr('disabled', $('.has-error').length > 0);
    }

    // sprawdza, czy podany input ma prawidłową wartość
    // w zależności od id,
    // używając innych szczegołówych funkcji sprawdzających
    function isCorrect($input) {

        var value = $input.val();

        switch ($input.attr('id')) {
            case 'pesel':
                return isCorrectPesel(value);

            case 'age':
                return isCorrectAge(value);

            default:
                return value.length > 0;

        }
    }

    // usuwamy wiersz tabeli po kliknięciu w przycisk
    $(document).on('click', 'tbody button', function () {

        // pytanie potwierdzające
        if (confirm("Czy jesteś pewny?")) {

            // wiersz powoli znika
            // by w końcu zostać usunięty z dokumentu
            $(this).closest('tr').fadeOut(300, function () {
                $(this).remove();
            });
        }
    });


    // po zatwierdzeniu formularza
    // dodajemy nowy wiersz to tabeli
    $('form').submit(function (e) {

        // zabezpieczamy się przed przeładowaniem strony
        e.preventDefault();

        // tworzymy obiekt klasy Person
        // z danymi z formularza
        var person = new Person($('#name').val(),
                $('#surname').val(),
                $('#age').val(),
                $('#pesel').val());

        // używając metody klasy Person getAsTr()
        // dodajemy nowy wiersz do tabeli
        person.getAsTr().appendTo("tBody");

        // resetujemy formularza
        // oraz wywołujemy zdarzenie onchange
        // na wszystkich inputach
        $('form')[0].reset();
        $('input').change();
    });

    // sortujemy tabelę po kliknięciu w nagłówek
    $('th').click(function () {

        // zapisujemy indeks klikniętego nagłówka
        var index = $(this).index();

        // sortujemy tablicę,
        // następnie dodajemy elementy w nowej
        // kolejności do tbody
        $('tbody tr').sort(function (tr1, tr2) {

            // funkcja porównująca dwa wiersze
            return $(tr1).find('td').eq(index).text() >
                    $(tr2).find('td').eq(index).text() ? 1 : -1;

        }).detach().appendTo('tbody');

    });

    // na początku oznaczamy wszystkie pola jako nieprawidłowe
    // oraz blokujemy przycisk
    $('.form-group').addClass('has-error');
    $('form button').attr('disabled', true);

    // pobiieramy listę osób z pliku persons.json
    $.get('persons.json', function (json) {
        var persons = JSON.parse(json);
        var person;

        for (var i = 0; i < persons.length; i++) {
            // tworzymy nowy obiekt klasy person na podstawie surowego obiektu
            person = new Person(JSON.stringify(persons[i]));

            // dodajemy wiersz tabeli
            person.getAsTr().appendTo("tbody");
        }
    }).fail(function () {
        alert("Nie udało się pobrać listy osób");
    });


    // inicjalizujemy obiekt klasy Person
    var janNowak = new Person('{"name": "Jan", "surname": "Kowalski","age": 13,"pesel": "55010110056"}');
    console.log(janNowak);

    // sprawdzamy działanie metod klasy Person
    console.log(janNowak.getFullName());
    console.log(janNowak.gender());
    console.log(janNowak.getYearBorn());
    console.log(janNowak.getAsTr().html());

})(jQuery);