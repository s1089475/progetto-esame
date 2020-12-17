package it.univpm.dropbox.util;

import java.util.Vector;

import it.univpm.dropbox.model.Info;

/**
 * QUESTA CLASSE GESTISCE LE OPERAZIONI PER IL CALCOLO DELLE STATISTICHE
 * RELATIVE ALLA DIMENSIONE DEI DILE
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */

public class Dimensione {
	/**
	 * QUESTO METODO RESTITUISCE IL VALORE MINIMO DELLA DIMENSIONE TRA I FILE
	 * PRESENTI
	 * 
	 * @param b
	 * @return Long
	 */
	public static Long minimo(Vector<Info> b) {
		Vector<Info> v = new Vector<>();
		for (int j = 0; j < b.size(); j++) {
			if (b.elementAt(j).getTipologia().equals("file")) {
				Info info = new Info(b.elementAt(j).getNome(), b.elementAt(j).getTipologia(),
						b.elementAt(j).getDimensione(), b.elementAt(j).getUltimaModifica(),
						b.elementAt(j).getPercorso());
				v.add(info);
			}
		}
		Long min = v.elementAt(0).getDimensione();
		for (int i = 0; i < v.size(); i++) {
			if (v.elementAt(i).getDimensione() < min) {
				min = v.elementAt(i).getDimensione();
			}
		}
		return min;
	}

	/**
	 * QUESTO METODO RESTITUISCE IL VALORE MASSIMO DELLA DIMENSIONE TRA I FILE
	 * PRESENTI
	 * 
	 * @param b
	 * @return Long
	 */

	public static Long massimo(Vector<Info> b) {
		Vector<Info> v = new Vector<>();
		for (int j = 0; j < b.size(); j++) {
			if (b.elementAt(j).getTipologia().equals("file")) {
				Info info = new Info(b.elementAt(j).getNome(), b.elementAt(j).getTipologia(),
						b.elementAt(j).getDimensione(), b.elementAt(j).getUltimaModifica(),
						b.elementAt(j).getPercorso());
				v.add(info);
			}
		}
		Long max = v.elementAt(0).getDimensione();
		for (int i = 0; i < v.size(); i++) {
			if (v.elementAt(i).getDimensione() > max) {
				max = v.elementAt(i).getDimensione();
			}
		}
		return max;
	}

	/**
	 * QUESTO METODO RESTITUISCE LA MEDIA DELLE DIMENSIONI DEI FILE PRESENTI
	 * 
	 * @param b
	 * @return Long
	 */

	public static Long media(Vector<Info> b) {
		Vector<Info> v = new Vector<>();
		for (int j = 0; j < b.size(); j++) {
			if (b.elementAt(j).getTipologia().equals("file")) {
				Info info = new Info(b.elementAt(j).getNome(), b.elementAt(j).getTipologia(),
						b.elementAt(j).getDimensione(), b.elementAt(j).getUltimaModifica(),
						b.elementAt(j).getPercorso());
				v.add(info);
			}
		}
		Long media = (long) 0;
		for (int i = 0; i < v.size(); i++) {
			media += v.elementAt(i).getDimensione();
		}
		media = media / v.size();
		return media;
	}
}
