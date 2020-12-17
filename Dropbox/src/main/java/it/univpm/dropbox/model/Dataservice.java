package it.univpm.dropbox.model;

import java.io.IOException;
import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.dropbox.util.Ordinamento;
import it.univpm.dropbox.util.RicercaFile;

/**
 * QUESTA CLASSE GESTISCE LE FUNZIONI DELL'APPLICAZIONE
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */
@Service
public class Dataservice {

	private Vector<Info> DataBase = new Vector<>();
	private Metadata[] metadata;
	private AccessoDropbox connect = new AccessoDropbox();
	private Ordinamento ordina = new Ordinamento();
	private RicercaFile file = new RicercaFile();
	private Stats stats;

	/**
	 * QUESTO METODO RICHIAMA IL METODO ORDINAMENTO NOME RESTITUENDO UN VECTOR CON
	 * LE RELATIVE INFORMAZIONI DEI FILE ORDINATI PER NOME DELL'ACCOUNT DROPBOX
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */

	public Vector<Info> ordinaN() throws org.apache.tomcat.util.json.ParseException, IOException {
		return ordina.OrdinamentoNome(connect.getData());
	}

	/**
	 * QUESTO METODO RICHIAMA IL METODO ORDINAMENTO TIPOLOGIA RESTITUENDO UN VECTOR
	 * CON LE RELATIVE INFORMAZIONI DEI FILE ORDINATI PER TIPOLOGIA DELL'ACCOUNT
	 * DROPBOX
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */

	public Vector<Info> ordinaT() throws org.apache.tomcat.util.json.ParseException, IOException {
		return ordina.OrdinamentoTipologia(connect.getData());
	}

	/**
	 * QUESTO METODO RICHIAMA IL METODO ORDINAMENTO ULTIMA MODIFICA RESTITUENDO UN
	 * VECTOR CON LE RELATIVE INFORMAZIONI DEI FILE ORDINATI PER ULTIMA MODIFICA
	 * DELL'ACCOUNT DROPBOX
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */
	public Vector<Info> ordinaU() throws org.apache.tomcat.util.json.ParseException, IOException {
		return ordina.OrdinamentoUltimaModifica(connect.getData());
	}

	/**
	 * QUESTO METODO RICHIAMA IL METODO ORDINAMENTO DIMENSIONE RESTITUENDO UN VECTOR
	 * CON LE RELATIVE INFORMAZIONI DEI FILE ORDINATI PER DIMENSIONE DELL'ACCOUNT
	 * DROPBOX
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */
	public Vector<Info> ordinaD() throws org.apache.tomcat.util.json.ParseException, IOException {
		return ordina.OrdinamentoDimensione(connect.getData());
	}

	/**
	 * QUESTO METODO RICHIAMA IL COSTRUTTORE DELLA CLASSE STATS RESTITUENDO LE
	 * STATISTICHE DEI FILE PRESENTI NELL'ACCOUNT DROPBOX
	 * 
	 * @return Stats
	 */
	public Stats createStat() {
		this.stats = new Stats(DataBase, file.ricerca(DataBase));
		return stats;
	}

	/**
	 * QUESTO METODO RICHIAMA IL METODO GETDATA RESTITUENDO UN VECTOR DI INFO DI
	 * TUTTI I FILE FILTRATI PER NOME PRESNETI NELL'ACCOUNT DROPBOX
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */
	public Vector<Info> Display_Data() throws org.apache.tomcat.util.json.ParseException, IOException {
		return connect.getData();
	}

	/**
	 * COSTRUTTORE
	 * 
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */
	public Dataservice() throws org.apache.tomcat.util.json.ParseException, IOException {
		DataBase = connect.LetturaFile();
	}

	/**
	 * QUESTO METODO INIZIALIZZA LE INFORMAZIONI GENERALI RELATIVE AI FILE PRESENTI
	 * NELL'ACCOUNT DROPBOX RESTITUENDO TUTTE LE INFORMZAIONI
	 * 
	 * @return Metadata []
	 */
	public Metadata[] Dispaly_Metadata() {

		metadata = new Metadata[4];
		metadata[0] = new Metadata("Nome", "Il nome del file", "String");
		metadata[1] = new Metadata("Tipologia", "La Tipologia del file", "String");
		metadata[2] = new Metadata("Dimensione", "La dimensione del file", "Long");
		metadata[3] = new Metadata("Ultima modifica", "La data dell'ultima modifica del file", "String");

		return metadata;
	}

}
