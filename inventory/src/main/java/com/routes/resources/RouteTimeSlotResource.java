package com.routes.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.core.Relation;

import java.time.LocalDateTime;

@Relation(value = "routeTimeSlot", collectionRelation = "routeTimeSlots")
public class RouteTimeSlotResource extends ResourceWithEmbedded {

    @JsonCreator
    public RouteTimeSlotResource(@JsonProperty("availableDate") LocalDateTime availableDate,
                                 @JsonProperty("uid") long id) {
        this.availableDate = availableDate;
        this.uid = id;
    }

    private LocalDateTime availableDate;
    private long uid;

    public void setId(long id) {
        this.uid = id;
    }

    public long getUid() {
        return uid;
    }

    public LocalDateTime getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDateTime availableDate) {
        this.availableDate = availableDate;
    }

    @Override
    public Link getId() {
        return this.getLink("route");
    }
}
