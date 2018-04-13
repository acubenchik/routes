package com.routes.controllers;

import com.routes.assemblers.RouteResourceAssembler;
import com.routes.model.Route;
import com.routes.repos.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import resources.RouteResource;

import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@Controller
@EnableCircuitBreaker
@RequestMapping("route")
public class RouteController {

    private final RouteRepository routeRepository;
    private final RouteResourceAssembler routeResourceAssembler;

    private final RouteControllerDelegate routeControllerDelegate;

    @Autowired
    public RouteController(RouteRepository routeRepository,
                           RouteResourceAssembler routeResourceAssembler,
                           RouteControllerDelegate routeControllerDelegate) {
        this.routeRepository = routeRepository;
        this.routeResourceAssembler = routeResourceAssembler;
        this.routeControllerDelegate = routeControllerDelegate;
    }

    @RequestMapping(value = "get/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Resources<RouteResource>> getRoutes() {
        Iterable<Route> routes = routeRepository.findAll();
        Resources<RouteResource> wrapped = routeResourceAssembler.toEmbeddedList(routes);
        return ResponseEntity.ok(wrapped);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<RouteResource> getRoute(@PathVariable Long id) {
        Route route = routeRepository.findById(id).orElse(null);
        RouteResource resource = routeResourceAssembler.toResource(route);
        resource.add(linkTo(methodOn(RouteController.class).getRoute(id)).withRel("all"));
        return ResponseEntity.ok(resource);
    }


    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity checkout(@RequestBody Map<String, String> params) {
        return this.routeControllerDelegate.checkout(params);
    }
}
