package edu.upc.fib.ossim.mcq.model;

import java.util.List;

public class QR {
	
	private int idQR;
	private int moduleQR; // Module de la question/réponse (mémoire ou processus)
	private int blockOnStep;
	private String titleQr;
	private String enonce;
	private String qrtitle;
	
	public String getQrtitle() {
		return qrtitle;
	}

	public void setQrtitle(String qrtitle) {
		this.qrtitle = qrtitle;
	}

	private boolean includeAnswers;
	private int difficulty;
	private int answerType;
	private int answerNumber;
	private Simulation simulation;
	private List<Answer> answerList;
	
	

	public QR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QR(int moduleQR, String titleQr,int blockOnStep, String enonce,
			boolean includeAnswers, int difficulty, int answerType,
			int answerNumber, Simulation simulation, List<Answer> answerList) {
		super();
		this.moduleQR = moduleQR;
		this.blockOnStep = blockOnStep;
		this.enonce = enonce;
		this.includeAnswers = includeAnswers;
		this.difficulty = difficulty;
		this.answerType = answerType;
		this.answerNumber = answerNumber;
		this.simulation = simulation;
		this.answerList = answerList;
		this.titleQr = titleQr;
	}


	
	/**
	 * @return the titleQr
	 */
	public String getTitleQr() {
		return titleQr;
	}

	/**
	 * @param titleQr the titleQr to set
	 */
	public void setTitleQr(String titleQr) {
		this.titleQr = titleQr;
	}

	public int getIdQR() {
		return idQR;
	}

	public void setIdQR(int idQR) {
		this.idQR = idQR;
	}

	public int getAnswerNumber() {
		return answerNumber;
	}
	public void setAnswerNumber(int answerNumber) {
		this.answerNumber = answerNumber;
	}
	public int getModuleQR() {
		return moduleQR;
	}
	public void setModuleQR(int moduleQR) {
		this.moduleQR = moduleQR;
	}
	public int getBlockOnStep() {
		return blockOnStep;
	}
	public void setBlockOnStep(int blockOnStep) {
		this.blockOnStep = blockOnStep;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public boolean isIncludeAnswers() {
		return includeAnswers;
	}
	public void setIncludeAnswers(boolean includeAnswers) {
		this.includeAnswers = includeAnswers;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public int getAnswerType() {
		return answerType;
	}
	public void setAnswerType(int type) {
		this.answerType = type;
	}
	public Simulation getSimulation() {
		return simulation;
	}
	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	

	
	

}
