package restaurant.bookingapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestReserveDto {
    private Long client_id;
    private Long table_id;
}
