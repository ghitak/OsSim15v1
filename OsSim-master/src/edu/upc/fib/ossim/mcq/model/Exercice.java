package edu.upc.fib.ossim.mcq.model;

import java.util.List;

public class Exercice {
	
	private int idExercice;
	private String titreExercice;
	private char typeExercice; // test ou entrainement
	private boolean actif; // flag vérifiant si l'exercice est activé ou pas
	private List<QR> listeQR;
	
	
	public Exercice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Exercice(String titre_Exercice, char type_Exercice,
			boolean actif, List<QR> liste_QR) {
		super();
		this.titreExercice = titre_Exercice;
		this.typeExercice = type_Exercice;
		this.actif = actif;
		this.listeQR = liste_QR;
	}




	public int getIdExercice() {
		return idExercice;
	}




	public void setIdExercice(int idExercice) {
		this.idExercice = idExercice;
	}




	public String getTitreExercice() {
		return titreExercice;
	}




	public void setTitreExercice(String titreExercice) {
		this.titreExercice = titreExercice;
	}




	public char getTypeExercice() {
		return typeExercice;
	}




	public void setTypeExercice(char typeExercice) {
		this.typeExercice = typeExercice;
	}




	public boolean isActif() {
		return actif;
	}




	public void setActif(boolean actif) {
		this.actif = actif;
	}




	public List<QR> getListeQR() {
		return listeQR;
	}




	public void setListeQR(List<QR> listeQR) {
		this.listeQR = listeQR;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return titreExercice;
	}
	
	

}
