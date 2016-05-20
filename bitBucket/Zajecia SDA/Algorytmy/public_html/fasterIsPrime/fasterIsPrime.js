/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function isPrime2(number) {
    if (number <= 1) {
        return false;
    }
    for (i = 2; i <= Math.sqrt(number); i++) {
        if (number % i === 0)
            return true;
    }
    return false;
}

console.log(isPrime2(12));