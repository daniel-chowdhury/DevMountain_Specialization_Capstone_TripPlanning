package com.devmountain.tripPlanning.controllers;


import com.devmountain.tripPlanning.dto.BookedTripDto;
import com.devmountain.tripPlanning.entities.BookedTrip;
import com.devmountain.tripPlanning.services.BookedTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips/v1/booked")
public class BookedTripController {

    @Autowired
    private BookedTripService bookedTripService;

    @PostMapping("/{userId}")
    public List<BookedTripDto> BookATrip(@RequestBody BookedTripDto bookedTripDto, @PathVariable Integer userId) {
        return bookedTripService.addTrip(bookedTripDto, userId);
    }

    @GetMapping("/{userId}")
    public List<BookedTripDto> getAllBookedTrips(@PathVariable Integer userId) {
        return bookedTripService.getAllBookedTrips(userId);
    }

    @DeleteMapping("/{tripId}")
    public void deleteTrip(@PathVariable Integer tripId) {
        bookedTripService.deleteTrip(tripId);
    }

}
