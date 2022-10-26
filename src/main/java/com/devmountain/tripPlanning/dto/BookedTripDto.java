package com.devmountain.tripPlanning.dto;

import com.devmountain.tripPlanning.entities.BookedTrip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookedTripDto implements Serializable {

    private Integer id;


    private String airline;


    private String origin_city;


    private String destination_city;


    private String trip_date;


    private String trip_time;


    private String duration;


    private String price;

    public BookedTripDto(BookedTrip bookedTrip) {
        this.id = bookedTrip.getId();
        this.airline = bookedTrip.getAirline();
        this.origin_city = bookedTrip.getOrigin_city();
        this.destination_city = bookedTrip.getDestination_city();
        this.trip_date = bookedTrip.getTrip_date();
        this.trip_time = bookedTrip.getTrip_time();
        this.duration = bookedTrip.getDuration();
        this.price = bookedTrip.getPrice();
    }

}
