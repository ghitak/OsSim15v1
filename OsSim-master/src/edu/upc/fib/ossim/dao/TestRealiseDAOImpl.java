package edu.upc.fib.ossim.dao;
/**
 * @author saksaka
 *
 */


import static edu.upc.fib.ossim.dao.DAOUtils.fermeturesSilencieuses;
import static edu.upc.fib.ossim.dao.DAOUtils.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.upc.fib.ossim.mcq.model.TestRealise;
import edu.upc.fib.ossim.utils.Constants;


public class TestRealiseDAOImpl implements TestRealiseDAO {

	private FactoryDAO factoryDAO;
	
	public TestRealiseDAOImpl(FactoryDAO daoFactory) {
		this.factoryDAO = daoFactory;
	}


	//@Override
	public List<TestRealise> getListTestsByEtudiant(long idEtudiant) {

		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
		List<TestRealise> listOfTest = new ArrayList<TestRealise> ();
		try {
			
			connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_LIST_TEST_REALISE_BY_ETUDIANT), false, idEtudiant );
     
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listOfTest.add(mapTestRealise1(resultSet));
			}
			

		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		}

		return listOfTest;
	}

	private TestRealise mapTestRealise1(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		
			TestRealise mTestRealise = new TestRealise();
			mTestRealise.setTitreExerice(resultSet.getString("Titre_exo"));
			mTestRealise.setDatePassageTest(resultSet.getDate("date_testpassing"));
			mTestRealise.setNote(resultSet.getInt("result"));			
			
		
		return mTestRealise;
	}

	//@Override
	public List<TestRealise> getListEtudiantsByTest(long idExercice) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
		List<TestRealise> listOfTest = new ArrayList<TestRealise> ();
		try {
			
			connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_lIST_REALISE_ETUDIANT_BY_TEST), false, idExercice );
     
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			listOfTest.add(mapTestRealise2(resultSet));
			}

		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		}

		return listOfTest;
	}

	private TestRealise mapTestRealise2(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		TestRealise mTestRealise = new TestRealise();
		mTestRealise.setNote(resultSet.getInt("result"));
		mTestRealise.setDatePassageTest(resultSet.getDate("date_testpassing"));
		mTestRealise.setTitreExerice(resultSet.getString("Titre_exo"));
		mTestRealise.setNom(resultSet.getString("nomprenom_etudiant"));
				
		return mTestRealise;
	}


	public void insertStudentResultByTest(TestRealise test) {
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        Calendar calendar = Calendar.getInstance();
	        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	        preparedStatement = initialisationRequetePreparee( connexion, DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_TEST_REALISE), true, test.getIdEtudiant(),test.getIdTest(),startDate,test.getNote());
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création du test realise, aucune ligne ajoutée dans la table." );
	        }
	      
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( preparedStatement, connexion );
	    } 
	}


}
