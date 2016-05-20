(function () {
    // zwraca sumę wszystkich argumentów
    function sum() {
        var add = 0;

        for (var i = 0; i < arguments.length; i++) {
            add += arguments[i];
        }

        return add;
    }

    function sum2() {
        var add = 0;

        for (var i = 0; i < arguments.length; i++) {
            add += arguments[i];
        }

        return add;
    }

    // sprawdza czy obie referencje wskazują na tę samą funkcję
    function sameFunctions(function1, function2) {
        return(function1 === function2);
    }

    // zwraca false, ponieważ są to dwie różne funkcje w pamięci
    console.log(sameFunctions(sum, sum2));

    var sum3 = sum;

    // zwraca true, ponieważ obie referencje wskazują na tę samą funkcję
    console.log(sameFunctions(sum, sum3));

    var a = [1, 2];
    var b = [1, 2];

    // false, ponieważ tablica to typ dostępny przez referencję
    console.log(a === b);

    var object1 = {name: 'Marek', surname: 'Kowalski'};
    var object2 = {name: 'Marek', surname: 'Kowalski'};

    // zwróci false, ponieważ object1 i object2
    // to dwa różne obiekty w pamięci
    console.log(object1 === object2);

    // sprawdza, czy oba obiekty mają takie same pola i wartości
    // pomija metody
    function similarObjects(object1, object2) {
        return JSON.stringify(object1) === JSON.stringify(object2);
    }

    console.log(similarObjects(object1, object2));

    // klonuje obiekt
    Object.prototype.clone = function () {
        return JSON.parse(JSON.stringify(this));
    };

    var myObject = {name: 'Jan', surname: 'Kowalski'};
    var mySecondObject = myObject.clone();

    console.log('obiekt ma takie same pola? ', similarObjects(myObject, mySecondObject));
})();