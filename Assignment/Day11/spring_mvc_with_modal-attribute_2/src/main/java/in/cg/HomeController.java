package in.cg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.cg.beans.Employee;

@Controller
public class HomeController {


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "emp-register";
	}

	@PostMapping("/reg-submit")
	public String formDataForReg(@ModelAttribute("emp") Employee emp) {
		return "profile";
	}
	
	@PostMapping("/login-submit")
	public String formDataForLogin(@ModelAttribute("emp") Employee emp) {
		return "profile";
	}
	

	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
