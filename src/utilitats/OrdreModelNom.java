package utilitats;

import java.util.Comparator;
import classe.Model;

public class OrdreModelNom implements Comparator<Model> {

	@Override
	public int compare(Model o1, Model o2) {
		if(o1.getNom().compareTo(o2.getNom())==0){
			return 0;
		}else if(o1.getNom().compareTo(o2.getNom())==1){
			return 1;
		}else{
			return -1;
		}
	}

}
