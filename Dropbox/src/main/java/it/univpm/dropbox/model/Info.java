package it.univpm.dropbox.model;

/**
 * QUESTA CLASSE CONTIENE LE INFORMAZIONI NECESSARIE RALATIVE AI FILE
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */
public class Info {

	private String nome;
	private String tipologia;
	private Long dimensione;
	private String ultimaModifica;
	private String percorso;

	/**
	 * COSTRUTTORE
	 * 
	 * @param nome
	 * @param tipologia
	 * @param dimensione
	 * @param ultimaModifica
	 * @param percorso
	 */

	public Info(String nome, String tipologia, Long dimensione, String ultimaModifica, String percorso) {
		this.nome = nome;
		this.tipologia = tipologia;
		this.dimensione = dimensione;
		this.ultimaModifica = ultimaModifica;
		this.percorso = percorso;
	}

	/**
	 * COSTRUTTORE VUOTO
	 */
	public Info() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Long getDimensione() {
		return dimensione;
	}

	public void setDimensione(Long dimensione) {
		this.dimensione = dimensione;
	}

	public String getUltimaModifica() {
		return ultimaModifica;
	}

	public void setUltimaModifica(String ultimaModifica) {
		this.ultimaModifica = ultimaModifica;
	}

	public String getPercorso() {
		return percorso;
	}

	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}

}
