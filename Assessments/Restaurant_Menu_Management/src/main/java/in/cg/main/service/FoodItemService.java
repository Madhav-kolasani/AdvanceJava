package in.cg.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.cg.main.dto.FoodItemDTO;
import in.cg.main.entities.FoodItem;
import in.cg.main.entities.Restaurant;
import in.cg.main.exception.ResourceNotFoundException;
import in.cg.main.repositories.FoodItemRepository;
import in.cg.main.repositories.RestaurantRepository;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final RestaurantRepository restaurantRepository;

    public FoodItemService(FoodItemRepository foodItemRepository, RestaurantRepository restaurantRepository) {
        this.foodItemRepository = foodItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public FoodItem addFoodItem(Long restaurantId, FoodItemDTO dto) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        FoodItem item = new FoodItem();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setCategory(dto.getCategory());
        item.setRestaurant(restaurant);

        return foodItemRepository.save(item);
    }

    public List<FoodItem> getFoodItems(Long restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}