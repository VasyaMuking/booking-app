package restaurant.bookingapp.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RemoveReservationsScheduler {
    private RemoveReservations removeReservations;
    @Scheduled(cron = "0 0 23 * * *", zone = "AMT")
    public void doWork(){
        removeReservations.removingReservationDb();

    }
}
