package asw.DBManagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import asw.Application;
import org.junit.Before;
import org.junit.Test;

import asw.DBManagement.model.Ciudadano;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class UpdateInfoTest {

	private Ciudadano johnDoe;

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
	}
}
