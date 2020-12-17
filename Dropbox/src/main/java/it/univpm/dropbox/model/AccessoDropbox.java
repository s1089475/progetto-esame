package it.univpm.dropbox.model;

import java.io.IOException;
import java.io.*;
import java.net.URL;
import java.util.Vector;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 * QUESTA CLASSE GESTISCE LA CONNESIONE CON L'ACCOUNT DROPBOX TRAMITE L'API
 * 
 * @author Roberto Dimitri
 * @author Andrea Iannotti
 *
 */
public class AccessoDropbox {
	private Vector<Info> data = new Vector<>();

	/**
	 * QUESTO METODO RESTITUISCE UN VECTOR CON LE RELATIVE INFORMAZIONI DEI FILE
	 * DELL'ACCOUNT DROPBOX TRAMITE L'UTILIZZO DELL'API
	 * 
	 * @return Vector<Info>
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */

	public Vector<Info> LetturaFile() throws org.apache.tomcat.util.json.ParseException, IOException {

		String url = "https://api.dropboxapi.com/2/files/list_folder";

		try {
			HttpsURLConnection openConnection = (HttpsURLConnection) new URL(url).openConnection();
			openConnection.setRequestMethod("POST");
			openConnection.setRequestProperty("Authorization",
					"Bearer CCEOj66w56MAAAAAAAAAAYmXt9HxK8gNwOzSoW83e3xuEptO9_JRpnzPaSQOiP1c");
			openConnection.setRequestProperty("Content-Type", "application/json");
			openConnection.setRequestProperty("Accept", "application/json");
			openConnection.setDoOutput(true);
			String jsonBody = "{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
					+ "    \"include_media_info\": false,\r\n" + "    \"include_deleted\": false,\r\n"
					+ "    \"include_has_explicit_shared_members\": false,\r\n"
					+ "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
					+ "}";

			try (OutputStream os = openConnection.getOutputStream()) {
				byte[] input = jsonBody.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			InputStream in = openConnection.getInputStream();

			String data = "";
			String line = "";
			try {
				InputStreamReader inR = new InputStreamReader(in);
				BufferedReader buf = new BufferedReader(inR);

				while ((line = buf.readLine()) != null) {
					data += line;
				}
			} finally {
				in.close();
			}

			JSONObject json = (JSONObject) JSONValue.parseWithException(data);
			JSONArray obj = (JSONArray) json.get("entries");

			for (Object o : obj) {
				Info f = new Info();

				f.setNome((String) ((JSONObject) o).get("name"));
				f.setTipologia((String) ((JSONObject) o).get(".tag"));
				f.setUltimaModifica((String) ((JSONObject) o).get("client_modified"));
				if (f.getUltimaModifica() == null) {
					f.setUltimaModifica("0");
				}
				f.setDimensione((Long) ((JSONObject) o).get("size"));
				if (f.getDimensione() == null) {
					f.setDimensione((long) 0);
				}
				f.setPercorso((String) ((JSONObject) o).get("path_lower"));
				this.data.add(f);

			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public Vector<Info> getData() {
		return data;
	}

	public void setData(Vector<Info> data) {
		this.data = data;
	}

}