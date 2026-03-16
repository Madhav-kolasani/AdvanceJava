package in.cg.carrentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.carrentals.entity.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Long> {
}