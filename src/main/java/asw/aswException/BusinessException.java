package asw.aswException;

import java.io.IOException;

public class BusinessException extends IOException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
