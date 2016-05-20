/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function solution(X, Y, D) {

    var times = 0;

    if (X === Y) {
        return times;
    }
    for (i = X; (!(i >= Y)); i += D) {
        times++;
    }
    return times;
}