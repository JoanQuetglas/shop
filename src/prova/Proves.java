package prova;


import utilitats.Estat;
import utilitats.TipusPagaments;
import classe.Client;
import classe.Gestor;

public class Proves {

	public static void main(String[] args) {
		Gestor m = new Gestor();
		m.inicialitzacio();
		m.afegirPagament("48971680T", TipusPagaments.PAYPAL, "HDJSHD", 12345);
		m.afegirAdreça("48971680T", "Carrer Lluna 14");
		System.out.println(m.getLlistaClients());
		System.out.println(m.getLlistaEmpleats());
		m.crearComanda("48971680T", "M095Z", "hola");
		m.crearComanda("48971680T", "M090S", "hola");
		m.crearComanda("46808932Z", "M095Z", "4563");
		System.out.println(m.getComandes());
		m.canviarEstatComanda(Estat.ATURADA, 1);
		System.out.println(m.getComandes());
		m.canviarEstatComanda(Estat.FINALITZADA, 1);
		System.out.println(m.getComandes());
		System.out.println(m.getEmpleatsLliures());
		
		
		System.out.println("prova metodes activitat:");
		
	
		
	}

}
