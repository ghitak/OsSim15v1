package edu.upc.fib.ossim.mcq.model;

public class Etudiant {
	
	private long idEtudiant;
	private String login;
	private String motDePasseEtudiant;
	private String nomPrenomEtudiant;
	
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String login, String motDePasseEtudiant,
			String nomPrenomEtudiant) {
		super();		
		this.login = login;
		this.motDePasseEtudiant = motDePasseEtudiant;
		this.nomPrenomEtudiant = nomPrenomEtudiant;
	}


	public long getIdEtudiant() {
		return idEtudiant;
	}


	public void setIdEtudiant(long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasseEtudiant() {
		return motDePasseEtudiant;
	}

	public void setMotDePasseEtudiant(String motDePasseEtudiant) {
		this.motDePasseEtudiant = motDePasseEtudiant;
	}

	public String getNomPrenomEtudiant() {
		return nomPrenomEtudiant;
	}

	public void setNomPrenomEtudiant(String nomPrenomEtudiant) {
		this.nomPrenomEtudiant = nomPrenomEtudiant;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", login=" + login
				+ ", motDePasseEtudiant=" + motDePasseEtudiant
				+ ", nomPrenomEtudiant=" + nomPrenomEtudiant + "]";
	}

	
	

}
