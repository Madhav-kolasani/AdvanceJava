package in.cg.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.main.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{

}
