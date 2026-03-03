package in.cg.main.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import in.cg.main.dto.UserDto;
import in.cg.main.entities.UserEntity;
import in.cg.main.repositories.UserRepository;

@Service
public class UserService implements IUserService {

	private final UserRepository userRepository;
	private final ModelMapper  mm;

	public UserService(UserRepository userRepository, ModelMapper mm) {
		this.userRepository = userRepository;
		this.mm = mm;
		
	}

	@Override
	public UserDto addUserDetails(UserDto ud) {
		UserEntity entity = dtoToEntity(ud);
		userRepository.save(entity);
		return entityToDto(entity);
	}

	public UserDto getUserById(int id) {
		return entityToDto(userRepository.findById(id).get());
	}

	public List<UserDto> allUsers() {
		return userRepository.findAll().stream().map(this::entityToDto).toList();
	}

	public UserDto updateUserDetails(int id, UserDto ud) {
		UserEntity entity = userRepository.findById(id).get();

		if (ud.getCity() != null) {
			entity.setCity(ud.getCity());
		}
		if (ud.getName() != null) {
			entity.setName(ud.getName());
		}
		if (ud.getEmail() != null) {
			entity.setEmail(ud.getEmail());
		}

		return entityToDto(entity);
	}

	public boolean deleteWithId(int id) {
		try {
			userRepository.delete(userRepository.findById(id).get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<UserDto> getALlUserConfidential() {
		return userRepository.findAll().stream().map(user -> {
			UserDto dto = new UserDto();
			dto.setCity(user.getCity());
			dto.setEmail(user.getEmail());
			dto.setName(user.getName());
			return dto;
		}).toList();
	}

	private UserDto entityToDto(UserEntity ue) {
		return mm.map(ue, UserDto.class);
	}

	private UserEntity dtoToEntity(UserDto dto) {   // why to create model mapper clas here and about that many times so i created a config there it returns modelmapper object and I injected that
		return mm.map(dto, UserEntity.class);
		
	}

}
