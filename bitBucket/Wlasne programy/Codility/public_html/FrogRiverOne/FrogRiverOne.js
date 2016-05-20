/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var A = [1, 4, 2, 6, 3, 5, 7];
//O(n2)
//function solution(X, A) {
//    if(X === 1){
//        return 0;
//    }
//    if(A.indexOf(X) === -1){
//        return -1;
//    }
//        
//    var temp = [];
//
//    for (var i = 0; i < A.length; i++) {
//
//        if (temp.indexOf(A[i]) === -1) {
//            if (X >= A[i]) {
//                temp.push(A[i]);
//                if (temp.length === X) {
//                    return i;
//                }
//            }
//        }
//    }
//    return -1;
//}

// O(n)
function solution(X, A) {
    
        temp = new Array(X),
        count = 0;
        
        for (var i = 0; i < A.length; i++ ){
            if(temp[A[i]] === undefined && A[i]<=X){ //A[i] = 1, temp[1]
                temp[A[i]] = 1;                     // odwołuje się przez 
                count ++;
            }
            
            if(count === X){
                return i;
            }
            
        }
        return -1;
}
console.log(solution(7, A));