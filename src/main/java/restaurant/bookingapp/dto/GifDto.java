package restaurant.bookingapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GifDto {
    String id;
    String type;
    @JsonProperty("image_url")
    String imageUrl;
}
