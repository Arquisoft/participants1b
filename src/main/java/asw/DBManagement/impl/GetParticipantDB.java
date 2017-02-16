package asw.DBManagement.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import asw.DBManagement.GetParticipant;
import asw.DBManagement.model.Ciudadano;
import asw.DBManagement.persistence.CiudadanoRepository;

@Component
public class GetParticipantDB implements GetParticipant{

	@Autowired
	private CiudadanoRepository repositorio; 
	
	@Override
	public List<Ciudadano> getCiudadano(String email) {
		List<Ciudadano> citizens = repositorio.findByEmail(email);
		return citizens;
	}


}
