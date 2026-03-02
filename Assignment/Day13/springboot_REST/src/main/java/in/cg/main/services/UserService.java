package in.cg.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.cg.main.entities.UserEntity;
import in.cg.main.repositories.UserRepository;

@Service
public class UserService implements IUserService{
	
	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserEntity addUserDetails(UserEntity u) {
		return userRepository.save(u);
	}

	public UserEntity getUserById(int id) {
		return userRepository.findById(id).get();
	}

	public List<UserEntity> allUsers() {
		return userRepository.findAll();
	}

	public UserEntity updateUserDetails(int id, UserEntity user) {
		UserEntity entity = userRepository.findById(id).get();
		
		if(user.getCity()!=null) {
			entity.setCity(user.getCity());
		}
		if(user.getName()!=null) {
			entity.setName(user.getName());
		}
		if(user.getEmail()!=null) {
			entity.setEmail(user.getEmail());
		}
		
		return entity;
	}

	public boolean deleteWithId(int id) {
		try {			
			userRepository.delete(userRepository.findById(id).get());
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
