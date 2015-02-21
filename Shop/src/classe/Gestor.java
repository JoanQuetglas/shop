package classe;

import java.util.ArrayList;

import utilitats.Coa;

public class Gestor {
	private Coa<Comanda> comandesPendents;
	private Coa<Comanda> comandesAturades;
	private ArrayList<Comanda> comandes;
	private ArrayList<Client> llistaClients;

	public Gestor() {
		Coa<Comanda> comandesPendents= new Coa<Comanda>();
		Coa<Comanda> comandesAturades= new Coa<Comanda>();
		ArrayList<Comanda> comandes= new ArrayList<Comanda>();
		ArrayList<Client> llistaClients=new ArrayList<Client>();
	}
	
	/**
	 *Crea un nou client si el dni inserit no coincideix amb cap dni dels clients introduits
	 * @param nom
	 * @param cognoms
	 * @param dni
	 * @param contrasenya
	 * @return
	 */

	public boolean crearClient(String nom, String cognoms, String dni,
			String contrasenya) {
		Client nouClient = new Client(nom, cognoms, dni, contrasenya);
		llistaClients.add(nouClient);
		
		return true;
	}

	public boolean crearComanda(Client client, Model model,
			String contrasenya) {
		if (contrasenya == client.getContrasenya()) {
			Comanda novaComanda = new Comanda(client, model);
			return true;
		}
		return false;
	}
	
	public boolean crearModel(){
		return true;
	}
	
	public boolean crearEmpleat(){
		return true;
	}
	
	
}
