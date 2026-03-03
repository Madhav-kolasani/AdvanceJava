package in.cg.main.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.cg.main.dto.UserDto;
import in.cg.main.services.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController {

	private final UserService userService;

	UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/all-users")
	public List<UserDto> allUsers() {
		return userService.allUsers();
	}

	@PostMapping("/user")
	public UserDto addUser(@Valid @RequestBody UserDto dto) {
		return userService.addUserDetails(dto);
	}

	@GetMapping("/user/{id}")
	public UserDto getByid(@PathVariable int id) {
		return userService.getUserById(id);
	};

	@GetMapping("/user/conf")
	public List<UserDto> getALlUserConfidential() {
		return userService.getALlUserConfidential();
	}
}
