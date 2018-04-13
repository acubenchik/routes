package com.routes.controllers;


import com.routes.services.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@Controller
@EnableCircuitBreaker
@RequestMapping("image")
public class ImageController {

    private IImageService imageService;

    @Autowired
    public ImageController(IImageService imageService) {
        this.imageService = imageService;
    }


    @RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String, String>> getImage(@PathVariable String id) {
        Map<String, String> jsonMap = new HashMap<>();
        try {
            jsonMap.put("content", imageService.getImage(id));
        } catch (IOException e) {

        }
        return ResponseEntity.ok()
                .body(jsonMap);
    }
}
