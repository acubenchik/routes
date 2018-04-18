package com.routes.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.core.Relation;

@Relation(value = "guide", collectionRelation = "guides")
public class GuideResource extends ResourceWithEmbedded {


    private String name;
    private String description;
    private long uid;

    @JsonCreator
    public GuideResource(@JsonProperty("name") String name,
                         @JsonProperty("description") String description,
                         @JsonProperty("uid") long uid) {
        this.name = name;
        this.description = description;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}
