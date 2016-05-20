(function ($) {

    var
        lastOperator = false,
        lastOperatorValue,
        firstNumber;

    $('td').click(function () {
        var text = $(this).text();
        var isDigit = !isNaN(text);

        var screen = $('div.screen').text().trim();

        if (isDigit) {
            if (screen === '0') {
                $('div.screen').text(text);
            } else {
                $('div.screen').text(screen + text);
            }

            lastOperator = false;
        } else {

            if (lastOperator) {
                $('div.screen').text('' + firstNumber + text);

            } else {
                if (lastOperatorValue) {
                    var screenArray = screen.split(lastOperatorValue);
                    console.log(screenArray);

                    var result;

                    switch (lastOperatorValue) {
                    case '+':
                        result = parseInt(screenArray[0]) + parseInt(screenArray[1]);
                        break;
                    case '-':
                        result = parseInt(screenArray[0]) - parseInt(screenArray[1]);
                        break;
                    case '*':
                        result = parseInt(screenArray[0]) * parseInt(screenArray[1]);
                        break;
                    case '/':
                        result = parseInt(screenArray[0]) / parseInt(screenArray[1]);
                        break;
                    }
                    $('div.screen').text(result);
                    firstNumber = result;

                    if (text !== '=') {
                        $('div.screen').text('' + result + text);
                    }

                    lastOperator = false;
                    lastOperatorValue = undefined;

                } else {

                    if (text !== '=') {
                        firstNumber = parseInt(screen);
                        $('div.screen').text(screen + text);
                    }

                }

            }
            if (text !== '=') {
                lastOperator = true;
                lastOperatorValue = text;
            }
        }

    });
})(jQuery);