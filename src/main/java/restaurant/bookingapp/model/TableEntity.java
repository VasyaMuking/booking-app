package restaurant.bookingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tables", schema = "public")
public class TableEntity {
    @Id
    private long id;
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private TableStatus tableStatus;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private ReservationEntity reservationEntity_id;
}
