package asw.participants.acceso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import asw.DBManagement.GetParticipant;
import asw.DBManagement.model.Ciudadano;
import asw.participants.GetParticipantInfo;
import asw.participants.acceso.errores.HTTP404Exception;

@RestController
public class GetParticipantInfoController implements GetParticipantInfo{
	
	@Autowired
	private final GetParticipant getParticipantDB;
	
	
	@Autowired
	GetParticipantInfoController(GetParticipant getParticipant)
	{
		this.getParticipantDB = getParticipant;
	}
	
	
	@RequestMapping(value = "/user",
			method = RequestMethod.POST,
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ParticipantsInfo> getInfoParticipant(@RequestBody ParticipantsLogin info){
		
		if (info.getEmail() == null || info.getPassword() == null
				|| info.getEmail().equals("") || info.getPassword().equals("")) {
			throw new HTTP404Exception("No se han intriducido datos");
		}
		
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]");
        Matcher mat = pattern.matcher(info.getEmail());
        
        if(!mat.matches())
        	throw new HTTP404Exception("El email no cumple con el formato requerido");
		
		Ciudadano ci = getParticipantDB.getCiudadano(info);
		
		
		if (ci == null) {
			throw new HTTP404Exception("No existe un usuario con ese email");
		}
		if(!ci.getPassword().equals(info.getPassword()))
		{
			throw new HTTP404Exception("Contraseña incorrecta");
		}
		
		return new ResponseEntity<ParticipantsInfo>(new ParticipantsInfo(ci), HttpStatus.OK);
	}
	
	@ExceptionHandler(HTTP404Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleErrorResponses(HTTP404Exception excep)
	{
		return excep.getMessageJSON();
	}
	
	
}
