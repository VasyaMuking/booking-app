package restaurant.bookingapp.mapper;

import org.mapstruct.Mapper;
import restaurant.bookingapp.dto.RegisterDto;
import restaurant.bookingapp.model.ProfileEntity;

@Mapper(componentModel = "spring") //TODO вот этот момент
public interface ProfileMapper {
    ProfileEntity fromRegisterDto(RegisterDto dto);
}
