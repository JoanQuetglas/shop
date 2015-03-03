package classe;

import utilitats.TipusPagaments;

public class Pagament {
	private TipusPagaments tipus;
	private String ppCompta;
	private int ppContrasenya;
	private String visaPropietari;
	private int visaCodi;
	private int visaNumTargeta
	private int visaDataExpiracio;
	
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
