package restaurant.bookingapp.service;

import restaurant.bookingapp.dto.RequestReserveDto;

public interface ReserveService {

    void reserveTable(RequestReserveDto requestReserveDto);

    public void dropReserve();
}
