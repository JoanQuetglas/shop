package utilitats;

/**
 * 
 */

/**
 * És un tipus de contenidor que representa una seqüència on
 * "el primer que entra es el darrer que surt" (FIFO - "First In First Out").
 * Quan es crea no hi ha cap element.
 * 
 * @author Josep
 *
 */
public class Coa<T> {

	/**
	 * Primer element de la coa.
	 */
	private Element<T> primer;

	/**
	 * Darrer element de la coa.
	 */
	private Element<T> darrer;
	
	/**
	 * Conta el elements que es van afegint a la coa i els que s'eliminen.
	 */
	private int contador;

	/**
	 * Indica si la coa està buida o no.
	 * 
	 * @return True si està buida i fals si hi ha elements.
	 */

	public boolean empty() {
		if (primer == null || darrer == null) {
			return true;
		}
		return false;
	}

	/**
	 * Afegeix un element al final de la coa.
	 * 
	 * @param info
	 *            L'element de qualsevol tipus que volem afegir a la coa.
	 */

	public void add(T info) {
		if (primer == null) {
			Element<T> nou = new Element<T>(info, null);
			primer = nou;
			darrer = nou;
			contador++;
		} else {
			Element<T> seguent = new Element<T>(info, null);
			darrer.setElementSeguent(seguent);
			darrer = seguent;
			contador++;
		}
	}

	/**
	 * Borra el primer element i posa el segon element a la primera posició.
	 * 
	 * @return El primer element de la coa.
	 */

	public T remove() {
		T x = primer.getInfo();
		primer.setInfo(null);
		primer = primer.getElementSeguent();
		contador--;
		return x;
	}

	/**
	 * Mostra el primer element de lla coa.
	 * 
	 * @return El primer element. Si la coa està buida torna null.
	 */

	public T element() {
		if (primer != null) {
			return primer.getInfo();
		} else {
			return null;
		}
	}

	/**
	 * Buida la coa.
	 */

	public void clear() {
		primer = null;
		darrer = null;
		contador = 0;
	}

	/**
	 * Indica quants elements hi ha a la coa.
	 * 
	 * @return El nombre d'elements que es trobem a la coa.
	 */

	public int size() {
		return contador;
	}

	/**
	 * Crea un coa buida.
	 */

	public Coa() {
		primer = null;
		darrer = null;
		contador = 0;
	}
}
