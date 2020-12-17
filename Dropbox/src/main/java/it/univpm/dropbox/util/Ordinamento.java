package it.univpm.dropbox.util;

import java.util.Vector;

import it.univpm.dropbox.model.Info;

/**
 * QUESTA CLASSE GESTISCE LE OPERAZIONI DI ORDINAMENTO DEI FILE PRESENTI
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */

public class Ordinamento {

	/**
	 * QUESTO METODO ORDINA PER NOME UN VECTOR CON LE RELATIVE INFORMAZIONI DI TUTTI
	 * I FILE PRESENTI NELL'ACCOUNT DROPBOX RESTITUENDO IL MEDESIMO VECTOR ORDINATO
	 * 
	 * @param v
	 * @return Vector<Info>
	 */

	public Vector<Info> OrdinamentoNome(Vector<Info> v) {
		if (v.size() != 0) {
			String appN, appT, appU, appP;
			Long appD;
			boolean scambio;
			scambio = true;
			while (scambio) {
				scambio = false;
				for (int i = 0; i < (v.size() - 1); i++) {
					String d = v.elementAt(i + 1).getNome();
					if (v.elementAt(i).getNome().compareTo(d) > 0) {
						for (int i1 = 0; i1 < (v.size() - 1); i1++) {
							String N = v.elementAt(i1 + 1).getNome();
							String T = v.elementAt(i1 + 1).getTipologia();
							Long D = v.elementAt(i1 + 1).getDimensione();
							String U = v.elementAt(i1 + 1).getUltimaModifica();
							String P = v.elementAt(i1 + 1).getPercorso();
							if (v.elementAt(i1).getPercorso().compareTo(P) > 0) {
								appN = v.elementAt(i1).getNome();
								v.elementAt(i1 + 1).setNome(appN);
								v.elementAt(i1).setNome(N);
								appT = v.elementAt(i1).getTipologia();
								v.elementAt(i1 + 1).setTipologia(appT);
								v.elementAt(i1).setTipologia(T);
								appD = v.elementAt(i1).getDimensione();
								v.elementAt(i1 + 1).setDimensione(appD);
								v.elementAt(i1).setDimensione(D);
								appU = v.elementAt(i1).getUltimaModifica();
								v.elementAt(i1 + 1).setUltimaModifica(appU);
								v.elementAt(i1).setUltimaModifica(U);
								appP = v.elementAt(i1).getPercorso();
								v.elementAt(i1 + 1).setPercorso(appP);
								v.elementAt(i1).setPercorso(P);
								scambio = true;
							}
						}

					}
				}
			}
		}
		return v;
	}

	/**
	 * QUESTO METODO ORDINA PER TIPOLOGIA UN VECTOR CON LE RELATIVE INFORMAZIONI DI
	 * TUTTI I FILE PRESENTI NELL'ACCOUNT DROPBOX RESTITUENDO IL MEDESIMO VECTOR
	 * ORDINATO
	 * 
	 * @param v
	 * @return Vector<Info>
	 */

	public Vector<Info> OrdinamentoTipologia(Vector<Info> v) {
		if (v.size() != 0) {
			String appN, appT, appU, appP;
			Long appD;
			boolean scambio;
			scambio = true;
			while (scambio) {
				scambio = false;
				for (int i1 = 0; i1 < (v.size() - 1); i1++) {
					String N = v.elementAt(i1 + 1).getNome();
					String T = v.elementAt(i1 + 1).getTipologia();
					Long D = v.elementAt(i1 + 1).getDimensione();
					String U = v.elementAt(i1 + 1).getUltimaModifica();
					String P = v.elementAt(i1 + 1).getPercorso();
					if (v.elementAt(i1).getTipologia().compareTo(T) > 0) {
						appN = v.elementAt(i1).getNome();
						v.elementAt(i1 + 1).setNome(appN);
						v.elementAt(i1).setNome(N);
						appT = v.elementAt(i1).getTipologia();
						v.elementAt(i1 + 1).setTipologia(appT);
						v.elementAt(i1).setTipologia(T);
						appD = v.elementAt(i1).getDimensione();
						v.elementAt(i1 + 1).setDimensione(appD);
						v.elementAt(i1).setDimensione(D);
						appU = v.elementAt(i1).getUltimaModifica();
						v.elementAt(i1 + 1).setUltimaModifica(appU);
						v.elementAt(i1).setUltimaModifica(U);
						appP = v.elementAt(i1).getPercorso();
						v.elementAt(i1 + 1).setPercorso(appP);
						v.elementAt(i1).setPercorso(P);
						scambio = true;
					}
				}
			}
		}
		return v;
	}

	/**
	 * QUESTO METODO ORDINA PER DIMENSIONE UN VECTOR CON LE RELATIVE INFORMAZIONI DI
	 * TUTTI I FILE PRESENTI NELL'ACCOUNT DROPBOX RESTITUENDO IL MEDESIMO VECTOR
	 * ORDINATO
	 * 
	 * @param v
	 * @return Vector<Info>
	 */

	public Vector<Info> OrdinamentoDimensione(Vector<Info> v) {
		if (v.size() != 0) {
			String appN, appT, appU, appP;
			Long appD;
			boolean scambio;
			scambio = true;
			while (scambio) {
				scambio = false;
				for (int i1 = 0; i1 < (v.size() - 1); i1++) {
					String N = v.elementAt(i1 + 1).getNome();
					String T = v.elementAt(i1 + 1).getTipologia();
					Long D = v.elementAt(i1 + 1).getDimensione();
					String U = v.elementAt(i1 + 1).getUltimaModifica();
					String P = v.elementAt(i1 + 1).getPercorso();
					if (v.elementAt(i1).getDimensione() < D) {
						appN = v.elementAt(i1).getNome();
						v.elementAt(i1 + 1).setNome(appN);
						v.elementAt(i1).setNome(N);
						appT = v.elementAt(i1).getTipologia();
						v.elementAt(i1 + 1).setTipologia(appT);
						v.elementAt(i1).setTipologia(T);
						appD = v.elementAt(i1).getDimensione();
						v.elementAt(i1 + 1).setDimensione(appD);
						v.elementAt(i1).setDimensione(D);
						appU = v.elementAt(i1).getUltimaModifica();
						v.elementAt(i1 + 1).setUltimaModifica(appU);
						v.elementAt(i1).setUltimaModifica(U);
						appP = v.elementAt(i1).getPercorso();
						v.elementAt(i1 + 1).setPercorso(appP);
						v.elementAt(i1).setPercorso(P);
						scambio = true;
					}
				}
			}
		}
		return v;
	}

	/**
	 * QUESTO METODO ORDINA PER ULTIMA MODIFICA UN VECTOR CON LE RELATIVE
	 * INFORMAZIONI DI TUTTI I FILE PRESENTI NELL'ACCOUNT DROPBOX RESTITUENDO IL
	 * MEDESIMO VECTOR ORDINATO
	 * 
	 * @param v
	 * @return Vector<Info>
	 */

	public Vector<Info> OrdinamentoUltimaModifica(Vector<Info> v) {
		if (v.size() != 0) {
			String appN, appT, appU, appP;
			Long appD;
			boolean scambio;
			scambio = true;
			while (scambio) {
				scambio = false;
				for (int i1 = 0; i1 < (v.size() - 1); i1++) {
					String N = v.elementAt(i1 + 1).getNome();
					String T = v.elementAt(i1 + 1).getTipologia();
					Long D = v.elementAt(i1 + 1).getDimensione();
					String U = v.elementAt(i1 + 1).getUltimaModifica();
					String P = v.elementAt(i1 + 1).getPercorso();
					if (v.elementAt(i1).getUltimaModifica().compareTo(U) < 0) {
						appN = v.elementAt(i1).getNome();
						v.elementAt(i1 + 1).setNome(appN);
						v.elementAt(i1).setNome(N);
						appT = v.elementAt(i1).getTipologia();
						v.elementAt(i1 + 1).setTipologia(appT);
						v.elementAt(i1).setTipologia(T);
						appD = v.elementAt(i1).getDimensione();
						v.elementAt(i1 + 1).setDimensione(appD);
						v.elementAt(i1).setDimensione(D);
						appU = v.elementAt(i1).getUltimaModifica();
						v.elementAt(i1 + 1).setUltimaModifica(appU);
						v.elementAt(i1).setUltimaModifica(U);
						appP = v.elementAt(i1).getPercorso();
						v.elementAt(i1 + 1).setPercorso(appP);
						v.elementAt(i1).setPercorso(P);
						scambio = true;
					}
				}
			}
		}
		return v;
	}

}







