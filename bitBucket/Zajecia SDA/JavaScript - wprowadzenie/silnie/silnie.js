/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//function silnia(n) {
//
//    if (n === 0) {
//        return 1;
//    } else {
//        var wynik = 1;
//        for (var i = 1; i <= n; i++) {
//            wynik = wynik * i;
//
//        }
//        return wynik;
//    }
//
//}
//console.log(silnia(2));
//
//var x = 3;
//while (x > 0) {
//    console.log("dzialam");
//    x--;
//}
//function silnia2(n) {
//    var wynik = 1;
//    while (n > 0) {
//        wynik = wynik * n;
//        n--;
//    }
//    return wynik;
//}
//console.log(silnia(4));


function silnia3(n) {
    if (n === 0) {
        return 1;
    } else {
        console.log(n + "*silnia3(" + (n - 1) + ")");
        return (n * silnia3(n - 1));

    }
}
console.log(silnia3(4));