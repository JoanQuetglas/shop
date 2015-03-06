package classe;

public class Empleat {
	private String nom;
	private String dni;
	private boolean disponibilitat;

	/**
	 * Torna el nom de l'empleat
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Estableix el nom de l'empleat
	 * 
	 * @param nom
	 */

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Torna la disponibilitat de l'empleat
	 * 
	 * @return vertader si esta disponible i si no fals.
	 */
	public boolean isDisponibilitat() {
		return disponibilitat;
	}

	/**
	 * Estableix la disponibilitat de l'empleat.
	 * 
	 * @param disponibilitat
	 */

	public void setDisponibilitat(boolean disponibilitat) {
		this.disponibilitat = disponibilitat;
	}

	/**
	 * Torna el DNI de l'empleat
	 * 
	 * @return DNI de l'empleat
	 */

	public String getDNI() {
		return dni;
	}

	/**
	 * Estableix el DNI de l'empleat
	 * 
	 * @param dni
	 */

	public void setDNI(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Empleat [nom=" + nom + ", DNI=" + dni + ", disponibilitat="
				+ disponibilitat + "]";
	}

	/**
	 * Crea un empleat buit
	 * 
	 * @param nom
	 * @param dni
	 */

	public Empleat(String nom, String dni) {
		this.nom = nom;
		this.dni = dni;
		this.disponibilitat = true;
	}

}
