package restaurant.bookingapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class GifDto {
    String id;
    String type;
    @JsonProperty("image_url") //TODO спросить про эту аннотацию
    String imageUrl;
}
