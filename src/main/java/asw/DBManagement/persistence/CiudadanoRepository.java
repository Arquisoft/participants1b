package asw.DBManagement.persistence;

import org.springframework.data.repository.CrudRepository;

import asw.DBManagement.model.Ciudadano;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface CiudadanoRepository extends CrudRepository<Ciudadano, Long> {

	Ciudadano findByEmail(String email);
}
