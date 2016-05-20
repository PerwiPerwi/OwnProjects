(function ($) {

    Array.prototype.quickSort = function () {

        if (this.length < 2) {
            return this;
        }

        var pivot = this[0],
            left = [],
            right = [];

        for (var i = 1; i < this.length; i++) {

            if (this[i].localeCompare(pivot) === -1) {

                left.push(this[i]);

            } else {

                right.push(this[i]);

            }
        }
        return left.quickSort().concat(pivot, right.quickSort());

    };


    console.log(['s', 'a', 'e', 'b', 'ą'].quickSort());
})(jQuery);