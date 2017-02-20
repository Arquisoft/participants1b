package asw.participants.acceso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import asw.DBManagement.impl.UpdateInfoDB;
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
	@Autowired
	private UpdateInfoDB updateInfo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHTML(Model modelo){
		return "login";
	}
	
//	@RequestMapping(value = "/logearse", method = RequestMethod.POST)
//	public String postHTML(@RequestBody String parametros, Model modelo){
//		
//	}
	
}
