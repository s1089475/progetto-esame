package it.univpm.dropbox.model;

/**
 * QUESTA CLASSE CONTIENE LE INFORMAZIONI GENRALI RELATIVE AI FILE
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */

public class Metadata {

	private String nome;
	private String descrizione;
	private String tipo;

	/**
	 * COSTRUTTORE
	 * 
	 * @param nome
	 * @param descrizione
	 * @param tipo
	 */

	public Metadata(String nome, String descrizione, String tipo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
