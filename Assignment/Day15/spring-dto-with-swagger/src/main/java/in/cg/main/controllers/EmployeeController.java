package in.cg.main.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.cg.main.dto.EmployeeDto;
import in.cg.main.services.EmployeeService;
import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	private final EmployeeService userService;

	EmployeeController(EmployeeService userService) {
		this.userService = userService;
	}

	@GetMapping("/all-employees")
	public List<EmployeeDto> allUsers() {
		return userService.allUsers();
	}

	@PostMapping("/emp")
	public EmployeeDto addUser(@Valid @RequestBody EmployeeDto dto) {
		return userService.addUserDetails(dto);
	}

	@GetMapping("/emp/{id}")
	public EmployeeDto getByid(@PathVariable int id) {
		return userService.getUserById(id);
	};

	@GetMapping("/emp/conf")
	public List<EmployeeDto> getALlUserConfidential() {
		return userService.getALlUserConfidential();
	}
}
