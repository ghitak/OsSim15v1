package edu.upc.fib.ossim.mcq.model;

import java.util.Date;

public class TestRealise {
	
	private String titreExerice;
	private int idEtudiant;
	private int idTest;
	private String nom;
	private int note; // peut �tre int
	private Date datePassageTest;
	
	
	
	public TestRealise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestRealise(int id_Etudiant, int idTest,  int note) {
		super();
		this.idTest = idTest;
		this.idEtudiant = id_Etudiant;
		this.note = note;
	}
	public TestRealise(String titreExerice, int id_Etudiant, int note,
			Date datePassageTest) {
		super();
		this.titreExerice = titreExerice;
		this.idEtudiant = id_Etudiant;
		this.note = note;
		this.datePassageTest = datePassageTest;
	}
	
	public String getTitreExerice() {
		return titreExerice;
	}
	public void setTitreExerice(String titreExerice) {
		this.titreExerice = titreExerice;
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Date getDatePassageTest() {
		return datePassageTest;
	}
	public void setDatePassageTest(Date datePassageTest) {
		this.datePassageTest = datePassageTest;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdTest() {
		return idTest;
	}
	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}
	
	
	
	
	
	

}
