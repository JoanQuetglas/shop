package classe;

import java.util.ArrayDeque;
import java.util.ArrayList;

import utilitats.Estat;

public class Gestor {
	private ArrayDeque<Comanda> comandesPendents;
	private ArrayDeque<Comanda> comandesAturades;
	private ArrayDeque<Empleat> empleatsLliures;
	private ArrayList<Comanda> comandes;
	private int idComandes;
	private ArrayList<Client> llistaClients;
	private ArrayList<Empleat> llistaEmpleats;
	private ArrayList<Model> cataleg;

	public Gestor() {
		comandesPendents = new ArrayDeque<Comanda>();
		comandesAturades = new ArrayDeque<Comanda>();
		empleatsLliures = new ArrayDeque<Empleat>();
		comandes = new ArrayList<Comanda>();
		llistaClients = new ArrayList<Client>();
		llistaEmpleats = new ArrayList<Empleat>();
		cataleg=new ArrayList<Model>();
		idComandes=0;
		
	}
	
	/**
	 * Comprova que mentres hi hagi comandes i treballadors aquests ultims s'assignin a una comanda. 
	 * @return
	 */

	public boolean assignarTreball() {
		boolean assignacio = false;
		while (!comandesPendents.isEmpty() && !empleatsLliures.isEmpty()) {
			if (comandesAturades.isEmpty()) {
				Empleat empleat=empleatsLliures.remove();
				empleat.setDisponibilitat(false);
				Comanda comanda=comandesPendents.remove();
				comanda.setEstat(Estat.ENPROCES);
				comanda.setEmpleat(empleat);
				comandes.add(comanda);
				assignacio = true;
			} else {
				Empleat empleat=empleatsLliures.remove();
				empleat.setDisponibilitat(false);
				Comanda comanda=comandesAturades.remove();
				comanda.setEstat(Estat.ENPROCES);
				comanda.setEmpleat(empleat);
				comandes.add(comanda);
				assignacio = true;
			}
		}
		return assignacio;
	}

	public boolean canviarEstatComanda(Estat tipus, int id) {
		for (Comanda comanda : comandes) {
			if (comanda.getId() == id) {
				switch (tipus) {
				case PENDENT:
					comanda.setEstat(Estat.PENDENT);
					return true;
				case ENPROCES:
					comanda.setEstat(Estat.ENPROCES);
					return true;
				case ATURADA:
					comanda.setEstat(Estat.ATURADA);
					comanda.getEmpleat().setDisponibilitat(true);
					empleatsLliures.add(comanda.getEmpleat());
					assignarTreball();
					//s'ha d'acabar
					return true;
				case FINALITZADA:
					comanda.setEstat(Estat.FINALITZADA);
					comanda.getEmpleat().setDisponibilitat(true);
					empleatsLliures.add(comanda.getEmpleat());
					assignarTreball();
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
		if (llistaClients.isEmpty()) {
			Client nouClient = new Client(nom, cognoms, dni, contrasenya);
			llistaClients.add(nouClient);
			return true;
		} else {
			for (Client a : llistaClients) {
				if (dni != a.getDni()) {
					Client nouClient = new Client(nom, cognoms, dni,
							contrasenya);
					llistaClients.add(nouClient);
					return true;
				}
			}
		}
		return false;
	}

	public boolean crearComanda(String dni, String nomModel, String contrasenya) {
		for(Client client:llistaClients){
			if(client.getDni().equalsIgnoreCase(dni)){
				for(Model model:cataleg){
					if(model.getNom().equalsIgnoreCase(nomModel)){
						if (contrasenya == client.getContrasenya()) {
							idComandes++;
							Comanda novaComanda = new Comanda(idComandes, client, model);
							comandesPendents.add(novaComanda);
							assignarTreball();
							return true;
						}
					}
				}
				
			}
		}
		return false;
	}

	public boolean crearEmpleat(String nom, String dni) {
		if (llistaEmpleats.isEmpty()) {
			Empleat nouEmpleat = new Empleat(nom, dni);
			llistaEmpleats.add(nouEmpleat);
			empleatsLliures.add(nouEmpleat);
			return true;
		} else {
			for (Empleat a : llistaEmpleats) {
				if (dni != a.getDNI()) {
					Empleat nouEmpleat = new Empleat(nom, dni);
					llistaEmpleats.add(nouEmpleat);
					empleatsLliures.add(nouEmpleat);
					return true;
				}
			}
		}
		return false;
	}

	public boolean crearModel(String llistaPeces, String nom, int preu) {
		if (cataleg.isEmpty()) {
			Model nouModel = new Model(llistaPeces, nom, preu);
			cataleg.add(nouModel);
			return true;
		} else {
			for (Model a : cataleg) {
				if (nom != a.getNom()) {
					Model nouModel = new Model(llistaPeces, nom, preu);
					cataleg.add(nouModel);
					return true;
				}
			}
		}
		return false;
	}

	public boolean modificarComanda() {
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
