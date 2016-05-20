
public class FabrykaFigur {

	public static void main(String[] args) throws Exception {
		
		Kwadrat kwadrat = new Kwadrat(5);
		Prostokat prostokat = new Prostokat(2, 5);
		Trojkat trojkat = new Trojkat(4, 5, 6);	s
		
		
		kwadrat.przedstawSie();
		System.out.println("Obwod kwadratu: " + kwadrat.ObliczObwod());
		System.out.println("Pole kwadratu: " + kwadrat.ObliczPole());
		
		trojkat.przedstawSie();
		System.out.println("Obwod Trójk¹ta " + trojkat.ObliczObwod());
		System.out.println("Pole Trójk¹ta " + trojkat.ObliczPole());
		
		prostokat.przedstawSie();
		System.out.println("Obwod prostokata: " + prostokat.ObliczObwod());
		System.out.println("Pole prostokata: " + prostokat.ObliczPole());

	}

}
