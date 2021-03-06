package edu.upc.fib.ossim.mcq;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import edu.upc.fib.ossim.mcq.model.Answer;
import edu.upc.fib.ossim.mcq.model.ProcessusSimulationProcessus;
import edu.upc.fib.ossim.mcq.model.QR;
import edu.upc.fib.ossim.mcq.model.SimulationProcessus;
import edu.upc.fib.ossim.mcq.view.PanelMCQCreatorProcess;
import edu.upc.fib.ossim.process.ProcessPresenter;
import edu.upc.fib.ossim.process.view.ProcessSettings;
import edu.upc.fib.ossim.template.view.PanelTemplate;
import edu.upc.fib.ossim.utils.Functions;
import edu.upc.fib.ossim.utils.SoSimException;

public class ProcessMCQCreatorPresenter extends ProcessPresenter{

	public ProcessMCQCreatorPresenter(boolean openSettings) {
		super(openSettings);
		// TODO Auto-generated constructor stub
	}
	@Override
	public PanelTemplate createPanelComponents() {
		super.createPanelComponents();
		return new PanelMCQCreatorProcess(this,"pr_42");
	}
	@Override
	public String getXMLRoot() {
		// Returns XML root element 
		return  Functions.getInstance().getPropertyString("xml_root_mcq_pro");
	}
	@Override
	public Vector<String> getXMLChilds() {
		Vector<String> childs = super.getXMLChilds();
		childs.add("mcq");
		return childs;
	}
	@Override
	public Vector<Vector<Vector<String>>> getXMLData(int child) {
		Vector<Vector<Vector<String>>> data = null;
		if(child!=3)
			data = super.getXMLData(child);
		else{
			data = MCQSession.getInstance().getmcqCreationPanel().getXMLData();
		}
		return data;
	}
	@Override
	public void putXMLData(int child, Vector<Vector<Vector<String>>> data) throws SoSimException {
		if(child!=3)
			super.putXMLData(child, data);
		else{
			int blockOnStep = new Integer (data.get(0).get(3).get(1)).intValue();
			int nbrAnswers = new Integer(data.get(0).get(4).get(1)).intValue();
			boolean includeAnswers = data.get(0).get(5).get(1).equals("true");
			System.out.println(includeAnswers);
			String question = data.get(0).get(1).get(1);
			ArrayList<String> answers = new ArrayList<String>();
			int answerType = Integer.parseInt(data.get(0).get(2).get(1));
			ArrayList<Boolean> answerbool = new ArrayList<Boolean>();
			int difficulty = new Integer(data.get(0).get(6).get(1)).intValue();
			for(int it = 1 ; it <= nbrAnswers; it++){
				if(answerType!=3){
					answers.add(data.get(it).get(1).get(1));
					if(includeAnswers){
						if(data.get(it).get(2).get(1).equals("true"))
							answerbool.add(new Boolean(true));
						else
							answerbool.add(new Boolean(false));
					}
				}
				else{
					answers.add(data.get(it).get(2).get(1));
				}
			}
			MCQSession.getInstance().getmcqCreationPanel().fillData(question,answerType, answers, answerbool,includeAnswers,blockOnStep,difficulty);
		}
	}
	@Override
	public void putBDData(QR qr) throws SoSimException {
		try {
			super.putBDData(qr);
			int blockOnStep = qr.getBlockOnStep();
			int nbrAnswers = qr.getAnswerNumber();
			boolean includeAnswers = qr.isIncludeAnswers();
			String question = qr.getEnonce();
			ArrayList<String> answers = new ArrayList<String>();
			List<Answer> listAnswers=qr.getAnswerList();
			int answerType =qr.getAnswerNumber();
			ArrayList<Boolean> answerbool = new ArrayList<Boolean>();
			int difficulty = qr.getDifficulty();
			for(int it = 1 ; it <= listAnswers.size(); it++){
				if(answerType!=3){
					answers.add(listAnswers.get(it).getText());
					if(includeAnswers){
						if(listAnswers.get(it).isValue())
							answerbool.add(new Boolean(true));
						else
							answerbool.add(new Boolean(false));
					}
				}
				else{
					answers.add(String.valueOf(listAnswers.get(it).isValue()));
				}
			}
			MCQSession.getInstance().getmcqCreationPanel().fillData(question,answerType, answers, answerbool,includeAnswers,blockOnStep,difficulty);

		} catch (Exception e) {

		}
	}
}

