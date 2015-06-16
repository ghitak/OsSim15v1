package edu.upc.fib.ossim.dao;


import static edu.upc.fib.ossim.dao.DAOUtils.fermeturesSilencieuses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.upc.fib.ossim.mcq.model.Etudiant;
import edu.upc.fib.ossim.mcq.model.Exercice;
import edu.upc.fib.ossim.mcq.model.QR;
import edu.upc.fib.ossim.mcq.model.TestRealise;
import edu.upc.fib.ossim.mcq.view.PanelAuthentification;
import edu.upc.fib.ossim.utils.Constants;


public class TestRealiseDAOImpl implements TestRealiseDAO {

	private FactoryDAO factoryDAO;


	Connection connexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;


	public TestRealiseDAOImpl(FactoryDAO daoFactory) {
		this.factoryDAO = daoFactory;
	}


	//@Override
	public List<TestRealise> getListTestsByEtudiant(long idEtudiant) {

		List<TestRealise> listOfTest = null;
		try {
			Connection mConnection = factoryDAO.getConnection();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			preparedStatement = mConnection .prepareStatement(
					DAOUtils.getProperties().getProperty( Constants.REQ_LIST_TEST_REALISE_BY_ETUDIANT));
			preparedStatement.setLong(1, idEtudiant);		

			resultSet = preparedStatement.executeQuery();
			listOfTest = writeResultSet(resultSet);

		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		}

		return listOfTest;
	}

	private List<TestRealise> writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		TestRealise mTestRealise = null;
		List<TestRealise> listOfTest = new ArrayList<TestRealise>();
		while (resultSet.next()) {
			
			 Exercice idExerice;
			
			 long idExo = resultSet.getLong("id_exercice");
			 char typeExo = resultSet.getString("exo_type").charAt(0);
			 String titre = resultSet.getString("titre_exo");
			 int actif = resultSet.getInt("isActif");
			 List<QR> listQR = null;
			 idExerice = new Exercice(titre, typeExo, actif==0?false:true, listQR);
			 Etudiant idEtudiant = PanelAuthentification.mEtudiant;
			 int note = resultSet.getInt("result"); // peut être int
			 Date datePassageTest = resultSet.getDate("date_testpassing");
			 mTestRealise = new TestRealise(idExerice, idEtudiant, note+"", datePassageTest);
			
			 listOfTest.add(mTestRealise);
		}
		return listOfTest;
	}

	//@Override
	public List<TestRealise> getListEtudiantsByTest(long idExercice) {
		
		List<TestRealise> listOfTest = null;
		try {
			Connection mConnection = factoryDAO.getConnection();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			preparedStatement = mConnection .prepareStatement(
					DAOUtils.getProperties().getProperty( Constants.REQ_lIST_REALISE_ETUDIANT_BY_TEST));
			preparedStatement.setLong(1, idExercice);		

			resultSet = preparedStatement.executeQuery();
			listOfTest = writeResultSet1(resultSet);

		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		}

		return listOfTest;
	}

	private List<TestRealise> writeResultSet1(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		TestRealise mTestRealise = null;
		List<TestRealise> listOfTest = new ArrayList<TestRealise>();
		while (resultSet.next()) {
			 Exercice idExerice;
			 System.out.println("toto");
			 long idExo = resultSet.getLong(1);
			 System.out.println("toto1");
			 char typeExo = resultSet.getString(2).charAt(0);
			 System.out.println("toto2");
			 String titre = resultSet.getString(3);
			 System.out.println("toto3");
			 int actif = resultSet.getInt(4);
			 System.out.println("toto4");
			 List<QR> listQR = null;
			 idExerice = new Exercice(titre, typeExo, actif==0?false:true, listQR);
			 
			 
			 int note = resultSet.getInt("result"); // peut être int
			 System.out.println("toto5");
			 Date datePassageTest = resultSet.getDate("date_testpassing");
			 String nomPrenomEtudiant = resultSet.getString("nomprenom_Etudiant");
			 System.out.println("toto6");
			 String login = resultSet.getString("login");
			 System.out.println("toto7");
			 String motDePasseEtudiant = resultSet.getString("password");
			 System.out.println("toto8");
			 Etudiant idEtudiant = new Etudiant(login, motDePasseEtudiant, nomPrenomEtudiant);
			 mTestRealise = new TestRealise(idExerice, idEtudiant, note+"", datePassageTest);
			
			 listOfTest.add(mTestRealise);
		}
		return listOfTest;
	}


}
