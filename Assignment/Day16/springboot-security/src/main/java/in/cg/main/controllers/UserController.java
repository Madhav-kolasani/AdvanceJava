package in.cg.main.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cg.main.dto.UserDto;
import in.cg.main.services.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody UserDto dto) {
		return userService.registerUser(dto);
	}
	
	@GetMapping("/user/profile")
	public String userProfile() {
		return "Welcome to profile page";
	}
	
	@GetMapping("/user/admin")
	public String adminDashboard() {
		return "Welcome to admin dashboard";
	}
}
