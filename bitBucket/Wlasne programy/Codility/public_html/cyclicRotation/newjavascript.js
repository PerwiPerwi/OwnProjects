/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var A = [1, 3, 5, 6, 3, 7, 9];
console.log(A);
function solution(A, K) {

    var tempArray = new Array (A.length),
        long = A.length,
        newLine = 0;

    if(A.length === 1){
        return A;
    }
    
    if(K%A.length === 0 ){
        return A;
    }
    if(K > A.length){
        K = K % A.length;
    }
    

        for(i = 0; i < A.length; i++){
            if((i+K) >= long){
               newLine = (i+K) - long;
               tempArray[newLine] = A[i];
           }
           else{
               tempArray[i+K] = A[i];
           }           
            console.log(tempArray);
        }
    return tempArray;
}

console.log(solution(A,7));