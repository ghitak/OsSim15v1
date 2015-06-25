package edu.upc.fib.ossim.dao;
/**
 * @author saksaka
 *
 */

import static edu.upc.fib.ossim.utils.Constants.FICHIER_PROPERTIES;
import static edu.upc.fib.ossim.utils.Constants.PROPERTY_DRIVER;
import static edu.upc.fib.ossim.utils.Constants.PROPERTY_MOT_DE_PASSE;
import static edu.upc.fib.ossim.utils.Constants.PROPERTY_NOM_UTILISATEUR;
import static edu.upc.fib.ossim.utils.Constants.PROPERTY_URL;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class FactoryDAO {
	
	
    private String              url;     
    private String              username;
    private String              password;
    
    FactoryDAO( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance 
     */
    public static FactoryDAO getInstance() throws DAOConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;
        

        InputStream fichierProperties = FactoryDAO.class.getResourceAsStream( FICHIER_PROPERTIES );
        
        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }
        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }
        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }
        FactoryDAO instance = new FactoryDAO( url, nomUtilisateur, motDePasse );
        return instance;
    }
    /* Méthode chargée de fournir une connexion à la base de données */
     /* package */ 
    Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    } 
     
     public EtudiantDAO getEtudiantDao() {
         return new EtudiantDAOImpl( this );
     } 
     
     public ProfesseurDAO getProfesseurDAO() {
         return new ProfesseurDAOImpl( this );
     } 
 	 	
 	public ExerciceDAO getExerciceDAO(){
 		return new ExerciceDAOImpl(this);
 	}
 	
 	public TestRealiseDAO getTestRealiseDAO(){
 		return new TestRealiseDAOImpl(this);
 	}
 	
 	public QrDAO getQrDAO(){
 		return new QrDAOImpl(this);
 	}
	
}
