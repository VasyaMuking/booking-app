package restaurant.bookingapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @PostMapping("/drop-reserve")
    public void dropReservation(){};
    @PostMapping("/drop-profile")
    public void dropProfile(){};
}
