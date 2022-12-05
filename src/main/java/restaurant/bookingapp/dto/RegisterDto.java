package restaurant.bookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.bookingapp.model.ProfileRole;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterDto {
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String email;
    private ProfileRole role;
}
