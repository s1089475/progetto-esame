package it.univpm.dropbox.filters;

import java.util.Vector;

import it.univpm.dropbox.model.Info;

/**
 * QUESTA CLASSE GESTISCE IL FILTRO PER NOME
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 *
 */
public class FiltroNome {
	private String tipo;

	public FiltroNome(String tipo) {
		this.tipo = tipo;
	}

	public Vector<Info> ricercaN(Vector<Info> v) {
		Vector<Info> d = new Vector<>();
		for (int i = 0; i < v.size(); i++) {
			if (v.elementAt(i).getNome().contains(tipo)) {
				Info info = new Info(v.elementAt(i).getNome(), v.elementAt(i).getTipologia(),
						v.elementAt(i).getDimensione(), v.elementAt(i).getUltimaModifica(),
						v.elementAt(i).getPercorso());
				d.add(info);
			}
		}
		return d;
	}
}
