package restaurant.bookingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BookingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingAppApplication.class, args);
    }

}
