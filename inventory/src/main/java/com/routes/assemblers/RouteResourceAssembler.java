package com.routes.assemblers;

import com.routes.controllers.RouteController;
import com.routes.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.stereotype.Service;
import com.routes.resources.RouteResource;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteResourceAssembler extends EmbeddableResourceAssemblerSupport<Route, RouteResource, RouteController> {

    private RouteTimeSlotAssembler routeTimeSlotAssembler;

    @Autowired
    public RouteResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider, RouteTimeSlotAssembler routeTimeSlotAssembler) {
        super(entityLinks, relProvider, RouteController.class, RouteResource.class);
        this.routeTimeSlotAssembler = routeTimeSlotAssembler;
    }

    @Override
    public RouteResource toResource(Route route) {
        RouteResource routeResource = createResourceWithId(route.getId(), route);
        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
        embeddables.addAll(routeTimeSlotAssembler.toEmbeddable(route.getSlots()));
        routeResource.setEmbeddeds(new Resources<>(embeddables));
        return routeResource;
    }

    @Override
    protected RouteResource instantiateResource(Route entity) {
        return new RouteResource(entity.getName(), entity.getId(), entity.getDescription());
    }

    @Override
    public Link linkToSingleResource(Route entity) {
        return entityLinks.linkToSingleResource(RouteResource.class, entity.getId());
    }
}
