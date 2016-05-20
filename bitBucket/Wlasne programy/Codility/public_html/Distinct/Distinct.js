

// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

// Correctness 100%, Performance 33%

//function solution(A) {
//    
//    if(A.length === 1){
//        return 1;
//    }
//    if(A.length === 0){
//        return 0;
//    }
//    
//    var tempArray = [],
//        counter = 0;
//        
//    for (var i = 0; i < A.length; i++) {
//        if (tempArray.indexOf(A[i]) === -1) {
//            tempArray.push(A[i]);
//        }
//    }
//    for (var i = 0; i < tempArray.length; i++) {
//        counter++;
//    }
//    return counter;
//}



// Correctness 100%, Performance 100%
function solution(A) {
    
    if(A.length === 1){
        return 1;
    }
    if(A.length === 0){
        return 0;
    }
    
    var tempArray = A.sort();
        counter = 0;
        
    for (var i = 0; i < A.length; i++) {
        if (tempArray[i] !== tempArray[i+1]) {
            counter++;
        }
    }
    return counter;
}