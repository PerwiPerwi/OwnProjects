/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function eat(howMany, limitInMouth) {
    
    var result = [],
        many = howMany,
        limit = limitInMouth;
        while(many > limit){
            console.log("start");
            console.log(many - limit);
        if (many > limit) {
            many -=limit;
            result.push(limit);
            console.log("if");
        }
        if(many <= limit){
            console.log(many+(" MANY"));
            result.push(many);
            return result;
        }
    }
}
console.log(eat(15,3));