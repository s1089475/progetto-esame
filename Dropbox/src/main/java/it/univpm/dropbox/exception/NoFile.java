package it.univpm.dropbox.exception;

public class NoFile extends Exception {

	/**
	 * ECCEZIONE PER ASSENZA DI FILE NELL'ACCOUNT DROPBOX
	 * 
	 * @author Roberto Dimitri
	 * @author Andrea Iannotti
	 */
	private static final long serialVersionUID = 1L;

	public NoFile(String msg) {
		super(msg);
	}

}
