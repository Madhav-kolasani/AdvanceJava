package in.cg.main.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.cg.main.dto.FoodItemDTO;
import in.cg.main.dto.RestaurantDTO;
import in.cg.main.entities.*;
import in.cg.main.service.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

	private final RestaurantService restaurantService;
	private final FoodItemService foodItemService;

	public RestaurantController(RestaurantService restaurantService, FoodItemService foodItemService) {
		this.restaurantService = restaurantService;
		this.foodItemService = foodItemService;
	}

	@GetMapping
	public Page<Restaurant> getRestaurants(@RequestParam int page, @RequestParam int size) {
		return restaurantService.getRestaurants(page, size);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public Restaurant addRestaurant(@Valid @RequestBody RestaurantDTO dto) {
		return restaurantService.addRestaurant(dto);
	}

	@PostMapping("/{restaurantId}/fooditems")
	@PreAuthorize("hasRole('ADMIN')")
	public FoodItem addFood(@PathVariable Long restaurantId, @Valid @RequestBody FoodItemDTO dto) {
	    return foodItemService.addFoodItem(restaurantId, dto);
	}

	@GetMapping("/{restaurantId}/fooditems")
	public List<FoodItem> getFoodItems(@PathVariable Long restaurantId) {
		return foodItemService.getFoodItems(restaurantId);
	}

}
