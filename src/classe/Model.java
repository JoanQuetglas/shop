package classe;

/**
 * Recull la informació de l'ordinador ofertat.
 * @author Quetglas, Torrens i Morey
 *
 */

public class Model {
	private String llistaPeces;
	private String nom;
	private int preu;
	
	/**
	 * Crea un model amb el parametres indicats
	 * @param llistaPeces
	 * @param nom
	 * @param preu
	 */

	public Model(String llistaPeces, String nom, int preu) {
		this.llistaPeces = llistaPeces;
		this.nom = nom;
		this.preu = preu;
	}

	/**
	 * @return El llistaPeces
	 */
	public String getLlistaPeces() {
		return llistaPeces;
	}

	/**
	 * @param llistaPeces
	 *            Modifica el llistaPeces
	 */
	public void setLlistaPeces(String llistaPeces) {
		this.llistaPeces = llistaPeces;
	}

	/**
	 * @return El nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            Modifica el nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return El preu
	 */
	public int getPreu() {
		return preu;
	}

	/**
	 * @param preu
	 *            Modifica el preu
	 */
	public void setPreu(int preu) {
		this.preu = preu;
	}

	@Override
	public String toString() {
		return "Model [llistaPeces=" + llistaPeces + ", nom=" + nom + ", preu="
				+ preu + "]";
	}

}
