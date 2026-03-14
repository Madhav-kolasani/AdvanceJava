package in.cg.passenger.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import in.cg.passenger.dto.RentalCarDetails;

import java.util.List;

@FeignClient(name = "carrentals-service")
public interface CarRentalsFeignClient {

    @GetMapping("/rentalcardetails")
    List<RentalCarDetails> getAllRentalCars();
}