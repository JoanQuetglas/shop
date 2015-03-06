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
	 * Adre�a del client
	 */
	private String adre�a;
	
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
	 * Obtenir nom del client
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modificar nom del client
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Obtenir cognoms del client
	 * @return the cognoms
	 */
	public String getCognoms() {
		return cognoms;
	}

	/**
	 * Modificar cognoms del client
	 * @param cognoms
	 */
	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	/**
	 * Obtenir dni del client
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Modificar dni del client
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Obtenir adre�a del client
	 * @return the adre�a
	 */
	public String getAdre�a() {
		return adre�a;
	}

	/**
	 * Modificar adre�a del client
	 * @param adre�a
	 */
	public void setAdre�a(String adre�a) {
		this.adre�a = adre�a;
	}

	/**
	 * Obtenir pagament Predeterminat del client
	 * @return the pagamentPredeterminat
	 */
	public Pagament getPagamentPredeterminat() {
		return pagamentPredeterminat;
	}

	/**
	 * Modificar pagament Predeterminat del client
	 * @param pagamentPredeterminat
	 */
	public void setPagamentPredeterminat(Pagament pagamentPredeterminat) {
		this.pagamentPredeterminat = pagamentPredeterminat;
	}

	/**
	 * Obtenir contrasenya del client
	 * @return the contrasenya
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**
	 * Modificar contrasenya del client
	 * @param contrasenya
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	/**
	 * Retorna un client [nom, cognoms, dni, adre�a, pagament predeterminat]
	 */
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", cognoms=" + cognoms + ", dni=" + dni
				+ ", adre�a=" + adre�a + ", pagamentPredeterminat="
				+ pagamentPredeterminat + "]";
	}
	
	


	
	
	
	

}
