package edu.upc.fib.ossim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.upc.fib.ossim.mcq.model.Etudiant;
import edu.upc.fib.ossim.mcq.model.Professeur;
import edu.upc.fib.ossim.utils.Constants;


public class ProfesseurDAOImpl implements ProfesseurDAO {
	private FactoryDAO factoryDAO;
	ProfesseurDAOImpl( FactoryDAO daoFactory ) {
        this.factoryDAO = daoFactory;

    }
	public Professeur chercher(String loginProfesseur, String motDePasseProfesseur)
			throws DAOException {
		// Statements allow to issue SQL queries to the database
		try {
			Connection mConnection = factoryDAO.getConnection();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			preparedStatement = mConnection.prepareStatement(
					DAOUtils.getProperties().getProperty( Constants.REQ_AUTHENTIFICATION_PROFESSEUR));
			preparedStatement.setString(1, loginProfesseur);
			preparedStatement.setString(2, motDePasseProfesseur);

			resultSet = preparedStatement.executeQuery();
			return writeResultSet(resultSet);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 

	    private Professeur writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
	    	Professeur professeur = null;
		while (resultSet.next()) {
			String loginProfesseur = resultSet.getString("login");
			String motDePasseProfesseur = resultSet.getString("password");
			long idProfesseur = resultSet.getLong("id_Professeur");
			String nomPrenomProfesseur = resultSet.getString("nomPrenom_Professeur");
			professeur = new Professeur( loginProfesseur, motDePasseProfesseur, nomPrenomProfesseur);
			professeur.setIdProdesseur(idProfesseur);
		}
		//System.out.println(professeur);
		return professeur;
	} 


}
