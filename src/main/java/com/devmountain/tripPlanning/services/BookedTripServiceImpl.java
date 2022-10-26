package com.devmountain.tripPlanning.services;

import com.devmountain.tripPlanning.dto.BookedTripDto;
import com.devmountain.tripPlanning.entities.BookedTrip;
import com.devmountain.tripPlanning.entities.User;
import com.devmountain.tripPlanning.repositories.BookedTripRepository;
import com.devmountain.tripPlanning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookedTripServiceImpl implements BookedTripService {

    @Autowired
    private BookedTripRepository bookedTripRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<BookedTripDto> addTrip(BookedTripDto bookedTripDto, Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        BookedTrip bookedTrip = new BookedTrip(bookedTripDto);
        bookedTrip.setUser(user.get());
        bookedTripRepository.saveAndFlush(bookedTrip);
        return getAllBookedTrips(userId);
    }

    @Override
    public List<BookedTripDto> getAllBookedTrips(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        List<BookedTrip> bookedTrips = user.get().getBookedTrips();
        List<BookedTripDto> bookedTripDtos = new ArrayList<>();
        for (BookedTrip bookedTrip : bookedTrips) {
            BookedTripDto bookedTripDto = new BookedTripDto(bookedTrip);
            bookedTripDtos.add(bookedTripDto);
        }
        //List<BookedTrip> bookedTrips = new ArrayList<>();
        return bookedTripDtos;
    }

    @Override
    @Transactional
    public void deleteTrip(Integer tripId) {
        Optional<BookedTrip> bookedTrip = bookedTripRepository.findById(tripId);
        bookedTripRepository.delete(bookedTrip.get());
    }
}
