package in.cg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.cg.beans.User;

@Controller
public class HomeController {


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/reg-submit")
	public String formDataForReg(@ModelAttribute User user) {
		return "profile";
	}
	
	@PostMapping("/login-submit")
	public String formDataForLogin(@ModelAttribute User user) {
		return "profile";
	}
	

	@GetMapping("home")
	public String home() {
		return "home";
	}
}
