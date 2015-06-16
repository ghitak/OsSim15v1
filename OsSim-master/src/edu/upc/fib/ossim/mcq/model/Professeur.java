package edu.upc.fib.ossim.mcq.model;

public class Professeur {
	

	private long idProdesseur;
	private String LoginProfesseur;
	private String motDePasseProfesseur;
	private String nomPrenomProfesseur;
	
	
	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Professeur(String login_Professeur,
			String motDePasse_Professeur, String nomPrenom_Professeur) {
		super();
		LoginProfesseur = login_Professeur;
		this.motDePasseProfesseur = motDePasse_Professeur;
		this.nomPrenomProfesseur = nomPrenom_Professeur;
	}



	public long getIdProdesseur() {
		return idProdesseur;
	}

	public void setIdProdesseur(long idProdesseur) {
		this.idProdesseur = idProdesseur;
	}

	public String getLoginProfesseur() {
		return LoginProfesseur;
	}

	public void setLoginProfesseur(String loginProfesseur) {
		LoginProfesseur = loginProfesseur;
	}

	public String getMotDePasseProfesseur() {
		return motDePasseProfesseur;
	}

	public void setMotDePasseProfesseur(String motDePasseProfesseur) {
		this.motDePasseProfesseur = motDePasseProfesseur;
	}

	public String getNomPrenomProfesseur() {
		return nomPrenomProfesseur;
	}

	public void setNomPrenomProfesseur(String nomPrenomProfesseur) {
		this.nomPrenomProfesseur = nomPrenomProfesseur;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Professeur [idProdesseur=" + idProdesseur
				+ ", LoginProfesseur=" + LoginProfesseur
				+ ", motDePasseProfesseur=" + motDePasseProfesseur
				+ ", nomPrenomProfesseur=" + nomPrenomProfesseur + "]";
	}
	
	
	

}
