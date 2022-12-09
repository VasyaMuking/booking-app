package restaurant.bookingapp.service;

import org.springframework.stereotype.Service;
import restaurant.bookingapp.dto.RequestReserveDto;
import restaurant.bookingapp.model.ProfileEntity;
import restaurant.bookingapp.model.ReservationEntity;
import restaurant.bookingapp.model.TableEntity;
import restaurant.bookingapp.repository.ProfileRepository;
import restaurant.bookingapp.repository.ReservationRepository;
import restaurant.bookingapp.repository.TableRepository;

import java.util.Optional;

@Service
public class ReserveServiceImpl implements ReserveService {

    private final ProfileRepository profileRepository;

    private final TableRepository tableRepository;

    private final ReservationRepository reservationRepository;

    public ReserveServiceImpl(ProfileRepository profileRepository, TableRepository tableRepository,
                              ReservationRepository reservationRepository) {
        this.profileRepository = profileRepository;
        this.tableRepository = tableRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void reserveTable(RequestReserveDto requestReserveDto) {
        ReservationEntity reservationEntity = new ReservationEntity();
        Optional<ProfileEntity> optionalProfileEntity = profileRepository.findById(requestReserveDto.getClient_id());
        ProfileEntity profile = optionalProfileEntity.get();
        reservationEntity.setProfile(profile);

        Optional<TableEntity> optionalTableEntity = tableRepository.findById(requestReserveDto.getTable_id());
        TableEntity tableEntity = optionalTableEntity.get();
        reservationEntity.setTableEntity(tableEntity);
        reservationRepository.save(reservationEntity);
    }
    @Override
    public void dropReserve() {
    }
}
