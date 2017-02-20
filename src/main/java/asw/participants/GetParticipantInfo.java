package asw.participants;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import asw.participants.acceso.ParticipantsInfo;
import asw.participants.acceso.ParticipantsLogin;

/**
 * Clase que permite al usuario entrar en sesión para comprobar sus datos
 * mediante combinacion email/contraseña
 * @author Pablo
 *
 */
public interface GetParticipantInfo{
	public ResponseEntity<ParticipantsInfo> getInfoParticipant(@RequestBody ParticipantsLogin info);
}
