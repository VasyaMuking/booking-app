package restaurant.bookingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
    @OneToOne
    @JoinColumn(name = "table_id")
    private TableEntity tableEntity;

}
