package restaurant.bookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import restaurant.bookingapp.dto.LoginDto;
import restaurant.bookingapp.dto.RegisterDto;
import restaurant.bookingapp.dto.RequestReserveDto;
import restaurant.bookingapp.mapper.ProfileMapper;
import restaurant.bookingapp.model.ProfileEntity;
import restaurant.bookingapp.model.TableEntity;
import restaurant.bookingapp.model.TableStatus;
import restaurant.bookingapp.repository.TableRepository;
import restaurant.bookingapp.service.GifService;
import restaurant.bookingapp.service.ProfileService;
import restaurant.bookingapp.service.ReserveService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    private final ReserveService reserveService;

    private final ProfileMapper profileMapper;

    private final TableRepository tableRepository;

    private final GifService gifService;

    public ProfileController(ProfileService profileService, ReserveService reserveService, ProfileMapper profileMapper,
                             TableRepository tableRepository, GifService gifService) {
        this.profileService = profileService;
        this.reserveService = reserveService;
        this.profileMapper = profileMapper;
        this.tableRepository = tableRepository;
        this.gifService = gifService;
    }

    @PostMapping("/register")
    @io.swagger.v3.oas.annotations.Operation(summary = "Регистрация пользователя")
    public void register(@Valid @RequestBody RegisterDto registerDto){
        ProfileEntity profile = profileMapper.fromRegisterDto(registerDto);
        profileService.register(profile);
    }

    @PostMapping("/auth")
    @io.swagger.v3.oas.annotations.Operation(summary = "Аутентификация пользователя")
    public String auth(@RequestBody LoginDto dto) {
        return profileService.auth(dto.getLogin(), dto.getPassword());
    }

    @GetMapping("/me")
    public ProfileEntity me(@AuthenticationPrincipal ProfileEntity profile) {
        return profile;
       //return (ProfileEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    @GetMapping("/freeTables")
    @io.swagger.v3.oas.annotations.Operation(summary = "Демонстрация свободных столов")
    public List<Long> showFreeTables(){
        return tableRepository.findAllByTableStatus(TableStatus.FREE).stream()
                .map(TableEntity::getId)
                .collect(Collectors.toList());
    }
    @PostMapping("/makeReserve")
    @io.swagger.v3.oas.annotations.Operation(summary = "Зарезервировать стол")
    public void makeReserve(@RequestBody RequestReserveDto requestReserveDto, HttpServletResponse response)throws IOException {
        reserveService.reserveTable(requestReserveDto);
        response.sendRedirect(gifService.getGifUrl());
    }
}
