package DBManagement.persistence;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DBManagement.model.Ciudadano;

@Component
public class DatabaseLoader {

	@Autowired
	private CiudadanoRepository repository;
	
	
	@PostConstruct
	 private void initDatabase() {
		
		Ciudadano c1 = new Ciudadano("Ramon", "Sobrino Llorca", "ramonsobrino@llorca.es",
				new Date("04-04-1986"), "Oviedo", "Española", "71664900", "123456");
		
		repository.save(c1);
		
		// Read
		 Iterable<Ciudadano> all = repository.findAll();
		 for (Ciudadano customer : all) {
		 System.out.println(customer);
		 } 
	}
}
