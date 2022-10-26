package com.devmountain.tripPlanning.repositories;

import com.devmountain.tripPlanning.entities.AvailableTrip;
import com.devmountain.tripPlanning.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AvailableTripRepositoryImpl implements AvailableTripRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<AvailableTrip> availableTrips(String theQuery) {
        Session currentSession = entityManager.unwrap(Session.class);
        List<AvailableTrip> availableTrips = currentSession.createQuery(theQuery).getResultList();
        return availableTrips;
    }

    @Override
    public List<AvailableTrip> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<AvailableTrip> query =
                currentSession.createQuery("from AvailableTrip", AvailableTrip.class);
        List<AvailableTrip> availableTrips = query.getResultList();
        return availableTrips;
    }

}
