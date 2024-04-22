package br.com.quon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequireObjectIsNullException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public RequireObjectIsNullException() {
		
		super("It is not allowed to persist a null object");
	}

	
	public RequireObjectIsNullException(String ex) {
		
		super(ex);
	}

	
}
