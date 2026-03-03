package in.cg.main.services;

import in.cg.main.dto.UserDto;
import in.cg.main.entities.UserEntity;

public interface IUserService {
	boolean deleteWithId(int id);
	UserDto addUserDetails(UserDto ud);
}
