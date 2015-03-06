package prova;


import utilitats.Estat;
import utilitats.TipusPagaments;
import classe.Client;
import classe.Gestor;

public class Proves {

	public static void main(String[] args) {
		
		Gestor m = new Gestor();
		m.inicialitzacio();
		m.crearComanda("46808932Z", "M090S", "4563");
		m.crearComanda("48971680T", "M095Z", "hola");
		m.menu();
		
		
	}

}
