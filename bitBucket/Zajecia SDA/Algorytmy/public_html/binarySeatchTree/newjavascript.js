/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var binarySearchTree = function () {
    this.testRoot = undefined;
    this.newRoot = undefined;
    this.size = 0;
    this.Add = function (key, value) {

        if (this.testRoot === undefined) {
            this.testRoot = {
                _left: undefined,
                _right: undefined,
                _key: key,
                _value: value
            };
            console.log(this.testRoot._value);
            return this.testRoot;
        }
            this.newRoot = {
                _left: undefined,
                _right: undefined,
                _key: key,
                _value: value
            };
        while (this.newRoot !== undefined) {
            console.log("poczatek");
            if (this.newRoot._value > this.testRoot._value) {
                console.log("if wiekszy");
                this.testRoot._right = this.newRoot._value;
                this.newRoot._left = this.testRoot;
                this.newRoot = this.testRoot._right;
            }
            if(this.newRoot._value < this.testRoot._value){
                console.log("IF mniejszy");
                this.newRoot = this.testRoot._left;
                this.newRoot._right = this.testRoot;
                this.newRoot._key = key;
                this.testRoot._left = this.testRoot._value;
            }
        }
        newRoot = this.testRoot;
    }
    this.printAll = function () {
        var temp = this.testRoot;
        console.log(temp);
        while (temp !== undefined) {
            temp = temp._right;
        }
    };
}
var tree = new binarySearchTree();
tree.Add("kot", 3);
tree.Add("Andrzej", 4);
//tree.printAll();