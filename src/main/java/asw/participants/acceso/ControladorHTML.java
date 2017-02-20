package asw.participants.acceso;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

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
	
	private String emailSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHTML(Model modelo){
		return "login";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String postHTML(@RequestBody String parametros, Model modelo){
		
		//parametros = email=nombre&password=contraseña
		String[] p = parametros.split("&");
		
		//Usuario en blanco
		if(p[0].length() <= 8){
			throw new HTTP404Exception();
		}
		
		//Contraseña en blanco
		if(p[1].length() <= 9){
			throw new HTTP404Exception();
		}
		
		String email = p[0].split("=")[1];
		email = email.replace("%40", "@");
		String password = p[1].split("=")[1];
		
		//Comprobar los datos
		
		try{
			Ciudadano ciudadano = repositorio.findByEmail(email);
			if (ciudadano!= null)
			{
				if(!ciudadano.getEmail().equals(email))
				{
					//throw new HTTP404Exception();
					return "error";
				}
		
				if(!ciudadano.getPassword().equals(password))
				{
					//throw new HTTP404Exception();
					return "error";
				}
				
//				"firstName": Nombre,
//				 "lastName": Apellidos,
//				 "edad": Edad (se calculará a partir de la fecha de nacimiento)
//				"ID": Número documento identificativo,
//				 "email": email

				
				if(ciudadano != null){
					emailSession = ciudadano.getEmail();
					modelo.addAttribute("apellido", ciudadano.getApellidos());
					modelo.addAttribute("nombre", ciudadano.getNombre());
					modelo.addAttribute("edad", ciudadano.getFechaNacimiento());
					modelo.addAttribute("dni", ciudadano.getDni());
					modelo.addAttribute("email", ciudadano.getEmail());
				}
				return "user";
			}
			
			}catch(Exception e){
				throw new HTTP404Exception();
			
			}
			return "error";
	}
	
	@RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
	public String changeInfo(@RequestBody String parametros, Model modelo){
		String[] p = parametros.split("&");
		
		//Contraseña
		if(p[0].length() <= 9){
			modelo.addAttribute("error", "Contraseña en blanco");
			return "error";
		}
		
		//Nueva Contraseña en blanco
		if(p[1].length() <= 12){
			modelo.addAttribute("error", "Nueva contraseña en blanco");
			return "error";
		}
		
		//Repetir Contraseña en blanco
		if(p[2].length() <= 17){
			modelo.addAttribute("error", "Repetir nueva contraseña en blanco");
			return "error";
		}
		
		String pass = p[0].split("=")[1];
		String newPass = p[1].split("=")[1];
		String newPassAgain = p[2].split("=")[1];
		
		if(!newPass.equals(newPassAgain)){
			modelo.addAttribute("error", "La nueva contraseña y su repetición no coinciden.");
			return "error";
		}
		
		
		try{
			updateInfo.UpdateCitizen(new ChangePassword(emailSession, pass, newPass));
		}catch (Exception e){
			modelo.addAttribute("error", "Ha ocurrido un error al cambiar la contraseña");
			return "error";
		}
		
		
		return "user";
		
	}
	
}
