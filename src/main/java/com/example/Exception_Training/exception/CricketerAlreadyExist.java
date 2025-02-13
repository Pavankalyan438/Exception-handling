package com.example.Exception_Training.exception;

public class CricketerAlreadyExist extends RuntimeException {
	private String msg;
	public CricketerAlreadyExist() {
		// TODO Auto-generated constructor stub
	}
	public CricketerAlreadyExist(String msg) {
		super(msg);
		this.msg = msg;
	}
	

}
