/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var LinkedList = function () {

    this.firstElement = undefined;
    this.lastElement = undefined;
    this.size = 0;

    this.addAtFront = function (val) {

        this.size++;

        if (this.firstElement === undefined) {

            this.firstElement = {
                value: val,
                _left: undefined,
                _right: undefined
            };
            this.lastElement = this.firstElement;
        } else {
            var newElement = {
                value: val,
                _left: undefined,
                _right: this.firstElement
            };

            this.firstElement._left = newElement;

            this.firstElement = newElement;

//            if (this.firstElement._right === undefined) {
//                this.lastElement = this.firstElement;
//            }

            return this.firstElement;
        }
        ;
        this.printAllElement = function () {
            var temp = this.firstElement;
            while (temp !== undefined) {
                console.log(temp.value);
                temp = temp._right;
            }
        };

        this.addOnTheRightSideOfElement = function (existingElement, newAddedElement) {
            this.size++;
            var newElement = {
                value: newAddedElement,
                _left: existingElement
            };
            if (existingElement._right === undefined) {
                newElement._right = undefined;
                newElement._left = existingElement;
                existingElement._right = newElement;
                this.lastElement = newElement;

            } else {
                newElement._right = existingElement._right;
                existingElement._right._left = newElement;
                existingElement._right = newElement;
            }
        };
        return newElement;
    };
    this.addOnTheLeftSideOfElement = function (existingElement, newAddedElement) {
        this.size++;
        var newElement = {
            value: newAddedElement,
            _right: existingElement
        };
        if (existingElement._left === undefined) {
            newElement._left = undefined;
            newElement._right = existingElement;
            existingElement._left = newElement;
        }

        newElement._left = existingElement._left;

        existingElement._left._right = newElement;
        existingElement._left = newElement;

        return newElement;
    };

    this.addAtBack = function (value) {
        if (this.size === 0) {
            this.addAtFront(value);
        } else {
            this.addOnTheRightSideOfElement(this.lastElement, value);
        }
    };
    
    this.removeAtFront = function () {
        
        this.firstElement = {
            value: this.firstElement._right,
            _left: undefined,
            _right: this.firstElement._right._right
        };
        this.firstElement._right._left = this.firstElement;

    };
    this.verify = function () {

        var counter = 0;

        var temp = this.firstElement;
        console.log(temp.value + (" verify Start"));
        while (temp !== undefined) {
            temp = temp._right;
            console.log(temp);
            counter++;
        }

        if (counter !== this.size) {
            console.log(this.size + ("return"));
            return false;
        }

        counter = 0;
        temp = this.lastElement;
        while (temp !== undefined) {
            temp = temp._left;
            counter++;
        }

        if (counter !== this.size) {
            return false;
        }

        return true;
    };
};


var list = new LinkedList();
var elem1 = list.addAtFront(10);
var elem2 = list.addAtFront(20);
var elem3 = list.addAtFront(30);
var elem4 = list.addAtFront(40);
//list.addOnTheLeftSideOfElement(elem3, 88);
var elem0 = list.addAtBack(1333);
list.removeAtFront();


//list.addOnTheRightSideOfElement(elem2, 40);
console.log(list.verify());
//list.addOnTheRightSideOfElement(elem6, 20);
list.printAllElement();
//console.log(elem1);