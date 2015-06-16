package edu.upc.fib.ossim.mcq.model;

public class ExerciceType {
	private int idTypeExo;
	private String Label_type_exo;
	
	
	public ExerciceType(String label_type_exo) {
		super();
		Label_type_exo = label_type_exo;
	}
	public ExerciceType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdTypeExo() {
		return idTypeExo;
	}
	public void setIdTypeExo(int idTypeExo) {
		this.idTypeExo = idTypeExo;
	}
	public String getLabel_type_exo() {
		return Label_type_exo;
	}
	public void setLabel_type_exo(String label_type_exo) {
		Label_type_exo = label_type_exo;
	}	
}
