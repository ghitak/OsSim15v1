package edu.upc.fib.ossim.mcq.model;


import java.util.List;

public class SimulationProcessus extends Simulation {
	
	private boolean multiprograming;
	private boolean preemptive;
	private int quantum;
	private boolean var;
	private int verrou;
	
	
	
	private List<ProcessusSimulationProcessus> ListeProcessus;
	
	
	
	
	public SimulationProcessus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SimulationProcessus(boolean multiprograming, boolean preemptive,
			int quantum, boolean var, int verrou,
			List<ProcessusSimulationProcessus> listeProcessus) {
		super();
		this.multiprograming = multiprograming;
		this.preemptive = preemptive;
		this.quantum = quantum;
		this.var = var;
		this.verrou = verrou;
		ListeProcessus = listeProcessus;
	}

	public boolean isMultiprograming() {
		return multiprograming;
	}
	public void setMultiprograming(boolean multiprograming) {
		this.multiprograming = multiprograming;
	}
	public boolean isPreemptive() {
		return preemptive;
	}
	public void setPreemptive(boolean preemptive) {
		this.preemptive = preemptive;
	}
	public int getQuantum() {
		return quantum;
	}
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
	public boolean isVar() {
		return var;
	}
	public void setVar(boolean var) {
		this.var = var;
	}

	public int getVerrou() {
		return verrou;
	}
	public void setVerrou(int verrou) {
		this.verrou = verrou;
	}
	public List<ProcessusSimulationProcessus> getListeProcessus() {
		return ListeProcessus;
	}
	public void setListeProcessus(List<ProcessusSimulationProcessus> listeProcessus) {
		ListeProcessus = listeProcessus;
	}
	
	
	
	

}
