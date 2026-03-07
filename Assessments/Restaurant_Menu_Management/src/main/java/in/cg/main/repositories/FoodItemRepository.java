package in.cg.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.main.entities.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

	List<FoodItem> findByRestaurantId(Long restaurantId);

}
