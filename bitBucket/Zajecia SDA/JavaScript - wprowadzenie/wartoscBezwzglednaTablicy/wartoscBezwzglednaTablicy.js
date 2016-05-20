/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 var tablica=[-10,12,11,402,33,-3];
 
 function roznica(tab){
 var min= tab[0];
 var max=tab[0];
 
 for(i=0;i<tab.length;i++){
 if(max>tab[i]){
 max=tab[i];
 }
 if(min<tab[i]){
 min=tab[i];
 }
 }
 return Math.abs(max - min);
 
 }
 console.log(roznica(tablica));