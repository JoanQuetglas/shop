package classe;

public class Empleat {
	/**
	 * Nom de l'empleat
	 */
	private String nom;
	/**
	 * DNI de l'empleat
	 */
	private String dni;
	/**
	 * Estat que varia segons la disponibilitat.
	 */
	private boolean disponibilitat;

	/**
	 * Torna el nom de l'empleat.
	 * @return Nom de l'empleat.
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Estableix el nom de l'empleat
	 * @param nom
	 */

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 *Torna la disponibilitat de l'empleat
	 * @return disponibilitat
	 */

	public boolean isDisponibilitat() {
		return disponibilitat;
	}
	/**
	 * Estableix disponibilitat del treballador
	 * @param disponibilitat
	 */

	public void setDisponibilitat(boolean disponibilitat) {
		this.disponibilitat = disponibilitat;
	}
	
	/**
	 * Torna el DNI de l'empleat
	 * @return
	 */

	public String getDNI() {
		return dni;
	}
	
	/**
	 * Estableix el DNI de l'empleat
	 * @param dni
	 */

	public void setDNI(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Retorna una cadena dels atributs de l'mpleat
	 */

	@Override
	public String toString() {
		return "Empleat [nom=" + nom + ", DNI=" + dni + ", disponibilitat="
				+ disponibilitat + "]";
	}
	
	/**
	 * Crea un empleat buit i amb la disponibilitat vertadera.
	 * @param nom
	 * @param dni
	 */

	public Empleat(String nom, String dni) {
		this.nom = nom;
		this.dni = dni;
		this.disponibilitat = true;
	}

}
