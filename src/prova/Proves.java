package prova;


import utilitats.Estat;
import utilitats.TipusPagaments;
import classe.Gestor;

public class Proves {

	public static void main(String[] args) {
		Gestor m = new Gestor();
		m.inicialitzacio();
		m.afegirPagament("48971680T", TipusPagaments.PAYPAL, "HDJSHD", 12345);
		m.afegirAdreça("48971680T", "Carrer Lluna 14");
		System.out.println(m.getLlistaClients());
		m.crearComanda("48971680T", "M095Z", "hola");
		System.out.println(m.getComandes());
		m.canviarEstatComanda(Estat.ATURADA, 1);
		System.out.println(m.getComandes());
		System.out.println(m.getLlistaEmpleats());
		System.out.println(m.getComandesPendents());
		
		
	}

}
