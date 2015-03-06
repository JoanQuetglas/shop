package classe;

import java.util.ArrayDeque;
import java.util.ArrayList;



import java.util.Collections;

import utilitats.Estat;
import utilitats.OrdreModelNom;
import utilitats.OrdreModelPreu;
import utilitats.TipusPagaments;

public class Gestor {
	
	/**
	 * Una coa de comandes pendents
	 */
	private ArrayDeque<Comanda> comandesPendents;
	
	/**
	 * Una coa de comandes aturades
	 */
	private ArrayDeque<Comanda> comandesAturades;
	/**
	 * Una coa d'empleats lliures
	 */
	private ArrayDeque<Empleat> empleatsLliures;
	/**
	 * Un arrayList del registre de totes les comandes que han passat per la nostra tenda
	 */
	private ArrayList<Comanda> comandes;
	/**
	 * La id de comanda
	 */
	private int idComandes;
	/**
	 * Una arrayList on es guarden tots els clients que s'ha registrat dins la nostra tenda
	 */
	private ArrayList<Client> llistaClients;
	/**
	 * Tots els empleat que fan feina dins la nostra tenda
	 */
	private ArrayList<Empleat> llistaEmpleats;
	/**
	 * Un arrayList on es guarden tots els models que tenim 
	 */
	private ArrayList<Model> cataleg;

	/**
	 * Constructor de gestor
	 */
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
	/**
	 * Aqui s'inicialitzen les dades de la nostra tenda on hi ha empleats i models
	 */
	public void inicialitzacio() {
		crearClient("Josep", "Morey", "48971680T", "hola");
		crearClient("Joan", "Quetglas", "46808932Z", "4563");
		crearClient("Toni","Marti","56824389M","7896");
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
		
	}
 
	/**
	 * Comprova que mentres hi hagi comandes pendents o aturades i treballadors lliures s'assignin a una comanda pendent o aturada.
	 * @return un boolea depent si s'ha realitzat la creació ( true ) o si no ( false )
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
	
	/**
	 * Canvia l'estat de la comanda.
	 * @param tipus és una opcio de una enumeració anomenada Estat
	 * @param id és la calu identificadora de la comanda, per diferenciar-la dels altres
	 * @return  un boolea depent si s'ha realitzat la creació ( true ) o si no ( false )
	 */
	
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
	 * Inserirem un boolea per canviar l'estat d'un empleat
	 * 
	 * @param disp pot ser true o false depenent com volguem canviar-ho
	 * @param dni l'empleat que s'ha de canviar el seu estat
	 * @return un boolea depent si s'ha realitzat la creació ( true ) o si no ( false )
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
	 * Crea un nou client sempre que el dni inserit no coincideix amb cap dni dels clients introduits anteriorment 
	 * @param nom 	del client
	 * @param cognoms del cient
	 * @param dni és una informacio unica que el diferencia de altres empleats 
	 * @param contrasenya una informacio unica per complementar el dni
	 * @return  un boolea depent si s'ha realitzat la creació ( true ) o si no ( false )
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
	
	/**
	 * Crea les comandes i directament les afegeix dins arraylist de comanda i la coa de comandesPendets
	 * @param dni és el que defineix el client que realitza la comanda
	 * @param nomModel	és el model de dins el cataleg que el client
	 * @param contrasenya	del el client que l'ha realitzada
	 * @return un boolea depent si s'ha realitzat la creació ( true ) o si no ( false )
	 */
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

	/**
	 * Crea els empleats i els afegeix dins l'arraylist de la llista d'empleats i la coa  empleatsLliures
	 * @param nom	és el nom de l'empleat
	 * @param dni	és el dni , una dada unica que el diferencia de altres empleats
	 * @return un boolea depent si s'ha realitzat la creació ( true ) o si no ( false )
	 */
	public boolean crearEmpleat(String nom, String dni) {
		if (llistaEmpleats.isEmpty()) {
			Empleat nouEmpleat = new Empleat(nom, dni);
			llistaEmpleats.add(nouEmpleat);
			empleatsLliures.add(nouEmpleat);
			assignarTreball();
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

	/**
	 * Crea models d'ordinadors mod i els afegeix dins els cataleg
	 * @param llistaPeces és un String on es posen totes les peces que necessita aquest ordinador mod per ser montat
	 * @param nom	és el nom de l'ordinador mod
	 * @param preu	és el que el client haurà de pagar per ell
	 * @return un boolea depent si s'ha realitzat la creació ( true ) o si no ( false )
	 */
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
	 * Per visualitzar totes les comandes les quals es troben en un estat pendent
	 * @return the comandesPendents és la coa que ordena de més antics a més nous en espera
	 */
	public ArrayDeque<Comanda> getComandesPendents() {
		return comandesPendents;
	}

	/**
	 * Per visualitzar totes les comandes les quals es troben en un estat d'aturada
	 * @return the comandesAturades és la coa que ordena de més antics a més nous en espera
	 */
	public ArrayDeque<Comanda> getComandesAturades() {
		return comandesAturades;
	}

	/**
	 * Per visualitzar tots els Empleats que tenen la disponibilitat true ,és a dir, no tenen cap comanda assignada 
	 * @return the empleatsLliures és una coa que ordena els empleats de més temps d'espera (els primers) i els més recents esperant (els darrers)
	 */
	public ArrayDeque<Empleat> getEmpleatsLliures() {
		return empleatsLliures;
	}

	/**
	 * Per visualitzar totes les comandes que han sol·licitat 
	 * @return the comandes és l'arraylist que guarda totes les comandes que s'han creat
	 */
	public ArrayList<Comanda> getComandes() {
		return comandes;
	}

	/**
	 * Per visualitzar tots els client que s'ha registrat
	 * @return the llistaClients és un arraylist que guarda totes els clients registrats
	 */
	public ArrayList<Client> getLlistaClients() {
		return llistaClients;
	}

	/**
	 * Per visualitzar tots els empleats que fan feina a la nostra tenda/taller
	 * @return the llistaEmpleats és un arraylist que guarda tots els nostres empleats
	 */
	public ArrayList<Empleat> getLlistaEmpleats() {
		return llistaEmpleats;
	}

	/**
	 * Per visualitzar tots els models que tenim guardats
	 * @return the cataleg és l'arraylist que guarda els models existents
	 */
	public ArrayList<Model> getCataleg() {
		return cataleg;
	}

	/**
	 * Afegir pagament de VISA
	 * 
	 * @param tipus El tipus de pagament segon la enumeriacio de TipusPagaments
	 * @param visaPropietari	El propietari en String
	 * @param visaCodi	El codi de la vis
	 * @param visaNumTargeta	El numero de targeta de la visa
	 * @param visaDataExpiracio	La data que la visa expira
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
	 * @param dniClient Per corroborar l'existencia d'aquest client
	 * @param tipus El tipus de pagament segon la enumeriacio de TipusPagaments
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
	 * @param tipus El tipus de pagament segon la enumeriacio de TipusPagaments
	 * @param ppCompta	Un String del nom de compta
	 * @param ppContrasenya	Un string per la contrasenya
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

	/**
	 * Mostra totes les comandes que no tenen un empleat que les realitzi
	 * @return Retorna una arrayList o null si no hi ha cap comanda sense assignar
	 */

	public ArrayList<Comanda> mostrarComandesSenseAssignar() {
		ArrayList<Comanda> comandesSenseAsig = new ArrayList<Comanda>();
		if (!comandesPendents.isEmpty() && !comandesAturades.isEmpty()) {
			comandesSenseAsig.addAll(getComandesPendents());
			comandesSenseAsig.addAll(getComandesAturades());
			return comandesSenseAsig;
		} else if (comandesPendents.isEmpty() && !comandesAturades.isEmpty()) {
			comandesSenseAsig.addAll(getComandesAturades());
			return comandesSenseAsig;
		} else if (!comandesPendents.isEmpty() && comandesAturades.isEmpty()) {
			comandesSenseAsig.addAll(getComandesPendents());
			return comandesSenseAsig;
		}
		return null;
	}
	/**
	 * Torna un arraylist que mostra totes les comandes pendents
	 * @return Retorna l'arraylist o null(si no hi ha comandes aturades)
	 */

	public ArrayList<Comanda> mostraComandesAturadesPendentsDePeces() {
		ArrayList<Comanda> comandesAturadesPendents = new ArrayList<Comanda>();
		if (!comandesAturades.isEmpty()) {
			comandesAturadesPendents.addAll(comandesAturades);
			return comandesAturadesPendents;
		} else {
			return null;
		}
	}
	/**
	 * Si un client vol canviar la seva adreça ha de utilitzar aquest mètode on només s'ha d'identificar i ficar la nova adreça
	 * @param dniClient S'utilitza per cercar i corroborar l'existencia del client
	 * @param adreça La nova adreça del client
	 * @return Retorna un boolea true si s'ha pogut canviar l'adreça i false si no
	 */

	public boolean afegirAdreça(String dniClient, String adreça) {
		for (Client client : llistaClients) {
			if (dniClient == client.getDni()) {
				client.setAdreça(adreça);
				return true;
			}
		}
		return false;
	}
	/**
	 * Torna un arraylist que conté totes les comandes que ha sol·licitat
	 * @param dni S'utilitza per cercar i corroborar l'exitencia del client
	 * @return torna L'arraylist de les comandes que ha sol·licitat el client o null si no té cap comanda
	 */

	public ArrayList<Comanda> tornarComandesClient(String dni) {
		ArrayList<Comanda> comandesClient = new ArrayList<Comanda>();
		for (Client client : llistaClients) {
			if (dni == client.getDni()) {
				for (Comanda comanda : comandes) {
					if (client == comanda.getClient()) {
						comandesClient.add(comanda);
					}
				}
				return comandesClient;

			}
		}
		return null;
	}
	/**
	 * Retorna l'empleat que ha realitzat una comanda la qual tenim el seu id
	 * @param id L'utilitzam per trobar la comanda 
	 * @return Retorna l'empleat que ha realitzat la comanda o null si està pendent i no té cap empleat que la realitzi
	 */
	public Empleat tornarEmpleatRealitzaComanda(int id) {
		for (Comanda comanda : comandes) {
			if (id == comanda.getId()) {
				return comanda.getEmpleat();
			}
		}
		return null;
	}
	
	public ArrayList<Model> modelDisponibles(String tipusOrdenacio){
		OrdreModelNom nom=new OrdreModelNom();
		OrdreModelPreu preu=new OrdreModelPreu();
		if(tipusOrdenacio.equalsIgnoreCase("nom")){
			Collections.sort(cataleg, nom);
			return cataleg;
		}else if(tipusOrdenacio.equalsIgnoreCase("preu"))
			Collections.sort(cataleg, preu);
			return cataleg;
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
			System.out.println(p.tornarComandesClient(LlegirTeclat.llegirSencer(prompt)


		} else if (value == 4) {
			System.out.println("sortint...");

		} else {
			System.out.println("No es un nombre valid!");
		}
	}
}
