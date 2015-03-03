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

	public boolean assignarTreball() {
		return true;
	}

	public boolean canviarEstatComanda(Estat tipus, int id) {
		for (Comanda d : comandes) {
			if (d.getId() == id) {
				switch (tipus) {
				case PENDENT:
					d.setEstat(Estat.PENDENT);
					return true;
				case ENPROCES:
					d.setEstat(Estat.ENPROCES);
					return true;
				case ATURADA:
					d.setEstat(Estat.ATURADA);
					return true;
				case FINALITZADA:
					d.setEstat(Estat.FINALITZADA);
					return true;
				default:
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * Inserirem un boolea per saber l'estat de l'empleat
	 * 
	 * @param disp
	 * @param dni
	 * @return
	 */
	public boolean canviarEstatEmpleat(boolean disp, String dni) {
		for (Empleat d : llistaEmpleats) {
			if (d.getDNI() == dni) {
				if (disp == true) {
					d.setDisponibilitat(true);
					return true;
				}
				if (disp == false) {
					d.setDisponibilitat(false);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
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
			novaComanda.setEstat(Estat.PENDENT);
			return true;
		}
		return false;
	}

	public boolean crearEmpleat(String nom, String dni) {
		Empleat nouEmpleat = new Empleat(nom, dni);
		for (Empleat a : llistaEmpleats) {
			if (nouEmpleat.getDNI() != a.getDNI()) {
				llistaEmpleats.add(nouEmpleat);
				return true;
			}
		}
		return false;
	}

	public boolean crearModel(String llistaPeces, String nom, int preu) {
		Model nouModel = new Model(llistaPeces, nom, preu);
		for (Model a : cataleg) {
			if (nouModel.getNom() != a.getNom()) {
				cataleg.add(nouModel);
				return true;
			}
		}
		return false;
	}
	
	public boolean modificarComanda(){
		return true;
	}

	/**
	 * @return the comandesPendents
	 */
	public ArrayDeque<Comanda> getComandesPendents() {
		return comandesPendents;
	}

	/**
	 * @return the comandesAturades
	 */
	public ArrayDeque<Comanda> getComandesAturades() {
		return comandesAturades;
	}

	/**
	 * @return the empleatsLliures
	 */
	public ArrayDeque<Empleat> getEmpleatsLliures() {
		return empleatsLliures;
	}

	/**
	 * @return the comandes
	 */
	public ArrayList<Comanda> getComandes() {
		return comandes;
	}

	/**
	 * @return the llistaClients
	 */
	public ArrayList<Client> getLlistaClients() {
		return llistaClients;
	}

	/**
	 * @return the llistaEmpleats
	 */
	public ArrayList<Empleat> getLlistaEmpleats() {
		return llistaEmpleats;
	}

	/**
	 * @return the cataleg
	 */
	public ArrayList<Model> getCataleg() {
		return cataleg;
	}
	
	

}
