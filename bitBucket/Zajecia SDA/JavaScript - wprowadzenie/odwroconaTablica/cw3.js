/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var tablica=[1,2,3,4,5];
function rev(tab){
    var temp_tab=[];
    for(i=tab.length-1;i>=0;i--){
        temp_tab.push(tab[i]);
    }
    return temp_tab;
}
console.log('stara tablica '+tablica);
console.log('odwrocona tablica '+rev(tablica));