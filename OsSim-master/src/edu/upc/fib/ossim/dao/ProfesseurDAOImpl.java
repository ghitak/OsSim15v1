package edu.upc.fib.ossim.dao;
/**
 * @author saksaka
 *
 */

import static edu.upc.fib.ossim.dao.DAOUtils.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.upc.fib.ossim.utils.Constants;


public class ProfesseurDAOImpl implements ProfesseurDAO {
	private FactoryDAO factoryDAO;
	ProfesseurDAOImpl( FactoryDAO daoFactory ) {
        this.factoryDAO = daoFactory;

    }
	public int getProfesseurId(String loginProfesseur, String motDePasseProfesseur)
			throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int profId = 0;
		// Statements allow to issue SQL queries to the database
		try {
			connexion = factoryDAO.getConnection();
			
			preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_AUTHENTIFICATION_PROFESSEUR), false, loginProfesseur,motDePasseProfesseur );

			resultSet = preparedStatement.executeQuery();
			if ( resultSet.next() ) {
				profId= resultSet.getInt("id_professeur");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profId;
	} 
	  

}
