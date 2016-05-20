/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function iterator(array) {

    var nextIndex = 0;


    return{
        next: function () {
            return nextIndex < array.length ?
                    {value: array[nextIndex++], done: false} :
                    {done: true};
        }
    };

}

var it = iterator(['a', 'b', 'c', 'a', 'c']);
a = it.next();

var obj = {};
while (a.done === false) {

    if (!obj.hasOwnProperty(a.value)) {
        obj[a.value] = 0;
    }
    obj[a.value]++;
    a = it.next();
}
console.log(obj);