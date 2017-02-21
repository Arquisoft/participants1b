package asw.participants.acceso;

import asw.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ParticipantsInfoTest {

    private String firstName;
    private String lastName;
    private long edad;
    private String nif;
    private String email;


    private ParticipantsInfo participantsInfo;


    @Before
    public void setUp() throws Exception {
        Date bornDate = null;
        firstName = "John";
        lastName = "Doe";
        email = "john@doe.net";
        edad = 47;
        nif = "12345678V";
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        participantsInfo = new ParticipantsInfo(firstName, lastName, bornDate, nif, email);
    }

    @Test
    public void getFirstName() throws Exception {
        assertThat(participantsInfo.getFirstName()).isEqualTo(firstName);
    }

    @Test
    public void getLastName() throws Exception {
        assertThat(participantsInfo.getLastName()).isEqualTo(lastName);
    }

    @Test
    public void getEdad() throws Exception {
        assertThat(participantsInfo.getEdad()).isEqualTo(edad);
    }

    @Test
    public void getNif() throws Exception {
        assertThat(participantsInfo.getNif()).isEqualTo(nif);

    }

    @Test
    public void getEmail() throws Exception {
        assertThat(participantsInfo.getEmail()).isEqualTo(email);
    }

    @Test
    public void equals() throws Exception {
        assertThat(participantsInfo.equals(participantsInfo)).isTrue();
        assertThat(participantsInfo.equals(null)).isFalse();
        assertThat(participantsInfo.equals(email)).isFalse();
    }

}