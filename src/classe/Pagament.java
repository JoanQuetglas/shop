package classe;

import utilitats.TipusPagaments;

public class Pagament {
	private TipusPagaments tipus;
	private String ppCompta;
	private int ppContrasenya;
	private String visaPropietari;
	private int visaCodi;
	private int visaNumTargeta;
	private int visaDataExpiracio;

	public TipusPagaments getTipus() {
		return tipus;
	}

	public void setTipus(TipusPagaments tipus) {
		this.tipus = tipus;
	}

	public String getPpCompta() {
		return ppCompta;
	}

	public void setPpCompta(String ppCompta) {
		this.ppCompta = ppCompta;
	}

	public int getPpContrasenya() {
		return ppContrasenya;
	}

	public void setPpContrasenya(int ppContrasenya) {
		this.ppContrasenya = ppContrasenya;
	}

	public String getVisaPropietari() {
		return visaPropietari;
	}

	public void setVisaPropietari(String visaPropietari) {
		this.visaPropietari = visaPropietari;
	}

	public int getVisaCodi() {
		return visaCodi;
	}

	public void setVisaCodi(int visaCodi) {
		this.visaCodi = visaCodi;
	}

	public int getVisaNumTargeta() {
		return visaNumTargeta;
	}

	public void setVisaNumTargeta(int visaNumTargeta) {
		this.visaNumTargeta = visaNumTargeta;
	}

	public int getVisaDataExpiracio() {
		return visaDataExpiracio;
	}

	public void setVisaDataExpiracio(int visaDataExpiracio) {
		this.visaDataExpiracio = visaDataExpiracio;
	}

	/**
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

	/**
	 * @param tipus
	 */
	public Pagament(TipusPagaments tipus) {
		super();
		this.tipus = tipus;
	}

	/**
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
