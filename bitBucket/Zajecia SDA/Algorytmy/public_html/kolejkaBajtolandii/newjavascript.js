/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var LinkedList = function () {

    this.lastElement = undefined;
    this.firstElement = undefined;

    this.size = 0;

    // Adds element on the right of the current element
    this.addAtFront = function (val) {

        // If current element is undefined
        if (this.firstElement == undefined) {

            this.size++;

            this.firstElement = {
                _left: undefined,
                _right: undefined,
                value: val
            }
            this.lastElement = this.firstElement;

        } else {
            return this.addOnTheLeftSide(this.firstElement, val);
        }

        return this.firstElement
    }

    this.addAtBack = function (val) {

        if (this.firstElement === undefined) { // in case of empty
            return this.addAtFront(val);
        } else {
            return this.addOnTheRightSide(this.lastElement, val);
        }
    }

    this.addOnTheRightSide = function (node, val) {

        this.size++;

        var newElement = {
            _left: node,
            _right: undefined,
            value: val
        }

        if (node._right !== undefined) {
            newElement._right = node._right;
            node._right._left = newElement;
        } else {
            this.lastElement = newElement;
        }

        node._right = newElement;

        return newElement;
    }

    this.addOnTheLeftSide = function (node, val) {

        this.size++;

        var newElement = {
            _left: undefined,
            _right: node,
            value: val
        }
        if (node._left !== undefined) {
            newElement._left = node._left;
            node._left._right = newElement;
        } else {
            this.firstElement = newElement;
        }

        node._left = newElement;

        return newElement;
    }

    this.removeFirstElement = function () {

        this.size--;

        if (this.firstElement == this.lastElement) {
            this.firstElement = undefined;
            this.lastElement = undefined;
        } else {
            this.firstElement._right._left = undefined;
            this.firstElement = this.firstElement._right;
        }

    }

    this.removeLastElement = function () {

        this.size--;

        if (this.firstElement == this.lastElement) {
            this.firstElement = undefined;
            this.lastElement = undefined;
        } else {
            this.lastElement._left._right = undefined;
            this.lastElement = this.lastElement._left;
        }
    }

    this.verify = function () {

        var counter = 0;

        var temp = this.firstElement;
        while (temp != undefined) {
            temp = temp._right;
            counter++;
        }

        if (counter != this.size) {
            return false;
        }

        counter = 0;
        temp = this.lastElement;
        while (temp != undefined) {
            temp = temp._left;
            counter++;
        }

        if (counter != this.size) {
            return false;
        }

        return true;
    }

    this.printAllElements = function () {

        var result = "";
        var elem = list.firstElement;
        while (elem != undefined) {

            result += (elem.value + " ")
            elem = elem._right;
        }

        console.log(result);
    }

}
function solution(array) {

    var lastInQue = 0;
    console.log("Poczatek");
    for (var i = 0; i < array.length; i++) {
        console.log(("Ostatni indeks: ") + lastInQue.value);
        list.printAllElements();
        if (array[i] === 10) {
            list.addAtBack(i);
            lastInQue = list.lastElement;
            continue;
        }
        if (array[i] === 0) {
            list.removeFirstElement();
            if (list.firstElement === undefined) {
                lastInQue === list.firstElement._right;
            }
            continue;
        }
        if (array[i] >= -5 && array[i] <= 5) {

            if (array[i] <= -1) {
                console.log("IF II");

                for (var k = array[i]; k < 0; k++) {
                    if (lastInQue === undefined) {
                        break;
                    }
                    lastInQue = lastInQue._left;
                }
                if (lastInQue === undefined) {
                    list.addAtFront(i);
                    lastInQue = list.firstElement;
                    continue;
                } else {
                    list.addOnTheLeftSide(lastInQue, i);
                    lastInQue = i;
                    continue;
                }
            } else {
                console.log("ELSE");
                console.log(lastInQue.value);
                for (var j = array[i]; j === 0; j--) {

                    lastInQue = lastInQue._right;
                    if (lastInQue._right === undefined) {
                        break;
                    }
                }
                if (lastInQue === undefined) {
                    list.addOnTheRightSide(lastInQue, i);
                    lastInQue = i;
                    continue;
                } else {
                    list.addAtBack(i);
                    lastInQue = list.lastElement;
                    continue;
                }
            }
        }
        //list.printAllElements();
    }
    list.printAllElements();
}
;

var array = [10, -3, 0, -3, -3, -5, 2, -1, -3, 0];
var list = new LinkedList();
console.log(array);
solution(array);
