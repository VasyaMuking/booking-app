package restaurant.bookingapp.controller;

import org.springframework.web.bind.annotation.*;
import restaurant.bookingapp.dto.LoginDto;
import restaurant.bookingapp.dto.RegisterDto;
import restaurant.bookingapp.mapper.ProfileMapper;
import restaurant.bookingapp.model.ProfileEntity;
import restaurant.bookingapp.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private ProfileService profileService;

    private ProfileMapper profileMapper;

    @PostMapping("/register")
    public void register(@RequestBody RegisterDto registerDto){ //TODO @Valid
        ProfileEntity profile = profileMapper.fromRegisterDto(registerDto);
        profileService.register(profile);
    }

    @PostMapping("/auth")
    public String auth(@RequestBody LoginDto dto) {
        return profileService.auth(dto.getLogin(), dto.getPassword());
    }

    @GetMapping("/me")
    public ProfileEntity me(@AuthenticationPrincipal ProfileEntity profile) {
        return profile; //TODO как правильно?
       // return (ProfileEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
