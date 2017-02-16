package asw.DBManagement;

import java.util.List;

import asw.DBManagement.model.Ciudadano;

/**
 * 
 * @author Pablo
 *
 */

public interface GetParticipant{
	public List<Ciudadano> getCiudadano(String email);
}
