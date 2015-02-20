package classe;

public class Client {
	private String nom;
	private String cognoms;
	private String dni;
	private String adreça;
	private Pagament pagamentPredeterminat;

	public Client(String nom, String cognoms, String dni) {
		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the cognoms
	 */
	public String getCognoms() {
		return cognoms;
	}

	/**
	 * @param cognoms
	 *            the cognoms to set
	 */
	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the adreça
	 */
	public String getAdreça() {
		return adreça;
	}

	/**
	 * @param adreça
	 *            the adreça to set
	 */
	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	/**
	 * @return the pagamentPredeterminat
	 */
	public Pagament getPagamentPredeterminat() {
		return pagamentPredeterminat;
	}

	/**
	 * @param pagamentPredeterminat
	 *            the pagamentPredeterminat to set
	 */
	public void setPagamentPredeterminat(Pagament pagamentPredeterminat) {
		this.pagamentPredeterminat = pagamentPredeterminat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", cognoms=" + cognoms + ", dni=" + dni
				+ ", adreça=" + adreça + ", pagamentPredeterminat="
				+ pagamentPredeterminat + "]";
	}

	public void realitzaComanda() {
		Comanda comandaNova = new Comanda();
	}

}
