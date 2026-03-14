package in.cg.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.passenger.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}