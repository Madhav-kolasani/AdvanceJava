package in.cg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("register")
	public String register() {
		return "register";
	}

	@PostMapping("reg-submit")
	public String formData(
			@RequestParam("username") String username,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("confirmPassword") String confirmPassword,
			Model m) {
		
		m.addAttribute("username", username);
		m.addAttribute("email", email);
		m.addAttribute("password", password);
		m.addAttribute("confirmPassword", confirmPassword);

		return "profile";
	}
	
	@PostMapping("login-submit")
	public String formData(
			@RequestParam("username") String username,
			Model m) {
		System.out.println(username);
		m.addAttribute("username", username);;
		return "profile";
	}
	

	@GetMapping("home")
	public String home() {
		return "home";
	}
}
