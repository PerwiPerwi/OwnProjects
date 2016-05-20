/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var tablica = [2, 20, 5, 6];

function iteracja(tab) {
    var max = tab[0];
    for (var i = 0; i < tab.length; i++) {
        if (max < tab[i]) {
            max = tab[i];
        }
    }
    console.log(max);
}
console.log(iteracja(tablica));

 