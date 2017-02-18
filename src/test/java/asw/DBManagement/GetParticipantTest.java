package asw.DBManagement;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class GetParticipantTest {

	// private asw.DBManagement.GetParticipant getParticipant;
	private asw.DBManagement.model.Ciudadano johnDoe;

	@Autowired
	private asw.DBManagement.persistence.CiudadanoRepository repository;

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
		when(repository.save(johnDoe)).thenReturn(johnDoe);
	}

}
