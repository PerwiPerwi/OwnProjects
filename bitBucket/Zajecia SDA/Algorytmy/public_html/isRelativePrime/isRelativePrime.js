/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function isRelativePrime(number1, number2){
    
    for(var i=2; i <= number2; i++ ){
        
        if(number1%i === 0){
            if(number2%i === 0){
                return false;
            }
        }
        return true;
    }
}

console.log(isRelativePrime(6,8));