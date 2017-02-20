package asw.DBManagement.model;

import asw.Application;
import org.junit.After;
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
public class CiudadanoTest {

    private Ciudadano johnDoe;

    private String nombre;
    private String apellidos;
    private String email;
    private Date fechaNacimiento;
    private String residencia;
    private String nacionalidad;
    private String dni;
    private String password;


    @Before
    public void setUp() throws Exception {
        Date bornDate = null;
        nombre = "John";
        apellidos = "Doe";
        email = "john@doe.net";
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
            fechaNacimiento = bornDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        residencia = "Phobos";
        nacionalidad = "Martian";
        dni = "12345678X";
        password = "password";

        johnDoe = new Ciudadano(nombre, apellidos, email, bornDate, residencia, nacionalidad, dni, password);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getNombre() throws Exception {
        assertThat(johnDoe.getNombre()).isEqualTo(nombre);
    }

    @Test
    public void setNombre() throws Exception {
        johnDoe.setNombre("nombre");
        assertThat(johnDoe.getNombre()).isEqualTo("nombre");
    }

    @Test
    public void getApellidos() throws Exception {

    }

    @Test
    public void setApellidos() throws Exception {

    }

    @Test
    public void getEmail() throws Exception {

    }

    @Test
    public void setEmail() throws Exception {

    }

    @Test
    public void getFechaNacimiento() throws Exception {

    }

    @Test
    public void setFechaNacimiento() throws Exception {

    }

    @Test
    public void getResidencia() throws Exception {

    }

    @Test
    public void setResidencia() throws Exception {

    }

    @Test
    public void getNacionalidad() throws Exception {

    }

    @Test
    public void setNacionalidad() throws Exception {

    }

    @Test
    public void getDni() throws Exception {

    }

    @Test
    public void setDni() throws Exception {

    }

    @Test
    public void getPassword() throws Exception {

    }

    @Test
    public void setPassword() throws Exception {

    }
}