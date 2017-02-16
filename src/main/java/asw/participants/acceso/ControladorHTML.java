package asw.participants.acceso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asw.DBManagement.GetParticipant;
import asw.DBManagement.model.Ciudadano;
import asw.participants.HTTP404Exception;

@Controller
@RequestMapping("/ControladorPeticion")
public class ControladorHTML {

	@Autowired
	private GetParticipant getParticipants;
	
	
	ControladorHTML(GetParticipant getParticipants){
		this.getParticipants = getParticipants;
	}
	
	
	@RequestMapping(value = "/datosCiudadano", method = RequestMethod.GET)
	public String getHTML(Model modelo){
		return "ciudadano";
	}
	
	//TODO Tratamiento de errores
	@RequestMapping(value = "/logearse", method = RequestMethod.POST)
	public String postHTML(@RequestBody String parametros, Ciudadano citizen){
		
		//parametros = usuario=nombre&password=contraseña
		String[] p = parametros.split(",");
		
		//Usuario en blanco
		if(p[0].length() <= 8){
			throw new HTTP404Exception();
		}
		
		//Contraseña en blanco
		if(p[1].length() <= 9){
			throw new HTTP404Exception();  //Lanzar error
		}
		
		String usuario = p[0].split("=")[1];
		String password = p[1].split("=")[1];
		
		System.out.println("peep");
		
		try{
			
			List<Ciudadano> ciudadanos = getParticipants.getCiudadano(usuario);
			
			if(ciudadanos!=null)
			{
				Ciudadano ci = ciudadanos.get(0);
				
				if(ci.getEmail().equals(usuario)&&ci.getPassword().equals(password))
				{
					//Revisar lo devuelto
					return"Todo bien";
				}
				else
				{
					throw new HTTP404Exception();
				}
			}
			else
			{
				throw new HTTP404Exception();
			}
			
		}
		catch(Exception e){
			throw new HTTP404Exception();
		}
		
	}
}
