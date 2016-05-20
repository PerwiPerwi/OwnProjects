/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function dwumian(n, k) {
    if (n < k) {
        return null;
    }
    var licznik = silnia3(n);
    var mianownik = silnia3(k) * silnia3(n - k);
    return (licznik / mianownik);

}



console.log(dwumian(4, 3));