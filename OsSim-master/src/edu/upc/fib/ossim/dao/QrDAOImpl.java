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
import edu.upc.fib.ossim.mcq.model.Exercice;
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

	
	public List getProcQR(int idQR) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List getBidByProc(int id_Proc) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List getProcQRMem(int idQR) {
		// TODO Auto-generated method stub
		return null;
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

	
	public void creerQRProcessus(QR q) {
		// TODO Auto-generated method stub
		
	}

	
	public void creerQRMemoire(QR q) {
		// TODO Auto-generated method stub
		
	}

	
	public void creerReponseQr() {
		// TODO Auto-generated method stub
		
	}

	
	public void creerParamQrProcessus() {
		// TODO Auto-generated method stub
		
	}

	
	public void creerParamQrMemoire() {
		// TODO Auto-generated method stub
		
	}

	
	public void creerProcessusQr() {
		// TODO Auto-generated method stub
		
	}

	
	public void creerProcessusQrArriving() {
		// TODO Auto-generated method stub
		
	}

	
	public void creerProcessusQrReady() {
		// TODO Auto-generated method stub
		
	}

	
	public void creerMemoireProcessusQr() {
		// TODO Auto-generated method stub
		
	}

	
	public void creerBidMemoire() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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
	    			listProcessMemoire.get(i).setList_Bid(bids);
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
		qr.setBlockOnStep(resultSet.getInt("blockOnStep"));
		qr.setEnonce(resultSet.getString("question"));
		qr.setModuleQR(resultSet.getInt("mod_QR"));
		qr.setIncludeAnswers(resultSet.getBoolean("includeAnswers"));
		qr.setDifficulty(resultSet.getInt("difficulty"));
		qr.setAnswerType(resultSet.getInt("answerType"));		
		return qr;
	}
}

