package com.routes.model;

import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NamedEntityGraph(name = "AbstractRoute.all",
        attributeNodes = {@NamedAttributeNode("slots")})
public class Route extends AbstractRoute {

    private String length;
    private String description;
    @OneToMany(mappedBy = "route")
//    @Fetch(FetchMode.JOIN) // ignored by spring
    private List<RouteTimeSlot> slots;

    public Route() {
    }

    public List<RouteTimeSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<RouteTimeSlot> slots) {
        this.slots = slots;
    }

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
