package com.daniel.cursomc.services.exceptions;

public class FileEmptyException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public FileEmptyException(String msg) {
		super(msg);
	}
	
	public FileEmptyException(String msg, Throwable cause) {
		super(msg);
	}	
}
