package edu.upc.fib.ossim.mcq.model;



/**
 * Les processus composant une simulation du module Processus
 * 
 * @author Ghita
 *
 */
public class ProcessusSimulationProcessus {
	
	private int pid;
	private String name;
	private int submission;
	private boolean periodic;
	private int prio;
	private String bursts;
	private long color;
	private String variables;
	private String resources;
	private String typeQueue;
	
	
	

	public ProcessusSimulationProcessus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	public ProcessusSimulationProcessus(int pid, String name,
			int submission, boolean periodic, String bursts, long color,
			String variables, String resources, String typeQueue) {
		super();
		this.pid = pid;
		this.name = name;
		this.submission = submission;
		this.periodic = periodic;
		this.bursts = bursts;
		this.color = color;
		this.variables = variables;
		this.resources = resources;
		this.typeQueue = typeQueue;
	}




	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSubmission() {
		return submission;
	}
	public void setSubmission(int submission) {
		this.submission = submission;
	}
	public boolean isPeriodic() {
		return periodic;
	}
	public void setPeriodic(boolean periodic) {
		this.periodic = periodic;
	}
	public String getBursts() {
		return bursts;
	}
	public void setBursts(String bursts) {
		this.bursts = bursts;
	}
	public long getColor() {
		return color;
	}
	public void setColor(long color) {
		this.color = color;
	}
	public String getVariables() {
		return variables;
	}
	public void setVariables(String variables) {
		this.variables = variables;
	}
	public String getResources() {
		return resources;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}
	public String getTypeQueue() {
		return typeQueue;
	}
	public void setTypeQueue(String typeQueue) {
		this.typeQueue = typeQueue;
	}

	public int getPrio() {
		return prio;
	}

	public void setPrio(int prio) {
		this.prio = prio;
	}
	
	
	
}
