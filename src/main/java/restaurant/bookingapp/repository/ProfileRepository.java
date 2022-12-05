package restaurant.bookingapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import restaurant.bookingapp.model.ProfileEntity;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {
    ProfileEntity findByLogin(String login);
}
