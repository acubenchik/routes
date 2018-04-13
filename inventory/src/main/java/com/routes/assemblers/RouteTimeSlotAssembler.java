package com.routes.assemblers;

import com.routes.controllers.RouteController;
import com.routes.model.RouteTimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;
import resources.RouteTimeSlotResource;

@Service
public class RouteTimeSlotAssembler extends EmbeddableResourceAssemblerSupport<RouteTimeSlot, RouteTimeSlotResource, RouteController> {

    @Autowired
    public RouteTimeSlotAssembler(EntityLinks entityLinks, RelProvider relProvider) {
        super(entityLinks, relProvider, RouteController.class, RouteTimeSlotResource.class);
    }

    @Override
    public Link linkToSingleResource(RouteTimeSlot entity) {
        return entityLinks.linkToSingleResource(RouteTimeSlotResource.class, entity.getId());
    }

    @Override
    public RouteTimeSlotResource toResource(RouteTimeSlot routeTimeSlot) {
        RouteTimeSlotResource routeTimeSlotResource = createResourceWithId(routeTimeSlot.getId(), routeTimeSlot);
        return routeTimeSlotResource;
    }

    @Override
    protected RouteTimeSlotResource instantiateResource(RouteTimeSlot entity) {
        return new RouteTimeSlotResource(entity.getAvailableDate(), entity.getId());
    }


}
