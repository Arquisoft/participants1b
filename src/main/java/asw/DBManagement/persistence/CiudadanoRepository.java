package asw.DBManagement.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.DBManagement.model.Ciudadano;

@Repository
public interface CiudadanoRepository extends CrudRepository<Ciudadano, Long> {

	Ciudadano findByNombre(String nombre);
}
