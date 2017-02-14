package DBManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DBManagement.UpdateInfo;
import DBManagement.model.Ciudadano;
import DBManagement.persistence.CiudadanoRepository;

@Component
public class UpdateInfoDB implements UpdateInfo {


	@Autowired
	private CiudadanoRepository repositorio; 
	
	@Override
	public boolean UpdateCitizen(Ciudadano ciudadano) {
		Ciudadano citizen  =repositorio.save(ciudadano);
		return citizen.equals(ciudadano);
	}

}
