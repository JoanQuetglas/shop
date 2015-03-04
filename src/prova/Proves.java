package prova;


import utilitats.TipusPagaments;
import classe.Gestor;

public class Proves {

	public static void main(String[] args) {
		Gestor m = new Gestor();
		m.inicialitzacio();
		m.afegirPagament("48971680T", TipusPagaments.PAYPAL, "HDJSHD", 12345);
		System.out.println(m.getLlistaClients());
		
		
		 
		
	}

}
