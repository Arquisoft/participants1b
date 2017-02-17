package asw.DBManagement.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ciudadano {
	
	@JsonIgnore
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellidos;
	private int edad;
	private String dni;
	private String email;
	@JsonIgnore
	private Date fechaNacimiento;
	@JsonIgnore
	private String residencia;
	@JsonIgnore
	private String nacionalidad;

	@JsonIgnore
	private String password;

	public Ciudadano(String nombre, String apellidos, String email, Date fechaNacimiento, String residencia,
			String nacionalidad, String dni, String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.residencia = residencia;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
		this.password = password;
		this.edad = calculateAgeByBirthDate(fechaNacimiento);
	}
	
	Ciudadano(){}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getEdad(){
		return edad;
	}
	
	private int calculateAgeByBirthDate(Date birthDate){
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse("15/08/1993", fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);
		return periodo.getYears();
	}


	@Override
	public String toString() {
		return "Ciudadano [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + ", residencia=" + residencia + ", nacionalidad=" + nacionalidad + ", dni=" + dni
				+ ", password=" + password + "]";
	}
	
	
}
