package edu.upc.fib.ossim.dao;

import java.util.List;

import edu.upc.fib.ossim.mcq.model.Exercice;
import edu.upc.fib.ossim.mcq.model.QR;

public interface ExerciceDAO {
	
	List<QR> getListQRByExo(int IdExo);
	void creerExerciceInfo(Exercice exo);
	void creerQrExercice(Exercice exo);
	void creerExercice(Exercice exo);
	List<Exercice> getListExercicePublies(); 
	List<Exercice> getListTestPublies(); 
	List<Exercice> getAllExercice(); 

}
