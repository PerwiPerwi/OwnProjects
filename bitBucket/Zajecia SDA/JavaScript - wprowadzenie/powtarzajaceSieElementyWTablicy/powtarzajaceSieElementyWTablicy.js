/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var tab1 = [1, 3, 5, 8, 9, 10];
var tab2 = [1, 5, 2, 9, 12, 100];
var tempA = [];
var tempB = [];
var czyWystepuje=false;

function tab3(tab1,tab2){
  for (i = 0; i < tab1.length; i++) {
    for (j = 0; j < tab2.length; j++) {
        if (tab1[i] === tab2[j]) {
            czyWystepuje=true;
        }
    }
    if(czyWystepuje===false){
        tempB.push(tab1[i]);
    }
    czyWystepuje=false;  
    
    
}

for (i = 0; i < tab1.length; i++) {
    for (j = 0; j < tab2.length; j++) {
        if (tab1[i] === tab2[j]) {
            //tempA.push(tab1[i]);
            czyWystepuje=true;
        }
    }
    if(czyWystepuje===false){
        tempB.push(tab1[i]);
    }
    czyWystepuje=false;
}
}
tab3(tab1,tab2);
tab3(tab2,tab1);
console.log(tempB);