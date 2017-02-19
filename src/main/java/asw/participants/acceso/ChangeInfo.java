package asw.participants.acceso;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ChangeInfo")
public class ChangeInfo {

	
	private String password;
	private String email;
	private String newPassword;
	
	public ChangeInfo(String email,String password, String newPassword) {
		this.email = email;
		this.email = password;
		this.newPassword=newPassword;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	@XmlElement
	public String getNewPassword() {
		return newPassword;
	}

	@Override
	public String toString() {
		return "ChangeInfo [password=" + password + ", email=" + email + ", newPassword=" + newPassword + "]";
	}
	
	
}
