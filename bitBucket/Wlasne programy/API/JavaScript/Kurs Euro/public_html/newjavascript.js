
(function ($) {
    var regExp = /^([1-7]{1})*(\.+[0-9]{2})|^([1-7]{1})*(\,+[0-9]{2})$/,
            userChoice = prompt("Wprowadź oczekiwany kurs euro\nW formie np. 4.30 (dwie liczby po przecinku)\n\
                            \nJeżeli podany przez Ciebie kurs euro będzie równy lub wyższy od aktualnego, otrzymasz powiadomienie"),
            end = false;
            
    if (regExp.test(userChoice) === true) {
        end = true;
    } else {
        while (end !== true) {
            userChoice = prompt("Wprowadź oczekiwany kurs euro\nW formie np. 4.30 (dwie liczby po przecinku)\n\
                                \nJeżeli podany przez Ciebie kurs euro będzie równy lub wyższy od aktualnego, otrzymasz powiadomienie");
            if (regExp.test(userChoice) === true) {
                end = true;
            }
        }
    }
    if ($('#output').val() === "") {
        $.getJSON('http://api.fixer.io/latest?symbols=PLN,EUR', function (data) {
            console.log(data.rates.PLN);
            $('#output').val(data.rates.PLN);

            if (data.rates.PLN >= userChoice) {
                alert("Kurs euro wynosi: " + (data.rates.PLN));
            }
        });
    }
    setInterval(function () {
        $('#output').val("");
        $.getJSON('http://api.fixer.io/latest?symbols=PLN,EUR', function (data) {
            console.log(data.rates.PLN);
            $('#output').val(data.rates.PLN);

            if (data.rates.PLN >= userChoice) {
                alert("Kurs euro wynosi: " + (data.rates.PLN));
            }
        });
    }, 15000);
})(jQuery);
