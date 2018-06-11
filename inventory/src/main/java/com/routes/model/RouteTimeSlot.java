package com.routes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class RouteTimeSlot {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Guide guide;

    @Column
    private LocalDateTime availableDate;

}
