package com.daniel.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
		
	}

	public List<FieldMessage> getErrors() {
		return erros;
	}

	public void addError(String fileName, String message) {
		erros.add(new FieldMessage(fileName,message));
	}

	
}
