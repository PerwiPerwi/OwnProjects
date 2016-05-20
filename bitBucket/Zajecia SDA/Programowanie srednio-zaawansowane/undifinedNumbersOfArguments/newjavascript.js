/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
   
    function sum (arg1 , arg2){
        if (arguments.length===2){
            return arg1+arg2;
        }
        return function (a){
            return a+arg1;
        };       
    }
    console.log(sum(2,3));
    console.log(sum(2)(5));
    

