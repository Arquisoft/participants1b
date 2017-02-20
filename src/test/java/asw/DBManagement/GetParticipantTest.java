package asw.DBManagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import asw.Application;
import asw.DBManagement.model.Ciudadano;
import asw.DBManagement.persistence.CiudadanoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class GetParticipantTest {
    private Ciudadano johnDoe;

    @Autowired
    @Mock
    private CiudadanoRepository repository;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        Date bornDate;

        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
            johnDoe = new Ciudadano("John", "Doe", "john@doe.net", bornDate, "Phobos", "Martian", "123456789", "password");

        } catch (ParseException e) {

            e.printStackTrace();
        }

    }


    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getCiudadano() throws Exception {
        assertThat(johnDoe).isNotNull();

        when(repository.save(johnDoe)).thenReturn(johnDoe);
    }

}
