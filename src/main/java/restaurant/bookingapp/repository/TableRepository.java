package restaurant.bookingapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;
import restaurant.bookingapp.model.TableEntity;
import restaurant.bookingapp.model.TableStatus;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;


@Repository
public interface TableRepository extends JpaRepository<TableEntity, Long> {

    Optional<TableEntity> findById(@NotNull Long id);
    TableEntity findAllById(Long id);
    List<TableEntity> findAllByTableStatus(TableStatus status);

    @Modifying
    @Query(value = "UPDATE TableEntity t SET t.tableStatus = 'FREE'")
    void setStatusFREE(@Param("tableStatus") TableStatus tableStatus, List<TableEntity> list);
}