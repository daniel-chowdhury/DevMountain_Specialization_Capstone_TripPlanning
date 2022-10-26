package com.devmountain.tripPlanning.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="available_trips")
public class AvailableTrip {

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

}
