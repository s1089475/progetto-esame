package it.univpm.dropbox.controller;

import java.io.IOException;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.dropbox.exception.NoFile;
import it.univpm.dropbox.exception.NoFiltro;
import it.univpm.dropbox.filters.FiltroNome;
import it.univpm.dropbox.filters.FiltroTipologia;
import it.univpm.dropbox.model.Dataservice;
import it.univpm.dropbox.model.Info;
import it.univpm.dropbox.model.Metadata;
import it.univpm.dropbox.model.Stats;

/**
 * QUESTA CLASSE GESTISCE LE CHIAMATE DI GET E POST DEL WEB SERVER
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 */

@RestController
public class Controller {

	@Autowired
	private Dataservice dataservice;

	/**
	 * QUETSO METODO RISPONDE A GET /MetaData RESTITUENDO TUTTE LE INFORMAZIONI
	 * 
	 * @return Metadata[]
	 */

	@GetMapping("/MetaData")
	public Metadata[] getMetadata() {
		return dataservice.Dispaly_Metadata();
	}

	/**
	 * QUESTO METODO RISPONDE A GET /Data RESTITUENDO UN VECTOR CON LE RELATIVE
	 * INFORMAZIONI DI TUTTI I FILE PRESENTI NELL'ACCOUNT DROPBOX
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 * @throws NoFile
	 */

	@GetMapping("/Data")
	public Vector<Info> file() throws org.apache.tomcat.util.json.ParseException, IOException, NoFile {
		if (dataservice.Display_Data().size() != 0) {
			return dataservice.Display_Data();
		} else
			throw new NoFile("Non sono presenti file.");
	}

	/**
	 * QUESTO METODO RISPONDE A GET /Ordina/Nome RESTITUENDO UN VECTOR CON LE
	 * RELATIVE INFORMAZIONI DI TUTTI I FILE ORDINATI PER NOME PRESENTI NELL'ACCOUNT
	 * DROPBOX
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */

	@GetMapping("/Ordina/Nome")
	public Vector<Info> ordinaNome() throws org.apache.tomcat.util.json.ParseException, IOException {
		return dataservice.ordinaN();
	}

	/**
	 * QUESTO METODO RISPONDE A GET /Ordina/Tipologia RESTITUENDO UN VECTOR CON LE
	 * RELATIVE INFORMAZIONI DI TUTTI I FILE ORDINATI PER TIPOLOGIA PRESENTI
	 * NELL'ACCOUNT DROPBOX
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */

	@GetMapping("/Ordina/Tipologia")
	public Vector<Info> ordinaTipologia() throws org.apache.tomcat.util.json.ParseException, IOException {
		return dataservice.ordinaT();
	}

	/**
	 * QUESTO METODO RISPONDE A GET /Ordina/UltimaModifica RESTITUENDO UN VECTOR CON
	 * LE RELATIVE INFORMAZIONI DI TUTTI I FILE ORDINATI PER ULTIMA MODIFICA
	 * PRESENTI NELL'ACCOUNT DROPBOX
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */

	@GetMapping("/Ordina/UltimaModifica")
	public Vector<Info> ordinaUltimaModifica() throws org.apache.tomcat.util.json.ParseException, IOException {
		return dataservice.ordinaU();
	}

	/**
	 * QUESTO METODO RISPONDE A GET /Ordina/Dimesione RESTITUENDO UN VECTOR CON LE
	 * RELATIVE INFORMAZIONI DI TUTTI I FILE ORDINATI PER DIMENSIONE PRESENTI
	 * NELL'ACCOUNT DROPBOX
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */

	@GetMapping("/Ordina/Dimensione")
	public Vector<Info> ordinaDimensione() throws org.apache.tomcat.util.json.ParseException, IOException {
		return dataservice.ordinaD();
	}

	/**
	 * QUESTO METODO RISPONDE A GET /Stats RESTITUENDO LE STATISTICHE DEI FILE
	 * PRESENTI NELL'ACCOUNT DROPBOX
	 * 
	 * @return Stats
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 * @throws NoFile
	 */

	@GetMapping("/Stats")
	public Stats getStat() throws org.apache.tomcat.util.json.ParseException, IOException, NoFile {
		if (dataservice.Display_Data().size() != 0) {
			return dataservice.createStat();
		} else
			throw new NoFile("Non sono presenti file.");
	}

	/**
	 * QUESTO METODO RISPONDE A POST /Filtro/Nome RESTITUENDO UN VECTOR DI INFO DI
	 * TUTTI I FILE FILTRATI PER NOME PRESNETI NELL'ACCOUNT DROPBOX
	 * 
	 * @param body
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 * @throws NoFiltro
	 */

	@PostMapping("/Filtro/Nome")
	public Vector<Info> getFiltNome(@RequestBody String body)
			throws org.apache.tomcat.util.json.ParseException, IOException, NoFiltro {
		if (body == null) {
			throw new NoFiltro("Errore sintassi.");
		}
		FiltroNome n = new FiltroNome(body);
		return n.ricercaN(dataservice.Display_Data());
	}

	/**
	 * QUESTO METODO RISPONDE A POST /Filtro/Tipologia RESTITUENDO UN VECTOR DI INFO
	 * DI TUTTI I FILE FILTRATI PER TIPOLOGIA PRESNETI NELL'ACCOUNT DROPBOX
	 * 
	 * @param body
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 * @throws NoFiltro
	 */

	@PostMapping("/Filtro/Tipologia")
	public Vector<Info> getFiltTipologia(@RequestBody String body)
			throws org.apache.tomcat.util.json.ParseException, IOException, NoFiltro {
		if (body == null) {
			throw new NoFiltro("Errore sintassi.");
		}
		FiltroTipologia t = new FiltroTipologia(body);
		return t.ricercaT(dataservice.Display_Data());
	}
}
