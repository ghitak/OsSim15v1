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
import java.util.List;

import edu.upc.fib.ossim.mcq.model.Exercice;
import edu.upc.fib.ossim.mcq.model.QR;
import edu.upc.fib.ossim.utils.Constants;

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
	

	public void creerExerciceInfo(Exercice exo) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_EXERCICE_INFO), true, exo.getTitreExercice(),exo.getTypeExercice(),exo.isActif() );
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'exercice, aucune ligne ajoutée dans la table." );
	        }
	        /* Récupération de l'id auto-généré par la requête d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	        	exo.setIdExercice(valeursAutoGenerees.getInt( 1 ) );
	        } else {
	            throw new DAOException( "Échec de la création de l'exercice en base, aucun ID auto-généré retourné." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    } 

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

		 exercice.setTypeExercice(resultSet.getString("exo_type"));
		 return exercice;
	 }

	public void creerQrExercice(Exercice exo) {
		Connection connexion = null;
	    PreparedStatement ps = null;
	    ResultSet resultSet = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        ps = connexion.prepareStatement(DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_QR_EXERCICE));
	        final int batchSize = 1000;
	        int count = 0;
	         
	        for (QR qr: exo.getListeQR()) {
	         
	        	ps.setInt(1, exo.getIdExercice());
	        	ps.setInt(2, qr.getIdQR());
	            ps.addBatch();
	             
	            if(++count % batchSize == 0) {
	                ps.executeBatch();
	            }
	        }
	        int[] statut = ps.executeBatch();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == null ) {
	            throw new DAOException( "Échec de la création des qrsexo, aucune ligne ajoutée dans la table." );
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, ps, connexion );
	    }
		
		
	}

	public void creerExercice(Exercice exo) {
		
		creerExerciceInfo(exo);
//		QrDAO qrDao=null;
//		for(int i=0;i<exo.getListeQR().size();i++)
//		{
//			qrDao=new QrDAOImpl(factoryDAO);
//			qrDao.creerQR(exo.getListeQR().get(i));
//		}
		creerQrExercice(exo);	
	}
	
	public List<Exercice> getAllExercice() 
			throws DAOException {
	    	Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    List<Exercice> listOfExercice = new ArrayList<Exercice>();
	    	// Statements allow to issue SQL queries to the database
	    	try {
	    		
	    		connexion = factoryDAO.getConnection();
	    		preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_LIST_EXERCISES),false);

	    		resultSet = preparedStatement.executeQuery();
	    		
	    		while (resultSet.next()) {
	    			listOfExercice.add(mapExercice(resultSet));
	    			}

	    		} catch ( SQLException e ) {
	    			throw new DAOException( e );
	    		} finally {
	    			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    		}
	    		return listOfExercice;
	    	}

	public List<Integer> getListExobyQR(int IdQR) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<Integer> listIdExercice = new ArrayList<Integer>();
    	// Statements allow to issue SQL queries to the database
    	try {
    		
    		connexion = factoryDAO.getConnection();
    		preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_LIST_EXO_BY_QR),false,IdQR);

    		resultSet = preparedStatement.executeQuery();
    		
    		while (resultSet.next()) {
    			listIdExercice.add(resultSet.getInt(1));
    			}

    		} catch ( SQLException e ) {
    			throw new DAOException( e );
    		} finally {
    			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
    		}
    		return listIdExercice;
	}

	public void creerQrExercice(List<Integer> listExo, int idQ) {
		Connection connexion = null;
	    PreparedStatement ps = null;
	    ResultSet resultSet = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        ps = connexion.prepareStatement(DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_QR_EXERCICE));
	        final int batchSize = 1000;
	        int count = 0;
	         
	        for (int i = 0; i<listExo.size(); i++) {
	         
	        	ps.setInt(1, listExo.get(i));
	        	ps.setInt(2, idQ);
	            ps.addBatch();
	             
	            if(++count % batchSize == 0) {
	                ps.executeBatch();
	            }
	        }
	        int[] statut = ps.executeBatch();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == null ) {
	            throw new DAOException( "Échec de la création des qrsexo, aucune ligne ajoutée dans la table." );
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, ps, connexion );
	    }
		
	}
}