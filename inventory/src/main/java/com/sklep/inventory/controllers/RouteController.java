package com.sklep.inventory.controllers;

import com.sklep.inventory.assemblers.RouteResourceAssembler;
import com.sklep.inventory.model.Route;
import com.sklep.inventory.repos.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import resources.RouteResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@Controller
@EnableCircuitBreaker
public class RouteController {

    private final RouteRepository routeRepository;
    private final RouteResourceAssembler routeResourceAssembler;

    private final DiscountClient discountClient;


    @Autowired
    public RouteController(RouteRepository routeRepository, RouteResourceAssembler routeResourceAssembler, DiscountClient discountClient) {
        this.routeRepository = routeRepository;
        this.routeResourceAssembler = routeResourceAssembler;
        this.discountClient = discountClient;
    }

    @RequestMapping(value = "get/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resources<RouteResource>> getItems() {
        Iterable<Route> czekans = routeRepository.findAll();
        Resources<RouteResource> wrapped = routeResourceAssembler.toEmbeddedList(czekans);
        return ResponseEntity.ok(wrapped);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<RouteResource> getItem(@PathVariable Long id) {
        Route item = routeRepository.findById(id).orElse(null);
        RouteResource resource = routeResourceAssembler.toResource(item);
        resource.add(linkTo(methodOn(RouteController.class).getItem(id)).withRel("all"));
        return ResponseEntity.ok(resource);
    }
}
