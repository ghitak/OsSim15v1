
package edu.upc.fib.ossim.utils;

public class Constants {
	/*
	 * ######## Fichier de Config ########
	 */
	public static final String FICHIER_PROPERTIES       = "/edu/upc/fib/ossim/dao/dao.properties";
	public static final String PROPERTY_URL             = "url";
	public static final String PROPERTY_DRIVER          = "driver";
	public static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
	public static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";
	
	/*
	 *############ requests #############
	 */
	public static final String REQUEST_PROPERTIES       = "/edu/upc/fib/ossim/dao/requetes.properties";
	//RAF: req authentif, info qr, histo etudiant, histo prof
	public static final String REQ_INIT_MDP_ETUDIANT = "init.mdp.etudiant";
	public static final String REQ_ETUDIANT_BY_ID = "get.etudiant.by.id";//à faire
	public static final String REQ_TEST_REALISE_BY_ETUDIANT = "list.test.realise.by.etudiant";//à faire
	public static final String REQ_ETUDIANT_BY_TEST = "list.etudiant.by.test";//à faire
	public static final String REQ_QR_BY_EXERCICE = "list.qr.by.exercice";
	public static final String REQ_ANSWERS_BY_QR = "list.answers.by.qr";
	public static final String REQ_INFO_QR = "get.info.qr.by.id"; 
	public static final String REQ_INFO_QR_PROCESSUS = "get.param.qr.processus.by.qr";
	public static final String REQ_INFO_QR_MEMOIRY = "get.info.qr.memoire.by.qr";
	public static final String REQ_PROCESSUS_READY_BY_QR = "list.processus.ready.by.qr";
	public static final String REQ_PROCESSUS_ARRIVING_BY_QR = "list.processus.arriving.by.qr";
	public static final String REQ_PROCESSUS_MEMOIRY_BY_QR = "list.processus.memoire.by.qr";
	public static final String REQ_BID_BY_PID = "list.bid.by.pid";
	public static final String REQ_EXERCICE_PUBLIE = "list.exo.publie";
	public static final String REQ_TEST_PUBLIE = "list.tests.publie";
	
	/*
	*############ Module Authentification et Historique #############
	*/
	
	public static final String REQ_AUTHENTIFICATION_ETUDIANT = "authentification.etudiant";
	public static final String REQ_AUTHENTIFICATION_PROFESSEUR = "authentification.professeur";
	public static final String REQ_LIST_TEST_REALISE_BY_ETUDIANT = "list.test.realise.by.etudiant";
	public static final String REQ_lIST_REALISE_ETUDIANT_BY_TEST = "list.test.realise.etudiant.by.test";
	
	/*
	 *############ Module QCM #############
	 */
	public static final int MODULE_PROCESS=1; 
	public static final int MODULE_MEMOIRE=2;
	
}

