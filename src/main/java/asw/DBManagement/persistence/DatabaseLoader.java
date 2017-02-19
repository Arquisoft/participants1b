package asw.DBManagement.persistence;

import java.time.Instant;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import asw.DBManagement.model.Ciudadano;

@Component
public class DatabaseLoader {

	@Autowired
	private CiudadanoRepository repository;
	
	
	@PostConstruct
	 private void initDatabase() {
		
		Ciudadano c1 = new Ciudadano("Ramon", "Sobrino Llorca", "ramonsobrino@llorca.es",
				Date.from(Instant.now()), "Oviedo", "Española", "71664900", "123456");
		Ciudadano c2 = new Ciudadano("Pablo", "Garcia", "pablo@gmail.es",
				Date.from(Instant.now()), "Oviedo", "Española", "79845632", "111111");
		Ciudadano c3 = new Ciudadano("Javier", "Fernandez", "javivaldu@gmail.es",
				Date.from(Instant.now()), "Oviedo", "Española", "78945612", "999999");
		repository.save(c1);
		repository.save(c2);
		repository.save(c3);
		// Read
		 Iterable<Ciudadano> all = repository.findAll();
		 for (Ciudadano customer : all) {
		 System.out.println(customer);
		 } 
	}
}
