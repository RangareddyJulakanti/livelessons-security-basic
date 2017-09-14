package basic;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class GreetingsRestController {

	@RequestMapping("/hai")
	public Map<String, Object> hi(Principal principal) {
		Map<String, Object> result = new HashMap<>();
		result.put("id", UUID.randomUUID().toString());
		result.put("content", "Hello, " + principal.getName());
		return result;
	}
	@RequestMapping("/service")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public String testService(){
       return "iam in test Service";
	}

}
