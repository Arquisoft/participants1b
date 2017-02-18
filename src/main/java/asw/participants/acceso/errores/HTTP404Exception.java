package asw.participants.acceso.errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "MENESNSN")
public class HTTP404Exception extends RuntimeException{
	
		private static final long serialVersionUID = 1L;
}
