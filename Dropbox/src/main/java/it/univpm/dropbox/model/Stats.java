package it.univpm.dropbox.model;

import java.util.Vector;

/**
 * QUESTA CLASSE FORNISCE LE STATISTICHE GENERALI DEI FILE
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */

public class Stats {

	private StatDimensione Statistiche_dimensione;
	private StatQuantità Statistiche_quantità;

	/**
	 * COSTRUTTORE CHE INIZIALIZZA LE VARIABILI RICHIAMANDO LE CLASSI StatDimenione
	 * E StatQuantità
	 * 
	 * @param v
	 * @param b
	 */

	public Stats(Vector<Info> v, Vector<String> b) {
		this.Statistiche_dimensione = new StatDimensione(v);
		this.Statistiche_quantità = new StatQuantità(b);
	}

	public StatDimensione getStatistiche_dimensione() {
		return Statistiche_dimensione;
	}

	public void setStatistiche_dimensione(StatDimensione statistiche_dimensione) {
		Statistiche_dimensione = statistiche_dimensione;
	}

	public StatQuantità getStatistiche_quantità() {
		return Statistiche_quantità;
	}

	public void setStatistiche_quantità(StatQuantità statistiche_quantità) {
		Statistiche_quantità = statistiche_quantità;
	}

}
