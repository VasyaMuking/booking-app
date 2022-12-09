package restaurant.bookingapp.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import restaurant.bookingapp.model.TableEntity;
import restaurant.bookingapp.model.TableStatus;
import restaurant.bookingapp.repository.TableRepository;
import restaurant.bookingapp.service.RemoveReservations;

import java.util.List;

@Component
public class RemoveReservationsScheduler {
    private final RemoveReservations removeReservations;
    private final TableRepository tableRepository;

    public RemoveReservationsScheduler(RemoveReservations removeReservations, TableRepository tableRepository) {
        this.removeReservations = removeReservations;
        this.tableRepository = tableRepository;
    }

    @Scheduled(cron = "0 0 23 * * *", zone = "AMT")
    public void doWork(){
        List<TableEntity> reserveStatusList =  tableRepository.findAllByTableStatus(TableStatus.RESERVED);
        tableRepository.setStatusFREE(TableStatus.FREE, reserveStatusList);
        removeReservations.removingReservationDb();
    }
}
