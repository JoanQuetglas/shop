package prova;


import utilitats.Estat;
import utilitats.TipusPagaments;
import classe.Client;
import classe.Gestor;

public class Proves {

	public static void main(String[] args) {
		Gestor m = new Gestor();
		m.inicialitzacio();
		System.out.println(m.modelDisponibles("preu"));
	}

}
