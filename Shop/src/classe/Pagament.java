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

	
	public Pagament(int visaCodi, int visaDataExpiracio , int visaNumTargeta , String visaPropietari, TipusPagaments tipus ) {
		this.visaCodi = visaCodi;
		this.visaDataExpiracio = visaDataExpiracio;
		this.visaNumTargeta = visaNumTargeta;
		this.visaPropietari = visaPropietari;
		this.tipus = tipus;
	}
	
	public Pagament(TipusPagaments tipus){
		this.tipus = tipus;
	}
	
}
