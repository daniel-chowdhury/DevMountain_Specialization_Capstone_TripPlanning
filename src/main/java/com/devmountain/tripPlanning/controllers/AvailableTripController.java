package com.devmountain.tripPlanning.controllers;

import com.devmountain.tripPlanning.entities.AvailableTrip;
import com.devmountain.tripPlanning.services.AvailableTripService;
import com.devmountain.tripPlanning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trips/v1")
public class AvailableTripController {

    @Autowired
    public AvailableTripService availableTripService;

    @PostMapping("/available")
    List<AvailableTrip> findAllAvailable(@RequestBody AvailableTrip availableTrip) {
        return availableTripService.findAllAvailable(availableTrip);
    }






}
