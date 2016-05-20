package zajecia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stringmain {
	
	public static void main(String [] args){
		List<String> lista = new ArrayList<>();
		
		lista.add("qw");
		lista.add("ae");
		lista.add("ddssd");
		lista.add("xxxx");
		lista.add("zzz");
		lista.add("dss");
		lista.add("d4ghh");
		lista.add("kk");
		lista.add("lasd");
		lista.add("bfe");
		lista.add("f43f4");
		
		Collections.sort(lista);
		Collections.reverse(lista);
		
		for (String element : lista) {
			System.out.println(element);	
		}
	}
}
