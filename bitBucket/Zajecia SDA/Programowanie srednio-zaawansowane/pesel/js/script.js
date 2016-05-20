$('input').change(function() {
    
    var tab = $(this).val().split(''),
        a = parseInt(tab[0]),
        b = parseInt(tab[1]),
        c = parseInt(tab[2]),
        d = parseInt(tab[3]),
        e = parseInt(tab[4]),
        f = parseInt(tab[5]),
        g = parseInt(tab[6]),
        h = parseInt(tab[7]),
        i = parseInt(tab[8]),
        j = parseInt(tab[9]),
        cn = 1*a + 3*b + 7*c + 9*d + 1*e + 3*f + 7*g + 9*h + 1*i + 3*j,
        result = 0,
        mod = cn % 10,
        controlNum;
    
    if( mod == 0) {
        controlNum = 0;
    } else {
        controlNum = 10 - mod;
    }
    
    console.log(parseInt(tab[10])?"Pesel poprawny.":"Pesel błędny");
    
});