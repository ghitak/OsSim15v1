
package edu.upc.fib.ossim.dao;



import edu.upc.fib.ossim.mcq.model.Professeur;

public interface ProfesseurDAO {
	
	Professeur chercher (String loginProfesseur, String motDePasseProfesseur) throws DAOException;

}
