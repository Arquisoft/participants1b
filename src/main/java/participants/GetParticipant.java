package Participants;

import DBManagement.model.Ciudadano;

/**
 * Devuelve la informacion para el usuario
 * @author Pablo
 *
 */
public interface GetParticipant {

		Ciudadano findByNombreUsuario(String nombre);
}
