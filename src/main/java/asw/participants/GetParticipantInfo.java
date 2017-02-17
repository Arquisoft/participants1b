package asw.participants;

import org.springframework.web.bind.annotation.RequestParam;

import asw.DBManagement.model.Ciudadano;

/**
 * Clase que permite al usuario entrar en sesión para comprobar sus datos
 * mediante combinacion email/contraseña
 * @author Pablo
 *
 */
public interface GetParticipantInfo{
		
	public Ciudadano getParticipantData(String name, String password );
}
