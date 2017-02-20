package asw.participants;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ChangeInfo {
	
	public ResponseEntity<ChangeInfo> changePassword(@RequestBody ChangeInfo info);
}
