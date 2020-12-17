package it.univpm.dropbox.util;

import java.util.Vector;

/**
 * QUESTA CLASSE GESTISCE LE OPERAZIONI PER IL CALCOLO DELLE STATISTICHE
 * RELATIVE ALLA QUANTITA' DI TIPOLOGIE DEI DILE
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */

public class Quantità {

	/**
	 * QUESTO METODO RESTITUISCE LA MEDIA DEL NUMERO DEI FILE PRESENTI PER TIPOLOGIE
	 * DIVERSE
	 * 
	 * @param d
	 * @return double
	 */
	public static double media(Vector<String> d) {
		double tmp, num = 0, den = 0, media;
		Vector<String> c = new Vector<>();
		while (d.size() != 0) {
			int j;
			tmp = 0;
			for (j = 0; j < d.size(); j++) {
				if (d.elementAt(0).equals(d.elementAt(j))) {
					tmp++;
					c.add(d.elementAt(j));
				}
			}
			d.removeAll(c);
			num += tmp;
			den++;
		}
		d.addAll(c);
		media = num / den;
		return media;
	}

	/**
	 * QUESTO METODO RESTITUISCE IL NUMERO DI FILE PRESENTI PER TIPOLOGIE DIVERSE
	 * 
	 * @param d
	 * @return String
	 */

	public static String tipo(Vector<String> d) {
		Vector<String> c = new Vector<>();
		String s = "";
		int tmp;
		while (d.size() != 0) {
			tmp = 0;
			for (int j = 0; j < d.size(); j++) {
				if (d.elementAt(0).equals(d.elementAt(j))) {
					tmp++;
					c.add(d.elementAt(j));
				}
			}
			s += "Sono presenti " + tmp + " elementi di tipo " + d.elementAt(0) + ", ";
			d.removeAll(c);
		}
		return s;
	}
}
