package edu.upc.fib.ossim.mcq.model;

import java.util.Date;

public class TestRealise {
	
	private Exercice idExerice;
	private Etudiant idEtudiant;
	private String note; // peut être int
	private Date datePassageTest;
	
	
	
	public TestRealise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestRealise(Exercice id_Exerice, Etudiant id_Etudiant, String note,
			Date datePassageTest) {
		super();
		this.idExerice = id_Exerice;
		this.idEtudiant = id_Etudiant;
		this.note = note;
		this.datePassageTest = datePassageTest;
	}
	
	public Exercice getIdExerice() {
		return idExerice;
	}
	public void setIdExerice(Exercice idExerice) {
		this.idExerice = idExerice;
	}
	public Etudiant getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Etudiant idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDatePassageTest() {
		return datePassageTest;
	}
	public void setDatePassageTest(Date datePassageTest) {
		this.datePassageTest = datePassageTest;
	}
	
	
	
	
	
	

}
