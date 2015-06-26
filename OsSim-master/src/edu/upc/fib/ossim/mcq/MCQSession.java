package edu.upc.fib.ossim.mcq;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import edu.upc.fib.ossim.mcq.view.MCQChooserDialog;
import edu.upc.fib.ossim.mcq.view.MCQCreationPanel;
import edu.upc.fib.ossim.mcq.view.MCQDisplayExo;
import edu.upc.fib.ossim.mcq.view.MCQQuestionLinker;
import edu.upc.fib.ossim.mcq.view.MCQViewPanel;
import edu.upc.fib.ossim.mcq.view.PanelAuthentification;
import edu.upc.fib.ossim.mcq.view.PanelAuthentification.Module;
import edu.upc.fib.ossim.mcq.view.PanelHistoryEtudiant;
import edu.upc.fib.ossim.mcq.view.PanelHistoryProfesseur;

public class MCQSession {

	private MediumPanel medium = null;
	private boolean saved=false;
	private MCQCreationPanel mcqCreationPanel = null;
	private MCQViewPanel mcqViewPanel = null;
	private Hashtable<Integer,String> answers = new Hashtable<Integer, String>();
	private static MCQSession instance = null;
	private MCQChooserDialog chooser = null;
	private MCQDisplayExo chooserDisplayExo = null;
	private PanelAuthentification authepanel = null;
	private PanelHistoryEtudiant historyStudentPanel = null;
	private PanelHistoryProfesseur historyProfesseurpanel = null;
	private Hashtable<Integer,String> correctAnswers = new Hashtable<Integer, String>();
	
	private int result=0;


	private MCQSession(){}

	public PanelAuthentification getAuthPanel(Module m){
		authepanel = new PanelAuthentification(m);
		return authepanel;
	}

	public MediumPanel getMediumPanel(){
		if(medium ==null) medium = new MediumPanel();
		return medium;
	}

	public PanelHistoryEtudiant getHistoryStudentPanel(){
		if(historyStudentPanel ==null) historyStudentPanel = new PanelHistoryEtudiant();
		return historyStudentPanel;
	}

	public PanelHistoryProfesseur getHistoryProfesseurPanel(int id){
		historyProfesseurpanel = new PanelHistoryProfesseur(id);
		return historyProfesseurpanel;
	}

	public void hideMediumPanel(){
		if(medium!=null) medium.setVisible(false);
	}


	public MCQCreationPanel getmcqCreationPanel(){
		if(mcqCreationPanel ==null)
			mcqCreationPanel = new MCQCreationPanel(MCQSession.getInstance().getMediumPanel().getAnswerType(), MCQSession.getInstance().getMediumPanel().getnbrAnswers());
		return mcqCreationPanel;
	}
	public MCQCreationPanel getmcqCreationPanel(int type,int nbrAnswers){
		mcqCreationPanel = new MCQCreationPanel(type, nbrAnswers);
		return mcqCreationPanel;
	}

	public MCQViewPanel getmcqViewPanel(int nbrQuestion, String question, int answerType,int nbrAnswers, List<String> answers,int blockOnStep,String correctAnswer){
		mcqViewPanel = new MCQViewPanel(question, answerType, nbrAnswers, answers, blockOnStep,correctAnswer);
		return mcqViewPanel;
	}
	public MCQViewPanel getmcqViewPanel(){
		if(mcqViewPanel == null)
			mcqViewPanel = new MCQViewPanel();
		return mcqViewPanel;
	}
	public void destroyMCQViewPanel(){
		mcqViewPanel = null;
	}

	public static MCQSession getInstance(){
		if(instance == null) instance = new MCQSession();
		return instance;
	}

	public static void destroyInstance(){
		instance = null;
	}
	public MCQChooserDialog getMCQChooserDialog(){
		if(chooser == null)chooser = new MCQChooserDialog(); 
		return chooser;
	}

	public MCQDisplayExo getMCQDisplayExo(){
		if(chooserDisplayExo == null)chooserDisplayExo = new MCQDisplayExo(); 
		return chooserDisplayExo;
	}

	public void addAnswer(int nbr, String Answer){
		answers.put(nbr, Answer);
	}
	public String getCorrectAnswer(int nbr){
		return correctAnswers.get(nbr);
	}
	public void addCorrectAnswer(int nbr, String Answer){
		correctAnswers.put(nbr, Answer);
	}
	public String getAnswer(int nbr){
		return answers.get(nbr);
	}
	public void saveXML(){
		Element root = new Element("qcm_answers");
		Document doc = new Document(root);
		doc.setRootElement(root);
		int it = 1;
		Element answer ; 
		while(answers.get(it)!=null){
			answer = new Element("question");
			answer.setAttribute("id",""+it);
			answer.addContent(new Element("answer",answers.get(it)));
			doc.getRootElement().addContent(answer);
			it++;
		}
		XMLOutputter xmlOutput = new XMLOutputter();

		xmlOutput.setFormat(Format.getPrettyFormat());
		try {
			String path = System.getProperty("user.dir");
			xmlOutput.output(doc, new FileWriter(path+chooser.getName()+".xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  void onDisconnect(){	
		if (medium != null){
			medium.dispose();
			medium = null;
		}
		/*if (mcqCreationPanel != null)
			mcqCreationPanel.dispose();
		if (mcqViewPanel != null)
			mcqViewPanel.dispose();
		if(instance != null)
			instance.dispose();*/
		if(authepanel!= null){
			authepanel.dispose();
			authepanel = null;
		}

		if (historyProfesseurpanel!= null){
			historyProfesseurpanel.dispose();
			historyProfesseurpanel = null;
		}
		if(historyStudentPanel!= null){
			historyStudentPanel.dispose();
			historyProfesseurpanel = null;
		}
		if( chooserDisplayExo != null){
			chooserDisplayExo.dispose();
			chooserDisplayExo = null;
		}
		MCQQuestionLinker.closeInstance();



	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	
	
}
