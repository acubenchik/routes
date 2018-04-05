package resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.core.Relation;

@Relation(value = "route", collectionRelation = "routes")
public class RouteResource extends ResourceWithEmbedded {

    private String name;
    private long uid;

    @JsonCreator
    public RouteResource(@JsonProperty("name") String name, @JsonProperty("uid") long uid) {
        this.name = name;
        this.uid = uid;
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
