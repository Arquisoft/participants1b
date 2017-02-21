package asw.participants.acceso;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import asw.DBManagement.model.Ciudadano;
import org.springframework.stereotype.Component;

@XmlRootElement(name = "ParticipantInfo")
public class ParticipantsInfo {

	private String firstName;
	private String lastName;
	private long edad;
	private String nif;
	private String email;
	
	public ParticipantsInfo(String firstName, String lastName, Date fechaNacimiento, String nif, String email) {
		super();
		LocalDate hoy = LocalDate.now();
		 LocalDate nacimiento = fechaNacimiento.toInstant().
		           atZone(ZoneId.systemDefault()).toLocalDate(); 
		this.firstName = firstName;
		this.lastName = lastName;
		this.edad = ChronoUnit.YEARS.between(nacimiento, hoy);
		this.nif = nif;
		this.email = email;
	}
	
	
	public ParticipantsInfo(Ciudadano ciudadano)
	{
		LocalDate hoy = LocalDate.now();   
		 LocalDate nacimiento = ciudadano.getFechaNacimiento().toInstant().
		           atZone(ZoneId.systemDefault()).toLocalDate(); 
		this.firstName = ciudadano.getNombre();
		this.lastName = ciudadano.getApellidos();
		this.edad = ChronoUnit.YEARS.between(nacimiento, hoy);
		this.nif = ciudadano.getDni();
		this.email = ciudadano.getEmail();
	}

	@XmlElement
	public String getFirstName() {
		return firstName;
	}

	@XmlElement
	public String getLastName() {
		return lastName;
	}

	@XmlElement
	public long getEdad() {
		return edad;
	}

	@XmlElement
	public String getNif() {
		return nif;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (edad ^ (edad >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipantsInfo other = (ParticipantsInfo) obj;
		if (edad != other.edad)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParticipantsInfo [firstName=" + firstName + ", lastName=" + lastName + ", edad=" + edad + ", nif=" + nif
				+ ", email=" + email + "]";
	}

	
}
