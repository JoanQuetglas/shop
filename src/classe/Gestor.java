package classe;

import java.util.ArrayDeque;
import java.util.ArrayList;

import menu.LlegirTeclat;
import utilitats.Estat;
import utilitats.TipusPagaments;

public class Gestor {
	
	/**
	 * Conte totes les comandes pendent
	 */
	private ArrayDeque<Comanda> comandesPendents;
	
	/**
	 * Conte totes les comandes aturades
	 */
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
		cataleg = new ArrayList<Model>();
		idComandes = 0;

	}

	public void inicialitzacio() {
		crearClient("Josep", "Morey", "48971680T", "hola");
		crearClient("Joan", "Quetglas", "46808932Z", "4563");

		crearEmpleat("Francesc", "59681391Z");
		crearEmpleat("Toni", "47839258S");
		crearEmpleat("Joan", "44335566F");
		crearEmpleat("Dani", "43523423J");
		crearModel(
				"Processador Intel core I7,Placa base Asus P5K, Targeta grafica Geforece GTX489",
				"M095Z", 1700);
		crearModel(
				"Processador Intel core I5,Placa base Rocket ZS, Targeta grafica Geforece G400",
				"M090T", 700);
		crearModel(
				"Processador Intel core I3,Placa base Intel TR, Targeta grafica Geforece G700",
				"M090S", 760);
		assignarTreball();
		
	}
 
	/**
	 * Comprova que mentres hi hagi comandes i treballadors aquests ultims
	 * s'assignin a una comanda.
	 * 
	 * @return
	 */

	
	public boolean assignarTreball(){
		boolean assignacio=false;
		if(!comandesPendents.isEmpty() || !comandesAturades.isEmpty()){
		while(!empleatsLliures.isEmpty() && !comandesPendents.isEmpty() || !comandesAturades.isEmpty()){
			if(!comandesAturades.isEmpty()){
				Empleat e = empleatsLliures.removeFirst();
				Comanda c = comandesAturades.removeFirst();
				e.setDisponibilitat(false);
				c.setEstat(Estat.ENPROCES);
				c.setEmpleat(e);
				assignacio = true;
			}else if(!comandesPendents.isEmpty()){
				Empleat e = empleatsLliures.removeFirst();
				Comanda c = comandesPendents.removeFirst();
				e.setDisponibilitat(false);
				c.setEstat(Estat.ENPROCES);
				c.setEmpleat(e);
				assignacio = true;
			}
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
					comandesAturades.add(comanda);
					comanda.getEmpleat().setDisponibilitat(true);
					empleatsLliures.add(comanda.getEmpleat()); //acabat
					comanda.setEmpleat(null);
					assignarTreball();
					return true;
				case FINALITZADA:
					comanda.setEstat(Estat.FINALITZADA);
					comanda.getEmpleat().setDisponibilitat(true);
					empleatsLliures.add(comanda.getEmpleat());
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
		for (Client client : llistaClients) {
			if (client.getDni().equalsIgnoreCase(dni)) {
				for (Model model : cataleg) {
					if (model.getNom().equalsIgnoreCase(nomModel)) {
						if (contrasenya == client.getContrasenya()) {
							idComandes++;
							Comanda novaComanda = new Comanda(idComandes,
									client, model);
							
							comandes.add(novaComanda);
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
			//assignarTreball();
			return true;
		} else {
			for (Empleat a : llistaEmpleats) {
				if (dni != a.getDNI()) {
					Empleat nouEmpleat = new Empleat(nom, dni);
					llistaEmpleats.add(nouEmpleat);
					empleatsLliures.add(nouEmpleat);
					assignarTreball();
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

	/**
	 * Afegir pagament de VISA
	 * 
	 * @param tipus
	 * @param visaPropietari
	 * @param visaCodi
	 * @param visaNumTargeta
	 * @param visaDataExpiracio
	 */
	public void afegirPagament(String dniClient, TipusPagaments tipus,
			String visaPropietari, int visaCodi, int visaNumTargeta,
			int visaDataExpiracio) {
		for (Client client : llistaClients) {
			if (dniClient == client.getDni()) {
				Pagament nouPagament = new Pagament(tipus, visaPropietari,
						visaCodi, visaNumTargeta, visaDataExpiracio);
				client.setPagamentPredeterminat(nouPagament);
			}
		}
	}

	/**
	 * Afegir pagament COMPTE BANCARI
	 * 
	 * @param tipus
	 */
	public String afegirPagament(String dniClient, TipusPagaments tipus) {
		if (tipus == TipusPagaments.TRANSFERENCIA) {
			for (Client client : llistaClients) {
				if (dniClient == client.getDni()) {
					Pagament nouPagament = new Pagament(tipus);
					client.setPagamentPredeterminat(nouPagament);
					return "699991004";
				}
			}

		} else if (tipus == TipusPagaments.CONTRAREMBOLS) {
			for (Client client : llistaClients) {
				if (dniClient == client.getDni()) {
					Pagament nouPagament = new Pagament(tipus);
					client.setPagamentPredeterminat(nouPagament);
					
				}
			}
		}
		return null;
	}

	/**
	 * Afegir pagament PAYPAL
	 * 
	 * @param tipus
	 * @param ppCompta
	 * @param ppContrasenya
	 */
	public void afegirPagament(String dniClient, TipusPagaments tipus,
			String ppCompta, int ppContrasenya) {
		for (Client client : llistaClients) {
			if (dniClient == client.getDni()) {
				Pagament nouPagament = new Pagament(tipus, ppCompta, ppContrasenya);
				client.setPagamentPredeterminat(nouPagament);
			}
		}

	}

	public boolean mostrarComandesSenseAssignar() { //malament
		if (!comandesPendents.isEmpty() && !comandesAturades.isEmpty()) {
			getComandesPendents();
			getComandesAturades();
			return true;
		} else if (comandesPendents.isEmpty() && !comandesAturades.isEmpty()) {
			getComandesAturades();
			return true;
		} else if (!comandesPendents.isEmpty() && comandesAturades.isEmpty()) {
			getComandesPendents();
			return true;
		}
		return false;
	}

	public boolean mostraComandesAturadesPendentsDePeces() { //malament
		if (!comandesAturades.isEmpty()) {
			getComandesAturades();
			return true;
		} else {
			return false;
		}
	}
	public boolean afegirAdreça(String dniClient, String adreça){
		for (Client client : llistaClients) {
			if (dniClient == client.getDni()) {
				client.setAdreça(adreça);
				return true;
			}
	}
		return false;
	}

	public Comanda tornarComandesClient(String nom , String contrasenya){ //acabar
		
		for (Client client : llistaClients) {
			if (nom == client.getNom() && contrasenya == client.getContrasenya()){
				for(Comanda com : comandes ){
					if(client == com.getClient()){
						
					}
				}
				
				
			}
				
			}
		return null;
	}
	
	
	public void menu(){
		Gestor p = new Gestor();
		System.out.println("1- Veure les comandes sense asignar");
		System.out.println("2- Comandes pendents de peces");
		System.out.println("3- ");
		System.out.println("4-");
		
		System.out.println("----------------------------------------------");
		int value =LlegirTeclat.llegirSencer("Introdueix una opció: ");

		if (value == 1) {
			System.out
					.println("-------------------------------------------------------");
			System.out
					.println("**********************************************************");
			System.out
					.println("*** Has seleccionat 'Veure les comandes sense asignar' ***");
			System.out
					.println("**********************************************************");
			System.out.println(p.mostrarComandesSenseAssignar());
			

		} else if (value == 2) {
			System.out
					.println("-------------------------------------------------------");
			System.out
					.println("********************************************************");
			System.out
					.println("******Has seleccionat 'Comandes pendents de peces'******");
			System.out
					.println("********************************************************");
			System.out.println(p.mostraComandesAturadesPendentsDePeces());

		} else if (value == 3) {
			System.out
					.println("-------------------------------------------------------");
			System.out
					.println("********************************************************");
			System.out
					.println("***Has seleccionat opcio 3.***");
			System.out
					.println("********************************************************");
			System.out.println(p.tornarComandesClient(null, null));


		} else if (value == 4) {
			System.out.println("sortint...");

		} else {
			System.out.println("No es un nombre valid!");
		}
	}
}
