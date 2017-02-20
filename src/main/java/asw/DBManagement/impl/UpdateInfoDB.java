package asw.DBManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import asw.DBManagement.UpdateInfo;
import asw.DBManagement.model.Ciudadano;
import asw.DBManagement.persistence.CiudadanoRepository;
import asw.participants.acceso.ChangePassword;

@Component
public class UpdateInfoDB implements UpdateInfo {


    @Autowired
    private CiudadanoRepository repositorio;

    @Override
    public boolean UpdateCitizen(Ciudadano ciudadano) {
        Ciudadano citizen = repositorio.save(ciudadano);
        return citizen.equals(ciudadano);
    }

	@Override
	public Ciudadano UpdateCitizen(ChangePassword info) {

		Ciudadano citizen = repositorio.findByEmail(info.getEmail());
		if(citizen==null)return null;
		if(!citizen.getPassword().equals(info.getPassword())) return null;
		
		citizen.setPassword(info.getNewPassword());
		repositorio.save(citizen);
		return citizen;
	}

}
