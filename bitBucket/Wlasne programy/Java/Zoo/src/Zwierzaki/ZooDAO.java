package Zwierzaki;
import java.util.ArrayList;
import java.util.List;

public class ZooDAO {
List<Zwierzaki>Zwierzaki=new ArrayList<Zwierzaki>();

public void dodajZwierzaka(Zwierzaki zwierzaki) {
	Zwierzaki.add(zwierzaki);
	System.out.println("Gratulacje, Zwierzak zostal dodany!");
}
public List<Zwierzaki> getZwierzak(){
	return Zwierzaki;

}
}

