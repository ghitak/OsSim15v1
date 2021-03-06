package edu.upc.fib.ossim.mcq;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import edu.upc.fib.ossim.AppSession;
import edu.upc.fib.ossim.mcq.model.Answer;
import edu.upc.fib.ossim.mcq.model.QR;
import edu.upc.fib.ossim.mcq.view.MCQViewPanel;
import edu.upc.fib.ossim.mcq.view.PanelMCQViewProcess;
import edu.upc.fib.ossim.process.ProcessPresenter;
import edu.upc.fib.ossim.template.view.PanelTemplate;
import edu.upc.fib.ossim.utils.Functions;
import edu.upc.fib.ossim.utils.SoSimException;

public class ProcessMCQViewPresenter extends ProcessPresenter{
	
	
	public ProcessMCQViewPresenter(boolean openSettings) {
		super(false);
		// TODO Auto-generated constructor stub
		for(int it = 0 ; it < AppSession.getInstance().getMenu().getMenuCount() ; it++){
			try{
			AppSession.getInstance().getMenu().getMenu(it).setEnabled(false);
			}catch(Exception exc){
				
				//WEIRD BUG, Apparantly the code says there are 14 Menus available where in fact only 5 exists
			}
		}
		panel.disableRunning(true);
		
			
	}

	@Override
	public void actionStop() {
		super.actionStop();	
		panel.disableRunning(true);
	}
	@Override
	public PanelTemplate createPanelComponents() {
		super.createPanelComponents();
		return new PanelMCQViewProcess(this,"pr_42");
	}
	@Override
	public boolean actionTimer() {
		if(timecontrols.getTime() == MCQSession.getInstance().getmcqViewPanel().getBlock_on_step())
			{
			return true;
			}
		else if(timecontrols.getTime()> MCQSession.getInstance().getmcqViewPanel().getBlock_on_step() && MCQSession.getInstance().getmcqViewPanel().getBlock_on_step()>0){
			actionStop();
			timecontrols.stop();
			return true;
		}
		else 
			return super.actionTimer();
	}
	public String getXMLRoot() {
		// Returns XML root element 
		return  Functions.getInstance().getPropertyString("xml_root_mcq_pro");
	}
	public Vector<String> getXMLChilds() {
		Vector<String> childs = super.getXMLChilds();
		childs.add("mcq");
		return childs;
	}
	@Override
	public void putXMLData(int child, Vector<Vector<Vector<String>>> data) throws SoSimException {
		if(child!=3)
			super.putXMLData(child, data);
		else{
			int blockOnStep = new Integer (data.get(0).get(3).get(1)).intValue();
			System.out.println(""+blockOnStep);
			int nbrAnswers = new Integer(data.get(0).get(4).get(1)).intValue();
			boolean includeAnswers =  data.get(0).get(5).get(1).equals("true");
			ArrayList<String> answers = new ArrayList<String>();
			String correct_answers = "";
			for(int it = 1; it <= nbrAnswers; it++){
				answers.add(data.get(it).get(1).get(1));
				if(includeAnswers){
				correct_answers+=data.get(it).get(2).get(1);
				if(it!=nbrAnswers)
					correct_answers+=",";
				}
			}
			if(!includeAnswers)
				correct_answers = null;
			//MCQSession.getInstance().getmcqViewPanel(data.get(0).get(1).get(1), Integer.parseInt(data.get(0).get(2).get(1)), nbrAnswers, answers);
			((PanelMCQViewProcess)panel).addmcqViewPanel(MCQSession.getInstance().getmcqViewPanel(MCQSession.getInstance().getMCQChooserDialog().getQuestionNumber(),data.get(0).get(1).get(1), Integer.parseInt(data.get(0).get(2).get(1)), nbrAnswers, answers,blockOnStep,correct_answers));
			panel.disableRunning(true);
		}
	}
	
	@Override
	public void putBDData(QR qr) throws SoSimException {
		
		try {
			super.putBDData(qr);
			int blockOnStep = qr.getBlockOnStep();
			int nbrAnswers = qr.getAnswerNumber();
			boolean includeAnswers = qr.isIncludeAnswers();
			ArrayList<String> answers = new ArrayList<String>();
			String correct_answers = "";
			List<Answer> listAnswers=qr.getAnswerList();
			for(int it = 0 ; it < listAnswers.size(); it++){
				answers.add(listAnswers.get(it).getText());
				if(includeAnswers){
					correct_answers+=String.valueOf(listAnswers.get(it).isValue());
					if(it!=nbrAnswers)
					 correct_answers+=",";
				}
				
			}
			if(!includeAnswers)
				correct_answers=null;    
			try{
			((PanelMCQViewProcess)panel).addmcqViewPanel(MCQSession.getInstance().getmcqViewPanel(MCQSession.getInstance().getMCQDisplayExo().getQuestionNumber(),qr.getEnonce(), qr.getAnswerType(), nbrAnswers, answers,blockOnStep,correct_answers));
			}catch(Exception e) {
				System.out.println("ya pb ds putdata addmcqViewPanel"+e.toString());

			}
			panel.disableRunning(true);
		} catch (Exception e) {
			System.out.println("ya pb ds putdata promcqviewpresenter"+e.toString());

		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		//Do Nothing
	}
	
}
