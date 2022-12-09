package restaurant.bookingapp.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;
import restaurant.bookingapp.model.ProfileEntity;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    ProfileEntity findByLogin(String login);
    ProfileRepository findAllById(@NotNull long id);
    @NonNull
    Optional<ProfileEntity> findById(@NonNull Long id);
}
