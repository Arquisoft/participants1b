package asw.participants.acceso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asw.DBManagement.GetParticipant;
import asw.DBManagement.impl.GetParticipantDB;
import asw.DBManagement.model.Ciudadano;
import asw.DBManagement.persistence.CiudadanoRepository;
import asw.participants.acceso.errores.HTTP404Exception;

@Controller
public class ControladorHTML {

	@SuppressWarnings("unused")
	@Autowired
	private GetParticipantDB getParticipantDB;
	@Autowired
	private CiudadanoRepository repositorio;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHTML(Model modelo){
		return "login";
	}
	
	@RequestMapping(
			value = "/logearse",
			method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ParticipantsInfo> postHTML(@RequestBody ParticipantsLogin info){
	
		if (info == null) {
			throw new HTTP404Exception();
		}
		
		Ciudadano ci = getParticipantDB.getCiudadano(info);
		
		
		if (ci == null) {
			throw new HTTP404Exception();
		}
		if(!ci.getPassword().equals(info.getPassword()))
		{
			throw new HTTP404Exception();
		}
		
		return new ResponseEntity<ParticipantsInfo>(new ParticipantsInfo(ci), HttpStatus.OK);
	}
	
}
