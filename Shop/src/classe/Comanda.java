package classe;

import utilitats.Estat;

public class Comanda {
	private int id;
	private String adre�aEnvio;
	private Client client;
	private Model model;
	private Pagament tipusPagament;
	private Estat estat;
	private Empleat empleat;

	public Comanda(Client client, Model model) {
		this.client = client;
		this.model = model;
	}

	/**
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

	@Override
	public String toString() {
		return "Comanda [adre�aEnvio=" + adre�aEnvio + ", client=" + client
				+ ", model=" + model + ", tipusPagament=" + tipusPagament + "]";
	}

	/**
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
