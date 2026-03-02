package in.cg.main.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.cg.main.entities.UserEntity;
import in.cg.main.services.UserService;

@RestController
public class UserController {
	
	private final UserService userService;
	UserController(UserService userService){
		this.userService = userService;
	}
	
	
	@PostMapping("/user")
	public UserEntity addUserDetails(@RequestBody UserEntity user) {
		return userService.addUserDetails(user);
	}
	
	@GetMapping("/user/{id}")
	public UserEntity getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/all-users")
	public List<UserEntity> allUsers(){
		return userService.allUsers();
	}
	
	@PutMapping("/user/{id}")
	public UserEntity addUserDetails(@PathVariable int id,@RequestBody UserEntity user) {
		return userService.updateUserDetails(id, user);
	}
	
	@DeleteMapping("/user/{id}")
	public boolean deleteUserById(@PathVariable int id) {
		return userService.deleteWithId(id);
	}
	
	
}
