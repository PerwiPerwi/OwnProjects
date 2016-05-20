(function ($) {
    Array.prototype.bubbleSort = function () {
        var swap,
            swapped;

        do {
            
            swapped = false;
            for (var i = 0; i < this.length - 1; i++) {

                if (this[i] > this[i + 1]) {
                    swap = this[i];
                    this[i] = this[i + 1];
                    this[i + 1] = swap;
                    swapped = true;
                    
                }
            }
        }
        while (swapped);
        
        return this;

    };

    var array = [2, 5, 3, 1, 9, 10, 4, 6];
    console.log(array.bubbleSort());
    
})(jQuery);