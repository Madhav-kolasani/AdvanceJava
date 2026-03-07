package in.cg.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.main.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByEmail(String email);
}