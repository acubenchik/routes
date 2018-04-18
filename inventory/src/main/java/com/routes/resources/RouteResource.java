package com.routes.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.core.Relation;

@Relation(value = "route", collectionRelation = "routes")
public class RouteResource extends ResourceWithEmbedded {

    private String name;
    private String description;
    private long uid;

    @JsonCreator
    public RouteResource(@JsonProperty("name") String name, @JsonProperty("uid") long uid,
                         @JsonProperty("description") String description) {
        this.name = name;
        this.uid = uid;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}
