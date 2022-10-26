package com.devmountain.tripPlanning.services;

import com.devmountain.tripPlanning.entities.AvailableTrip;

import java.util.List;

public interface AvailableTripService {

    public List<AvailableTrip> findAllAvailable(AvailableTrip availableTrip);
}
