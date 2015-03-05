package classe;

public class Client {
	/**
	 * Nom del client
	 */
	private String nom;
	
	/**
	 * Cognoms del client
	 */
	private String cognoms;
	
	/**
	 * DNI del client
	 */
	private String dni;
	
	/**
	 * Contrasenya del client
	 */
	private String contrasenya;
	
	/**
	 * Adreça del client
	 */
	private String adreça;
	
	/**
	 * Pagament predeterminat del client
	 */
	private Pagament pagamentPredeterminat;
	
	/**
	 * Crea un client nou
	 * @param nom
	 * @param cognoms
	 * @param dni
	 * @param contrasenya
	 */
	public Client(String nom, String cognoms, String dni, String contrasenya) {
		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
		this.contrasenya = contrasenya;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modificar
	 * @param nom
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

	/**
	 * @return the contrasenya
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**
	 * @param contrasenya
	 *            the contrasenya to set
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", cognoms=" + cognoms + ", dni=" + dni
				+ ", adreça=" + adreça + ", pagamentPredeterminat="
				+ pagamentPredeterminat + "]";
	}
	
	


	
	
	
	

}
