package classe;

import utilitats.TipusPagaments;

public class Client {
	private String nom;
	private String cognoms;
	private String dni;
	private String contrasenya;
	private String adreça;
	private Pagament pagamentPredeterminat;

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
	
	
	/**
	 * Afegir pagament de VISA
	 * @param tipus
	 * @param visaPropietari
	 * @param visaCodi
	 * @param visaNumTargeta
	 * @param visaDataExpiracio
	 */
	public void afegirPagament(TipusPagaments tipus, String visaPropietari, int visaCodi,
			int visaNumTargeta, int visaDataExpiracio) {
		Pagament nouPagament = new Pagament(tipus, visaPropietari, visaCodi,
				visaNumTargeta, visaDataExpiracio);
	}
	
	/**
	 * Afegir pagament COMPTE BANCARI
	 * @param tipus
	 */
	public void afegirPagament(TipusPagaments tipus) {
		Pagament nouPagament = new Pagament(tipus);
	}
	/**
	 * Afegir pagament PAYPAL
	 * @param tipus
	 * @param ppCompta
	 * @param ppContrasenya
	 */
	public void afegirPagament(TipusPagaments tipus, String ppCompta, int ppContrasenya) {
		Pagament nouPagament = new Pagament(tipus, ppCompta, ppContrasenya);
	}

	
	
	
	

}
