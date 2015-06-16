package edu.upc.fib.ossim.mcq.model;

public class Answer {
	
	private String text;
	private boolean value;
	
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(String text, boolean value) {
		super();
		this.text = text;
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	
	

}
