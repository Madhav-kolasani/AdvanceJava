package in.cg.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import in.cg.entities.User;

@FeignClient(name="ORDER-SERVICE")
public interface OrderServiceClient {
	
	@GetMapping("/users/getuserorders")
	List<User> getUsers();
}
