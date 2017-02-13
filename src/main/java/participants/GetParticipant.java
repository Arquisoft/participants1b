package Participants;

import DBManagement.model.Ciudadano;

import org.springframework.data.repository.CrudRepository;

import participants.dbManagement.modelo.Ciudadano;

/**
 * Devuelve la informacion para el usuario
 * @author Pablo
 *
 */
public interface GetParticipant extends CrudRepository<Ciudadano, Long>{

		//Ciudadano findByNombreUsuario(String nombre);
}
