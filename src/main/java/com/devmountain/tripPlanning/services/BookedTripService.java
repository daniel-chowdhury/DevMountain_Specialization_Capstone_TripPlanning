package com.devmountain.tripPlanning.services;


import com.devmountain.tripPlanning.dto.BookedTripDto;
import com.devmountain.tripPlanning.entities.BookedTrip;

import java.util.List;

public interface BookedTripService {

    public List<BookedTripDto> addTrip(BookedTripDto bookedTripDto, Integer userId);

    public List<BookedTripDto> getAllBookedTrips(Integer userId);

    public void deleteTrip(Integer tripId);
}
