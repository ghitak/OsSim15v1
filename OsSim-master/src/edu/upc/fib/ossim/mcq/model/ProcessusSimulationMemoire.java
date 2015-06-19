package edu.upc.fib.ossim.mcq.model;

import java.util.List;


/**
 * Les processus composant une simulation du module mémoire
 * 
 * @author Ghita
 *
 */
public class ProcessusSimulationMemoire { 
	
	private int idQR;
	private int pid;
	private String name;
	private int size;
	private int duration;
	private long color;
	private int quantum;
	private String quantumOrders;
	private List <Bid> ListBid;
	
	
		
	public ProcessusSimulationMemoire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProcessusSimulationMemoire(int pid, String name, int size,
			int duration, long color, int quantum, String quantumOrders,
			List<Bid> listBid) {
		super();
		this.pid = pid;
		this.name = name;
		this.size = size;
		this.duration = duration;
		this.color = color;
		this.quantum = quantum;
		this.quantumOrders = quantumOrders;
		ListBid = listBid;
	}




	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Bid> getListBid() {
		return ListBid;
	}

	public void setListBid(List<Bid> listBid) {
		ListBid = listBid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public long getColor() {
		return color;
	}
	public void setColor(long color) {
		this.color = color;
	}
	public int getQuantum() {
		return quantum;
	}
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

	

	public String getQuantumOrders() {
		return quantumOrders;
	}

	public void setQuantumOrders(String quantumOrders) {
		this.quantumOrders = quantumOrders;
	}

	public int getIdQR() {
		return idQR;
	}

	public void setIdQR(int idQR) {
		this.idQR = idQR;
	}
	
	
}
