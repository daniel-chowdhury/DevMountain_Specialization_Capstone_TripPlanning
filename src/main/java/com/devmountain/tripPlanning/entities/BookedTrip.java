package com.devmountain.tripPlanning.entities;

import com.devmountain.tripPlanning.dto.BookedTripDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="booked_trips")
public class BookedTrip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String airline;

    @Column
    private String origin_city;

    @Column
    private String destination_city;

    @Column
    private String trip_date;

    @Column
    private String trip_time;

    @Column
    private String duration;

    @Column
    private String price;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    public BookedTrip(BookedTripDto bookedTripDto) {
        this.airline = bookedTripDto.getAirline();
        this.origin_city = bookedTripDto.getOrigin_city();
        this.destination_city = bookedTripDto.getDestination_city();
        this.trip_date = bookedTripDto.getTrip_date();
        this.trip_time = bookedTripDto.getTrip_time();
        this.duration = bookedTripDto.getDuration();
        this.price = bookedTripDto.getPrice();
    }

}
