/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var A = [1, 5, 2, 7, 3, 6];


function solution(A) {
    console.log(A);
    var temp = new Array(A.length);
        counter = 0;
        for(i = 0; i < A.length; i++){
            if(temp[A[i]] === undefined ){
                temp[A[i]] = 1;
                counter++;
            }
            else{
                return 0;
            }
        }  
        console.log(temp);
        for(var i = 1; i < temp.length; i++){
            if(temp[i] === undefined ){
                return 0;
            }
        }
    return 1;
}
console.log(solution(A));
