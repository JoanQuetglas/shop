package classe;

import utilitats.Estat;

public class Comanda {

	/**
	 * identificador de la comanda
	 */
	private int id;

	/**
	 * adreça Envio de la comanda
	 */
	private String adreçaEnvio;

	/**
	 * client que fa la comanda
	 */
	private Client client;

	/**
	 * model de la comanda
	 */
	private Model model;

	/**
	 * tipus de Pagament per la comanda [PAYPAL, VISA, TRANSFERENCIA,
	 * CONTRAREMBOLS]
	 */
	private Pagament tipusPagament;

	/**
	 * estat de la comanda [ENPROCES, FINALITZADA, ATURADA, PENDENT]
	 */
	private Estat estat;

	/**
	 * empleat que s'encarrega de la comanda
	 */
	private Empleat empleat;

	/**
	 * Crea una comanda nova.
	 * 
	 * @param id
	 * @param client
	 * @param model
	 * @param estar
	 * @param tipusPagament
	 * @param adreçaEnvio
	 */
	public Comanda(int id, Client client, Model model) {
		this.client = client;
		this.model = model;
		this.id = id;
		estat = Estat.PENDENT;
		tipusPagament = client.getPagamentPredeterminat();
		adreçaEnvio = client.getAdreça();
	}

	/**
	 * Obtenir adreçaEnvio de la comanda
	 * 
	 * @return the adreçaEnvio
	 */
	public String getAdreçaEnvio() {
		return adreçaEnvio;
	}

	/**
	 * Modificar adreçaEnvio de la comanda
	 * 
	 * @param adreçaEnvio
	 */
	public void setAdreçaEnvio(String adreçaEnvio) {
		this.adreçaEnvio = adreçaEnvio;
	}

	/**
	 * Obtenir client de la comanda
	 * 
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Modificar client de la comanda
	 * 
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Obtenir model de la comanda
	 * 
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Modificar model de la comanda
	 * 
	 * @param model
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Obtenir tipusPagament de la comanda
	 * 
	 * @return the tipusPagament
	 */
	public Pagament getTipusPagament() {
		return tipusPagament;
	}

	/**
	 * Modificar tipusPagament de la comanda
	 * 
	 * @param tipusPagament
	 */
	public void setTipusPagament(Pagament tipusPagament) {
		this.tipusPagament = tipusPagament;
	}

	/**
	 * Obtenir estat de la comanda
	 * 
	 * @return the estat
	 */
	public Estat getEstat() {
		return estat;
	}

	/**
	 * Modificar estat de la comanda
	 * 
	 * @param estat
	 */
	public void setEstat(Estat estat) {
		this.estat = estat;
	}

	/**
	 * Obtenir empleat de la comanda
	 * 
	 * @return the empleat
	 */
	public Empleat getEmpleat() {
		return empleat;
	}

	/**
	 * Modificar empleat de la comanda
	 * 
	 * @param empleat
	 */
	public void setEmpleat(Empleat empleat) {
		this.empleat = empleat;
	}

	/**
	 * Obtenir id de la comanda
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modificar id de la comanda
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comanda [id=" + id + ", adreçaEnvio=" + adreçaEnvio
				+ ", client=" + client + ", model=" + model
				+ ", tipusPagament=" + tipusPagament + ", estat=" + estat
				+ ", empleat=" + empleat + "]";
	}

}
