(function ($) {



    function getLongestWord(sentence) {

        var wordsArray = sentence.split(' '),
            longestWord = wordsArray[0];

        for (var i = 1; i < wordsArray.length; i++) {
            if (longestWord.length < wordsArray[i].length) {
                longestWord = wordsArray[i];
            }
        }

        return longestWord;

    }

    console.log(getLongestWord('To jest przykładowy tekst'));

})(jQuery);