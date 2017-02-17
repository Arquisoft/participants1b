package asw.participants.acceso;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import asw.DBManagement.impl.GetParticipantDB;
import asw.DBManagement.model.Ciudadano;
import asw.participants.GetParticipantInfo;

public class GetParticipantInfoController implements GetParticipantInfo{

	@Override
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Ciudadano getParticipantData(@RequestParam(value="login") String login,@RequestParam(value="password") String password) {
		GetParticipantDB getPart = new GetParticipantDB();
		Ciudadano ciudadano = getPart.getCiudadano(login);
		
		return ciudadano;
	}

}
