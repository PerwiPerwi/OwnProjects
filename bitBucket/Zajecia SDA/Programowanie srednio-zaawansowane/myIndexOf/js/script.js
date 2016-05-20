(function ($) {

    Array.prototype.myIndexOf = function (value) {

        for (var i = 0; this.length; i++) {

            if (this[i] === value) {

                return i;

            }
        }

        return -1;

    };

    Array.prototype.myIndexOf2 = function (value) {

        var minimumIndex = 0,
            maximumIndex = this.length - 1,
            currentIndex;

        while (minimumIndex <= maximumIndex) {

            currentIndex = Math.floor((maximumIndex + minimumIndex) / 2);

            if (this[currentIndex] === value) {

                return currentIndex;

            }

            if (this[currentIndex] < value) {

                minimumIndex = currentIndex + 1;

            } else {

                maximumIndex = currentIndex - 1;

            }
        }

        return -1;
    }

    var myArray = [3,4,5,6,7,8,9,10];

    console.log(myArray.myIndexOf2(5));

})(jQuery)