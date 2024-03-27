package deneme;
import java.util.*;
import java.lang.Exception;

public class InvalidLine extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidLine() {
		
	}
	
	public InvalidLine(String errorMessage) {
		super(errorMessage);
	}
	public InvalidLine(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public InvalidLine(Throwable err) {
		super(err);
	}
}
