
/*<<<<<<< HEAD
>>>>>>> 14b0a3fc4e10ee42898de8097d53aebf8b6f60d8
package edu.upc.fib.ossim.dao;

import java.util.List;

import edu.upc.fib.ossim.mcq.model.Answer;
import edu.upc.fib.ossim.mcq.model.ProcessusSimulationProcessus;
import edu.upc.fib.ossim.mcq.model.QR;
import edu.upc.fib.ossim.mcq.model.Simulation;
import edu.upc.fib.ossim.mcq.model.SimulationMemoire;
import edu.upc.fib.ossim.mcq.model.SimulationProcessus;

public interface QrDAO {
	  QR getInfoQR(int IdQR);
	  List<Answer>getAnswersQR(int IdQR);
	  List getProcQR(int idQR);
	  List getBidByProc(int id_Proc);
	  List getProcQRMem(int idQR);
	  List<ProcessusSimulationProcessus> getProcQRProcArriving(int idQR);
	  List<ProcessusSimulationProcessus> getProcQRProcReady(int idQR);
	  SimulationProcessus getParamQRProc(int idQR);
	  SimulationMemoire getParamQRMem(int idQR);
	  void creerQRProcessus(QR q);
	  void creerQRMemoire(QR q);
	  void creerReponseQr();
	  void creerParamQrProcessus();
	  void creerParamQrMemoire();
	  void creerProcessusQr();
	  void creerProcessusQrArriving();
	  void creerProcessusQrReady();
	  void creerMemoireProcessusQr();
	  void creerBidMemoire();
	  
	  QR findQR(int idQR);

}
<<<<<<< HEAD
=======
=======*/

package edu.upc.fib.ossim.dao;

import java.util.List;

import edu.upc.fib.ossim.mcq.model.Answer;
import edu.upc.fib.ossim.mcq.model.Bid;
import edu.upc.fib.ossim.mcq.model.ProcessusSimulationMemoire;
import edu.upc.fib.ossim.mcq.model.ProcessusSimulationProcessus;
import edu.upc.fib.ossim.mcq.model.QR;
import edu.upc.fib.ossim.mcq.model.Simulation;
import edu.upc.fib.ossim.mcq.model.SimulationMemoire;
import edu.upc.fib.ossim.mcq.model.SimulationProcessus;

public interface QrDAO {
	  QR getInfoQR(int IdQR);
	  List<Answer>getAnswersQR(int IdQR);
	  List<Bid> getBidByProc(int id_Proc);
	  List<ProcessusSimulationMemoire> getProcQRMem(int idQR);
	  List<ProcessusSimulationProcessus> getProcQRProcArriving(int idQR);
	  List<ProcessusSimulationProcessus> getProcQRProcReady(int idQR);
	  SimulationProcessus getParamQRProc(int idQR);
	  SimulationMemoire getParamQRMem(int idQR);
	  void creerQRInfo(QR q);
	  void creerReponseQr(List<Answer> ans);
	  void creerParamQrProcessus(SimulationProcessus simp);
	  void creerParamQrMemoire(SimulationMemoire simm);
	  void creerProcessusQr(List<ProcessusSimulationProcessus> listroA);
	  void creerMemoireProcessusQr(List<ProcessusSimulationMemoire> listpro);
	  void creerBidMemoire(List<Bid> bid);
	  
	  QR findQR(int idQR);
	  void creerQR(QR q);

}

