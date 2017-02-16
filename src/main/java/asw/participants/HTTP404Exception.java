/**
 * 
 */
package asw.participants;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ramón Sobrino Llorca
 *
 */
@ResponseStatus( value = HttpStatus.NOT_FOUND, reason="No such Order")

public class HTTP404Exception extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
