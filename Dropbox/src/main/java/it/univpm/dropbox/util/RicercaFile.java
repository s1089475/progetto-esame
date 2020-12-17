package it.univpm.dropbox.util;

import java.util.Vector;

import it.univpm.dropbox.model.Info;

/**
 * QUESTA CLASSE GESTISCE LE OPERAZIONI DI RICERCA PER TIPOLOGIA DI FILE
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */

public class RicercaFile {

	/**
	 * QUESTO METODO ANALIZZA UN VECTOR CON LE RELATIVE INFORMAZIONI DI TUTTI I FILE
	 * PRESENTI NELL'ACCOUNT DROPBOX COPIANDO LE TIPOLGIE DEI FILE IN UN NUOVO
	 * VECTOR DI STRINGHE
	 * 
	 * @param v
	 * @return Vector<String>
	 */

	public Vector<String> ricerca(Vector<Info> v) {
		Vector<String> d = new Vector<>();
		for (int i = 0; i < v.size(); i++) {
			if (v.elementAt(i).getTipologia().equals("file")) {
				v.elementAt(i).getNome().indexOf(".");
				v.elementAt(i).getNome().substring(v.elementAt(i).getNome().indexOf("."));
				d.add(v.elementAt(i).getNome().substring(v.elementAt(i).getNome().indexOf(".")));
			}
		}
		return d;
	}

	/**
	 * COSTRUTTORE VUOTO
	 */

	public RicercaFile() {

	}

}
