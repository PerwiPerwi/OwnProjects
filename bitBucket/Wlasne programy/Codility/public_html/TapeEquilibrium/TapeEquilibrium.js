/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function solution(A) {
   
    var result = -1;
   
    for(var i = 1; i < A.length; i++) {
       
        var sum1 = 0;
        var sum2 = 0;
       
        for(var j = 0; j < i; j++) {
            sum1 += A[j];  
        }
       
        for(var k = i; k < A.length; k++) {
            sum2 += A[k];
        }
       
        var min = Math.abs(sum1 - sum2);
       
        if (result === -1) {
            result = min;
        } else {
            if (min < result) {
                result = min;
            }
        }
    }
       
    return result;
   
}