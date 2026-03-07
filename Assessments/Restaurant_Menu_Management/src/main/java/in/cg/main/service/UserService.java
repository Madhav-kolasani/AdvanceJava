package in.cg.main.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.cg.main.dto.UserDTO;
import in.cg.main.entities.UserEntity;
import in.cg.main.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserDTO dto) {
        if(userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new DataIntegrityViolationException("Email already registered");
        }

        UserEntity user = new UserEntity();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        String role = dto.getRole() != null && dto.getRole().equalsIgnoreCase("admin") 
                ? "ROLE_ADMIN" 
                : "ROLE_USER";

        user.setRole(role);

        userRepository.save(user);
    }
}