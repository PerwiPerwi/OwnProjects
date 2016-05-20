(function () {

    String.prototype.halfString = function () {

        return this.substring(0, Math.floor(this.length / 2));

    };

    function protectEmail(mail) {

        var mailParts = mail.split('@');
        return mailParts[0].halfString() + '...@' + mailParts[1];

    }

    console.log(protectEmail('alamakota@wp.pl'));

})()