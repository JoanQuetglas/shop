package prova;

import classe.Gestor;

public class Proves {

	public static void main(String[] args) {
		Gestor m=new Gestor();
		m.crearClient("Francesc", "Torrens", "45167980V", "1452");
		System.out.println(m.getLlistaClients());
	}

}
