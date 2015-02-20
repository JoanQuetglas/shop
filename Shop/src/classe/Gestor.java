package classe;

import java.util.ArrayList;

import utilitats.Coa;

public class Gestor {
	private Coa<Comanda> coaComandes;
	private ArrayList<Client> llistaClients;

	public Gestor() {

	}

	public boolean nouClient(String nom, String cognoms, String dni,
			String contrasenya) {
		Client nouClient = new Client(nom, cognoms, dni, contrasenya);
		llistaClients.add(nouClient);

		return true;
	}

	public boolean realitzaComanda(Client client, Model model,
			String contrasenya) {
		if (contrasenya == client.getContrasenya()) {
			Comanda novaComanda = new Comanda(client, model);

			return true;
		}
		return false;

	}
}
