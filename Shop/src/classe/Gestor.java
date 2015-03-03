package classe;

import java.util.ArrayDeque;
import java.util.ArrayList;

import utilitats.Estat;

public class Gestor {
	private ArrayDeque<Comanda> comandesPendents;
	private ArrayDeque<Comanda> comandesAturades;
	private ArrayDeque<Empleat> empleatsLliures;
	private ArrayList<Comanda> comandes;
	private ArrayList<Client> llistaClients;
	private ArrayList<Empleat> llistaEmpleats;
	private ArrayList<Model> cataleg;

	public Gestor() {
		ArrayDeque<Comanda> comandesPendents = new ArrayDeque<Comanda>();
		ArrayDeque<Comanda> comandesAturades = new ArrayDeque<Comanda>();
		ArrayDeque<Empleat> empleatsLliures = new ArrayDeque<Empleat>();
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		ArrayList<Client> llistaClients = new ArrayList<Client>();
		ArrayList<Empleat> llistaEmpleats = new ArrayList<Empleat>();
	}

	/**
	 * Crea un nou client si el dni inserit no coincideix amb cap dni dels
	 * clients introduits anteriorment
	 * 
	 * @param nom
	 * @param cognoms
	 * @param dni
	 * @param contrasenya
	 * @return
	 */

	public boolean crearClient(String nom, String cognoms, String dni,
			String contrasenya) {
		Client nouClient = new Client(nom, cognoms, dni, contrasenya);
		for (Client a : llistaClients) {
			if (nouClient.getDni() != a.getDni()) {
				llistaClients.add(nouClient);
				return true;
			}
		}
		return false;
	}

	public boolean crearComanda(Client client, Model model, String contrasenya) {
		if (contrasenya == client.getContrasenya()) {
			Comanda novaComanda = new Comanda(client, model);
			comandesPendents.add(novaComanda);
			return true;
		}
		return false;
	}

	public boolean crearModel(String llistaPeces, String nom, int preu) {
		Model nouModel=new Model(llistaPeces,nom,preu);
		for (Model a : cataleg) {
			if (nouModel.getNom() != a.getNom()) {
				cataleg.add(nouModel);
				return true;
			}
		}
		return false;
	}

	public boolean crearEmpleat() {
		return true;
	}

	public boolean canviarEstatComanda(int tipus,int id){
		for(Comanda d: comandes){
			if(d.getId()==id){
				switch (tipus){
				case 1 : 
					d.setEstat(Estat.PENDENT);
					return true;
				case 2 :
					d.setEstat(Estat.ENPROCES);
					return true;
				case 3 : 
					d.setEstat(Estat.ATURADA);
					return true;	
				case 4 :
					d.setEstat(Estat.FINALITZADA);
					return true;
				default :
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
}
}
