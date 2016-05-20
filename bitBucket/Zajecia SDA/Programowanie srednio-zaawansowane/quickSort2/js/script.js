(function ($) {

    function quickSort(array) { // quick sort - sortowanie szybkie

        var pivot = array[0],
            left = [],
            right = [];

        if (array.length < 2) {

            return array;

        }

        for (var i = 1; i < array.length; i++) {

            /*if (array[i] < pivot) {*/
            
            if (array[i].localeCompare(pivot) === -1) {

                left.push(array[i]);

            } else {

                right.push(array[i]);

            }
        }

        return quickSort(left).concat(pivot, quickSort(right));
    }

    /*console.log(quickSort([1, 5, 7, 3, 8, 9, 10, 2, 24]));*/
    console.log(quickSort(['s', 'a', 'e', 'b', 'ą']));

})(jQuery)