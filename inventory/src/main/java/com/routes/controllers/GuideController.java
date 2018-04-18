package com.routes.controllers;

import com.routes.assemblers.GuideResourceAssember;
import com.routes.model.Guide;
import com.routes.repos.GuideRepository;
import com.routes.resources.GuideResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@Controller
@RequestMapping("guide")
@ExposesResourceFor(GuideResource.class)
public class GuideController {

    private final GuideRepository guideRepository;
    private final GuideResourceAssember guideResourceAssember;

    @Autowired
    public GuideController(GuideRepository guideRepository, GuideResourceAssember guideResourceAssember) {
        this.guideRepository = guideRepository;
        this.guideResourceAssember = guideResourceAssember;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity get(@PathVariable Long id) {
        Guide guide = guideRepository.findById(id).orElse(null);
        return ResponseEntity.ok(guideResourceAssember.toResource(guide));
    }
}
