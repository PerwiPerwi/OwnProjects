/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var array = [1,5,3,5,1,1,4,3];

function isAlone(array){
    
    for(i = 0; i <array.length; i++){
        if(array.indexOf(array[i]) === array.lastIndexOf(array[i])){
            return array[i];
        }
    }
}
console.log(isALone(array));