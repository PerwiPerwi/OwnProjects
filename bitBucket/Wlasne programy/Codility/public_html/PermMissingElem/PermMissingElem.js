/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var array = [2, 3, 1, 5];
function solution(A) {
    var sortArray = A.sort();
    
    if(A[0] !== 1){
        return 1;
    }
    if(A.length !== A.length+1){
        return A.length;
    }
    
    if(A.length === 1 || A.length===0){
        return array;
    }
    
    for (i = 0; i < sortArray.length; i++) {

        if (!(i === sortArray[i])) {
                    console.log(i);
            return sortArray[i]-1;
         
        }
    }
}
console.log(solution(array));

