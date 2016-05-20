package Dziedziczenie;

public class Czlowiek extends Zwierze implements Alkoholik{

	public void idz(){
		System.out.println("Czlowiek idz");
	}

	@Override
	public void pij() {
		System.out.println("Czlowiek Pij");
		
	}
}
