package Dziedziczenie;

public class main {

	public static void main(String[] args) {
		
		Czlowiek czlowiek = new Czlowiek();
		czlowiek.idz();
		
		Pies pies = new Pies();
		pies.idz();
		
		Zwierze zwierze2 = new Czlowiek();
		
		zwierze2.idz();
		
		Alkoholik alko = new Czlowiek();
		
		czlowiek.pij();
	}

}
