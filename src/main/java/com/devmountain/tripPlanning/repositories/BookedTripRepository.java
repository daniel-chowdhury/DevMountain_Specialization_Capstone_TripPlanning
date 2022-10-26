package com.devmountain.tripPlanning.repositories;


import com.devmountain.tripPlanning.entities.BookedTrip;
import com.devmountain.tripPlanning.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookedTripRepository extends JpaRepository<BookedTrip, Integer> {
    List<BookedTrip> findAllByUserEquals(User user);
}
