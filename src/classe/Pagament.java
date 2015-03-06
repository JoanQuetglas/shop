package classe;

import utilitats.TipusPagaments;

/**
 * 
 * @author Quetglas, Torrens i Morey
 *
 */

public class Pagament {
	private TipusPagaments tipus;
	private String ppCompta;
	private int ppContrasenya;
	private String visaPropietari;
	private int visaCodi;
	private int visaNumTargeta;
	private int visaDataExpiracio;



	/**
	 * @return El tipus
	 */
	public TipusPagaments getTipus() {
		return tipus;
	}

	/**
	 * @param tipus Modifica el tipus
	 */
	public void setTipus(TipusPagaments tipus) {
		this.tipus = tipus;
	}

	/**
	 * @return El ppCompta
	 */
	public String getPpCompta() {
		return ppCompta;
	}

	/**
	 * @param ppCompta Modifica el ppCompta
	 */
	public void setPpCompta(String ppCompta) {
		this.ppCompta = ppCompta;
	}

	/**
	 * @return El ppContrasenya
	 */
	public int getPpContrasenya() {
		return ppContrasenya;
	}

	/**
	 * @param ppContrasenya Modifica ppContrasenya
	 */
	public void setPpContrasenya(int ppContrasenya) {
		this.ppContrasenya = ppContrasenya;
	}

	/**
	 * @return El visaPropietari
	 */
	public String getVisaPropietari() {
		return visaPropietari;
	}

	/**
	 * @param visaPropietari Modifica el visaPropietari
	 */
	public void setVisaPropietari(String visaPropietari) {
		this.visaPropietari = visaPropietari;
	}

	/**
	 * @return EL visaCodi
	 */
	public int getVisaCodi() {
		return visaCodi;
	}

	/**
	 * @param visaCodi Modifica el visaCodi
	 */
	public void setVisaCodi(int visaCodi) {
		this.visaCodi = visaCodi;
	}

	/**
	 * @return El visaNumTargeta
	 */
	public int getVisaNumTargeta() {
		return visaNumTargeta;
	}

	/**
	 * @param visaNumTargeta Modifica el visaNumTargeta
	 */
	public void setVisaNumTargeta(int visaNumTargeta) {
		this.visaNumTargeta = visaNumTargeta;
	}

	/**
	 * @return El visaDataExpiracio
	 */
	public int getVisaDataExpiracio() {
		return visaDataExpiracio;
	}

	/**
	 * @param visaDataExpiracio Modifica el visaDataExpiracio.
	 */
	public void setVisaDataExpiracio(int visaDataExpiracio) {
		this.visaDataExpiracio = visaDataExpiracio;
	}

	/**Crea un pagament visa
	 * @param tipus
	 * @param visaPropietari
	 * @param visaCodi
	 * @param visaNumTargeta
	 * @param visaDataExpiracio
	 */
	public Pagament(TipusPagaments tipus, String visaPropietari, int visaCodi,
			int visaNumTargeta, int visaDataExpiracio) {
		super();
		this.tipus = tipus;
		this.visaPropietari = visaPropietari;
		this.visaCodi = visaCodi;
		this.visaNumTargeta = visaNumTargeta;
		this.visaDataExpiracio = visaDataExpiracio;
	}

	@Override
	public String toString() {
		return "Pagament [tipus=" + tipus + "]";
	}

	/**Crea un transferencia o contrarebols
	 * @param tipus
	 */
	public Pagament(TipusPagaments tipus) {
		super();
		this.tipus = tipus;
	}

	/**Crea un pagament de paypal
	 * @param tipus
	 * @param ppCompta
	 * @param ppContrasenya
	 */
	public Pagament(TipusPagaments tipus, String ppCompta, int ppContrasenya) {
		this.tipus = tipus;
		this.ppCompta = ppCompta;
		this.ppContrasenya = ppContrasenya;
	}

}
