package com.routes.assemblers;

import com.routes.controllers.RouteController;
import com.routes.model.RouteTimeSlot;
import com.routes.resources.GuideResource;
import com.routes.resources.RouteTimeSlotResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RouteTimeSlotAssembler extends EmbeddableResourceAssemblerSupport<RouteTimeSlot, RouteTimeSlotResource, RouteController> {

    private final GuideResourceAssember guideResourceAssember;

    @Autowired
    public RouteTimeSlotAssembler(EntityLinks entityLinks, RelProvider relProvider, GuideResourceAssember guideResourceAssember) {
        super(entityLinks, relProvider, RouteController.class, RouteTimeSlotResource.class);
        this.guideResourceAssember = guideResourceAssember;
    }

    @Override
    public Link linkToSingleResource(RouteTimeSlot entity) {
        return entityLinks.linkToSingleResource(RouteTimeSlotResource.class, entity.getId());
    }

    @Override
    public RouteTimeSlotResource toResource(RouteTimeSlot routeTimeSlot) {
        RouteTimeSlotResource routeTimeSlotResource = createResourceWithId(routeTimeSlot.getId(), routeTimeSlot);
        final List<EmbeddedWrapper> embeddables = new ArrayList<>();
        embeddables.addAll(guideResourceAssember.toEmbeddable(Collections.singletonList(routeTimeSlot.getGuide())));
        routeTimeSlotResource.setEmbeddeds(new Resources<>(embeddables));
        routeTimeSlotResource.add(entityLinks.linkToSingleResource(GuideResource.class, routeTimeSlot.getGuide().getId()).withRel("guide"));
        return routeTimeSlotResource;
    }

    @Override
    protected RouteTimeSlotResource instantiateResource(RouteTimeSlot entity) {
        return new RouteTimeSlotResource(entity.getAvailableDate(), entity.getId());
    }


}
