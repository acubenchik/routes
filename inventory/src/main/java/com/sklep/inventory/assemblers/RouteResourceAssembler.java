package com.sklep.inventory.assemblers;

import com.sklep.inventory.controllers.RouteController;
import com.sklep.inventory.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;
import resources.RouteResource;

@Service
public class RouteResourceAssembler extends EmbeddableResourceAssemblerSupport<Route, RouteResource, RouteController> {

    @Autowired
    public RouteResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, RouteController.class, RouteResource.class);
    }

    @Override
    public RouteResource toResource(Route route) {
        RouteResource routeResource = createResourceWithId(route.getId(), route);
        return routeResource;
    }

    @Override
    protected RouteResource instantiateResource(Route entity) {
        return new RouteResource(entity.getName(), entity.getId());
    }

    @Override
    public Link linkToSingleResource(Route entity) {
        return entityLinks.linkToSingleResource(RouteResource.class, entity.getId());
    }
}
