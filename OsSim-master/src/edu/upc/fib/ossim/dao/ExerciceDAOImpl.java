
package edu.upc.fib.ossim.dao;

import static edu.upc.fib.ossim.dao.DAOUtils.fermeturesSilencieuses;
import static edu.upc.fib.ossim.dao.DAOUtils.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.upc.fib.ossim.mcq.model.Exercice;
import edu.upc.fib.ossim.mcq.model.QR;
import edu.upc.fib.ossim.utils.Constants;
import edu.upc.fib.ossim.dao.DAOUtils;

public class ExerciceDAOImpl implements ExerciceDAO{

	private FactoryDAO factoryDAO;

	public ExerciceDAOImpl(FactoryDAO daoFactory) {
		this.factoryDAO = daoFactory;
	}

	public List<QR> getListQRByExo(int idExo) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<QR> qr = new ArrayList<QR>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, DAOUtils.getProperties().getProperty(Constants.REQ_QR_BY_EXERCICE), false, idExo );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	        	
	        	    QrDAO qrDao=new QrDAOImpl(factoryDAO);
	        	    qr.add(qrDao.findQR(resultSet.getInt("id_QR")));
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

		return qr;
	}
	

	public void creerExercice(Exercice Exo) {
		// TODO Auto-generated method stub
		
	}

	public List<Exercice> getListExercicePublies() {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<Exercice> exercices = new ArrayList<Exercice>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();

	        preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_EXERCICE_PUBLIE), false);

	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	        	exercices.add(mapExercice(resultSet));
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

		return exercices;
	}

	public List<Exercice> getListTestPublies() {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<Exercice> Tests = new ArrayList<Exercice>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();

	        preparedStatement = initialisationRequetePreparee( connexion, DAOUtils.getProperties().getProperty(Constants.REQ_TEST_PUBLIE), false);

	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	        	Tests.add(mapExercice(resultSet));
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

		return Tests;		
	}
	
	//Id_exercice, Titre_exo, Exo_type
	 private static Exercice mapExercice( ResultSet resultSet ) throws SQLException {
		 Exercice exercice=new Exercice();
		 exercice.setIdExercice(resultSet.getInt("Id_exercice"));
		 exercice.setTitreExercice(resultSet.getString("Titre_exo"));

		 exercice.setTypeExercice(resultSet.getString("exo_type").charAt(0));
		 System.out.println(exercice.toString());
		 return exercice;
	 }
}



