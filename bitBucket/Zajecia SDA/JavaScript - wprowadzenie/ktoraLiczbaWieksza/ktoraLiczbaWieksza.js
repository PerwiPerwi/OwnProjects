/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function max(a, b, c) {
    if ((a > b) && (a > c)) {
        return a;
    } else if ((a < b) && (b > c)) {
        return b;
    } else if ((a < c) && (c > b)) {
        return c;
    }
}


function max(a, b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}
console.log(max(max(3, 7), 10));
