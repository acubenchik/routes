package com.sklep.inventory.model;

import javax.persistence.*;

@Entity
public class RouteTimeSlot {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Guide guide;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }
}
