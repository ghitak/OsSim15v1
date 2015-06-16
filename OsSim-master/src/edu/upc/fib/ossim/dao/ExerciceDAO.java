package edu.upc.fib.ossim.dao;

import java.util.List;

import edu.upc.fib.ossim.mcq.model.Exercice;
import edu.upc.fib.ossim.mcq.model.QR;

public interface ExerciceDAO {// ghita
	
	List<QR> getListQRByExo(int IdExo);
	void creerExercice(Exercice Exo);	 
	List<Exercice> getListExercicePublies(); 
	List<Exercice> getListTestPublies(); 

}
