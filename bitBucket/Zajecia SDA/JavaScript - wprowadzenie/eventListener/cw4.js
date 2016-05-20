

var element = document.getElementById("klik");
liczba_klikniec=0;
element.addEventListener('click',function(e){
    liczba_klikniec++;
    element.innerHTML=("KLIKASZ!! "+liczba_klikniec);
    
        if((liczba_klikniec=>10)&&(liczba_klikniec<20)){
        element.innerHTML=("WItam "+liczba_klikniec);
        element.style.background="red";
        element.style.color="white";
    }
        else if((liczba_klikniec=>20)&&(liczba_klikniec<30)){
            element.innerHTML=("Po co klikasz? "+liczba_klikniec);
            element.style.background="blue";
            element.style.color="yellow";
        }
    }
    
   
    );
