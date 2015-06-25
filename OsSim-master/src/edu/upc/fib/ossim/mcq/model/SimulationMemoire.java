package edu.upc.fib.ossim.mcq.model;

import java.util.List;

public class SimulationMemoire extends Simulation {
	
	private int memorySize;
	private int soSize;
	private int pageSize;
	private String policy;
	private List<ProcessusSimulationMemoire> ListeProcessus;
	
	
	
	public SimulationMemoire(int memorySize, int soSize, int pageSize,
			String policy) {
		super();
		this.memorySize = memorySize;
		this.soSize = soSize;
		this.pageSize = pageSize;
		this.policy = policy;
	}
	public SimulationMemoire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}
	public int getSoSize() {
		return soSize;
	}
	public void setSoSize(int soSize) {
		this.soSize = soSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String i) {
		this.policy = i;
	}
	public List<ProcessusSimulationMemoire> getListeProcessus() {
		return ListeProcessus;
	}
	public void setListeProcessus(List<ProcessusSimulationMemoire> listeProcessus) {
		ListeProcessus = listeProcessus;
	}
	
	

}

