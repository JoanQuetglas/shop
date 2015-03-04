package prova;



import classe.Gestor;

public class Proves {

	public static void main(String[] args) {
		Gestor m=new Gestor();
		m.crearClient("Josep", "Morey", "48971680T", "hola");
		m.crearEmpleat("Francesc", "59681391Z");
		m.crearModel("ram", "asus", 700);
		m.crearModel("placa base", "ultra", 3250);
		System.out.println(m.getCataleg());
		System.out.println(m.getEmpleatsLliures());
		System.out.println(m.getLlistaClients());
		m.crearComanda("48971680T", "asus", "hola");
		m.crearComanda("48971680T", "asus", "hola");
		System.out.println(m.getComandes());
		System.out.println(m.getComandesPendents());
	}

}
