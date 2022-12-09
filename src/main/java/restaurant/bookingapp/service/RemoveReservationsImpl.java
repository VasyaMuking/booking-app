package restaurant.bookingapp.service;

import org.springframework.stereotype.Service;
import restaurant.bookingapp.repository.ReservationRepository;

@Service
public class RemoveReservationsImpl implements RemoveReservations{

    private ReservationRepository reservationRepository;

    @Override
    public void removingReservationDb() {
        reservationRepository.deleteAll();
    }
}
