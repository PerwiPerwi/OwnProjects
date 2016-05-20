/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$( document ).ready(function(){
    
    $("#number3").on('click',function(e){;

    liczenie();

    });

});

    function liczenie(){
        
    var firstNumber = parseInt($("#number1").val());
    
    var secondNumber = parseInt($("#number2").val());
    
    var result = firstNumber * secondNumber;
    
    
    //alert("wynik mnozenia wynosi:" + result);
    
    }