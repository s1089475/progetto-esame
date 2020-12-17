package it.univpm.dropbox.model;

import java.util.Vector;

import it.univpm.dropbox.util.Quantità;

/**
 * QUESTA CLASSE FORNISCE LE STATISTICHE RELATIVE ALLA QUANTITA' DI TIPOLOGIE
 * DEI FILE
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */

public class StatQuantità {

	private double media;
	private String File_Presenti;

	/**
	 * COSTRUTTORE CHE INIZIALIZZA LE VARIABILI RICHIAMANDO I METODI DELLA CLASSE
	 * Quantità
	 * 
	 * @param b
	 */

	public StatQuantità(Vector<String> b) {
		this.media = Quantità.media(b);
		this.File_Presenti = Quantità.tipo(b);
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public String getFile_Presenti() {
		return File_Presenti;
	}

	public void setFile_Presenti(String File_Presenti) {
		this.File_Presenti = File_Presenti;
	}

}
