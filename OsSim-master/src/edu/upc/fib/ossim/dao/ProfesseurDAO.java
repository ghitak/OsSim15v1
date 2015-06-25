package edu.upc.fib.ossim.dao;
/**
 * @author saksaka
 *
 */

public interface ProfesseurDAO {
	
	int getProfesseurId (String loginProfesseur, String motDePasseProfesseur) throws DAOException;

}
