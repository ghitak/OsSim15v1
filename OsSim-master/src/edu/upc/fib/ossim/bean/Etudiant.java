/**
 * 
 */
package edu.upc.fib.ossim.bean;

/**
 * @author Laure
 *
 */
public class Etudiant {

	private long idEtudiant ;
	private String loginEtud;
	private String passwordEtud;
	/**
	 * @param idEtudiant
	 * @param loginEtud
	 * @param passwordEtud
	 */
	public Etudiant(long idEtudiant, String loginEtud, String passwordEtud) {
		super();
		this.idEtudiant = idEtudiant;
		this.loginEtud = loginEtud;
		this.passwordEtud = passwordEtud;
	}
	/**
	 * 
	 */
	public Etudiant() {
		super();
	}
	/**
	 * @return the idEtudiant
	 */
	public long getIdEtudiant() {
		return idEtudiant;
	}
	/**
	 * @param idEtudiant the idEtudiant to set
	 */
	public void setIdEtudiant(long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	/**
	 * @return the loginEtud
	 */
	public String getLoginEtud() {
		return loginEtud;
	}
	/**
	 * @param loginEtud the loginEtud to set
	 */
	public void setLoginEtud(String loginEtud) {
		this.loginEtud = loginEtud;
	}
	/**
	 * @return the passwordEtud
	 */
	public String getPasswordEtud() {
		return passwordEtud;
	}
	/**
	 * @param passwordEtud the passwordEtud to set
	 */
	public void setPasswordEtud(String passwordEtud) {
		this.passwordEtud = passwordEtud;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", loginEtud="
				+ loginEtud + ", passwordEtud=" + passwordEtud + "]";
	}
	
	
	
}
