package asw.participants.acceso;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ChangePasswordInfo")
public class ChangePasswordInfo {
	
	private String msg;
	
	public ChangePasswordInfo(){}
	public ChangePasswordInfo(String msg){
		this.msg = msg;
	}
	
	@XmlElement
	public String getMsg(){
		return msg;
	}
	
	@Override
	public String toString() {
		return "ChangeInfo [ message: "+ msg +"]";
	}
	
}
