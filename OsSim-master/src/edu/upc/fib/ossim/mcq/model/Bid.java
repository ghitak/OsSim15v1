package edu.upc.fib.ossim.mcq.model;

/**
 * Les Bid composant un processus
 * 
 * @author Ghita
 *
 */
public class Bid {
	private int pid;
	private int idQR;
	private int num_Bid;
	private int size_Bid;
	private boolean load;
	
	
	
	public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bid(int num_Bid, int size_Bid, boolean load) {
		super();
		this.num_Bid = num_Bid;
		this.size_Bid = size_Bid;
		this.load = load;
	}
	

	public int getNum_Bid() {
		return num_Bid;
	}
	public void setNum_Bid(int num_Bid) {
		this.num_Bid = num_Bid;
	}
	public int getSize_Bid() {
		return size_Bid;
	}
	public void setSize_Bid(int size_Bid) {
		this.size_Bid = size_Bid;
	}
	public boolean isLoad() {
		return load;
	}
	public void setLoad(boolean load) {
		this.load = load;
	}
	public int getIdQR() {
		return idQR;
	}
	public void setIdQR(int idQR) {
		this.idQR = idQR;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	

}
