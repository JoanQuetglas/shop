package classe;

public class Model {
	private String llistaPeces;
	private String nom;
	private int preu;

	public Model(String llistaPeces, String nom, int preu) {
		this.llistaPeces = llistaPeces;
		this.nom = nom;
		this.preu = preu;
	}

	/**
	 * @return the llistaPeces
	 */
	public String getLlistaPeces() {
		return llistaPeces;
	}

	/**
	 * @param llistaPeces
	 *            the llistaPeces to set
	 */
	public void setLlistaPeces(String llistaPeces) {
		this.llistaPeces = llistaPeces;
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
	 * @return the preu
	 */
	public int getPreu() {
		return preu;
	}

	/**
	 * @param preu
	 *            the preu to set
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
