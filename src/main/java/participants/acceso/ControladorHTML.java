package participants.acceso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import participants.GetParticipant;

@Controller
@RequestMapping("/ControladorPeticion")
public class ControladorHTML {

	private final GetParticipant getParticipant;
	
	@Autowired
	ControladorHTML(GetParticipant getParticipant){
		this.getParticipant = getParticipant;
	}
	
	@RequestMapping("/formularioPeticiones")
	public String formulario(Model modelo){
		return "formularioPeticiones";
	}
	
	
	@RequestMapping(value = "/datosCiudadano", method = RequestMethod.GET)
	public String getHTML(Model modelo){
		return "ciudadano";
	}
	
	 
	@RequestMapping(value = "/logearse", method = RequestMethod.POST)
	public String postHTML(@RequestBody String parametros, Model modelo){
		
		//parametros = usuario=nombre&password=contraseña
		String[] p = parametros.split("&");
		
		//Usuario en blanco
		if(p[0].length() <= 8){
			//Lanzar error
		}
		
		//Contraseña en blanco
		if(p[1].length() <= 9){
			//Lanzar error
		}
		
		String usuario = p[0].split("=")[1];
		String password = p[1].split("=")[1];
		
		//Comprobar los datos
		
		return "ciudadano";
	}
}
