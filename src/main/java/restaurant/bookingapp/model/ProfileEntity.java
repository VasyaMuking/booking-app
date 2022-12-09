package restaurant.bookingapp.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNullApi;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;

@JsonIncludeProperties(value = {"id", "login", "email", "name", "role"}) //
@Getter
@Setter
@Entity
@Table(name = "profiles")
public class ProfileEntity implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
