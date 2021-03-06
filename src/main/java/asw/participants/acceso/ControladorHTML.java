package asw.participants.acceso;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asw.DBManagement.impl.GetParticipantDB;
import asw.DBManagement.model.Ciudadano;
import asw.DBManagement.persistence.CiudadanoRepository;

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
	
	@RequestMapping(value = "/changeInfo", method = RequestMethod.GET)
	public String getHTMLChange(Model modelo){
		return "changeInfo";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String postHTML(@RequestBody String parametros, Model modelo){
		//parametros = email=nombre&password=contraseña
		String[] p = parametros.split("&");
		
		//Usuario en blanco
		if(p[0].length() <= 8){
			modelo.addAttribute("error", "Usuario en blanco.");
			return "error";
		}
		
		//Contraseña en blanco
		if(p[1].length() <= 9){
			modelo.addAttribute("error", "Contraseña en blanco.");
			return "error";
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
					modelo.addAttribute("error", "Email no coincide.");
					return "error";
				}
		
				if(!ciudadano.getPassword().equals(password))
				{
					modelo.addAttribute("error", "La contraseña no coincide con la del usuario.");
					return "error";
				}

				
				if(ciudadano != null){
					modelo.addAttribute("apellido", ciudadano.getApellidos());
					modelo.addAttribute("nombre", ciudadano.getNombre());
					String f = ciudadano.getFechaNacimiento().toString().substring(0, 10);
					modelo.addAttribute("edad", edad(f));
					modelo.addAttribute("dni", ciudadano.getDni());
					modelo.addAttribute("email", ciudadano.getEmail());
				}
				return "user";
			}
			
			modelo.addAttribute("error", "Usuario no registrado.");
			return "error";
			
			}catch(Exception e){
				modelo.addAttribute("error", "Ha ocurrido en error al conseguir los datos del usuario.");
				return "error";
			
			}
	}
	
	protected int edad(String fecha_nac) {
		   
	    Date fechaActual = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	    String hoy = formato.format(fechaActual);
	    String[] dat1 = fecha_nac.split("-");
	    String[] dat2 = hoy.split("-");
	    int edad = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
	    int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
	    if (mes < 0) {
	    	edad = edad - 1;
	    } else if (mes == 0) {
	      int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
	      if (dia > 0) {
	    	  edad = edad - 1;
	      }
	    }
	    return edad;
	    
	  }
}
