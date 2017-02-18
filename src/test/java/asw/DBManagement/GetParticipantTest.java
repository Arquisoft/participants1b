package asw.DBManagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import asw.DBManagement.model.Ciudadano;
import asw.DBManagement.persistence.CiudadanoRepository;

public class GetParticipantTest {

	private Ciudadano johnDoe;

	@Autowired
	private CiudadanoRepository repository;

	@Before
	public void setUp() {
		Date bornDate = new Date();

		try {
			bornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		johnDoe = new asw.DBManagement.model.Ciudadano("John", "Doe", "john@doe.net", bornDate, "Phobos", "Martian",
				"123456789", "password");
	}

	@Test
	public void testgetCiudadano() {
		assertThat(johnDoe).isNotNull();
		when(repository.save(johnDoe)).thenReturn(johnDoe);
	}

}
