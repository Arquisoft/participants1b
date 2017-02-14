package DBManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DBManagement.GetParticipant;
import DBManagement.model.Ciudadano;
import DBManagement.persistence.CiudadanoRepository;

@Component
public class GetParticipantDB implements GetParticipant{

	@Autowired
	private CiudadanoRepository repositorio; 
	
	@Override
	public Ciudadano getCiudadano(String nombre) {
		Ciudadano citizen = repositorio.findByNombre(nombre);
		return citizen;
	}


}
