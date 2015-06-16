
package edu.upc.fib.ossim.dao;

public interface ProfesseurDAO {
	
	int getProfesseurId (String loginProfesseur, String motDePasseProfesseur) throws DAOException;

}
