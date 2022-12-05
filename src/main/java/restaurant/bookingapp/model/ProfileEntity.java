package restaurant.bookingapp.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JsonIncludeProperties(value = {"id", "login", "email", "name", "role"}) //
@Getter
@Setter
@Entity
@Table(name = "profiles")
public class ProfileEntity { //TODO имплементировать userDetails
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true) //
    private String login;
    private String password; //
    private String email;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private ProfileRole role;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private ReservationEntity reservation;
}
