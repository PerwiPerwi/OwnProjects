package Dziedziczenie;

public abstract class Ostros {
	
	private double h;
	
	public double objetosc(){
		
		return 1/3. * polePodstawy() * h;
		
	}
	
	abstract double polePodstawy();

}
