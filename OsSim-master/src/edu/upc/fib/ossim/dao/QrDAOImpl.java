package edu.upc.fib.ossim.dao;

import static edu.upc.fib.ossim.dao.DAOUtils.fermeturesSilencieuses;
import static edu.upc.fib.ossim.dao.DAOUtils.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.upc.fib.ossim.mcq.model.Answer;
import edu.upc.fib.ossim.mcq.model.Bid;
import edu.upc.fib.ossim.mcq.model.ProcessusSimulationMemoire;
import edu.upc.fib.ossim.mcq.model.ProcessusSimulationProcessus;
import edu.upc.fib.ossim.mcq.model.QR;
import edu.upc.fib.ossim.mcq.model.SimulationMemoire;
import edu.upc.fib.ossim.mcq.model.SimulationProcessus;
import edu.upc.fib.ossim.utils.Constants;

public class QrDAOImpl implements QrDAO {

	private FactoryDAO factoryDAO;

	public QrDAOImpl(FactoryDAO daoFactory) {
		this.factoryDAO = daoFactory;
	}

	
	public QR getInfoQR(int IdQR) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    QR qr  = new QR();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_INFO_QR), false, IdQR );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {

	        	qr=mapQR(resultSet);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		
		return qr;
	}

	
	public List<Answer> getAnswersQR(int IdQR) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<Answer> answers  = new ArrayList<Answer>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_ANSWERS_BY_QR), false, IdQR );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {

	        	answers.add(mapAnswer(resultSet));
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		
		return answers;
	}

	

	
	public List<ProcessusSimulationProcessus> getProcQRProcArriving(int idQR) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<ProcessusSimulationProcessus> listProc  = new ArrayList<ProcessusSimulationProcessus>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_PROCESSUS_ARRIVING_BY_QR), false, idQR );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {

	        	    listProc.add(mapProcess(resultSet));
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		
		return listProc;
	}

	
	public List<ProcessusSimulationProcessus> getProcQRProcReady(int idQR) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<ProcessusSimulationProcessus> listProc  = new ArrayList<ProcessusSimulationProcessus>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_PROCESSUS_READY_BY_QR), false, idQR );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {

	        	    listProc.add(mapProcess(resultSet));
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		
		return listProc;
	}

	

	public SimulationProcessus getParamQRProc(int idQR) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    SimulationProcessus sim  = new SimulationProcessus();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_INFO_QR_PROCESSUS), false, idQR );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {

	        	    sim=mapSimulationProcessus(resultSet);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
				
		return sim;
	}

	public SimulationMemoire getParamQRMem(int idQR) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    SimulationMemoire simp = new SimulationMemoire();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, DAOUtils.getProperties().getProperty(Constants.REQ_INFO_QR_MEMOIRY), false, idQR );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	simp = mapQrMemoryParam( resultSet );
	        	    
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

		return simp;
	}


	private SimulationMemoire mapQrMemoryParam(ResultSet resultSet) throws SQLException {
		SimulationMemoire s = new SimulationMemoire();
		s.setManagement(resultSet.getString("management"));
		s.setMemorySize(resultSet.getInt("MemorySize"));
		s.setPageSize(resultSet.getInt("pagesize"));
		s.setPolicy(resultSet.getInt("policy"));
		s.setSoSize(resultSet.getInt("sosize"));
		return s;
	}

	public QR findQR(int idQR) {
		
	    QR qr=null;
	    List<Answer> answers=new ArrayList<Answer>();
	    
	    qr=getInfoQR(idQR);
	    
	    answers=getAnswersQR(idQR);
	    qr.setAnswerList(answers);
	    qr.setAnswerNumber(answers.size());
	    if(qr.getModuleQR()==Constants.MODULE_MEMOIRE){
	    	SimulationMemoire simulation;
	    	simulation=getParamQRMem(idQR);
	    	
	    	List<ProcessusSimulationMemoire> listProcessMemoire=getProcQRMem(idQR);
	    	if(qr.getSimulation().getManagement()=="PAG"){
	    		List<Bid> bids=null;
	    		for(int i=0; i<listProcessMemoire.size();i++){
	    			bids=getBidByProc(listProcessMemoire.get(i).getPid());
	    			listProcessMemoire.get(i).setListBid(bids);
	    		}	
	    	}
	    	simulation.setListeProcessus(listProcessMemoire);
	    	qr.setSimulation(simulation);
	    	
	    }else if(qr.getModuleQR()==Constants.MODULE_PROCESS){
	    	SimulationProcessus simulation=new SimulationProcessus();
	    	simulation=getParamQRProc(idQR);
	    	List<ProcessusSimulationProcessus> listProcessArriving=getProcQRProcArriving(idQR);
	    	List<ProcessusSimulationProcessus> listProcessReady=getProcQRProcReady(idQR);
	    	System.out.println("size R"+listProcessReady.size()+" size A "+listProcessArriving.size());
	    	listProcessArriving.addAll(listProcessReady);
	    	System.out.println("size R"+listProcessReady.size()+" size A "+listProcessArriving.size());
	    	
	    	for(int i=0; i<listProcessArriving.size();i++){
	    		System.out.println(listProcessArriving.get(i).getName());
	    	}
	    	System.out.println("managmnt"+simulation.getManagement());
	    	simulation.setListeProcessus(listProcessArriving);
	    	
	    	
	    	
	    	qr.setSimulation(simulation);
	    	
	    }

		return qr;
	}

	public static ProcessusSimulationProcessus mapProcess(ResultSet resultSet) throws SQLException{
		ProcessusSimulationProcessus process=new ProcessusSimulationProcessus();
		process.setBursts(resultSet.getString("Bursts"));
		process.setPrio(resultSet.getInt("prio"));
		process.setPid(resultSet.getInt("pid"));
		process.setName(resultSet.getString("p_name"));
		process.setSubmission(resultSet.getInt("submission"));
		process.setPeriodic(resultSet.getBoolean("Periodic"));
		process.setColor(resultSet.getLong("Color"));
		process.setVariables(resultSet.getString("Variables"));
		process.setResources(resultSet.getString("Resources"));
		process.setTypeQueue(resultSet.getString("Queue_id"));
		return process;
	}
	
	public static Answer mapAnswer(ResultSet resultSet) throws SQLException{
		Answer answer=new Answer();
		answer.setText(resultSet.getString("answer"));
		answer.setValue(resultSet.getBoolean("isCorrectanswer"));
		
		return answer;
	}
	
	public static SimulationProcessus mapSimulationProcessus(ResultSet resultSet) throws SQLException{
		SimulationProcessus sim=new SimulationProcessus();
		sim.setManagement(resultSet.getString("management"));
		sim.setMultiprograming(resultSet.getBoolean("multiprogramming"));
		sim.setPreemptive(resultSet.getBoolean("preemptive"));
		sim.setQuantum(resultSet.getInt("Quantum"));
		sim.setVar(resultSet.getBoolean("var"));
		sim.setVerrou(resultSet.getInt("Verrou"));
		
		
		return sim;
	}
	
	public static QR mapQR(ResultSet resultSet) throws SQLException{
		QR qr=new QR();
		qr.setIdQR(resultSet.getInt("id_qr"));
		qr.setTitleQr(resultSet.getString("title_QR"));
		qr.setBlockOnStep(resultSet.getInt("blockOnStep"));
		qr.setEnonce(resultSet.getString("question"));
		qr.setModuleQR(resultSet.getInt("mod_QR"));
		qr.setIncludeAnswers(resultSet.getBoolean("includeAnswers"));
		qr.setDifficulty(resultSet.getInt("difficulty"));
		qr.setAnswerType(resultSet.getInt("answerType"));		
		return qr;
	}

	public void creerReponseQr(List<Answer> listAns) {
		Connection connexion = null;
	    PreparedStatement ps = null;
	    ResultSet resultSet = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        ps = connexion.prepareStatement(DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_ANSWER_QR));
	        final int batchSize = 1000;
	        int count = 0;
	         
	        for (Answer answer: listAns) {
	         
	            ps.setString(1, answer.getText());
	            ps.setBoolean(2, answer.isValue());
	            ps.addBatch();
	             
	            if(++count % batchSize == 0) {
	                ps.executeBatch();
	            }
	        }
	        int[] statut = ps.executeBatch();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == null ) {
	            throw new DAOException( "Échec de la création des reponses, aucune ligne ajoutée dans la table." );
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, ps, connexion );
	    }
	
	}


	public void creerParamQrProcessus(SimulationProcessus simp) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_SIMULATION_PROCESS_PARAM), true, simp.getIdQR(),simp.isMultiprograming(),simp.isPreemptive(),simp.getQuantum(),simp.isVar(),simp.getVerrou(),simp.getManagement());
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de la simulation processus, aucune ligne ajoutée dans la table." );
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( preparedStatement, connexion );
	    } 
		
	}


	public void creerParamQrMemoire(SimulationMemoire simm) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_SIMULATION_MEMORY_PARAM), true, simm.getIdQR(),simm.getManagement(),simm.getPageSize(),simm.getMemorySize(),simm.getSoSize(),simm.getPolicy());
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de la simulation memoire, aucune ligne ajoutée dans la table." );
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( preparedStatement, connexion );
	    } 
	}


	public void creerProcessusQr(
			List<ProcessusSimulationProcessus> listroA) {
		Connection connexion = null;
	    PreparedStatement ps = null;
	    ResultSet resultSet = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        ps = connexion.prepareStatement(DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_PROCESS_SIMULATION_PROCESS));
	        final int batchSize = 1000;
	        int count = 0;
	         
	        for (ProcessusSimulationProcessus pro: listroA) {
	         
	        	ps.setInt(1, pro.getIdQR());
	        	ps.setInt(2, pro.getPid());
	        	ps.setString(3,pro.getName());
	        	ps.setInt(4,pro.getPrio());
	        	ps.setInt(5,pro.getSubmission());
	        	ps.setBoolean(6,pro.isPeriodic());
	        	ps.setString(7,pro.getBursts());
	        	ps.setLong(8,pro.getColor());
	        	ps.setString(9,pro.getVariables());
	        	ps.setString(10,pro.getResources());	        	
	        	ps.setString(11,pro.getTypeQueue());
	        	
	            ps.addBatch();
	             
	            if(++count % batchSize == 0) {
	                ps.executeBatch();
	            }
	        }
	        int[] statut = ps.executeBatch();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == null ) {
	            throw new DAOException( "Échec de la création de la queue arriving, aucune ligne ajoutée dans la table." );
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, ps, connexion );
	    }		
	}


	public void creerMemoireProcessusQr(List<ProcessusSimulationMemoire> listpro) {
		Connection connexion = null;
	    PreparedStatement ps = null;
	    ResultSet resultSet = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        ps = connexion.prepareStatement(DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_PROCESS_SIMULATION_MEMORY));
	        final int batchSize = 1000;
	        int count = 0;
	         
	        for (ProcessusSimulationMemoire pro: listpro) {
	         
	        	ps.setInt(1, pro.getIdQR());
	        	ps.setInt(2, pro.getPid());
	        	ps.setString(3,pro.getName());
	        	ps.setInt(4,pro.getSize());
	        	ps.setInt(5,pro.getDuration());
	        	ps.setLong(6,pro.getColor());
	        	ps.setString(7,pro.getQuantumOrders());
	        	ps.setInt(8,pro.getQuantum());  
	        	
	            ps.addBatch();
	             
	            if(++count % batchSize == 0) {
	                ps.executeBatch();
	            }
	        }
	        int[] statut = ps.executeBatch();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == null ) {
	            throw new DAOException( "Échec de la création de la queue pro memoire, aucune ligne ajoutée dans la table." );
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, ps, connexion );
	    }		
		
	}


	public void creerBidMemoire(List<Bid> bids) {
		Connection connexion = null;
	    PreparedStatement ps = null;
	    ResultSet resultSet = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        ps = connexion.prepareStatement(DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_BID));
	        final int batchSize = 1000;
	        int count = 0;
	         
	        for (Bid bid: bids) {
	         
	        	ps.setInt(1, bid.getIdQR());
	        	ps.setInt(2, bid.getPid());
	            ps.setInt(3, bid.getNum_Bid());
	            ps.setInt(4, bid.getSize_Bid());
	            ps.setBoolean(5, bid.isLoad());
	            ps.addBatch();
	             
	            if(++count % batchSize == 0) {
	                ps.executeBatch();
	            }
	        }
	        int[] statut = ps.executeBatch();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == null ) {
	            throw new DAOException( "Échec de la création des bids, aucune ligne ajoutée dans la table." );
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, ps, connexion );
	    }
		
	}

	public List<Bid> getBidByProc(int id_Proc) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<Bid> bids = new ArrayList<Bid>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, DAOUtils.getProperties().getProperty(Constants.REQ_BID_BY_PID), false,id_Proc);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	bids.add(mapBid(resultSet));
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

		return bids;	
	}


	private Bid mapBid(ResultSet resultSet) throws SQLException{
		
		Bid b = new Bid();
		b.setNum_Bid(resultSet.getInt("bid"));
		b.setLoad(resultSet.getBoolean("load"));
		b.setSize_Bid(resultSet.getInt("size"));
		return b;
	}

	public List<ProcessusSimulationMemoire> getProcQRMem(int idQR) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<ProcessusSimulationMemoire> procs = new ArrayList<ProcessusSimulationMemoire>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, DAOUtils.getProperties().getProperty(Constants.REQ_PROCESSUS_MEMOIRY_BY_QR), false,idQR);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	procs.add(mapQrProcMem(resultSet));
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

		return procs;	
	}


	private ProcessusSimulationMemoire mapQrProcMem(ResultSet resultSet) throws SQLException{
		
		ProcessusSimulationMemoire pm = new ProcessusSimulationMemoire();
		pm.setColor(resultSet.getInt("color"));
		pm.setDuration(resultSet.getInt("duration"));
		pm.setName(resultSet.getString("p_name"));
		pm.setPid(resultSet.getInt("pid"));
		pm.setQuantum(resultSet.getInt("quantum"));
		pm.setQuantumOrders(resultSet.getString("quantumOrders"));
		pm.setSize(resultSet.getInt("size"));
		return pm;
	}


	public void creerQRInfo(QR q) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = factoryDAO.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, DAOUtils.getProperties().getProperty(Constants.REQ_INSERT_INFO_QR), true, q.getModuleQR(),q.getBlockOnStep(),q.getEnonce(),q.isIncludeAnswers(),q.getDifficulty(),q.getAnswerType() );
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'etudiant, aucune ligne ajoutée dans la table." );
	        }
	        /* Récupération de l'id auto-généré par la requête d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	        	q.setIdQR(valeursAutoGenerees.getInt( 1 ) );
	        } else {
	            throw new DAOException( "Échec de la création de l'etudiant en base, aucun ID auto-généré retourné." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    } 

		
	}


	public void creerQR(QR q) {
				    
		    creerQRInfo(q);
		    creerReponseQr(q.getAnswerList());
		    
		    if(q.getModuleQR()==Constants.MODULE_MEMOIRE){
		    	SimulationMemoire simm = (SimulationMemoire)q.getSimulation();
		    	creerParamQrMemoire(simm);
		    	creerMemoireProcessusQr(simm.getListeProcessus());
		    	
		    	if(q.getSimulation().getManagement()=="PAG"){
		    		
		    		for(int i=0; i<simm.getListeProcessus().size();i++){
		    			List<Bid> bids = simm.getListeProcessus().get(i).getListBid();
		    			if (bids != null) 	creerBidMemoire(bids);
		    			
		    		}	
		    	}
		    	
		    }else if(q.getModuleQR()==Constants.MODULE_PROCESS){
		    	SimulationProcessus simulation=(SimulationProcessus) q.getSimulation();
		    	creerParamQrProcessus(simulation);
		    	creerProcessusQr(simulation.getListeProcessus());
		    	
		    }

	}

	public List<QR> getAllQr() 
			throws DAOException {
	    	Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    List<QR> listOfQr = new ArrayList<QR>();
	    	// Statements allow to issue SQL queries to the database
	    	try {
	    		
	    		connexion = factoryDAO.getConnection();
	    		preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_LIST_QUESTION),false);

	    		resultSet = preparedStatement.executeQuery();
	    		
	    		while (resultSet.next()) {
	    			listOfQr.add(mapQR(resultSet));
	    			}

	    		} catch ( SQLException e ) {
	    			throw new DAOException( e );
	    		} finally {
	    			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    		}
	    		return listOfQr;
	    	}
	
	public List<QR> getAllQrFromExercice(int idExercice) 
			throws DAOException {
	    	Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    List<QR> listOfQrFromExercice = new ArrayList<QR>();
	    	// Statements allow to issue SQL queries to the database
	    	try {
	    		
	    		connexion = factoryDAO.getConnection();
	    		preparedStatement = initialisationRequetePreparee( connexion,DAOUtils.getProperties().getProperty(Constants.REQ_LIST_TITRE_QR_BY_EXERCICE),false, idExercice);

	    		resultSet = preparedStatement.executeQuery();
	    		
	    		while (resultSet.next()) {
	    			listOfQrFromExercice.add(mapQR(resultSet));
	    			}

	    		} catch ( SQLException e ) {
	    			throw new DAOException( e );
	    		} finally {
	    			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    		}
	    		return listOfQrFromExercice;
	    	}
	
	
}

