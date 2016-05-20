package sprawdzPlec;

public class SprawdzPlec {
	
	public static void main(String[] args){
	
	String [] imiona = { "Jan", "Andrzej", "Kasia", "Joanna", "Natalia", "Karol", "Ewa"};
	int counter = 0;
	
	
	for( int i = 0 ; i < imiona.length; i++){
		if(imiona[i].substring(imiona[i].length()-1, imiona[i].length()).equals("a")){
			counter++;
		}
	}
		System.out.println("Liczba kobiet w tablicy wynosi: " + counter);

	}
}