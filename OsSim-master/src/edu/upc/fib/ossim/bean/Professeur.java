/**
 * 
 */
package edu.upc.fib.ossim.bean;

/**
 * @author Laure
 *
 */
public class Professeur {

	private long idProfesseur ;
	private String loginProf;
	private String passwordProf;
	/**
	 * @param idProfesseur2
	 * @param loginProf
	 * @param passwordProf
	 */
	public Professeur(long idProfesseur2, String loginProf, String passwordProf) {
		super();
		this.idProfesseur = idProfesseur2;
		this.loginProf = loginProf;
		this.passwordProf = passwordProf;
	}
	/**
	 * 
	 */
	public Professeur() {
		super();
	}
	/**
	 * @return the idProfesseur
	 */
	public long getIdProfesseur() {
		return idProfesseur;
	}
	/**
	 * @param idProfesseur the idProfesseur to set
	 */
	public void setIdProfesseur(int idProfesseur) {
		this.idProfesseur = idProfesseur;
	}
	/**
	 * @return the loginProf
	 */
	public String getLoginProf() {
		return loginProf;
	}
	/**
	 * @param loginProf the loginProf to set
	 */
	public void setLoginProf(String loginProf) {
		this.loginProf = loginProf;
	}
	/**
	 * @return the passwordProf
	 */
	public String getPasswordProf() {
		return passwordProf;
	}
	/**
	 * @param passwordProf the passwordProf to set
	 */
	public void setPasswordProf(String passwordProf) {
		this.passwordProf = passwordProf;
	}

	
}
