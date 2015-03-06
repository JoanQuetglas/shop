package classe;

public class Empleat {
	private String nom;
	private String dni;
	private boolean disponibilitat;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isDisponibilitat() {
		return disponibilitat;
	}

	public void setDisponibilitat(boolean disponibilitat) {
		this.disponibilitat = disponibilitat;
	}

	public String getDNI() {
		return dni;
	}

	public void setDNI(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Empleat [nom=" + nom + ", DNI=" + dni + ", disponibilitat="
				+ disponibilitat + "]";
	}

	public Empleat(String nom, String dni) {
		this.nom = nom;
		this.dni = dni;
		this.disponibilitat = true;
	}

}
