package restaurant.bookingapp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import restaurant.bookingapp.model.TableEntity;
@Repository
public interface TableRepository extends CrudRepository<TableEntity, Long> {
    TableEntity findAllById(Long id);//TODO правильно ли
}
