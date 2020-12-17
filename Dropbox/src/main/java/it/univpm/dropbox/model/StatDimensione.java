package it.univpm.dropbox.model;

import java.util.Vector;

import it.univpm.dropbox.util.Dimensione;

/**
 * QUESTA CLASSE FORNISCE LE STATISTICHE RELATIVE ALLA DIMENSIONE DEI FILE
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */

public class StatDimensione {
	private Long max;
	private Long min;
	private Long media;

	/**
	 * COSTRUTTORE CHE INIZIALIZZA LE VARIABILE RICHIAMANDO I METODI DELLA CLASSE
	 * Dimensione
	 * 
	 * @param v
	 */

	public StatDimensione(Vector<Info> v) {
		this.max = Dimensione.massimo(v);
		this.min = Dimensione.minimo(v);
		this.media = Dimensione.media(v);
	}

	public Long getMax() {
		return max;
	}

	public void setMax(Long max) {
		this.max = max;
	}

	public Long getMin() {
		return min;
	}

	public void setMin(Long min) {
		this.min = min;
	}

	public Long getMedia() {
		return media;
	}

	public void setMedia(Long media) {
		this.media = media;
	}

}
