package restaurant.bookingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tables")
public class TableEntity {
    @Id
    private long id;
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private ReservationEntity reservationEntity_id;
}
