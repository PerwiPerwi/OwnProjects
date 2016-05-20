/*Napisz funkcję primaAprilis(yearFrom, yearTo), która w zadanym
 przedziale zwróci tablicę lat, w których 1 kwietnia przypada na wtorek.
 
 */

(function ($) {

    function primaAprilis(yearFrom, yearTo) {
        var yearArray = [];
        for (var year = yearFrom; year <= yearTo; year++) {

            var pa = new Date(year, 3, 1);
            if (pa.getDay() === 2) {
                yearArray.push(year);
            }
        }
        return yearArray;
    }
    console.log(primaAprilis(1900, 2016));

})(jQuery);