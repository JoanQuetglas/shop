package classe;

import utilitats.Estat;

public class Comanda {
	
	/**
	 * identificador de la comanda
	 */
	private int id;
	
	/**
	 * adre�a Envio de la comanda
	 */
	private String adre�aEnvio;
	
	/**
	 * client que fa la comanda
	 */
	private Client client;
	
	/**
	 * model de la comanda
	 */
	private Model model;
	
	/**
	 * tipus de Pagament per la comanda [PAYPAL, VISA, TRANSFERENCIA, CONTRAREMBOLS]
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
	 * @param id
	 * @param client
	 * @param model
	 * @param estar
	 * @param tipusPagament
	 * @param adre�aEnvio
	 */
	public Comanda(int id, Client client, Model model) {
		this.client = client;
		this.model = model;
		this.id = id;
		estat = Estat.PENDENT;
		tipusPagament = client.getPagamentPredeterminat();
		adre�aEnvio = client.getAdre�a();
	}

	
	
	
	
	/**
	 * Obtenir adre�aEnvio de la comanda
	 * @return the adre�aEnvio
	 */
	public String getAdre�aEnvio() {
		return adre�aEnvio;
	}

	/**
	 * @param adre�aEnvio
	 *            the adre�aEnvio to set
	 */
	public void setAdre�aEnvio(String adre�aEnvio) {
		this.adre�aEnvio = adre�aEnvio;
	}

	/**
	 * Obtenir client de la comanda
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Obtenir client de la comanda
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Obtenir client de la comanda
	 * @return the tipusPagament
	 */
	public Pagament getTipusPagament() {
		return tipusPagament;
	}

	/**
	 * @param tipusPagament
	 *            the tipusPagament to set
	 */
	public void setTipusPagament(Pagament tipusPagament) {
		this.tipusPagament = tipusPagament;
	}

	

	/**
	 * Obtenir client de la comanda
	 * @return the estat
	 */
	public Estat getEstat() {
		return estat;
	}

	/**
	 * @param estat
	 *            the estat to set
	 */
	public void setEstat(Estat estat) {
		this.estat = estat;
	}

	/**
	 * Obtenir client de la comanda
	 * @return the empleat
	 */
	public Empleat getEmpleat() {
		return empleat;
	}

	/**
	 * @param empleat
	 *            the empleat to set
	 */
	public void setEmpleat(Empleat empleat) {
		this.empleat = empleat;
	}
	
	/**
	 * Obtenir client de la comanda
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
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
		return "Comanda [id=" + id + ", adre�aEnvio=" + adre�aEnvio
				+ ", client=" + client + ", model=" + model
				+ ", tipusPagament=" + tipusPagament + ", estat=" + estat
				+ ", empleat=" + empleat + "]";
	}

}
