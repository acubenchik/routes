package com.routes.assemblers;

import com.routes.controllers.GuideController;
import com.routes.model.Guide;
import com.routes.resources.GuideResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Component;

@Component
public class GuideResourceAssember extends EmbeddableResourceAssemblerSupport<Guide, GuideResource, GuideController> {

    @Autowired
    public GuideResourceAssember(final EntityLinks entityLinks,
                                 final RelProvider relProvider) {
        super(entityLinks, relProvider, GuideController.class, GuideResource.class);
    }

    @Override
    public Link linkToSingleResource(Guide entity) {
        return entityLinks.linkToSingleResource(GuideResource.class, entity.getId());
    }

    @Override
    public GuideResource toResource(Guide guide) {
        return createResourceWithId(guide.getId(), guide);
    }

    @Override
    protected GuideResource instantiateResource(Guide entity) {
        return new GuideResource(entity.getName(), entity.getInfo(), entity.getId());
    }
}
