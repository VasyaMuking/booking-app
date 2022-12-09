package restaurant.bookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.bookingapp.model.ReservationEntity;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    //List<ReservationEntity> findAllBy
    void deleteAll();
}
