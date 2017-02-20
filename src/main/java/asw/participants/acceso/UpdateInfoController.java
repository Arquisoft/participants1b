package asw.participants.acceso;

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

import asw.DBManagement.UpdateInfo;
import asw.DBManagement.impl.UpdateInfoDB;
import asw.DBManagement.model.Ciudadano;
import asw.participants.acceso.errores.HTTP404Exception;

@RestController
public class UpdateInfoController {

	
	@Autowired
	private UpdateInfo updateInfo;
	
	@Autowired
	UpdateInfoController(UpdateInfoDB updateInfo)
	{
		this.updateInfo = updateInfo;
	}
	
	@RequestMapping(
			value = "/changeInfo",
			method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ChangePasswordInfo> postHTML2(@RequestBody ChangePassword info){
	
		if (info.getEmail() == null || info.getPassword() == null || info.getNewPassword() == null
				|| info.getEmail().equals("") || info.getPassword().equals("") || info.getNewPassword().equals("")) {
			throw new HTTP404Exception("No se han introducido todos los datos");
		}
		
		Ciudadano ci = updateInfo.UpdateCitizen(info);
		
		if (ci == null) {
			throw new HTTP404Exception("Email o contraseña incorrectas");
		}
		
		
		return new ResponseEntity<ChangePasswordInfo>(new ChangePasswordInfo("Se ha cambiado correctamente la contraseña"),
				HttpStatus.OK);
	}
	
	
	@ExceptionHandler(HTTP404Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleErrorResponses(HTTP404Exception excep)
	{
		return excep.getMessageJSON();
	}
}
