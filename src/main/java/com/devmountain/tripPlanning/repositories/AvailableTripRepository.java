package com.devmountain.tripPlanning.repositories;


import com.devmountain.tripPlanning.entities.AvailableTrip;
import com.devmountain.tripPlanning.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public interface AvailableTripRepository {

    public List<AvailableTrip> availableTrips(String theQuery);


    public List<AvailableTrip> findAll();

}
