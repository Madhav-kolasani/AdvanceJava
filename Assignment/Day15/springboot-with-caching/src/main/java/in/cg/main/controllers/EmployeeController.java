package in.cg.main.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.cg.main.services.FileStorageService;

import in.cg.main.dto.EmployeeDto;
import in.cg.main.services.EmployeeService;
import org.springframework.core.io.Resource;
import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	private final EmployeeService userService;
	private final FileStorageService fileService;

	EmployeeController(EmployeeService userService, FileStorageService fileService) {
		this.userService = userService;
		this.fileService= fileService;
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

	@DeleteMapping("/emp/{id}")
	public boolean deleteById(@PathVariable int id) {
		return userService.deleteWithId(id);
	}

	@PostMapping(value = "/upload", consumes = "multipart/form-data")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		return fileService.uploadFile(file);
	}

	@GetMapping("/download/{filename}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

		Resource resource = fileService.downloadFile(filename);

		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}
