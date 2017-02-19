package asw.DBManagement;

import asw.DBManagement.model.Ciudadano;
import asw.participants.acceso.ChangeInfo;
import asw.participants.acceso.ParticipantsInfo;

/**
 * 
 * @author Ramon Sobrino Llorca
 *
 */
public interface UpdateInfo{

	public boolean UpdateCitizen(Ciudadano ciudadano);
	public Ciudadano UpdateCitizen(ChangeInfo info);
}
