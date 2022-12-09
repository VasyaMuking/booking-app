package restaurant.bookingapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import restaurant.bookingapp.dto.GifResponse;
import restaurant.bookingapp.feign.GifClient;
import restaurant.bookingapp.feign.GifTags;

@Service
public class GifService {

    private final GifClient gifClient;
    private final String gifAppId;

    public GifService(GifClient gifClient, @Value("${giphy.app_id}") String gifAppId) {
        this.gifClient = gifClient;
        this.gifAppId = gifAppId;
    }

    public String getGifUrl(){
        GifResponse randomGifByTag = gifClient.getRandomGifByTag(gifAppId, GifTags.CONFIRMED.name());
        return randomGifByTag.getData().getImageUrl();
    }
}
