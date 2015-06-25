package edu.upc.fib.ossim.dao;
/**
 * @author saksaka
 *
 */

import java.util.List;

import edu.upc.fib.ossim.mcq.model.Answer;
import edu.upc.fib.ossim.mcq.model.Bid;
import edu.upc.fib.ossim.mcq.model.ProcessusSimulationMemoire;
import edu.upc.fib.ossim.mcq.model.ProcessusSimulationProcessus;
import edu.upc.fib.ossim.mcq.model.QR;
import edu.upc.fib.ossim.mcq.model.SimulationMemoire;
import edu.upc.fib.ossim.mcq.model.SimulationProcessus;

public interface QrDAO {
	  QR getInfoQR(int IdQR);
	  List<Answer>getAnswersQR(int IdQR);
	  List<Bid> getBidByProc(int id_Proc,int id_qr);
	  List<ProcessusSimulationMemoire> getProcQRMem(int idQR);

	  List<QR> getAllQr();

	  List<ProcessusSimulationProcessus> getProcQRProcArriving(int idQR);
	  List<ProcessusSimulationProcessus> getProcQRProcReady(int idQR);
	  SimulationProcessus getParamQRProc(int idQR);
	  SimulationMemoire getParamQRMem(int idQR);
	  void creerQRInfo(QR q);
	  void creerReponseQr(List<Answer> ans, int idQr);
	  void creerParamQrProcessus(SimulationProcessus simp, int idQr);
	  void creerParamQrMemoire(SimulationMemoire simm, int idQr);
	  void creerProcessusQr(List<ProcessusSimulationProcessus> listroA,int idQr);
	  void creerMemoireProcessusQr(List<ProcessusSimulationMemoire> listpro,int idQr);
	  void creerBidMemoire(List<Bid> bid,int idQr);

	  
	  QR findQR(int idQR);
	  void creerQR(QR q);
  
	  public List<QR> getAllQrFromExercice(int idExercice);


}

