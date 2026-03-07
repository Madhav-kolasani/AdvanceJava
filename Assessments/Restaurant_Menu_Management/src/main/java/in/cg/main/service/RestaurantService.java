package in.cg.main.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.cg.main.dto.RestaurantDTO;
import in.cg.main.entities.Restaurant;
import in.cg.main.repositories.RestaurantRepository;

@Service
public class RestaurantService {

	private final RestaurantRepository restaurantRepository;

	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	public Page<Restaurant> getRestaurants(int page, int size) {
		return restaurantRepository.findAll(PageRequest.of(page, size));
	}

	public Restaurant addRestaurant(RestaurantDTO dto) {

		Restaurant r = new Restaurant();
		r.setName(dto.getName());
		r.setLocation(dto.getLocation());
		r.setRating(dto.getRating());

		return restaurantRepository.save(r);
	}
}
