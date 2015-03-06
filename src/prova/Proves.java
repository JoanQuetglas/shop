package prova;


import utilitats.Estat;
import utilitats.TipusPagaments;
import classe.Client;
import classe.Gestor;

public class Proves {

	public static void main(String[] args) {
		Gestor m = new Gestor();
		m.inicialitzacio();
		m.crearComanda("48971680T", "M090T", "hola");
		System.out.println(m.tornarComandesClient("48971680T"));
	
	}

}
