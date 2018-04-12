package com.sklep.inventory.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Route extends AbstractRoute {

    public Route() {
    }

    private String length;
    private String description;

    @OneToMany(mappedBy = "route")
    private List<RouteTimeSlot> slots;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
