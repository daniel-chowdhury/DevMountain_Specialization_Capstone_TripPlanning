package com.devmountain.tripPlanning.services;

import com.devmountain.tripPlanning.entities.AvailableTrip;
import com.devmountain.tripPlanning.repositories.AvailableTripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableTripServiceImpl implements AvailableTripService {

    @Autowired
    private AvailableTripRepository availableTripRepository;

    @Override
    public List<AvailableTrip> findAllAvailable(AvailableTrip availableTrip) {
        //String tripQuery = "from AvailableTrip a where ";
        String tripQuery = "";
        if (availableTrip.getAirline() == null && availableTrip.getOrigin_city() == null
        && availableTrip.getDestination_city() == null && availableTrip.getTrip_date() == null
        && availableTrip.getTrip_time() == null && availableTrip.getDuration() == null
        && availableTrip.getPrice() == null) {
            return availableTripRepository.findAll();
        }
        if (availableTrip.getAirline() != null) {
            tripQuery = tripQuery + " and a.airline='" + availableTrip.getAirline() + "'";
        }
        if (availableTrip.getOrigin_city() != null) {
            tripQuery = tripQuery + " and a.origin_city='" + availableTrip.getOrigin_city() + "'";
        }
        if (availableTrip.getDestination_city() != null) {
            tripQuery = tripQuery + " and a.destination_city='" + availableTrip.getDestination_city() + "'";
        }
        if (availableTrip.getTrip_date() != null) {
            tripQuery = tripQuery + " and a.trip_date='" + availableTrip.getTrip_date() + "'";
        }
        if (availableTrip.getTrip_time() != null) {
            tripQuery = tripQuery + " and a.trip_time='" + availableTrip.getTrip_time() + "'";
        }
        if (availableTrip.getDuration() != null) {
            tripQuery = tripQuery + " and a.duration='" + availableTrip.getDuration() + "'";
        }
        if (availableTrip.getPrice() != null) {
            tripQuery = tripQuery + " and a.price='" + availableTrip.getPrice() + "'";
        }
        tripQuery = tripQuery.replaceFirst(" and ", "");
        tripQuery = "from AvailableTrip a where " + tripQuery;
        return availableTripRepository.availableTrips(tripQuery);
    }

}
