package utilitats;

import java.util.Comparator;

import classe.Model;

public class OrdreModelPreu implements Comparator<Model> {

	@Override
	public int compare(Model o1, Model o2) {
		return o1.getPreu() - o2.getPreu();
	}

}
