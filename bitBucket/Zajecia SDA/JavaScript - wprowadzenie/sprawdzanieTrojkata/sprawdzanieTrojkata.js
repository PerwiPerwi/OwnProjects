/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function Liczenie(a, b, c) {
    var c = 0;

    this.a = parseInt(a, 10);
    this.b = parseInt(b, 10);
    this.c = undefined;
    if (c) {
        this.c = parseInt(c, 10);
    }
    this.sprawdzTrojkat = function () {

        if (this.c) {
        return  (((this.a + this.b)> this.c)&&
                ((this.a + this.c) > this.b)&&
                ((this.b + this.c) > this.a));
    }
return false;
    };
    this.pole = function () {
        if (this.c) {
            return Math.sqrt(((this.a + this.b + this.c) *
                    (this.a + this.b - this.c) *
                    (this.a - this.b + this.c) *
                    (-(this.a) + this.b + this.c))) / 4;
        } else {
            return this.a * this.b;
        }
    };
    this.obwod = function () {

        if (this.c) {

            return this.a + this.b + this.c;
        } else {

            return this.a + this.b;
        }
    };
}
;
var trojkat = new Liczenie(5, 6, 10);

console.log(trojkat.pole());
console.log(trojkat.obwod());
console.log(trojkat.sprawdzTrojkat());
